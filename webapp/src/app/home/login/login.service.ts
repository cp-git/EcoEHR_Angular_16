
import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams, HttpResponse  } from '@angular/common/http';
// import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable, throwError } from 'rxjs';
import { AppSettings } from '../../appsettings';
import { StaffMember } from '../../administration/staff-members//staffmember';
import { StaffPaymentDetails } from "./payment/staffpaymentdetails";
import { RequestDemo } from "../aboutus/request-for-demo";
import {tap} from 'rxjs/internal/operators';
import {map, catchError } from 'rxjs/operators'




@Injectable({
    providedIn :'root'
})
export class LoginService {

    constructor(private http: HttpClient) { }

    updateStaffLastActionURL = AppSettings.API_ENDPOINT + "./admin/modifyStaffMemberLastActionById";
    requestForDemoURL = AppSettings.API_ENDPOINT + "./payment/requestForDemo";
    updateStaffPaymentDetailsURL = AppSettings.API_ENDPOINT + "./payment/modifyStaffPaymentDetails";
    getStaffPaymentStatusURL = AppSettings.API_ENDPOINT + "./admin/getPaymentInfo";
    updateLoginTimeURL = AppSettings.API_ENDPOINT + "./payment/setUserLoginTime";
    updateLogoutTimeURL = AppSettings.API_ENDPOINT + "./payment/setUserLogoutTime";
    getLoginStatusURL = AppSettings.API_ENDPOINT + "./payment/getUserLoginStatus";

    // login(userName: any, password: any): Observable<Response> {
    //     let loginRequest = JSON.stringify({ loginId: userName, loginKey: password });
    //     let headers = new Headers({ 'Content-Type': 'application/json', 'Accept': 'application/json' });
    //     headers.append('Access-Control-Allow-Headers', 'Content-Type');
    //     return this.http.post(AppSettings.API_AUTH_ENDPOINT + '/auth/login', loginRequest)
    //         .pipe(tap((resp: { headers: { get: (arg0: string) => string; }; }) => {
    //             localStorage.setItem('jwt', resp.headers.get('x-auth-token'));            
    //         }).catch(this.handleError));
    // }

    // login(userName: string, password: string): Observable<any> {
    //     // const loginRequest = { loginId: userName, loginKey: password };
    //     let loginRequest = JSON.stringify({ loginId: userName, loginKey: password });
    //     const cpheaders = new HttpHeaders({
    //       'Content-Type': 'application/json',
    //       'Accept': 'application/json'
    //     });
    //     cpheaders.append('Access-Control-Allow-Headers', 'Content-Type');

    // console.log("Before api call")
    // console.log(cpheaders)
    // console.log(loginRequest)
    // console.log(AppSettings.API_AUTH_ENDPOINT)
    // console.log( localStorage.getItem('jwt') )

    //     return this.http.post<any>(AppSettings.API_AUTH_ENDPOINT + '/auth/login', loginRequest )
    //       .pipe(
         
    //         tap((resp: any) => {
    //           console.log("After api call")
    //           console.log(resp)
    //           // Replace this with the appropriate way to get the token from the response
    //           const token = resp.headers.get("x-auth-token");
    //           if (token) {
    //             localStorage.setItem('jwt', token);
    //           }
    //         }),
    //         catchError(this.handleError)
    //       );
    //   }
    
    login(userName: string, password: string): Observable<HttpResponse<any>> {
      const loginRequest = { loginId: userName, loginKey: password };
      const headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Accept': 'application/json'
      });
  
      console.log("Before API call");
      console.log("Headers:", headers);
      console.log("Request body:", loginRequest);
  
      return this.http.post<any>(
        `${AppSettings.API_AUTH_ENDPOINT}/auth/login`, 
        loginRequest, 
        { headers, observe: 'response' }  // Observe the response to access headers
      ).pipe(
        tap((resp: HttpResponse<any>) => {
          console.log("After API call");
          console.log("Response:", resp);
          // Extract the token from the response headers
          const token = resp.headers.get('x-auth-token');
          if (token) {
            localStorage.setItem('jwt', token);
            console.log( localStorage.getItem('jwt'))
          }
        }),
        catchError(this.handleError)
      );
    }
  
      private handleError(error: any) {
        console.error('An error occurred:', error);
        return throwError(() => new Error('Something went wrong; please try again later.'));
      }

    // getStaffPaymentStatus(): Observable<StaffPaymentDetails> {
    //     const token = localStorage.getItem('jwt');
    //     const cpHeaders = new HttpHeaders({
    //       'Content-Type': 'application/json',
    //       'x-auth-token': token ? token : ''
    //     });
	// 	let options = new RequestOptions({ headers: cpHeaders });
	// 	return this.http.get(this.getStaffPaymentStatusURL, options)
	// 		.map(this.extractData)
	// 		.catch(this.handleError);
    // }
    getStaffPaymentStatus(): Observable<StaffPaymentDetails> {
        const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
    
        return this.http.get<StaffPaymentDetails>(this.getStaffPaymentStatusURL, { headers })
          .pipe(
            map(this.extractDataStaffPaymentDetails),
            catchError(this.handleError)
          );
      }

    updateStaffLastAction(staffMemberObject: StaffMember): Observable<number> {
       
        const token = localStorage.getItem('jwt');
        const cpHeaders = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
        const options = { cpHeaders, observe: 'response' as 'response' };

        // let options = new RequestOptions({ headers: cpHeaders });
        return this.http.put<StaffMember>(this.updateStaffLastActionURL, staffMemberObject, options)
        .pipe(    
        map((success: { status: any; }) => success.status),
            catchError(this.handleError)
        );
    }

    // updateStaffPaymentDetails(paymentDetailsObject: StaffPaymentDetails): Observable<number>{
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
    //     let options = new RequestOptions({ headers: cpHeaders });
    //     return this.http.put(this.updateStaffPaymentDetailsURL, paymentDetailsObject, options)
    //         .map((success: { status: any; }) => success.status)
    //         .catch(this.handleError);
    // }
    // updateStaffPaymentDetails(paymentDetailsObject: StaffPaymentDetails): Observable<number> {
    //     const headers = new HttpHeaders({
    //       'Content-Type': 'application/json',
    //       'x-auth-token': localStorage.getItem('jwt') || ''
    //     });
    
    //     return this.http.put(this.updateStaffPaymentDetailsURL, paymentDetailsObject, { headers, responseType: 'text' as 'json' })
    //       .pipe(
    //         map((response: any) => {
    //           // If the response is a status or any other relevant data, handle it accordingly
    //           // Here, assuming `response` is a text and we are extracting a number
    //           return parseInt(response, 10); // Convert the response to a number
    //         }),
    //         catchError(this.handleError)
    //       );
    //   }

      updateStaffPaymentDetails(paymentDetailsObject: StaffPaymentDetails): Observable<number> {
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': localStorage.getItem('jwt') || ''
        });
      
        return this.http.put(this.updateStaffPaymentDetailsURL, paymentDetailsObject, { headers, responseType: 'json' })
          .pipe(
            map((response: any) => {
              // If the response is a status or any other relevant data, handle it accordingly
              // Here, assuming `response` contains a field 'status' we are interested in
              return response.status; // or any other field you need from the response
            }),
            catchError(this.handleError)
          );
      }

    updateLogoutTime(staffDetails: StaffMember): Observable<StaffMember> {
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': localStorage.getItem('jwt') || ''
        });
    
        return this.http.put<StaffMember>(this.updateLogoutTimeURL, staffDetails, { headers })
          .pipe(
            catchError(this.handleError) // Handle errors without modifying response type
          );
      }
    

    // getLoginStatus(): Observable<StaffMember>{
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
    //     // let cpParams = new URLSearchParams();
    //     // cpParams.set('loginId', userName.toString());
	// 	let options = new RequestOptions({ headers: cpHeaders});
    //     return this.http.get(this.getLoginStatusURL, options)
    //      .map(this.extractData)
    //     .catch(this.handleError);
    // }

    updateLoginTime(staffDetails: StaffMember): Observable<StaffMember>{
        const token = localStorage.getItem('jwt');
        const cpHeaders = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
    
        
        // let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
        // let options = new RequestOptions({ headers: cpHeaders });
        const options = { cpHeaders, observe: 'response' as 'response' };

        return this.http.put(this.updateLoginTimeURL, staffDetails, options)
        
        .pipe(
        map(this.extractDataStaffMember),
        catchError(this.handleError)
        );
    }

    getLoginStatus(): Observable<StaffMember> {
        const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
    
        return this.http.get<StaffMember>(this.getLoginStatusURL, { headers })
          .pipe(
            map((response: any) => this.extractDataStaffMember(response)),
            catchError(this.handleError)
          );
      }

     

    // updateLogoutTime(staffDetails: StaffMember): Observable<StaffMember>{
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
    //     let options = new RequestOptions({ headers: cpHeaders });
    //     return this.http.put(this.updateLogoutTimeURL, staffDetails, options)
    //     .map(this.extractData)
    //     .catch(this.handleError);
    // }

    requestForDemo(demoObj: RequestDemo): Observable<number> {
        const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
    
        // Correct options object for HttpClient
        const options = { headers, observe: 'response' as 'response' };
    
        return this.http.post<HttpResponse<any>>(this.requestForDemoURL, demoObj, options)
          .pipe(
            map(response => response.status),
            catchError(this.handleError)
          );
      }

    private extractDataStaffPaymentDetails(res: any):StaffPaymentDetails {
		let body = res.json();
		return body;
    }

    private extractDataStaffMember(res: any):StaffMember {
		let body = res.json();
		return body;
    }
    // private extractData<T>(response: any): T {
    //     return response as T;
    //   }
    // private extractData(response: any): StaffMember {
    //     // Assuming response is of type StaffMember, adjust according to your response structure
    //     return response as StaffMember;
    //   }
    
    
    // private handleError(error: Response | any) {
    //     return Observable.throw(error.status);
    // }

    isSignedIn(): boolean {
        return localStorage.getItem('jwt') !== null;
    }
}
