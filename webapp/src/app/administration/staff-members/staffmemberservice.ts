// import { Injectable } from '@angular/core';
// import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
// import { Observable } from 'rxjs';

// import { AppSettings } from '../../appsettings';
// import { StaffMember } from 'app/administration/staff-members/staffMember';
// import { StaffRole } from 'app/administration/staff-members/staffRole';
// import { MasterLookup } from 'app/administration/master-lookup/masterLookup';
// import { StaffPaymentDetails } from '../../home/payment/staffpaymentdetails';


// @Injectable()
// export class StaffMemberService {
//     //URLs for CRUD operations
//     getStaffbyIdUrl = AppSettings.API_ENDPOINT + "./admin/getListOfActiveStaffMembers";
//     addstaffroleUrl = AppSettings.API_ENDPOINT + "./admin/createStaffRoles";
//     addstaffmemberUrl = AppSettings.API_ENDPOINT + "./admin/createStaffMember";
//     getStaffMemberbyIdUrl=AppSettings.API_ENDPOINT+"./admin/getStaffMemberById";
//     updateStaffMemberUrl=AppSettings.API_ENDPOINT+"./admin/modifyStaffMemberById";
//     updateStaffRoleUrl=AppSettings.API_ENDPOINT+"./admin/modifyStaffRolesById";
//     deleteStaffMemberUrl=AppSettings.API_ENDPOINT+"./admin/removeStaffMemberById";
//     updateStudStatusUrl=AppSettings.API_ENDPOINT+"./admin/updateStudentStatus";
//     updatePaymentStatusUrl=AppSettings.API_ENDPOINT+"./admin/updatePaymentStatus";

//     //Create constructor to get Http instance
//     constructor(private http: Http) { }


//     //** GET Staff Member by Id from view  **
//     getAllStaffMembers(organizationId: number): Observable<StaffMember> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         cpParams.set('organizationId', organizationId.toString());
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getStaffbyIdUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }

//     insertStaffRole(staffRoleObject: StaffRole): Observable<number> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let options = new RequestOptions({ headers: cpHeaders });
//         return this.http.post(this.addstaffroleUrl, staffRoleObject, options)
//             .map(success => success.status)
//             .catch(this.handleError);
//     }
//     getStaffMemberById(staffId: number): Observable<StaffMember> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
// 		let cpParams = new URLSearchParams();
//         cpParams.set('staffId', staffId.toString());
// 		let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
// 		return this.http.get(this.getStaffMemberbyIdUrl, options)
//         .map(this.extractData)
//         .catch(this.handleError);
//     }
//     insertStaffMember(staffMemberObject: StaffMember): Observable<StaffMember> {
//         console.log("inside   insertStaffMember service.")
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token":localStorage.getItem('jwt') });
//         let options = new RequestOptions({ headers: cpHeaders });
//         return this.http.post(this.addstaffmemberUrl, staffMemberObject, options)
//         .map(this.extractData)
//         .catch(this.handleError);
//     }
//   // ** Update Staff Member **
//   updateStaffMember(staffMemberObject: StaffMember):Observable<StaffMember> {
//     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
//     let options = new RequestOptions({ headers: cpHeaders });
//     return this.http.put(this.updateStaffMemberUrl, staffMemberObject, options)
//     .map(this.extractData)
//     .catch(this.handleError);
// }

// updateStaffPayment(staffPaymentObj: StaffPaymentDetails):Observable<StaffMember> {
//     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
//     let options = new RequestOptions({ headers: cpHeaders});
//     return this.http.put(this.updatePaymentStatusUrl, StaffPaymentDetails, options)
//     .map(this.extractData)
//     .catch(this.handleError);
// }


// // updateStaffPayment():Observable<StaffMember> {
// //     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
// //     let options = new RequestOptions({ headers: cpHeaders});
// //     return this.http.put(this.updatePaymentStatusUrl, options)
// //     .map(this.extractData)
// //     .catch(this.handleError);
// // }

// // ** Active or Deactive Student Profile **
// updateStudentStatus(staffId: number): Observable<number> {
//     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//     let cpParams = new URLSearchParams();
//     cpParams.set('staffId', staffId.toString());
//     let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//     return this.http.put(this.updateStudStatusUrl, options)
//         .map(success => success.status)
//         .catch(this.handleError);
// }
   
//  // ** Update Staff Member **
//  updateStaffRole(staffRoleObject: StaffRole):Observable<number> {
//     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
//     let options = new RequestOptions({ headers: cpHeaders });
//     return this.http.put(this.updateStaffRoleUrl, staffRoleObject, options)
//     .map(success => success.status)
//     .catch(this.handleError);
// }

// //delete master lookup
// deleteStaffMember(staffId: number): Observable<number> {
//     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//     let cpParams = new URLSearchParams();
//     cpParams.set('staffId', staffId.toString());
//     let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//     return this.http.delete(this.deleteStaffMemberUrl, options)
//         .map(success => success.status)
//         .catch(this.handleError);
// }



//     private extractData(res: Response) {
//         let body = res.json();
//         return body;
//     }

//     private handleError(error: Response | any) {
//         console.error(error.message || error);
//         return Observable.throw(error.status);
//     }
// }