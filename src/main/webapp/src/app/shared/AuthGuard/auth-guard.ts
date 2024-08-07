import { inject } from '@angular/core';
import { Router, CanActivateFn, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';

export const AuthGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> => {
  const router = inject(Router);
  const jwtHelper = inject(JwtHelperService);

  const token = localStorage.getItem('jwt');
  if (token && !jwtHelper.isTokenExpired(token)) {
    return true;
  }

  return router.createUrlTree(['/login']);
};
