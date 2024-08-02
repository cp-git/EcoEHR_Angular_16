import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { ReactiveFormsModule } from '@angular/forms';
import { StaffPaymentDetails } from './payment/staffpaymentdetails';
import { Data } from '../../data';
import { DatePipe } from '@angular/common'
import { CurrentUserService } from '../../profiles/currentUserService';
import { StaffMember } from '../../administration/staff-members/staffmember';
import { LoginService } from './login.service';
import { JwtHelperService } from '@auth0/angular-jwt';

declare const $: any;

@Component({
	selector: 'ehr-home-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
	loginForm!: FormGroup;
	test: Date = new Date();
	errorMessage!: String;
	statusCode!: number;
	jwtHelper: JwtHelperService = new JwtHelperService
	lastVisitedURL!: string;
	isExpired: boolean = true;
	staff!: StaffPaymentDetails;
	paymentStatus!: string;
	loggedInUser!: StaffMember;
	userRole!: string;
	staffId!: number;
	hide = true;			
  formGroup:ReactiveFormsModule =''	;

	constructor(private formBuilder: FormBuilder,
		private router: Router,
		private sharedData: Data,
		public datepipe: DatePipe,
		private currentUserService: CurrentUserService,
		private loginService: LoginService) { }

	ngOnInit() {
    
		//localStorage.clear();
		this.loginForm = this.formBuilder.group({
			userName: ['', [Validators.required, Validators.minLength(3)]],
			password: ['', Validators.required]
		});
		this.checkExpiry();
	}

	isFieldValid(form: FormGroup, field: string): boolean {
		const control = form.get(field);
		return control ? !control.valid && control.touched : false;
	}
	

	
	onLogin(userName: any, password: any) {
		this.preProcessConfigurations();
		if (this.loginForm.valid) {
			$('#signIn').prop('disabled', true);
			// this.loginService.login(userName, password)
			// .subscribe(()=>{

			// 	this.loginService.getLoginStatus()
			// 	.subscribe((data: StaffMember) =>{
			// 		this.loggedInUser = data;
			// 		this.userRole = this.loggedInUser.designation;
					
			// 			this.loginService.getStaffPaymentStatus()
			// 			.subscribe((data: StaffPaymentDetails) =>{
			// 				this.staff = data;
						
			// 				//update login date and time
			// 				this.loginService.updateLoginTime(this.loggedInUser)
			// 				.subscribe(()=>{
			// 				})

			// 				localStorage.setItem('currentUser',data.toString());
			// 				this.paymentStatus = this.staff.paymentStatus;
							
			// 				//check whether the user trying to login has up to date subscription to EHR.
			// 				// Validate the status of payment.
			// 				let liscence_end_date =this.datepipe.transform(this.staff.licenseEndDate, 'yyyy-MM-dd');
			// 				let current_date = this.datepipe.transform(new Date(),'yyyy-MM-dd');
							
			// 				if (this.userRole == "TRY_ME" && this.paymentStatus == "approved" && current_date != null && liscence_end_date != null && current_date <= liscence_end_date) {
			// 					this.router.navigate(['../patients/patients.module#Patients']);	
			// 				  }else if(this.userRole != "TRY_ME" && this.paymentStatus == "approved"){
			// 					this.router.navigate(['../patients/patients.module#Patients']);	
			// 				  }else{
			// 					this.sharedData.successMsg = userName;
			// 					this.sharedData.statusCode = 200;
			// 					this.sharedData.msgName = "Payment";
			// 					this.router.navigate(['../checkout']);
			// 				  }

			// 			})
			// 	})
			
			// }, (errorCode: number) => {
			// 	$('#signIn').prop('disabled', false);
			// 	this.statusCode = errorCode
			// })
		
		}
	}


	checkLoginStatus(userName: number,password: any): boolean{
		this.staffId = userName;
		// this.loginService.getLoginStatus()
		// .subscribe(() =>{
		// 	return true;
		// })
		return true;
	}

	recoverPassword(){
		this.router.navigate(['/recover']);
	}

	
	validateAllFormFields(formGroup: FormGroup) {
		Object.keys(formGroup.controls).forEach(field => {
			const control = formGroup.get(field);
			if (control instanceof FormControl) {
				control.markAsTouched({ onlySelf: true });
			} else if (control instanceof FormGroup) {
				this.validateAllFormFields(control);
			}
		});
	}

	handleError(error: { status: any; }) {
		switch (error.status) {
			case 401:
		}
	}
	preProcessConfigurations() {
		this.statusCode = -1;
	}

	checkExpiry() {
		let token = localStorage.getItem('jwt')
		if (token != '' && this.jwtHelper.isTokenExpired(token)) {
			this.isExpired = true;
		}
		else {
			this.isExpired = false;
		}
	}
}