import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { AppSettings } from '../../appsettings';
import { QuestionGroup } from '../models/questionGroup';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map } from 'rxjs/operators';


@Injectable(
  {
    providedIn :'root'
  }
)
export class QuestionGroupService {
    getAllQuestionGroupsUrl = AppSettings.API_ENDPOINT+"./questionGroups/getAllQuestionGroups";
    constructor(private http:HttpClient) {}

     getAllQuestionGroups(): Observable<QuestionGroup[]> {
        const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
    
		return this.http.get(this.getAllQuestionGroupsUrl, {headers})
        .pipe(
        map(this.extractData),
        catchError(this.handleError)
        );
    }

    private extractData(res: Response | any) {
	    let body = res.json();
        return body;
    }
    
    private handleError (error: Response | any) {
		console.error(error.message || error);
		return Observable.throw(error.status);
    }
}