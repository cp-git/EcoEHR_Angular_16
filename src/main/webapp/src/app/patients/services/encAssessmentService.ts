import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions, URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs';
import { AppSettings } from '../../appsettings';
import { EncAsessment } from '../models/EncAsessment';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';


@Injectable()
export class EncAssessmentService {
    deleteAssessmentUrl = AppSettings.API_ENDPOINT + "./assessment/removeEncAsessmentById";
    addAssessmentUrl = AppSettings.API_ENDPOINT + "./assessment/createEncAsessment";
    getAssessmentByEncIdUrl = AppSettings.API_ENDPOINT + "./assessment/getEncAssessmentByEncId";

    constructor(private http: HttpClient) { }

    insertassessmentData(assessment: EncAsessment[]): Observable<number> {
        const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
            'Content-Type': 'application/json',
            'x-auth-token': token ? token : ''
          });
      
          return this.http.post<any>(this.addAssessmentUrl, assessment, {headers})

        // let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        // let options = new RequestOptions({ headers: cpHeaders });
        // return this.http.post(this.addAssessmentUrl, assessment, options)
        //     .map(success => success.status)
        //     .catch(this.handleError);
    }
    
    getAssessmentByEncId(encounterId:any): Observable<EncAsessment[]> {
        const token = localStorage.getItem('jwt') || '';
		const headers = new HttpHeaders({
			'Content-Type': 'application/json',
			'x-auth-token': token
		});
		
		
		const params = new HttpParams().set('encounterId', encounterId.toString());

		return this.http.get<any>(this.getAssessmentByEncIdUrl,{headers, params} )
	
        // let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        // let cpParams = new URLSearchParams();
        // //console.log("encounter id"+encounterId);
        // cpParams.set('encounterId', encounterId.toString());
        // let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
        // return this.http.get(this.getAssessmentByEncIdUrl, options)
        //     .map(this.extractData)
        //     .catch(this.handleError);
    }

    // deleteAssessmentData(encAsessmentId: number):Observable<number> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
	// 	let cpParams = new URLSearchParams();
    //     cpParams.set('encAsessmentId', encAsessmentId.toString());
	// 	let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.delete(this.deleteAssessmentUrl, options)
    //     .map(success => success.status)
    //            .catch(this.handleError);
    // }

    // private extractData(res: Response) {
    //    // console.log(res.toString())
    //     let body = res.json();
    //     return body;
    // }

    // private handleError(error: Response | any) {
    //     console.error(error.message || error);
    //     return Observable.throw(error.status);
    // }
}