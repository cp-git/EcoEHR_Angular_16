import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';

import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AppSettings } from 'src/app/appsettings';
import { EncounterQuestionOption } from '../models/encounterQuestionOption';


@Injectable()
export class EncounterQuestionOptionService {
    insertAllQuestionOptionsUrl = AppSettings.API_ENDPOINT+"./encQuestionOptions/createEncounterQuestionOptions";
    deleteEncQustionOptionsUrl =  AppSettings.API_ENDPOINT + "./encQuestionOptions/deleteQuestionOptions"
    
    constructor(private http:HttpClient) {}

     
    // insertQuestionOptions(encounterQuestionOption: EncounterQuestionOption[]): Observable<number> {

    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let options = new RequestOptions({ headers: cpHeaders });
    //     return this.http.post(this.insertAllQuestionOptionsUrl, encounterQuestionOption, options)
    //         .map(success => success.status)
    //         .catch(this.handleError);
    // }


      deleteEncQustionOptions(encounterId:number,sysName:string):Observable<number> {
       

        const token = localStorage.getItem('jwt') || '';
        const headers = new HttpHeaders({
            'Content-Type': 'application/json',
            'x-auth-token': token
        });
        
        
        const params = new HttpParams().set('encounterId', encounterId.toString()).set('sysType', sysName);;
 
       
 
        
        return this.http.delete<any>(this.deleteEncQustionOptionsUrl, {headers,params})

        
        
		// let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
        // return this.http.delete(this.deleteEncQustionOptionsUrl, options)
        // .map(success => success.status)
        //        .catch(this.handleError);
    }

    private extractData(res: Response) {
	    let body = res.json();
        return body;
    }
    
    private handleError (error: Response | any) {
		console.error(error.message || error);
		return Observable.throw(error.status);
    }
}