import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TimerComponent } from '../../components/timer/timer.component';
import { AuthService } from '../../components/timer/auth.service';
import { CurrentUserService } from '../../profiles/currentUserService';
import { LoginService } from '../../home/login/login.service';

@NgModule({
    imports: [ RouterModule, CommonModule ],
    declarations: [ TimerComponent ],
    exports: [ TimerComponent ],
    providers: [AuthService,CurrentUserService,LoginService]
})

export class TimerModule {}
