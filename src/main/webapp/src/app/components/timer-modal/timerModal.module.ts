import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TimerModalComponent } from './timer-modal.component'
import {MatCardModule} from '@angular/material/card';
import { TimerModule } from './../timer/timer.module'
@NgModule({
    imports: [ RouterModule, CommonModule,MatCardModule ,TimerModule ],
    declarations: [ TimerModalComponent ],
    exports: [ TimerModalComponent ],
})

export class TimerModalModule {}
