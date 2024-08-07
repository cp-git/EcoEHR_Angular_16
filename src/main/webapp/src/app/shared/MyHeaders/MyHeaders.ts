import {Injectable} from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';

@Injectable({
  providedIn:'root'
})
export class MyHeaders {

  constructor(private http: Http) {}

  createAuthorizationHeader(headers: Headers) {
    //headers.append('x-auth-token', localStorage.getItem("jwt")); 
  }

  get(url: string) {
    let headers = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem("jwt")});
    this.createAuthorizationHeader(headers);
    let options = new RequestOptions({ headers: headers});
    return this.http.get(url, options);
  }

  post(url: string, data: any) {
    let headers = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem("jwt")});
    this.createAuthorizationHeader(headers);
    let options = new RequestOptions({ headers: headers});
    return this.http.post(url, data, options);
  }

  put(url: string, data: any) {
    let headers = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem("jwt")});
    this.createAuthorizationHeader(headers);
    return this.http.post(url, data, {
      headers: headers
    });
  }

  delete(url: string,params: any) {
    let headers = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem("jwt")});
    this.createAuthorizationHeader(headers);
    let options = new RequestOptions({ headers: headers, params: params });
    return this.http.get(url, options);
  }
  getCall(url: string,params: any) {
    let headers = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem("jwt")});
    this.createAuthorizationHeader(headers);
    let options = new RequestOptions({ headers: headers, params: params });
    return this.http.get(url, options);
  }
}
