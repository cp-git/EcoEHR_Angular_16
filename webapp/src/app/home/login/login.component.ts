import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { LoginService } from './login.service';
import { StaffMember } from '../../administration/staff-members/staffmember';
import { StaffPaymentDetails } from './payment/staffpaymentdetails';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Data } from '../../data';

@Component({
  selector: 'ehr-home-login',
  templateUrl: './login.component.html',
  styleUrls: ['../home.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  isExpired: boolean = true;
  statusCode!: number;
  loggedInUser!: StaffMember;
  userRole!: string;
  staff!: StaffPaymentDetails;
  paymentStatus!: string;
  hide = true;
  jwtHelper: JwtHelperService = new JwtHelperService();

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private sharedData: Data,
    private datePipe: DatePipe,
    private loginService: LoginService
  ) {}

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      userName: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', Validators.required]
    });
    this.checkExpiry();
  }

  onLogin() {
    console.log("Login function called");
    if (this.loginForm.valid) {
      console.log("Form is valid");
      const formValue = this.loginForm.value;
      this.loginService.login(formValue.userName, formValue.password).subscribe(
        () => {
          console.log("Login service call successful");
          this.loginService.getLoginStatus().subscribe((data: StaffMember) => {
            console.log("Get login status successful");
            this.loggedInUser = data;
            this.userRole = this.loggedInUser.designation;

            this.loginService.getStaffPaymentStatus().subscribe((paymentData: StaffPaymentDetails) => {
              console.log("Get payment status successful");
              this.staff = paymentData;
              this.loginService.updateLoginTime(this.loggedInUser).subscribe(() => {
                console.log("Login time updated");
              });

              localStorage.setItem('currentUser', data.toString());
              this.paymentStatus = this.staff.paymentStatus;
              let licenseEndDate = this.datePipe.transform(this.staff.licenseEndDate, 'yyyy-MM-dd');
              let currentDate = this.datePipe.transform(new Date(), 'yyyy-MM-dd');

              if (this.userRole == "TRY_ME" && this.paymentStatus == "approved" && currentDate && licenseEndDate && currentDate <= licenseEndDate) {
                this.router.navigate(['../patients/patients.module#Patients']);
              } else if (this.userRole != "TRY_ME" && this.paymentStatus == "approved") {
                this.router.navigate(['../patients/patients.module#Patients']);
              } else {
                this.sharedData.successMsg = formValue.userName;
                this.sharedData.statusCode = 200;
                this.sharedData.msgName = "Payment";
                this.router.navigate(['../checkout']);
              }
            });
          });
        },
        (errorCode: number) => {
          console.log("Login service call failed with error code: ", errorCode);
          this.statusCode = errorCode;
        }
      );
    } else {
      console.log("Form is invalid");
    }
  }

  checkExpiry() {
    let token = localStorage.getItem('jwt');
    if (token && this.jwtHelper.isTokenExpired(token)) {
      this.isExpired = true;
    } else {
      this.isExpired = false;
    }
  }
}
