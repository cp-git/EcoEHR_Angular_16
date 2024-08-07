import {Injectable} from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';

@Injectable()
export class MyHeaders {

  constructor(private http: Http) {}

  createAuthorizationHeader(headers: Headers) {
    //headers.append('x-auth-token', localStorage.getItem("jwt")); 
  }

  get(url) {
    let headers = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem("jwt")});
    this.createAuthorizationHeader(headers);
    let options = new RequestOptions({ headers: headers});
    return this.http.get(url, options);
  }

  post(url, data) {
    let headers = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem("jwt")});
    this.createAuthorizationHeader(headers);
    let options = new RequestOptions({ headers: headers});
    return this.http.post(url, data, options);
  }

  put(url, data) {
    let headers = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem("jwt")});
    this.createAuthorizationHeader(headers);
    return this.http.post(url, data, {
      headers: headers
    });
  }

  delete(url,params) {
    let headers = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem("jwt")});
    this.createAuthorizationHeader(headers);
    let options = new RequestOptions({ headers: headers, params: params });
    return this.http.get(url, options);
  }
  getCall(url,params) {
    let headers = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem("jwt")});
    this.createAuthorizationHeader(headers);
    let options = new RequestOptions({ headers: headers, params: params });
    return this.http.get(url, options);
  }
}
