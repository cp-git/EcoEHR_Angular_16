import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions, URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs';
import { Template } from '../models/template';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AppSettings } from 'src/app/appsettings';

@Injectable()
export class TemplateService {

    addTemplateUrl = AppSettings.API_ENDPOINT + "./template/createTemplate";
    getAllActiveTemplatesUrl = AppSettings.API_ENDPOINT + "./template/getAllActiveTemplates";
    getAllActiveTemplatesByEncIdUrl = AppSettings.API_ENDPOINT + "./template/getAllActiveTemplatesByEncId";
    getActiveTemplateBySystemIdUrl = AppSettings.API_ENDPOINT + "./template/getActiveTemplateBySystemId";
    getActiveTemplateByEncIdUrl = AppSettings.API_ENDPOINT + "./template/getActiveTemplateByEncId";
   
    constructor(private http: HttpClient) {}

    //insert encounter
    // insertTemplate(template: Template): Observable<Template> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let options = new RequestOptions({ headers: cpHeaders });
    //     return this.http.post(this.addTemplateUrl, template, options)
    //         .map(this.extractData)
    //         .catch(this.handleError);
    // }
    
    getAllActiveTemplates(): Observable<Template[]> {
        const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
		return this.http.get<Template[]>(this.getAllActiveTemplatesUrl, {headers});
        // let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
        // let options = new RequestOptions({ headers: cpHeaders });
        // return this.http.get(this.getAllActiveTemplatesUrl, options)
        //     .map(this.extractData)
        //     .catch(this.handleError);
    }

    // getAllActiveTemplatesByEncId(encounterId:number): Observable<Template[]> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let cpParams = new URLSearchParams();
    //     cpParams.set('encounterId', encounterId.toString());
	// 	let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.get(this.getAllActiveTemplatesByEncIdUrl, options)
    //         .map(this.extractData)
    //         .catch(this.handleError);
    // }

    // getActiveTemplateBySystemId(systemId:number): Observable<Template> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let cpParams = new URLSearchParams();
	// 	cpParams.set('systemId', systemId.toString());
	// 	let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.get(this.getActiveTemplateBySystemIdUrl, options)
    //         .map(this.extractData)
    //         .catch(this.handleError);
    // }

    // getActiveTemplateByEncId(systemId:number,encounterId:number,examName:string): Observable<Template> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let cpParams = new URLSearchParams();
	// 	cpParams.set('systemId', systemId.toString());
    //     cpParams.set('encounterId', encounterId.toString());
    //     cpParams.set('examName', examName.toString());
	// 	let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.get(this.getActiveTemplateByEncIdUrl, options)
    //         .map(this.extractData)
    //         .catch(this.handleError);
    // }

    // private extractData(res: Response) {
    //     let body = res.json();
    //     return body;
    // }

    // private handleError(error: Response | any) {
    //     console.error(error.message || error);
    //     return Observable.throw(error.status);
    // }
}