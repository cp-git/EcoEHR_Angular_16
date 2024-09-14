import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Data, Router } from '@angular/router';
import { JwtHelper } from 'angular2-jwt';


import { CommonModule, DatePipe } from '@angular/common'
import { StaffMember } from 'src/app/administration/staff-members/staffmember';
import { CurrentUserService } from '../currentUserService';
import { StaffFeedBack } from 'src/app/patients/models/staffFeedback';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { TimerModule } from 'src/app/components/timer/timer.module';



declare const $: any;

@Component({
	selector: 'ehr-home-contactus',
	templateUrl: './contactus.component.html',
	styleUrls: ['../profile.component.css', '../../app.component.css'],
    standalone: true,
  imports: [FormsModule ,CommonModule,TimerModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule,MatIconModule],

})
export class ContactUsComponent implements OnInit {

    loggedInUser!: StaffMember;
    contactUsForm!: FormGroup;
	statusCode!:number;
	requestProcessing = false;
	isDisabled!: boolean;

	constructor(private formBuilder: FormBuilder,
		private router: Router,
		public datepipe: DatePipe,
		private currentUserService: CurrentUserService){}
	//	private loginService: LoginService) { }

	ngOnInit() {
		//localStorage.clear();
		
		//this.checkExpiry();
        
        this.contactUsForm = this.formBuilder.group({
            subject: [null, [Validators.required, Validators.maxLength(50)]],
            description:[null, [Validators.required, Validators.maxLength(5000)]],
           
        });      
	}



	onsubmit(event:Event){
	//	this.statusCode = 200;
	
	//		console.log("ifffffffff");
			
		
			this.isDisabled=true;
		
            console.log(this.contactUsForm.valid);
            
			this.currentUserService.getCurrentStaffMember()
				.subscribe(data => {
                    alert("added...")
		         this.loggedInUser =  data;
					console.log(this.loggedInUser);
					//console.log(this.loggedInUser.email);
					 let userEmail = this.loggedInUser.email;
					// console.log(userEmail);
					// this.sendEmail(this.loggedInUser);
				
				})



			//        let staffToUpdate = new StaffMember(this.loggedInUser.staffId, this.loggedInUser.loginId, this.loggedInUser.loginKey, this.loggedInUser.firstName, null, 
			//         this.loggedInUser.lastName, this.loggedInUser.staffImage, this.loggedInUser.providerType, this.loggedInUser.designation, this.loggedInUser.providerFlag, 0, true, this.loggedInUser.clinicLocationId,
			//         this.loggedInUser.mobileNo, null,this.loggedInUser.email, this.loggedInUser.npiNumber, null, null, null, null, null, null, null, null, this.loggedInUser.licenseNumber, 
			//         this.loggedInUser.licenseNumber, this.loggedInUser.licenseExpDate, this.loggedInUser.deaNumber, this.loggedInUser.deaExpDate, this.loggedInUser.malpracticeCoverage,this.loggedInUser.malpracticeExpiration , 
			//         this.loggedInUser.dob, this.loggedInUser.gender, this.loggedInUser.ssn);
		
			//   


		
	}

	sendEmail(){
	
			let feedbackSubject = this.contactUsForm.get('subject')?.value;
			let feedbackDescription = this.contactUsForm.get('description')?.value;
			//console.log(feedbackSubject);
			//console.log(feedbackDescription);
			let feedback = new StaffFeedBack(feedbackSubject,feedbackDescription)
			this.currentUserService.sendFeedbackEmail(feedback)
			.subscribe(successCode => {
                alert("adedd..")
					  this.statusCode = successCode;
					  
			})  
			this.contactUsForm.reset();
		}
	  


	
}