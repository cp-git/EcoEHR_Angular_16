// import { Injectable } from '@angular/core';
// import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
// import { Observable } from 'rxjs';
// import { StaffDetails } from './StaffDetails';
// import { AppSettings } from '../../appsettings';

// @Injectable()
// export class StaffDetailsService {
//     //URLs for CRUD operations
// 	getCCMProviderUrl = AppSettings.API_ENDPOINT+"./admin/getCCMProviders";
// 	getStaffDetailsbyIdUrl=AppSettings.API_ENDPOINT+"./admin/getActiveStaffMemberFromView";
//  	getAllStaffMembersUrl = AppSettings.API_ENDPOINT + "./admin/getListOfActiveStaffMembersfromsView";
// 	//Create constructor to get Http instance
// 	constructor(private http:Http) { 
// 	}
	
// 	getCCMProvider(): Observable<StaffDetails[]> {
		
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
// 		let cpParams = new URLSearchParams();
       
// 		let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getCCMProviderUrl,options)
//         .map(this.extractData)
//         .catch(this.handleError);
// 	}
	
// 	getAllStaffMembers(): Observable<StaffDetails[]> {
		
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
// 		let cpParams = new URLSearchParams();
//         //cpParams.set('organizationId', organizationId.toString());
// 		let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getAllStaffMembersUrl,options)
//         .map(this.extractData)
//         .catch(this.handleError);
//     }

// 	 getStaffDetailsById(staffId: number): Observable<StaffDetails> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
//         let cpParams = new URLSearchParams();
//         cpParams.set('staffId', staffId.toString());
       		
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getStaffDetailsbyIdUrl, options)
//         .map(this.extractData)
//         .catch(this.handleError);
//     }
	
// 	private extractData(res: Response) {
// 	    let body = res.json();
//         return body;
//     }
//     private handleError (error: Response | any) {
// 		console.error(error.message || error);
// 		return Observable.throw(error.status);
//     }
// }