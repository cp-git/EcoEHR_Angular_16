import { Component, OnInit, HostListener } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
// import { SelectComponent } from 'ng2-select';
import { StaffMember } from './administration/staff-members/staffmember';
// import { AuthService } from './components/timer/auth.service'
import { LoginService } from './home/login/login.service';
import { CurrentUserService } from './profiles/currentUserService';
declare var $: any;

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html'
})

export class AppComponent implements OnInit{
    // loggedInUser: StaffMember;
    // constructor(private activatedRoute: ActivatedRoute,
    //     private router: Router,
    //     private authService: AuthService,
    //     private currentUserService: CurrentUserService,
    //     private loginService : LoginService
    //     ) { }

    ngOnInit() {
        // $.material.init();
        // const path = this.activatedRoute.snapshot.queryParams['path'];
        // const navigateTo = '/' + path;
        // if (path) {
        //     this.router.navigate([navigateTo]);
        // }
        
        // disable inspect mode of browser using shortcut keys
        // document.onkeydown = function (event) {
        //     if (event.keyCode == 123) {
        //         return false;
        //     }
        //     if (event.ctrlKey && event.shiftKey && event.keyCode == 'I'.charCodeAt(0)) {
        //         return false;
        //     }
        //     if (event.ctrlKey && event.shiftKey && event.keyCode == 'C'.charCodeAt(0)) {
        //         return false;
        //     }
        //     if (event.ctrlKey && event.shiftKey && event.keyCode == 'J'.charCodeAt(0)) {
        //         return false;
        //     }
        //     if (event.ctrlKey && event.keyCode == 'U'.charCodeAt(0)) {
        //         return false;
        //     }
        // }
    }
    
    @HostListener('document:keyup', ['$event'])
    @HostListener('document:click', ['$event'])
    @HostListener('document:wheel', ['$event'])
    // @HostListener('document:mousemove', ['$event'])
    resetTimer() {
        // this.authService.notifyUserAction();
        
    }

    

    
    // @HostListener('window:beforeunload', [ '$event' ])
    // onbeforeunloadHandler($event) {
    //     $event.preventDefault();
    //     $event.returnValue = " ";
    //     this.logout();
    // }

    // logout() {
    //    // console.log("logged out method called");
    //     this.currentUserService.getCurrentStaffMember()
	// 	.subscribe(data => {
    //         this.loggedInUser =  data;
    //       // console.log(this.loggedInUser);
    //        let staffToUpdate = new StaffMember(this.loggedInUser.staffId, this.loggedInUser.loginId, this.loggedInUser.loginKey, this.loggedInUser.firstName, null, 
    //         this.loggedInUser.lastName, this.loggedInUser.staffImage, this.loggedInUser.providerType, this.loggedInUser.designation, this.loggedInUser.providerFlag, 0, true, this.loggedInUser.clinicLocationId,
    //         this.loggedInUser.mobileNo, null,this.loggedInUser.email, this.loggedInUser.npiNumber, null, null, null, null, null, null, null, null, this.loggedInUser.licenseNumber, 
    //         this.loggedInUser.licenseNumber, this.loggedInUser.licenseExpDate, this.loggedInUser.deaNumber, this.loggedInUser.deaExpDate, this.loggedInUser.malpracticeCoverage,this.loggedInUser.malpracticeExpiration , 
    //         this.loggedInUser.dob, this.loggedInUser.gender, this.loggedInUser.ssn);

    //         this.loginService.updateLogoutTime(staffToUpdate)
    //         .subscribe(()=>{ 
    //         })
    //     })  

    //     localStorage.removeItem('jwt');
    // }
}
