import { OnInit, Component } from "@angular/core";
import { Subject, Subscription } from "rxjs";
import { timer } from "rxjs/observable/timer";
import { AuthService } from "../timer/auth.service";
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { takeUntil } from "rxjs/internal/operators/takeUntil";
import { take } from "rxjs/internal/operators/take";


@Component({
    selector: 'ehr-timer-modal',
    templateUrl: 'timer-modal.component.html',
    styleUrls: ['timer-modal.component.css', '../../app.component.css'],
})

export class TimerModalComponent implements OnInit {
    minutesDisplay!: number;
    secondsDisplay!: number;
    endTime = 15;
    unsubscribe$: Subject<any> = new Subject();
    timerSubscription!: Subscription;
    showTimerModal: boolean = false;


    constructor(private authService: AuthService) { }

    // ngOnInit() {
    //     this.resetTimer();
    //     this.authService.userActionOccured.
    //     pipe(
    //       takeUntilDestroyed(this.unsubscribe$)
    //     )
    //         .subscribe(() => {
    //             if (this.timerSubscription) {
    //                 this.timerSubscription.unsubscribe();
    //             }
    //             this.resetTimer();
    //         });
    // }
    ngOnInit() {
      this.resetTimer();
      this.authService.userActionOccured
        .pipe(takeUntil(this.unsubscribe$))
        .subscribe(() => {
          if (this.timerSubscription) {
            this.timerSubscription.unsubscribe();
          }
          this.resetTimer();
        });
    }
  

    resetTimer(endTime: number = this.endTime) {
      const interval = 1000;
      const duration = endTime * 60;
      this.timerSubscription = timer(0, interval).pipe(
        take(duration)
      ).subscribe(value =>
        this.render((duration - +value) * interval)
      );
    }

    private render(count:any) {
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

