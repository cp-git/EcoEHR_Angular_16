import { Injectable } from "@angular/core";
import {
  Http,
  Response,
  Headers,
  URLSearchParams,
  RequestOptions
} from "@angular/http";
import { Observable } from "rxjs";
import { AppSettings } from "../../appsettings";
import { HttpClient, HttpHeaders, HttpResponse } from "@angular/common/http";
import { catchError, map } from "rxjs/operators";

@Injectable(
  {
    providedIn : 'root'
  }
)
export class RoleGuardService {
  //URLs for CRUD operations
  roleCheckUrl = AppSettings.API_ENDPOINT+"./admin/isAdmin";
 
  //Create constructor to get Http instance
  constructor(private http: HttpClient) {}

  roleCheck(): Observable<number> {
    const token = localStorage.getItem('jwt');
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'x-auth-token': token ? token : ''
    });

    return this.http.get(this.roleCheckUrl, { headers, observe: 'response' })
      .pipe(
        map((response: HttpResponse<any>) => response.status),
        catchError(this.handleError)
      );
  }

private extractData(res: Response | any) {
    let body = res.json();
    return body;
}
private handleError (error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.status);
}

  }