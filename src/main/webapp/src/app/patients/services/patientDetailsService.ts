import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { AppSettings } from '../../appsettings';
import { PatientDetails } from '../models/PatientDetails';
import { PatientRecord } from '../models/PatientRecord';
import {map, catchError } from 'rxjs/operators'
import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';

@Injectable()
export class PatientDetailsService {
	//URLs for CRUD operations
	addPatientDetailsUrl = AppSettings.API_ENDPOINT + "./patients/createPatientDetails";
	getAllPatientsUrl = AppSettings.API_ENDPOINT + "./patients/getListOfActivePatientsfromsView";
	getPatientByPatientIdUrl = AppSettings.API_ENDPOINT + "./patients/getPatientByPatientId";
	updatePatientDetailsUrl = AppSettings.API_ENDPOINT + "./patients/modifyPatientDetails";
    getPatientRecordByPatientIdUrl = AppSettings.API_ENDPOINT + "./patients/getPatientRecordByPatientId";
	getPatientRecordByUserIdUrl = AppSettings.API_ENDPOINT + "./patients/getListOfActivePatientByUserId";
	//Create constructor to get Http instance
	constructor(private http: HttpClient) {
	}

	inserPatientDetails(patientDetails: PatientDetails): Observable<PatientDetails> {

		const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
    
		return this.http.post<any>(this.addPatientDetailsUrl, patientDetails, {headers})
		
	}



	getAllPatients(): Observable<PatientRecord[]> {
		const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
		return this.http.get<PatientRecord[]>(this.getAllPatientsUrl, {headers});
	  }
	// getAllPatients(): Observable<PatientRecord[]> {

	// 	const token = localStorage.getItem('jwt');
    //     const headers = new HttpHeaders({
    //       'Content-Type': 'application/json',
    //       'x-auth-token': token ? token : ''
    //     });
	// 	return this.http.get(this.getAllPatientsUrl, {headers});
		

		
	
	// }

	getAllPatientsByUserId(): Observable<PatientRecord[]> {
		const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
		return this.http.get(this.getPatientRecordByUserIdUrl, {headers})
		.pipe(
		map((response: any) => this.extractData(response)),
		//catchError(this.handleError)
		);
	}

	getPatientRecordsByPatientId(patientId: number): Observable<PatientRecord> {
		const token = localStorage.getItem('jwt') || '';
		const headers = new HttpHeaders({
			'Content-Type': 'application/json',
			'x-auth-token': token
		});
		
		
		const params = new HttpParams().set('patientId', patientId.toString());

		return this.http.get(this.getPatientRecordByPatientIdUrl, {headers, params})
		.pipe(
			map((response: any) => this.extractData(response)),
		//	catchError(this.handleError)
		);
	}

	getPatientDetailsByPatientId(patientId: number): Observable<PatientDetails> {
		const token = localStorage.getItem('jwt') || '';
		const headers = new HttpHeaders({
			'Content-Type': 'application/json',
			'x-auth-token': token
		});
		
		
		const params = new HttpParams().set('patientId', patientId.toString());

		return this.http.get<any>(this.getPatientByPatientIdUrl,{headers, params} )
	
	}

	updatePatientDetails(patientDetails: PatientDetails): Observable<PatientDetails> {
		const token = localStorage.getItem('jwt') || '';
		const headers = new HttpHeaders({
			'Content-Type': 'application/json',
			'x-auth-token': token
		});
		return this.http.put<any>(this.updatePatientDetailsUrl, patientDetails, {headers})
	
	}

	private extractData(res: Response) {
		let body = res.json();
		return body;
	}
	// private handleError(error: Response | any) {
	// 	console.error(error.message || error);
	// 	return Observable.throw(error.status);
	// }
}