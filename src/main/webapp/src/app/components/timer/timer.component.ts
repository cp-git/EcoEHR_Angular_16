import { OnInit, Component, ViewChild } from "@angular/core";
import { Subject, Subscription } from "rxjs";
import { timer } from "rxjs/observable/timer";
import { AuthService } from "../../components/timer/auth.service";
import { StaffMember } from "../../administration/staff-members/staffmember";
import { CurrentUserService } from "../../profiles/currentUserService";
import { LoginService } from "../../home/login/login.service";
import { takeUntil } from "rxjs/internal/operators/takeUntil";
import { take } from "rxjs/internal/operators/take";

@Component({
    selector: 'ehr-timer',
    templateUrl: 'timer.component.html',
    styleUrls: ['timer.component.css', '../../app.component.css'],
})

export class TimerComponent implements OnInit {
    minutesDisplay!: number;
    secondsDisplay!: number;
    loggedInUser!: StaffMember;
    endTime = 15;
    unsubscribe$: Subject<any> = new Subject();
    timerSubscription!: Subscription;
    showModal: boolean = false;

    options = {
        text: "Success !",
        type: "fail",
        autoDismis: false,
        timeout: 2000
    }

    constructor(
        private authService: AuthService,
        private currentUserService: CurrentUserService,
        private loginService : LoginService
        ) { }

    ngOnInit() {
        this.resetTimer();
        this.authService.userActionOccured
        .pipe(takeUntil
          (this.unsubscribe$))
            .subscribe(() => {
                if (this.timerSubscription) {
                    this.timerSubscription.unsubscribe();
                }
                this.resetTimer();
            });
    }

    resetTimer(endTime: number = this.endTime) {
        // console.log('heereeeee in reset')
        const interval = 1000;
        const duration = endTime * 60;
        this.timerSubscription = timer(0, interval).
        pipe(
            take(duration))
            .subscribe(value =>
                this.render((duration - +value) * interval),
            err => { },
            () => {
                //code here for logout.
                this.setLogoutStatus()
                this.authService.logOutUser();
            }
            )
    }

    setLogoutStatus(){
        
        this.currentUserService.getCurrentStaffMember()
		.subscribe(data => {
            this.loggedInUser =  data;
           //console.log(this.loggedInUser)
           let staffToUpdate = new StaffMember(this.loggedInUser.staffId, this.loggedInUser.loginId, this.loggedInUser.loginKey, this.loggedInUser.firstName, '', 
            this.loggedInUser.lastName, this.loggedInUser.staffImage, this.loggedInUser.providerType, this.loggedInUser.designation, this.loggedInUser.providerFlag, 0, true, this.loggedInUser.clinicLocationId,
            this.loggedInUser.mobileNo, '',this.loggedInUser.email, this.loggedInUser.npiNumber, '', '', '', '', new Date(), '',new Date(), '', this.loggedInUser.licenseNumber, 
            this.loggedInUser.licenseNumber, this.loggedInUser.licenseExpDate, this.loggedInUser.deaNumber, this.loggedInUser.deaExpDate, this.loggedInUser.malpracticeCoverage,this.loggedInUser.malpracticeExpiration , 
            this.loggedInUser.dob, this.loggedInUser.gender, this.loggedInUser.ssn);

            this.loginService.updateLogoutTime(staffToUpdate)
            .subscribe(()=>{
            })
        })  
    }    


    private render(count: any) {
        this.secondsDisplay = this.getSeconds(count);
        this.minutesDisplay = this.getMinutes(count);
        this.colorchange(this.minutesDisplay,this.secondsDisplay);
    }
    // colorchange(minutes:number, seconds:number)
    // {
    //  if(minutes<=2 && seconds<0)
    //  {
    //     document.getElementById("timer").style.borderColor="red"
    //  }
    //  else{
    //     document.getElementById("timer").style.borderColor="#0471af"
    //  }
    // }
    colorchange(minutes: number, seconds: number) {
      const timerElement = document.getElementById("timer");
      if (timerElement) {
        if (minutes <= 2 && seconds < 0) {
          timerElement.style.borderColor = "red";
        } else {
          timerElement.style.borderColor = "#0471af";
        }
      }}

    private getSeconds(ticks: number) {
        const seconds = ((ticks % 60000) / 1000).toFixed(0);
        return this.pad(seconds);
    }

    private getMinutes(ticks: number) {
        const minutes = Math.floor(ticks / 60000);
        return this.pad(minutes);
    }

    private pad(digit: any) {
        return digit <= 9 ? '0' + digit : digit;
    }

}

