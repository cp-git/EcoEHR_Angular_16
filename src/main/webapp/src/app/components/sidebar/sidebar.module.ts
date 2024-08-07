import { NgModule } from '@angular/core'
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { SidebarComponent } from '../sidebar/sidebar.component';
import { Data } from '../../data';
import { StaffMemberService } from '../../administration/staff-members/staffmemberservice';
import { SidebarProfileRefreshService } from './sidebarProfileRefreshService';
import { RoleGuardService } from '../../shared/AuthGuard/RoleGuardService';
import { NgxLoadingModule, ngxLoadingAnimationTypes } from 'ngx-loading';
import { TimerModule } from '../../components/timer/timer.module';
import { SystemService } from '../../patients/services/systemService';
import { QuestionGroupService } from '../../patients/services/questionGroupService';
import { CurrentUserService } from '../../profiles/currentUserService';
import { LoginService } from '../../home/login/login.service';

@NgModule({
    imports: [
        RouterModule,
        CommonModule,
        TimerModule,
        NgxLoadingModule.forRoot({
            animationType: ngxLoadingAnimationTypes.threeBounce,
            backdropBackgroundColour: 'rgba(255,255,255,0.3)',
            backdropBorderRadius: '10px',
            primaryColour: '#0073e6',
            secondaryColour: '#3399ff',
            tertiaryColour: '#99d6ff'
        })
    ],
    declarations: [
        SidebarComponent
    ],
    exports: [
        SidebarComponent
    ],
    providers: [
        Data,
        StaffMemberService,
        SidebarProfileRefreshService,
        SystemService,
        QuestionGroupService,
        RoleGuardService,
        LoginService,
        CurrentUserService
    ]
})
export class SidebarModule { }
