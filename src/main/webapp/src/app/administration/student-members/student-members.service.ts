import { Injectable } from '@angular/core';
import { HttpHeaders, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppSettings } from '../../appsettings';
import { StudentMembers } from './student-members';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/internal/operators/catchError';
import { map } from 'rxjs/internal/operators/map';



@Injectable({
    providedIn :'root'
})
export class StudentMembersService {
    //URLs for CRUD operations
    // getStaffbyIdUrl = AppSettings.API_ENDPOINT + "./admin/getListOfActiveStaffMembers";
    
    getAllStudentMembersUrl = AppSettings.API_ENDPOINT + "./admin/getListOfActiveStudentMembersfromsView";  

    //Create constructor to get Http instance
    constructor(private http: HttpClient) { }


    //** GET Staff Member by Id from view  **
    // getAllStaffMembers(organizationId: number): Observable<StaffMember> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let cpParams = new URLSearchParams();
    //     cpParams.set('organizationId', organizationId.toString());
    //     let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.get(this.getStaffbyIdUrl, options)
    //         .map(this.extractData)
    //         .catch(this.handleError);
    // }

    getAllStudentMembers(): Observable<StudentMembers[]> {
		
		let cpParams = new HttpParams();
        let token = localStorage.getItem('jwt');
        let cpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' ,  'x-auth-token': token ? token : ''});

        //cpParams.set('organizationId', organizationId.toString());
		let options = { headers: cpHeaders, params: cpParams };
        return this.http.get(this.getAllStudentMembersUrl,options)
        .pipe(
        map(this.extractData),
        catchError(this.handleError));
    }

    

    private extractData(res: any) {
        let body = res.json();
        return body;
    }

    private handleError(error: any) {
        console.error(error.message || error);
        return Observable.throw(error.status);
    }
}