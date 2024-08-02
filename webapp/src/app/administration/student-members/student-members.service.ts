import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';

import { AppSettings } from '../../appsettings';
import { StudentMembers } from './student-members';


@Injectable()
export class StudentMembersService {
    //URLs for CRUD operations
    // getStaffbyIdUrl = AppSettings.API_ENDPOINT + "./admin/getListOfActiveStaffMembers";
    
    getAllStudentMembersUrl = AppSettings.API_ENDPOINT + "./admin/getListOfActiveStudentMembersfromsView";  

    //Create constructor to get Http instance
    constructor(private http: Http) { }


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
		
        let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
		let cpParams = new URLSearchParams();
        //cpParams.set('organizationId', organizationId.toString());
		let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
        return this.http.get(this.getAllStudentMembersUrl,options)
        .map(this.extractData)
        .catch(this.handleError);
    }

    

    private extractData(res: Response) {
        let body = res.json();
        return body;
    }

    private handleError(error: Response | any) {
        console.error(error.message || error);
        return Observable.throw(error.status);
    }
}