// import { Component, OnInit, Renderer2, Inject } from '@angular/core';
// import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
// import { Router } from '@angular/router';
// import { JwtHelper } from 'angular2-jwt';
// import { DOCUMENT } from '@angular/common';
// import { Data } from 'app/data';

// declare const $: any;

// @Component({
// 	selector: 'ehr-home-checkout',
// 	templateUrl: './payment.checkout.html',
// 	styleUrls: ['../home.component.css']
// })
// export class CheckoutComponent implements OnInit {
// 	checkoutForm: FormGroup;
// 	test: Date = new Date();
// 	errorMessage: String;
// 	statusCode: number;
// 	jwtHelper: JwtHelper = new JwtHelper();
// 	lastVisitedURL: string;
// 	isExpired: boolean = true;
//   fullName: any;

//     constructor(private formBuilder: FormBuilder,
//         private _renderer2: Renderer2, 
//         private sharedData: Data,
//         @Inject(DOCUMENT) private _document: Document,
// 		private router: Router) { }

// 	ngOnInit() {
//         this.fullName = this.sharedData.successMsg;
//         this.sharedData.successMsg = this.fullName;
// 				this.sharedData.statusCode = 200;
// 				this.sharedData.msgName = "Payment";
//         let script = this._renderer2.createElement('script');
//         script.type = `text/javascript`;
//         script.text = `{
//             var stripe = Stripe("pk_test_51HNMPIFtve7dlO7OLKevFQqhe6XGw1p3SctaCFtHHldZ8zk6NIT6khjbr5tnRqz75foja4WnSB4qIP9GGVZyjDxU00MmVM1bOu");
//             var checkoutButton = document.getElementById("checkout-button");
            
//             document.getElementById("checkout-button").addEventListener("click", function () {
              
//                 // fetch("http://34.195.111.53/ehr/api/rest/./payment/create-checkout-session?",{
//                   fetch("https://54.162.55.186:8443/ehrlitebe/api/rest/./payment/create-checkout-session?",{
//                 method: "POST",
//               })
//                 .then(function (response) {
//                   return response.json();
//                 })
//                 .then(function (session) {
//                   return stripe.redirectToCheckout({ sessionId: session.id });
//                 })
//                 .then(function (result) {
//                   // If redirectToCheckout fails due to a browser or network
//                   // error, you should display the localized error message to your
//                   // customer using error.message.
//                   //console.log(result);
//                   if (result.error) {
//                     alert(result.error.message);
//                   }
//                 })
//                 .catch(function (error) {
//                   //console.error("Error:", error);
//                 });
//             });
//         }`;
        
//         this._renderer2.appendChild(this._document.body, script);
        
//     }
// }