import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { System } from "../models/system";
import { AppSettings } from "../../appsettings";

@Injectable({
    providedIn:'root'
})
export class SystemService {

    getallSystemUrl = AppSettings.API_ENDPOINT + "./system/getListOfSystems";
    getRefLinkForSysCodeURL = AppSettings.API_ENDPOINT + "./system/getSystemInfoById";
    constructor(private http: HttpClient) {}

    // getAllSystems(): Observable<System[]> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let options = new RequestOptions({ headers: cpHeaders });
    //     return this.http.get(this.getallSystemUrl, options)
    //         .map(this.extractData)
    //         .catch(this.handleError);
    // }


    getAllSystems(): Observable<System[]> {
        const token = localStorage.getItem('jwt') ;
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
        const options = {headers}
    
        if (!this.getallSystemUrl) {
          return throwError('API URL is not set');
        }
    
        return this.http.get<System[]>(this.getallSystemUrl, options)
        .pipe(
          map((response: any) => this.extractData(response)),
          catchError(this.handleError)
        );
      }

      getReferenceLinkForSysCode(sysCode: string): Observable<System> {
        const token = localStorage.getItem('jwt') || '';
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token
        });
        const params = new HttpParams().set('sysCode', sysCode);
    
        return this.http.get<System>(this.getRefLinkForSysCodeURL, { headers, params }).pipe(
          map(response => this.extractData(response)),
          catchError(this.handleError)
        );
      }
    

    private extractData(res:any) {
        let body = res.json();
        return body;
    }

   
    private handleError(error: Response | any) {
        console.error(error.message || error);
        return Observable.throw(error.status);
    }
}