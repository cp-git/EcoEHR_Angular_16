import { Injectable } from '@angular/core';
import { Router, CanActivate, CanActivateChild } from '@angular/router';
import {JwtHelper} from 'angular2-jwt';

@Injectable()
export class StudentAuthGuard implements CanActivateChild {

    jwtHelper: JwtHelper = new JwtHelper();

  constructor(private router: Router) {}

  canActivateChild() {
    let token= localStorage.getItem('jwt');
    if (localStorage.getItem('jwt') !== null) {
      return true;
    }
    this.router.navigate(['/studentlogin']);
    return false;

  }

  
}