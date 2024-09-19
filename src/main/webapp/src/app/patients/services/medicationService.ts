import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions, URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs';
import { AppSettings } from '../../appsettings';
import { PatientMedication } from '../models/PatientMedication';
import { PatientMedicationRecord } from '../models/patientMedicationRecord';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';


@Injectable()
export class MedicationService {
    discontinueMedicationUrl = AppSettings.API_ENDPOINT+"./patientMedication/deletePatientMedication";
    insertAllMedicationUrl = AppSettings.API_ENDPOINT + "./patientMedication/createPatientMedication";
    getMedicationListUrl = AppSettings.API_ENDPOINT + "./patientMedication/getListOfPatientMedication";
    getMedicationByEncIdUrl=AppSettings.API_ENDPOINT + "./patientMedication/getListPatientMedicationByEncId"
    deleteMedicationByEncIdUrl=AppSettings.API_ENDPOINT + "./patientMedication/deletePatientMedicationByenc"
    
    constructor(private http: HttpClient) { }

    //insert patient Medication
    insertAllMedication(medication: PatientMedication[]): Observable<number> {
        const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
    
		return this.http.post<any>(this.insertAllMedicationUrl, medication, {headers})
       // console.log(medication)
        //   let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        //   let options = new RequestOptions({ headers: cpHeaders });
        //   return this.http.post(this.insertAllMedicationUrl, medication, options)
        //       .map(success => success.status)
        //       .catch(this.handleError);
      }

      getPatientMedications(patientId:any): Observable<PatientMedicationRecord[]> {

        const token = localStorage.getItem('jwt') || '';
		const headers = new HttpHeaders({
			'Content-Type': 'application/json',
			'x-auth-token': token
		});
		
		
		const params = new HttpParams().set('patientId', patientId.toString());

		return this.http.get<any>(this.getMedicationListUrl,{headers, params} )


        // let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        // let cpParams = new URLSearchParams();
        // cpParams.set('patientId', patientId.toString());
        // let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
        // return this.http.get(this.getMedicationListUrl, options)
        //     .map(this.extractData)
        //     .catch(this.handleError);
    }

    // getMedicationByEncId(encounterId): Observable<PatientMedication[]> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let cpParams = new URLSearchParams();
    //     cpParams.set('encounterId', encounterId.toString());
    //     let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.get(this.getMedicationByEncIdUrl, options)
    //         .map(this.extractData)
    //         .catch(this.handleError);
    // }

    // deleteMedicationByEncId(encounterId): Observable<number> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let cpParams = new URLSearchParams();
    //     cpParams.set('encounterId', encounterId.toString());
    //     let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.delete(this.deleteMedicationByEncIdUrl, options)
    //         .map(success => success.status)
    //         .catch(this.handleError);
    // }

    // discontinueMedication(patientMedication: PatientMedication):Observable<number> {
	//     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
    //     let options = new RequestOptions({ headers: cpHeaders });
    //     return this.http.put(this.discontinueMedicationUrl, patientMedication, options)
    //            .map(success => success.status)
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