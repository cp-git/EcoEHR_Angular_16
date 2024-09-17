import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions, URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs';
import { AppSettings } from '../../appsettings';

import { patch } from 'webdriver-js-extender';
import { PatientAllergy } from '../models/patientAllergy';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable()
export class PatientAllergyService {
  
    insertAllergyUrl = AppSettings.API_ENDPOINT + "./allergy/createPatientAllergy";
    getAllergyListUrl = AppSettings.API_ENDPOINT + "./allergy/getAllPatientAllergy"
    getmasterpreventiveListUrl = AppSettings.API_ENDPOINT + "./masterpreventive/getAllMasterPreventiveCare"
    deletePatientAllergyUrl =  AppSettings.API_ENDPOINT + "./allergy/deletePatientAllergy"
    constructor(private http: HttpClient) { }

    //insert patient Medication
    // insertAllergy(allergy: PatientAllergy[]): Observable<number> {
    //     //console.log(allergy)
    //       let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //       let options = new RequestOptions({ headers: cpHeaders });
    //       return this.http.post(this.insertAllergyUrl, allergy, options)
    //           .map(success => success.status)
    //           .catch(this.handleError);
    //   }

      getPatientAllergies(patientId: { toString: () => string; }): Observable<PatientAllergy[]> {
        const token = localStorage.getItem('jwt') || '';
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token
        });
    
        const params = new HttpParams().set('patientId', patientId.toString());
    
        return this.http.get<PatientAllergy[]>(this.getAllergyListUrl, { headers, params });
    }

    // getPatientMastPreventitive(patientId: { toString: () => string; }): Observable<MasterPreventive[]> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let cpParams = new URLSearchParams();
    //     cpParams.set('patientId', patientId.toString());
    //    // console.log("Master Prev Service: "+ patientId);
    //     let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.get(this.getmasterpreventiveListUrl, options)
    //         .map(this.extractData)
    //         .catch(this.handleError);
    // }
   
    //    deletePatientAllergies(patientAllergyId: number):Observable<number> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
	// 	let cpParams = new URLSearchParams();
    //     cpParams.set('patientAllergyId', patientAllergyId.toString());
	// 	let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.delete(this.deletePatientAllergyUrl, options)
    //     .map(success => success.status)
    //            .catch(this.handleError);
    // }
  
    // private extractData(res: Response) {
    //     //console.log(res.toString())
    //     let body = res.json();
    //     return body;
    // }

    // private handleError(error: Response | any) {
    //     console.error(error.message || error);
    //     return Observable.throw(error.status);
    // }
}