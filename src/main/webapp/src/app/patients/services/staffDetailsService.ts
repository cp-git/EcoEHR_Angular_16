import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';

import { AppSettings } from '../../appsettings';
import { StaffDetails } from 'src/app/administration/staff-members/StaffDetails';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable()
export class StaffDetailsService {
    //URLs for CRUD operations
	getCCMProviderUrl = AppSettings.API_ENDPOINT+"./admin/getCCMProviders";
	getStaffDetailsbyIdUrl=AppSettings.API_ENDPOINT+"./admin/getActiveStaffMemberFromView";
 	getAllStaffMembersUrl = AppSettings.API_ENDPOINT + "./admin/getListOfActiveStaffMembersfromsView";
	//Create constructor to get Http instance
	constructor(private http:HttpClient) { 
	}



    getCCMProvider(): Observable<StaffDetails[]> {
        const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
		return this.http.get<StaffDetails[]>(this.getCCMProviderUrl, {headers});



       
    }
	
	// getCCMProvider(): Observable<StaffDetails[]> {
		
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
	// 	let cpParams = new URLSearchParams();
       
	// 	let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.get(this.getCCMProviderUrl,options)
    //     .map(this.extractData)
    //     .catch(this.handleError);
	// }
	
	getAllStaffMembers(): Observable<StaffDetails[]> {

        const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
		return this.http.get<StaffDetails[]>(this.getAllStaffMembersUrl, {headers});
		
        // let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
		// let cpParams = new URLSearchParams();
        // //cpParams.set('organizationId', organizationId.toString());
		// let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
        // return this.http.get(this.getAllStaffMembersUrl,options)
        // .map(this.extractData)
        // .catch(this.handleError);
    }

	 getStaffDetailsById(staffId: number): Observable<StaffDetails> {

        const token = localStorage.getItem('jwt') || '';
		const headers = new HttpHeaders({
			'Content-Type': 'application/json',
			'x-auth-token': token
		});
		
		
		const params = new HttpParams().set('staffId', staffId.toString());

		return this.http.get<any>(this.getStaffDetailsbyIdUrl,{headers, params} )


        // let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
        // let cpParams = new URLSearchParams();
        // cpParams.set('staffId', staffId.toString());
       		
        // let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
        // return this.http.get(this.getStaffDetailsbyIdUrl, options)
        // .map(this.extractData)
        // .catch(this.handleError);
    }
	
	// private extractData(res: Response) {
	//     let body = res.json();
    //     return body;
    // }
    // private handleError (error: Response | any) {
	// 	console.error(error.message || error);
	// 	return Observable.throw(error.status);
    // }
}