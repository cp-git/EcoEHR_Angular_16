
import { Injectable } from "@angular/core";
// import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { StaffMember } from '../administration/staff-members/staffmember';
import { AppSettings } from "../appsettings";
import { StaffFeedBack } from "../patients/models/staffFeedback";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { catchError, map } from "rxjs/operators";

@Injectable({
    providedIn: 'root'
  })
export class CurrentUserService {
	
    //URLs for CRUD operation
    private getloggedInUser = AppSettings.API_ENDPOINT + "./admin/profile";
    private sendFeedbackURL = AppSettings.API_ENDPOINT + "./admin/sendUserFeedback";
    

    constructor(private http: HttpClient) {
    }

    getCurrentStaffMember(): Observable<StaffMember> {
        const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
    
        // let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem("jwt") });
        const options = { headers, observe: 'response' as 'response' };

        // let options = new RequestOptions({ headers: cpHeaders });
        return this.http.get(this.getloggedInUser, options)
        .pipe(  
        map(this.extractDataStaffMember),
            catchError(this.handleError)
        );
    }

    sendFeedbackEmail(feebbackObject : StaffFeedBack): Observable<number>  {
        const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
        const options = { headers, observe: 'response' as 'response' };

        // let options = new RequestOptions({ headers: cpHeaders });
        return this.http.put(this.sendFeedbackURL, feebbackObject, options)
        .pipe(   
        map((success: { status: any; }) => success.status),
            catchError(this.handleError)
        );

	}





    private extractData(res: Response) {
        let body = res.json();
        return body;
    }
    private handleError(error: Response | any) {
        console.error(error.message || error);
        return throwError(error.status);    }

        private extractDataStaffMember(res: any):StaffMember {
            let body = res.json();
            return body;
        } 

}