import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { LoginService } from '../../home/login/login.service';
import { NavbarComponent } from './navbar.component';
import { RoleGuardService } from '../../shared/AuthGuard/RoleGuardService';

@NgModule({
    imports: [RouterModule, CommonModule],
    declarations: [NavbarComponent],
    exports: [NavbarComponent],
    providers: [
        LoginService,
        RoleGuardService
    ]
})

export class NavbarModule { }
