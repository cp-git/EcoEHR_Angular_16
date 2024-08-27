import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';

import { AppSettings } from '../../appsettings';
import { ClinicLocation } from '../models/ClinicLocation';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';

@Injectable()
export class ClinicLocationService {
    //URLs for CRUD operations
    
    getallClinicLocationUrl = AppSettings.API_ENDPOINT+"./admin/getListOfClinicLocations";
    getClinicLocationByIdUrl = AppSettings.API_ENDPOINT+"./admin/getClinicLocationById";
    addClinicLocationUrl = AppSettings.API_ENDPOINT+"./admin/createClinicLocation";
    updateClinicLocationUrl = AppSettings.API_ENDPOINT+"./admin/modifyClinicLocationById";
    deleteClinicLocationUrl =  AppSettings.API_ENDPOINT+"./admin/removeClinicLocationById";
    constructor(private http:HttpClient) { 
    }
    
    //Create Clinic location
    // insertClinicLocation(clinicLocation: ClinicLocation):Observable<number> {
       
	//     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token":localStorage.getItem('jwt') });
    //     let options = new RequestOptions({ headers: cpHeaders });
    //     return this.http.post(this.addClinicLocationUrl, clinicLocation, options)
    //            .map(success => success.status)
    //            .catch(this.handleError);
    // }

    //get all clinic locations
    // getAllClinicLocations(): Observable<ClinicLocation[]> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let cpParams = new URLSearchParams();
    //    // cpParams.set('organizationId', organizationId.toString());
    //     let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.get(this.getallClinicLocationUrl, options)
    //         .map(this.extractData)
    //         .catch(this.handleError);
    // }

    getAllClinicLocations(): Observable<ClinicLocation[]> {
        const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
		return this.http.get<ClinicLocation[]>(this.getallClinicLocationUrl, {headers});



       
    }

    
    //Fetch clinic location by id
    // getClinicLocationById(locationId: number): Observable<ClinicLocation> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
	// 	let cpParams = new URLSearchParams();
    //     cpParams.set('locationId', locationId.toString());
	// 	let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
	// 	return this.http.get(this.getClinicLocationByIdUrl, options)
    //     .map(this.extractData)
    //     .catch(this.handleError);
    // }
    //   //Update clinic location
    // updateClinicLocation(clinic: ClinicLocation):Observable<number> {
	//     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
    //     let options = new RequestOptions({ headers: cpHeaders });
    //     return this.http.put(this.updateClinicLocationUrl, clinic, options)
    //            .map(success => success.status)
    //            .catch(this.handleError);
    // } 

    //  //delete clinic location
    //  deleteClinicLocation(clinicLocation: ClinicLocation):Observable<number> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
	// 	let cpParams = new URLSearchParams();
    //     cpParams.set('locationId', clinicLocation.locationId.toString());
	// 	let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.delete(this.deleteClinicLocationUrl, options)
    //     .map(success => success.status)
    //            .catch(this.handleError);
    // }
    // private extractData(res: Response) {
	//     let body = res.json();
    //     return body;
    // }
    
    // private handleError (error: Response | any) {
	// 	console.error(error.message || error);
	// 	return Observable.throw(error.status);
    // }
}    