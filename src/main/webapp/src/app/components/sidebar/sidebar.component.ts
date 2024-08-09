import { Component, OnInit, OnChanges, SimpleChanges, ElementRef } from '@angular/core';
import { Router } from '@angular/router';
import { RoleGuardService } from '../../shared/AuthGuard/RoleGuardService';
import { SystemService } from '../../patients/services/systemService';
import { QuestionGroupService } from '../../patients/services/questionGroupService';
import { CurrentUserService } from '../../profiles/currentUserService';
import { LoginService } from '../../home/login/login.service';
import { StaffMember } from '../../administration/staff-members/staffmember';

// src/app/sidebar/sidebar-routes.config.ts

export const ROUTES = [
    {
      path: '/dashboard',
      title: 'Dashboard',
      icontype: 'dashboard',
      type: 'link',
    },
    {
      path: '/user-profile',
      title: 'User Profile',
      icontype: 'person',
      type: 'link',
    },
    {
      path: '/settings',
      title: 'Settings',
      icontype: 'settings',
      type: 'sub',
      collapse: 'settingsCollapse',
      children: [
        { path: 'profile', title: 'Profile', icontype: 'person' },
        { path: 'security', title: 'Security', icontype: 'lock' },
      ],
    },
    // Add more routes as needed
  ];
  
@Component({
  selector: 'ehr-sidebar',
  templateUrl: 'sidebar.component.html',
  styleUrls: ['sidebar.component.css', '../../app.component.css'],
})
export class SidebarComponent implements OnInit, OnChanges {
  private toggleButton: any;
  private sidebarVisible: boolean;
  public menuItems: any[] = [];
  organizationId!: number;
  isadmin: boolean = false;
  loggedInUser!: StaffMember;
  staffImage: string = './assets/img/default-avatar.png';
  listTitles:any[] ;
    requestProcessing: boolean=false;
    statusCode: string='';
  constructor(
    private roleguard: RoleGuardService,
    private systemService: SystemService,
    private questionGroupService: QuestionGroupService,
    private currentUserService: CurrentUserService,
    private loginService: LoginService,
    private router: Router,
    private element: ElementRef
  ) {
    this.sidebarVisible = false;
    this.listTitles = [];
  }

// src/app/sidebar/sidebar-routes.config.ts


  

  ngOnChanges(change: SimpleChanges) {
    const input = this.element.nativeElement.querySelector('input[type="file"]');
    if (input?.files && input.files[0]) {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        const imgElement = this.element.nativeElement.querySelector('#wizardPicturePreview');
        if (imgElement) {
          imgElement.src = e.target.result;
        }
      };
      reader.readAsDataURL(input.files[0]);
    }
  }

  ngOnInit() {
    this.getAllSystems();
    this.getAllQuestionGroup();
    this.getLoggedInUserDetails();
    this.adminCheck();
    this.menuItems = ROUTES.filter((menuItem) => menuItem);

    this.listTitles = ROUTES.filter((listTitle) => listTitle);

    this.toggleButton = this.element.nativeElement.querySelector('.navbar-toggle');
    this.initSidebar();
  }

  getLoggedInUserDetails() {
    this.currentUserService.getCurrentStaffMember().subscribe((data) => {
      this.loggedInUser = data;
      if (data.staffImage) {
        this.staffImage = data.staffImage;
      }
    });
  }

  getAllSystems() {
    this.systemService.getAllSystems().subscribe((data) => {
      localStorage.setItem('system', JSON.stringify(data));
    });
  }

  getAllQuestionGroup() {
    this.questionGroupService.getAllQuestionGroups().subscribe((data) => {
      localStorage.setItem('questionGroup', JSON.stringify(data));
    });
  }

  adminCheck() {
    this.roleguard.roleCheck().subscribe(
      (successCode) => {
        this.isadmin = successCode === 200;
      },
      () => {
        this.isadmin = false;
      }
    );
  }
  
  sidebarProfileRefresh() {
    this.preProcessConfigurations();
}
    preProcessConfigurations() {
        this.statusCode = '';
        this.requestProcessing = true;
    }

  sidebarToggle() {
    this.sidebarVisible = !this.sidebarVisible;
  }

  logout() {
    this.currentUserService.getCurrentStaffMember()
		.subscribe(data => {
            this.loggedInUser =  data;
           //console.log(this.loggedInUser)
           let staffToUpdate = new StaffMember(this.loggedInUser.staffId, this.loggedInUser.loginId, this.loggedInUser.loginKey, this.loggedInUser.firstName, '',
            this.loggedInUser.lastName, this.loggedInUser.staffImage, this.loggedInUser.providerType, this.loggedInUser.designation, this.loggedInUser.providerFlag, 0, true, this.loggedInUser.clinicLocationId,
            this.loggedInUser.mobileNo, '',this.loggedInUser.email, this.loggedInUser.npiNumber, '', '', '', '', new Date(), '', new Date(), '', this.loggedInUser.licenseNumber,
            this.loggedInUser.licenseNumber, this.loggedInUser.licenseExpDate, this.loggedInUser.deaNumber, this.loggedInUser.deaExpDate, this.loggedInUser.malpracticeCoverage,this.loggedInUser.malpracticeExpiration ,
            this.loggedInUser.dob, this.loggedInUser.gender, this.loggedInUser.ssn);
    this.loginService.updateLogoutTime(staffToUpdate).subscribe(() => {

    })
})
      localStorage.removeItem('jwt');
      this.router.navigate(['/home']);
      location.reload();
   
  }

  updatePS() {
    if (window.matchMedia('(min-width: 960px)').matches && !this.isMac()) {
      const elemSidebar = this.element.nativeElement.querySelector('.sidebar .sidebar-wrapper');
      if (elemSidebar) {
        // Initialize PerfectScrollbar if needed
      }
    }
  }

  isMac(): boolean {
    return /MAC|IPAD/.test(navigator.platform.toUpperCase());
  }

  private initSidebar() {
    document.querySelector('#minimizeSidebar')?.addEventListener('click', () => {
      document.body.classList.toggle('sidebar-mini');
    });

    document.querySelector('#sidebarToggle')?.addEventListener('click', () => {
      this.sidebarToggle();
    });
  }

  isMobileMenu() {
    return window.innerWidth <= 991;
  }
}
