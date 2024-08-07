import { Component, OnInit, Renderer2, ViewChild, ElementRef, Directive , HostListener} from '@angular/core';
import { ROUTES } from '../sidebar/sidebar.component';
import { Router, ActivatedRoute, NavigationEnd ,RoutesRecognized,NavigationStart} from '@angular/router';
import { Location, LocationStrategy, PathLocationStrategy } from '@angular/common';
import { StaffMember } from '../../administration/staff-members/staffmember';
import {LoginService} from '../../home/login/login.service';
import { RoleGuardService } from '../../shared/AuthGuard/RoleGuardService';
const misc: any = {
    navbar_menu_visible: 0,
    active_collapse: true,
    disabled_collapse_init: 0,
};

declare var $: any;
@Component({
    selector: 'ccm-navbar',
    templateUrl: 'navbar.component.html',
    styleUrls: ['navbar.component.css']
})

export class NavbarComponent implements OnInit {
    private listTitles: any[]=[];
    location: Location;
    private nativeElement: Node;
    private toggleButton: any;
    private sidebarVisible: boolean;

    private pathArray:any[]=[];
    private ccpPath:string='';
    currentBrowserUrl: string='';
    organizationId:number=0;
    staffId:number=0;
    hideLogo :boolean =true;
    statusCode: any;
    isadmin:boolean = false;

    @ViewChild('app-navbar-cmp') button: any;
    @HostListener('window:resize') onResizeNav() {
        // guard against resize before view is rendered
        if(window.screen.width < 1200 ) {
            this.hideLogo =false;
        }
        else
        this.hideLogo = true;
      }
    constructor(location: Location, 
                private renderer: Renderer2,
                private element: ElementRef,
                private route: ActivatedRoute,
                //private currentUserService:CurrentUserService,
                private loginService: LoginService,
                private router: Router,
               // public _data: DataService,
                private roleguard: RoleGuardService) {
        this.location = location;
        this.nativeElement = element.nativeElement;
        this.sidebarVisible = false;
    }

    ngOnInit() {

        this.adminCheck();
        if(window.screen.width < 1200)
        {
            this.hideLogo =false;
        }
        else
        {
            this.hideLogo = true;
        }

        $('body').addClass('sidebar-mini');
        this.listTitles = ROUTES.filter(listTitle => listTitle);

        const navbar: HTMLElement = this.element.nativeElement;
        this.toggleButton = navbar.getElementsByClassName('navbar-toggle')[0];
        if ($('body').hasClass('sidebar-mini')) {
            misc.sidebar_mini_active = true;
        }
        if ($('body').hasClass('hide-sidebar')) {
            misc.hide_sidebar_active = true;
        }
        $('#minimizeSidebar').click(function() {
            if (misc.sidebar_mini_active === true) {
                $('body').removeClass('sidebar-mini');
                misc.sidebar_mini_active = false;

            } else {
                setTimeout(function() {
                    $('body').addClass('sidebar-mini');

                    misc.sidebar_mini_active = true;
                }, 300);
            }

            // we simulate the window Resize so the charts will get updated in realtime.
            const simulateWindowResize = setInterval(function() {
                window.dispatchEvent(new Event('resize'));
            }, 180);

            // we stop the simulation of Window Resize after the animations are completed
            setTimeout(function() {
                clearInterval(simulateWindowResize);
            }, 1000);
        });
        $('#hideSidebar').click(function() {
            if (misc.hide_sidebar_active === true) {
                setTimeout(function() {
                    $('body').removeClass('hide-sidebar');
                    misc.hide_sidebar_active = false;
                }, 300);
                setTimeout(function () {
                    $('.sidebar').removeClass('animation');
                }, 600);
                $('.sidebar').addClass('animation');

            } else {
                setTimeout(function() {
                    $('body').addClass('hide-sidebar');
                    // $('.sidebar').addClass('animation');
                    misc.hide_sidebar_active = true;
                }, 300);
            }

            // we simulate the window Resize so the charts will get updated in realtime.
            const simulateWindowResize = setInterval(function() {
                window.dispatchEvent(new Event('resize'));
            }, 180);

            // we stop the simulation of Window Resize after the animations are completed
            setTimeout(function() {
                clearInterval(simulateWindowResize);
            }, 1000);
        });
    }



    onResize(event:any) {
      if ($(window).width() > 1000) {
        return false;
      }
      return true;
    }
    adminCheck()
    {
        this.roleguard.roleCheck()
        .subscribe(successCode => {
            this.statusCode = successCode;
            if(this.statusCode===200){
                this.isadmin= true;
                        }
            else this.isadmin=false
              },
              errorCode => this.statusCode = errorCode);

             // this.isadmin= false;
          } 

    sidebarOpen() {
        const toggleButton = this.toggleButton;
        const body = document.getElementsByTagName('body')[0];
        setTimeout(function(){
            toggleButton.classList.add('toggled');
        }, 500);
        body.classList.add('nav-open');

        this.sidebarVisible = true;
      
    };
    sidebarClose() {
        const body = document.getElementsByTagName('body')[0];
        this.toggleButton.classList.remove('toggled');
        this.sidebarVisible = false;
        body.classList.remove('nav-open');
    };
    sidebarToggle() {
        if (this.sidebarVisible === false) {
            this.sidebarOpen();
        } else {
            this.sidebarClose();
        }
    };

    getTitle() {
        
        let titlee: any = this.location.prepareExternalUrl(this.location.path());
    
        this.pathArray=titlee.split("/");
      
        let  linkPath="/"+this.pathArray[1];
        
        for (let i = 0; i < this.listTitles.length; i++) {
         
            if (this.listTitles[i].type === "link"  && this.listTitles[i].path === linkPath) {
             
                return this.listTitles[i].title;
                
            } 
            if(this.listTitles[i].path === "/ccp" && this.pathArray.length===3)
            {
                return this.listTitles[i].title;
            }
            if( this.listTitles[i].path === "/editprofile")
            {
                return this.listTitles[i].title;
            }

            else if (this.listTitles[i].type === "sub" || this.listTitles[i].type === "hide") {
             
                  for (let j = 0; j < this.listTitles[i].children.length; j++) {
       
                    if(this.listTitles[i].path === "/patients" && this.pathArray[2] === "addencounter")
                    {
                        return "Add Encounter"
                    }

                    if(this.listTitles[i].path === "/patients" && this.pathArray[2] === "patienthistory")
                    {
                        return "Patient Details"
                    }

                    if(this.listTitles[i].path === "/patients" && this.pathArray[2] === "update")
                    {
                      
                        return "Update Patient"
                    }
             
                    if(this.pathArray.includes(this.listTitles[i].children[j].path))
                    {
                        
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

    logout()
    {
        // this._data.patientCount =null
       
        // this.currentBrowserUrl=this.router.url;
        // this.currentUserService.getStaff()
        // .subscribe(data => {
        //   this.staffId=data.staffId;          
        // //Setting last action of the Staff Member as last client in DB
        //   let staffMemberObject = new StaffMember(data.staffId,null,null,null,null,
        //     null,null,null,null,data.clinicLocationId,true,data.organization,null,null,null,null,null,null,
        //     this.currentBrowserUrl,null,null,null,null,null,null,null);
        //     this.loginService.updateStaffLastAction(staffMemberObject)
        //     .subscribe(data => {
                
        //     })

        // });
        
        localStorage.removeItem('jwt');
    }
}
