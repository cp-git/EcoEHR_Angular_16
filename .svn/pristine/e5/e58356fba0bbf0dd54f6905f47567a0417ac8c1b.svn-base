import { Injectable } from "@angular/core";
import {
  Http,
  Response,
  Headers,
  URLSearchParams,
  RequestOptions
} from "@angular/http";
import { Observable } from "rxjs";
import { Reset } from './reset';
import { AppSettings } from "../../appsettings";

@Injectable()
export class ResetService {
  //URLs for CRUD operations
  checktokenUrl = AppSettings.API_ENDPOINT+"./home/auth/checktoken";
  resetUrl = AppSettings.API_ENDPOINT+"./home/auth/reset";
  //Create constructor to get Http instance
  constructor(private http: Http) {}

  checkToken(token: String): Observable<number> {
    let cpHeaders = new Headers({ "Content-Type": "application/json" });
    let options = new RequestOptions({ headers: cpHeaders });
    return this.http
      .post(this.checktokenUrl, token, options)
      .map(success => success.status)
      .catch(this.handleError);
  }

  updatePassword(reset:Reset)
  {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.post(this.resetUrl, reset, options)
               .map(success => success.status)
               .catch(this.handleError);
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
