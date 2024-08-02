// import { Component, OnInit, Renderer2, Inject } from '@angular/core';
// import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
// import { Router } from '@angular/router';
// import { JwtHelper } from 'angular2-jwt';
// import { Data } from 'app/data';
// import { DOCUMENT } from '@angular/common';
// import { LoginService } from 'app/home/login/loginService';
// import { StaffPaymentDetails } from '../staffpaymentdetails';

// declare const $: any;

// @Component({
// 	selector: 'ehr-home-checkout',
// 	templateUrl: './payment.success.html',
// 	styleUrls: ['../../home.component.css']
// })
// export class PaymentSuccessComponent implements OnInit {
// 	loginForm: FormGroup;
// 	test: Date = new Date();
// 	errorMessage: String;
// 	statusCode: number;
// 	jwtHelper: JwtHelper = new JwtHelper();
// 	lastVisitedURL: string;
// 	isExpired: boolean = true;
// 	fullName: any;
// 	msgName: any;

//     constructor(private formBuilder: FormBuilder,
//         private _renderer2: Renderer2, 
//         @Inject(DOCUMENT) private _document: Document,
// 		private router: Router,
// 		private sharedData: Data,
// 		private loginService: LoginService) { }

// 	ngOnInit() {
// 		this.fullName = this.sharedData.successMsg;
// 		this.validateStudentPayment();
// 	}
	
// 	validateStudentPayment(){
// 		var future = new Date();
// 		future.setDate(future.getDate() + 30);
// 		let paymentDetails = new StaffPaymentDetails(0,0,'approved',null,null);
// 		this.loginService.updateStaffPaymentDetails(paymentDetails)
// 		.subscribe(() => {
// 			this.router.navigate(['../patients/patients.module#Patients']);
// 		  },
// 			errorCode => this.statusCode = errorCode);
// 	}
	
// }