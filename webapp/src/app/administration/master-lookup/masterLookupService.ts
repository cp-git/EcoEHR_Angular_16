// import { Injectable } from '@angular/core';
// import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
// import { Observable } from 'rxjs';
// import { AppSettings } from 'app/appsettings';
// import { MasterLookup } from 'app/administration/master-lookup/masterLookup';
// @Injectable()
// export class MasterLookupService {

//     getAllMasterLookupTypeUrl = AppSettings.API_ENDPOINT + "./admin/getListOfMasterLookupType";
//     getAllMasterlookupUrl = AppSettings.API_ENDPOINT + "./admin/getListOfMasterLookup";
//     getAddressStateUrl = AppSettings.API_ENDPOINT + "./admin/getListOfAddressStates";
//     getFrequencyUrl = AppSettings.API_ENDPOINT + "./admin/getListOfFrequency";
//     getRouteUrl = AppSettings.API_ENDPOINT + "./admin/getRoute";
//     getPatientStatusUrl = AppSettings.API_ENDPOINT + "./admin/getListOfPatientStatus";
//     getCredentialsUrl = AppSettings.API_ENDPOINT + "./admin/getListOfCredentials";
//     getProviderTypesUrl = AppSettings.API_ENDPOINT + "./admin/getListOfProviderTypes";
//     getSpecializationTypesUrl = AppSettings.API_ENDPOINT + "./admin/getListOfSpecializationForStud";
//     insertMasterLookupUrl = AppSettings.API_ENDPOINT + "./admin/createMasterLookup";
//     insertCredentialsUrl = AppSettings.API_ENDPOINT + "./admin/createCredentials";
//     deleteMasterLookupUrl = AppSettings.API_ENDPOINT + "./admin/removeMasterLookup";
//     getRefillUrl = AppSettings.API_ENDPOINT + "./admin/getListOfMasterLookupByRefillType";
//     getDiscontinuedReasonUrl = AppSettings.API_ENDPOINT + "./admin/getListOfMasterLookupByDiscontinuesReason";
//     getTitleUrl = AppSettings.API_ENDPOINT + "./admin/getTitles";
//     getLangUrl = AppSettings.API_ENDPOINT + "./admin/getLanguage";
//     getRaceUrl = AppSettings.API_ENDPOINT + "./admin/getRace";
//     getEthnicityUrl = AppSettings.API_ENDPOINT + "./admin/getEthnicity";
    
//     //Create constructor to get Http instance
//     constructor(private http: Http) { }

//     getAllMasterLookupType(): Observable<string> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getAllMasterLookupTypeUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }

//     getAllMasterlookup(): Observable<MasterLookup[]> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getAllMasterlookupUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }

//     insertMasterLookup(masterlookup: MasterLookup): Observable<number> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let options = new RequestOptions({ headers: cpHeaders });
//         return this.http.post(this.insertMasterLookupUrl, masterlookup, options)
//             .map(success => success.status)
//             .catch(this.handleError);
//     }

//     getAddressState(): Observable<MasterLookup[]> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getAddressStateUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }

//     getFrequency(): Observable<MasterLookup[]> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getFrequencyUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }

//     getTitles(): Observable<MasterLookup[]> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getTitleUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }

//     getLanguage(): Observable<MasterLookup[]> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getLangUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }

//     getRace(): Observable<MasterLookup[]> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getRaceUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }

//     getEthnicity(): Observable<MasterLookup[]> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getEthnicityUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }

//     getRoute(): Observable<MasterLookup[]> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getRouteUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }

//     getCredentials(): Observable<MasterLookup[]> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getCredentialsUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }
//     getProviderTypes(): Observable<MasterLookup[]> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getProviderTypesUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }

//     getSpecializationTypes(): Observable<MasterLookup[]> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getSpecializationTypesUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }

//     insertCredentials(credentials: MasterLookup): Observable<number> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let options = new RequestOptions({ headers: cpHeaders });
//         return this.http.post(this.insertCredentialsUrl, credentials, options)
//             .map(success => success.status)
//             .catch(this.handleError);
//     }

//     getPatientStatus(): Observable<MasterLookup[]> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getPatientStatusUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }

//     //delete master lookup
//     deleteMasterLookup(lookupId: number): Observable<number> {
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         cpParams.set('lookupId', lookupId.toString());
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.delete(this.deleteMasterLookupUrl, options)
//             .map(success => success.status)
//             .catch(this.handleError);
//     }

//     getLookUpTypeAsRefill(): Observable<MasterLookup[]> {
//         //console.log("MSTLOOKUPRefillService");
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getRefillUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }

//     getLookUpTypeAsDiscontinued_Reason(): Observable<MasterLookup[]> {
//         //console.log("MSTLOOKUPRefillService");
//         let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
//         let cpParams = new URLSearchParams();
//         let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
//         return this.http.get(this.getDiscontinuedReasonUrl, options)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }


//     private extractData(res: Response) {
//         let body = res.json();
//         return body;
//     }

//     private handleError(error: Response | any) {
//         console.error(error.message || error);
//         return Observable.throw(error.status);
//     }
// }