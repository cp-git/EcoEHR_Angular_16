import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { AppSettings } from '../../appsettings';
import { Orders } from '../models/orders';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable()
export class OrdersService {
	//URLs for CRUD operations
	addOrderUrl = AppSettings.API_ENDPOINT + "./order/createOrders";
	getAllOrderUrl = AppSettings.API_ENDPOINT + "./order/getAllOrders";
	getOrdersByPatientIdUrl = AppSettings.API_ENDPOINT + "./order/getOrdersByPatientId";
	getOrdersByPatientIdAndEncIdUrl = AppSettings.API_ENDPOINT + "./order/getOrdersByPatientIdEncId";
	updateOrderUrl = AppSettings.API_ENDPOINT + "./order/modifyOrders";
	deletOrdertDataUrl = AppSettings.API_ENDPOINT + "./order/removeOrdersById";
    
	//Create constructor to get Http instance
	constructor(private http: HttpClient) {
	}

	insertOrders(orders: Orders): Observable<Orders> {


		const token = localStorage.getItem('jwt');
        const headers = new HttpHeaders({
          'Content-Type': 'application/json',
          'x-auth-token': token ? token : ''
        });
    
		return this.http.post<any>(this.addOrderUrl, orders, {headers})

		// let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
		// let options = new RequestOptions({ headers: cpHeaders });
		// return this.http.post(this.addOrderUrl, orders, options)
		// 	.map(this.extractData)
		// 	.catch(this.handleError);
	}

	// getAllOrders(): Observable<Orders[]> {
	// 	let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
	// 	let options = new RequestOptions({ headers: cpHeaders });
	// 	return this.http.get(this.getAllOrderUrl, options)
	// 		.map(this.extractData)
	// 		.catch(this.handleError);
	// }

	// getOrdersByPatientId(patientId: number): Observable<Orders[]> {
	// 	let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
	// 	let cpParams = new URLSearchParams();
	// 	cpParams.set('patientId', patientId.toString());
	// 	let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
	// 	return this.http.get(this.getOrdersByPatientIdUrl, options)
	// 		.map(this.extractData)
	// 		.catch(this.handleError);
	// }

	getOrdersByPatientIdEncId(patientId: number, encounterId: number ): Observable<Orders[]> {

		const token = localStorage.getItem('jwt') || '';
        const headers = new HttpHeaders({
            'Content-Type': 'application/json',
            'x-auth-token': token
        });
        
        
        const params = new HttpParams().set('encounterId', encounterId.toString()).set('patientId', patientId.toString());
        return this.http.get<any>(this.getOrdersByPatientIdAndEncIdUrl, {headers,params})


		// let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
		// let cpParams = new URLSearchParams();
		// cpParams.set('patientId', patientId.toString());
		// cpParams.set('encounterId', encounterId.toString());
		// let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
		// return this.http.get(this.getOrdersByPatientIdAndEncIdUrl, options)
		// 	.map(this.extractData)
		// 	.catch(this.handleError);
	}

	// getOrdersByPaitIdEncId(patientId: number, encounterId: number ): Observable<MedOrders[]> {
	// 	let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
	// 	let cpParams = new URLSearchParams();
	// 	cpParams.set('patientId', patientId.toString());
	// 	cpParams.set('encounterId', encounterId.toString());
	// 	let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
	// 	return this.http.get(this.getOrdersByPatientIdAndEncIdUrl, options)
	// 		.map(this.extractData)
	// 		.catch(this.handleError);
	// }

	// updateOrders(orderDetails: Orders): Observable<Orders> {
	// 	let cpHeaders = new Headers({ 'Content-Type': 'application/json', "x-auth-token": localStorage.getItem('jwt') });
	// 	let options = new RequestOptions({ headers: cpHeaders });
	// 	return this.http.put(this.updateOrderUrl, orderDetails, options)
	// 		.map(this.extractData)
	// 		.catch(this.handleError);
	// }

	// deletOrdertData(orderId: number):Observable<number> {
    //     let cpHeaders = new Headers({ 'Content-Type': 'application/json' , "x-auth-token":localStorage.getItem('jwt')});
	// 	let cpParams = new URLSearchParams();
    //     cpParams.set('orderId', orderId.toString());
	// 	let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
    //     return this.http.delete(this.deletOrdertDataUrl, options)
    //     .map(success => success.status)
    //            .catch(this.handleError);
    // }
	// private extractData(res: Response) {
	// 	let body = res.json();
	// 	return body;
	// }
	// private handleError(error: Response | any) {
	// 	console.error(error.message || error);
	// 	return Observable.throw(error.status);
	// }
}