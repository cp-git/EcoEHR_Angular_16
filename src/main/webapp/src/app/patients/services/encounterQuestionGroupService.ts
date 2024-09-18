import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { AppSettings } from 'src/app/appsettings';
import { EncounterQuestionGroup } from '../models/encounterQuestionGroup';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';



@Injectable()
export class EncounterQuestionGroupService {
    insertAllQuestionGroupsUrl = AppSettings.API_ENDPOINT + "./encounterQuestionGroup/createEncounterQuestionGroup";
    deleteEncQustionGroupUrl = AppSettings.API_ENDPOINT + "./encounterQuestionGroup/deleteQuestionGroups";
    constructor(private http: HttpClient) { }


    // insertQuestionGroups(encounterQuestionGroup: EncounterQuestionGroup[]): Observable<number> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let options = new RequestOptions({ headers: cpHeaders });
    //     return this.http.post(this.insertAllQuestionGroupsUrl, encounterQuestionGroup, options)
    //         .map(success => success.status)
    //         .catch(this.handleError);
    // }


    deleteEncQustionGroups(encounterId:number,sysName:string):Observable<number> {

        const token = localStorage.getItem('jwt') || '';
        const headers = new HttpHeaders({
            'Content-Type': 'application/json',
            'x-auth-token': token
        });
        
        
        const params = new HttpParams().set('encounterId', encounterId.toString()).set('sysType', sysName);
        return this.http.delete<any>(this.deleteEncQustionGroupUrl, {headers,params})

        // let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
		// let cpParams = new URLSearchParams();
        // cpParams.set('encounterId', encounterId.toString());
        // cpParams.set('sysType', sysName.toString());
		// let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
        // return this.http.delete(this.deleteEncQustionGroupUrl, options)
        // .map(success => success.status)
        //        .catch(this.handleError);
    }
    private extractData(res: Response) {
        let body = res.json();
        return body;
    }

    private handleError(error: Response | any) {
        console.error(error.message || error);
        return Observable.throw(error.status);
    }
}