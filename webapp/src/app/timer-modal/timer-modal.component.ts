import { OnInit, Component } from "@angular/core";
import { Subject, Subscription } from "rxjs";
import { timer } from "rxjs/observable/timer";
import { AuthService } from "../timer/auth.service";
import { take, takeUntil } from 'rxjs/operators';


@Component({
    selector: 'ehr-timer-modal',
    templateUrl: 'timer-modal.component.html',
    styleUrls: ['timer-modal.component.css', '../app.component.css'],
})

export class TimerModalComponent implements OnInit {
    minutesDisplay: number =0;
    secondsDisplay: number =0;
    endTime = 15;
    unsubscribe$: Subject<any> = new Subject();
    timerSubscription: Subscription = new Subscription;
    showTimerModal: boolean = false;


    constructor(private authService: AuthService) { }

    ngOnInit() {

      console.log("in ngOnint")
        this.resetTimer();
        this.authService.userActionOccured
        .pipe(
            takeUntil(this.unsubscribe$))
            .subscribe(() => {
                if (this.timerSubscription) {
                    this.timerSubscription.unsubscribe();
                }
                this.resetTimer();
            });
    }

    resetTimer(endTime: any = this.endTime) {
      console.log("in reset timer")
        const interval = 1000;
        const duration:any = endTime * 60000 ;
        this.timerSubscription = timer(0, interval).pipe(
          take(duration)
        ).subscribe((value: any) => this.render((duration - +value) * interval));
    }

    private render(count: number) {
        this.secondsDisplay = this.getSeconds(count);
        this.minutesDisplay = this.getMinutes(count);
    }

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

