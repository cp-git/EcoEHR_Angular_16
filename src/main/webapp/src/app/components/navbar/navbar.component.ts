import { Component, OnInit, Renderer2, ViewChild, ElementRef, HostListener } from '@angular/core';
import { ROUTES } from '../sidebar/sidebar.component';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { LoginService } from '../../home/login/login.service';
import { RoleGuardService } from '../../shared/AuthGuard/RoleGuardService';

const misc: any = {
  navbar_menu_visible: 0,
  active_collapse: true,
  disabled_collapse_init: 0,
};

@Component({
  selector: 'ccm-navbar',
  templateUrl: 'navbar.component.html',
  styleUrls: ['navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  listTitles: any[] = [];
  location: Location;
  private nativeElement: Node;
  private toggleButton: any;
  sidebarVisible: boolean;
  pathArray: any[] = [];
  ccpPath: string = '';
  currentBrowserUrl: string = '';
  organizationId: number = 0;
  staffId: number = 0;
  hideLogo: boolean = true;
  statusCode: any;
  isadmin: boolean = false;

  @ViewChild('navbar', { static: true }) button!: ElementRef;
  
  @HostListener('window:resize')
  onResizeNav() {
    this.hideLogo = window.innerWidth < 1200 ? false : true;
  }

  constructor(
    location: Location,
    private renderer: Renderer2,
    private element: ElementRef,
    private route: ActivatedRoute,
    private loginService: LoginService,
    private router: Router,
    private roleguard: RoleGuardService
  ) {
    this.location = location;
    this.nativeElement = element.nativeElement;
    this.sidebarVisible = false;
  }

  ngOnInit() {
    this.adminCheck();
    this.hideLogo = window.innerWidth < 1200 ? false : true;

    document.body.classList.add('sidebar-mini');
    this.listTitles = ROUTES.filter((listTitle) => listTitle);

    const navbar: HTMLElement = this.element.nativeElement;
    this.toggleButton = navbar.getElementsByClassName('navbar-toggle')[0];
    if (document.body.classList.contains('sidebar-mini')) {
      misc.sidebar_mini_active = true;
    }
    if (document.body.classList.contains('hide-sidebar')) {
      misc.hide_sidebar_active = true;
    }

    document.getElementById('minimizeSidebar')?.addEventListener('click', () => {
      this.toggleSidebar('sidebar-mini', misc);
    });

    document.getElementById('hideSidebar')?.addEventListener('click', () => {
      this.toggleSidebar('hide-sidebar', misc);
    });
  }

  onResize(event: any) {
    return window.innerWidth > 1000 ? false : true;
  }

  adminCheck() {
    this.roleguard.roleCheck().subscribe(
      (successCode) => {
        this.statusCode = successCode;
        this.isadmin = this.statusCode === 200;
      },
      (errorCode) => (this.statusCode = errorCode)
    );
  }

  toggleSidebar(className: string, misc: any) {
    const body = document.body;
    if (misc[className + '_active']) {
      body.classList.remove(className);
      misc[className + '_active'] = false;
    } else {
      setTimeout(() => {
        body.classList.add(className);
        misc[className + '_active'] = true;
      }, 300);

      const simulateWindowResize = setInterval(() => {
        window.dispatchEvent(new Event('resize'));
      }, 180);

      setTimeout(() => {
        clearInterval(simulateWindowResize);
      }, 1000);
    }
  }

  sidebarOpen() {
    const toggleButton = this.toggleButton;
    const body = document.body;
    setTimeout(() => {
      toggleButton.classList.add('toggled');
    }, 500);
    body.classList.add('nav-open');

    this.sidebarVisible = true;
  }

  sidebarClose() {
    const body = document.body;
    this.toggleButton.classList.remove('toggled');
    this.sidebarVisible = false;
    body.classList.remove('nav-open');
  }

  sidebarToggle() {
    this.sidebarVisible ? this.sidebarClose() : this.sidebarOpen();
  }

  getTitle() {
    const titlee: any = this.location.prepareExternalUrl(this.location.path());
    this.pathArray = titlee.split('/');

    let linkPath = '/' + this.pathArray[1];

    for (let i = 0; i < this.listTitles.length; i++) {
      if (this.listTitles[i].type === 'link' && this.listTitles[i].path === linkPath) {
        return this.listTitles[i].title;
      }
      if (this.listTitles[i].path === '/ccp' && this.pathArray.length === 3) {
        return this.listTitles[i].title;
      }
      if (this.listTitles[i].path === '/editprofile') {
        return this.listTitles[i].title;
      } else if (this.listTitles[i].type === 'sub' || this.listTitles[i].type === 'hide') {
        for (let j = 0; j < this.listTitles[i].children.length; j++) {
          if (this.listTitles[i].path === '/patients' && this.pathArray[2] === 'addencounter') {
            return 'Add Encounter';
          }

          if (this.listTitles[i].path === '/patients' && this.pathArray[2] === 'patienthistory') {
            return 'Patient Details';
          }

          if (this.listTitles[i].path === '/patients' && this.pathArray[2] === 'update') {
            return 'Update Patient';
          }

          if (this.pathArray.includes(this.listTitles[i].children[j].path)) {
            return this.listTitles[i].children[j].title;
          }
        }
      }
    }
    return 'Dashboard';
  }

  getPath() {
    return this.location.prepareExternalUrl(this.location.path());
  }

  logout() {
    localStorage.removeItem('jwt');
  }
}
