// import { Component, OnInit } from '@angular/core';
// import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
// import { Router } from '@angular/router';
// import { JwtHelper } from 'angular2-jwt';

// import { Data } from 'app/data';
// import { DatePipe } from '@angular/common'
// import { CurrentUserService } from 'app/profiles/currentUserService';
// import { StaffMember } from 'app/administration/staff-members/staffmember';
// import { StaffFeedBack } from 'app/patients/models/staffFeedback';


// declare const $: any;

// @Component({
// 	selector: 'ehr-home-contactus',
// 	templateUrl: './contactus.component.html',
// 	styleUrls: ['../profile.component.css', '../../app.component.css']

// })
// export class ContactUsComponent implements OnInit {

//     loggedInUser: StaffMember;
//     contactUsForm: FormGroup;
// 	statusCode:number;
// 	requestProcessing = false;
// 	isDisabled: boolean;

// 	constructor(private formBuilder: FormBuilder,
// 		private router: Router,
// 		private sharedData: Data,
// 		public datepipe: DatePipe,
// 		private currentUserService: CurrentUserService){}
// 	//	private loginService: LoginService) { }

// 	ngOnInit() {
// 		//localStorage.clear();
		
// 		//this.checkExpiry();
        
//         this.contactUsForm = this.formBuilder.group({
//             subject: [null, [Validators.required, Validators.maxLength(50)]],
//             description:[null, [Validators.required, Validators.maxLength(5000)]],
           
//         });      
// 	}

// 	isFieldValid(form: FormGroup, field: string) {
// 		return !form.get(field).valid && form.get(field).touched;
// 	}

// 	onsubmit(event){
// 	//	this.statusCode = 200;
// 		if (this.contactUsForm.valid) {
// 	//		console.log("ifffffffff");
// 			this.preProcessConfigurations();
		
// 			document.getElementById("submitFeedback").innerText="Processing";
// 			this.isDisabled=true;
		
// 			this.currentUserService.getCurrentStaffMember()
// 				.subscribe(data => {
// 		         this.loggedInUser =  data;
// 					console.log(this.loggedInUser);
// 					//console.log(this.loggedInUser.email);
// 					 let userEmail = this.loggedInUser.email;
// 					// console.log(userEmail);
// 					// this.sendEmail(this.loggedInUser);
				
// 				})



// 			//        let staffToUpdate = new StaffMember(this.loggedInUser.staffId, this.loggedInUser.loginId, this.loggedInUser.loginKey, this.loggedInUser.firstName, null, 
// 			//         this.loggedInUser.lastName, this.loggedInUser.staffImage, this.loggedInUser.providerType, this.loggedInUser.designation, this.loggedInUser.providerFlag, 0, true, this.loggedInUser.clinicLocationId,
// 			//         this.loggedInUser.mobileNo, null,this.loggedInUser.email, this.loggedInUser.npiNumber, null, null, null, null, null, null, null, null, this.loggedInUser.licenseNumber, 
// 			//         this.loggedInUser.licenseNumber, this.loggedInUser.licenseExpDate, this.loggedInUser.deaNumber, this.loggedInUser.deaExpDate, this.loggedInUser.malpracticeCoverage,this.loggedInUser.malpracticeExpiration , 
// 			//         this.loggedInUser.dob, this.loggedInUser.gender, this.loggedInUser.ssn);
		
// 			//   


// 		}
// 	}

// 	sendEmail(){
	
// 			let feedbackSubject = this.contactUsForm.get('subject').value;
// 			let feedbackDescription = this.contactUsForm.get('description').value;
// 			//console.log(feedbackSubject);
// 			//console.log(feedbackDescription);
// 			let feedback = new StaffFeedBack(feedbackSubject,feedbackDescription)
// 			this.currentUserService.sendFeedbackEmail(feedback)
// 			.subscribe(successCode => {
// 					  this.statusCode = successCode;
					  
// 			})  
// 			this.contactUsForm.reset();
// 		}
	  
// 	preProcessConfigurations() {
// //		console.log("precoesss configugggggg");
// 		this.statusCode = null;
// 		this.requestProcessing = true;   
// 	 }
	

	
// }