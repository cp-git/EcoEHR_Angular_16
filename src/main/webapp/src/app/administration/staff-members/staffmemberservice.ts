

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

import { AppSettings } from '../../appsettings';
import { StaffMember } from '../../administration/staff-members/staffmember';
import { StaffRole } from '../../administration/staff-members/staffrole';
import { StaffPaymentDetails } from '../../home/payment/staffpaymentdetails';


@Injectable({
    providedIn :'root'
})
export class StaffMemberService {
    //URLs for CRUD operations
    getStaffbyIdUrl = AppSettings.API_ENDPOINT + "./admin/getListOfActiveStaffMembers";
    addstaffroleUrl = AppSettings.API_ENDPOINT + "./admin/createStaffRoles";
    addstaffmemberUrl = AppSettings.API_ENDPOINT + "./admin/createStaffMember";
    getStaffMemberbyIdUrl=AppSettings.API_ENDPOINT+"./admin/getStaffMemberById";
    updateStaffMemberUrl=AppSettings.API_ENDPOINT+"./admin/modifyStaffMemberById";
    updateStaffRoleUrl=AppSettings.API_ENDPOINT+"./admin/modifyStaffRolesById";
    deleteStaffMemberUrl=AppSettings.API_ENDPOINT+"./admin/removeStaffMemberById";
    updateStudStatusUrl=AppSettings.API_ENDPOINT+"./admin/updateStudentStatus";
    updatePaymentStatusUrl=AppSettings.API_ENDPOINT+"./admin/updatePaymentStatus";

    //Create constructor to get Http instance
    constructor(private http: HttpClient) { }


    //** GET Staff Member by Id from view  **
    // getAllStaffMembers(organizationId: number): Observable<StaffMember> {
    //     const token = localStorage.getItem('jwt');

    //     let cpHeaders = new HttpHeaders({ 'Content-Type': 'application/json', "x-auth-token": token?token:''});
    //     let cpParams = new URLSearchParams();
    //     cpParams.set('organizationId', organizationId.toString());
    //     let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.get(this.getStaffbyIdUrl, {options}).pipe(
    //         map((response: any) => this.extractData(response)),
    //         catchError(this.handleError)
    //     );
    // }
    getAllStaffMembers(organizationId: number): Observable<StaffMember[]> {
        const token = localStorage.getItem('jwt') || '';
        const headers = new HttpHeaders({
            'Content-Type': 'application/json',
            'x-auth-token': token
        });
        const params = new HttpParams().set('organizationId', organizationId.toString());

        return this.http.get<StaffMember[]>(this.getStaffbyIdUrl, { headers, params }).pipe(
            map(response => this.extractData(response)),
            catchError(this.handleError)
        );
    }
    insertStaffRole(staffRoleObject: StaffRole): Observable<number> {
        const token = localStorage.getItem('jwt') || '';
    
        const headers = new HttpHeaders({
            'Content-Type': 'application/json',
            'x-auth-token': token
        });
    
        return this.http.post(this.addstaffroleUrl, staffRoleObject, { headers, observe: 'response' })
            .pipe(
                map(response => response.status),
                catchError(this.handleError)
            );
    }
    getStaffMemberById(staffId: number): Observable<StaffMember> {
		
        let cpParams = new URLSearchParams();
        cpParams.set('staffId', staffId.toString());
        const token = localStorage.getItem('jwt') || '';
        const headers = new HttpHeaders({
            'Content-Type': 'application/json',
            'x-auth-token': token
        });
        const params = new HttpParams().set('staffId', staffId.toString());

		// let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
		return this.http.get(this.getStaffMemberbyIdUrl, { headers, params })
        .pipe(
        map(this.extractData),
        catchError(this.handleError))
    }
    insertStaffMember(staffMemberObject: StaffMember): Observable<StaffMember> {
        console.log("inside   insertStaffMember service.")
        const token = localStorage.getItem('jwt') || '';
        const headers = new HttpHeaders({
            'Content-Type': 'application/json',
            'x-auth-token': token
        });
        return this.http.post(this.addstaffmemberUrl, staffMemberObject, {headers})
        .pipe(
        map(this.extractData),
        catchError(this.handleError)
        );
    }
  // ** Update Staff Member **
  updateStaffMember(staffMemberObject: StaffMember):Observable<StaffMember> {
    const token = localStorage.getItem('jwt') || '';
    const headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'x-auth-token': token
    });
    return this.http.put(this.updateStaffMemberUrl, staffMemberObject, {headers})
    .pipe(
    map(this.extractData),
    catchError(this.handleError)
    );
}

updateStaffPayment(staffPaymentObj: StaffPaymentDetails):Observable<StaffMember> {
    const token = localStorage.getItem('jwt') || '';
    const headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'x-auth-token': token
    });
    return this.http.put(this.updatePaymentStatusUrl, StaffPaymentDetails, {headers})
    .pipe(
    map(this.extractData),
    catchError(this.handleError));
}




// ** Active or Deactive Student Profile **
updateStudentStatus(staffId: number): Observable<number> {
    const token = localStorage.getItem('jwt') || '';
    const headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'x-auth-token': token
    });
    const params = new HttpParams().set('staffId', staffId.toString());

    return this.http.put(this.updateStudStatusUrl, {}, { headers, params, observe: 'response' })
    .pipe(
        map(response => response.status),
        catchError(this.handleError)
    );
}


   
 // ** Update Staff Member **
 updateStaffRole(staffRoleObject: StaffRole):Observable<number> {
    const token = localStorage.getItem('jwt') || '';
    const headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'x-auth-token': token
    });
    return this.http.put(this.updateStaffRoleUrl, staffRoleObject, {headers, observe: 'response' }).pipe(
    map(success => success.status),
    catchError(this.handleError)
    );
}

//delete master lookup
deleteStaffMember(staffId: number): Observable<number> {
    let cpParams = new URLSearchParams();
    cpParams.set('staffId', staffId.toString());
    const token = localStorage.getItem('jwt') || '';
    const headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'x-auth-token': token
    });
    const params = new HttpParams().set('staffId', staffId.toString());

    return this.http.delete(this.deleteStaffMemberUrl,  { headers, params,  observe: 'response' }).pipe(
        map(success => success.status),
        catchError(this.handleError)
    );
}



    private extractData(res: Response | any) {
        let body = res.json();
        return body;
    }

    private handleError(error: Response | any) {
        console.error(error.message || error);
        return Observable.throw(error.status);
    }
}