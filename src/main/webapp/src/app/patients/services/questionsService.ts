import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { AppSettings } from 'src/app/appsettings';
import { QuestionRecord } from '../models/questionRecord';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';


@Injectable()
export class QuestionsService {

    getAllQuestionsOfGroupUrl = AppSettings.API_ENDPOINT + "./questions/getListOfAllQuestionsBySystemId";
    
    constructor(private http: HttpClient) {}

   getAllQuestionsOfGroup(systemId:number): Observable<QuestionRecord[]> {

    const token = localStorage.getItem('jwt') || '';
    const headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'x-auth-token': token
    });
    
    
    const params = new HttpParams().set('systemId', systemId.toString());

    
    return this.http.get<any>(this.getAllQuestionsOfGroupUrl, {headers,params})

        // let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
        // let cpParams = new URLSearchParams();
        // cpParams.set('systemId', systemId.toString());
		// let options = new RequestOptions({ headers: cpHeaders,params: cpParams});
        // return this.http.get(this.getAllQuestionsOfGroupUrl, options)
        //  .map(this.extractData)
        // // .map(data=>{
        // //     let records:QuestionRecord[] = data.json();
        // //     return records.filter(d => d.questionGroupId == questionGroupId);
        // // })
        // .catch(this.handleError);
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