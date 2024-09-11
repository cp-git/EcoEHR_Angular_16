import { Component, OnInit, Pipe, PipeTransform, signal } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators, ValidatorFn, AbstractControl } from '@angular/forms';

import { NgxSpinnerService } from 'ngx-spinner';import { StaffPaymentDetails } from '../../home/payment/staffpaymentdetails';


import * as moment from 'moment';
import { StaffMember } from './staffmember';
import { StaffDetailsService } from 'src/app/patients/services/staffDetailsService';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatSidenavModule } from '@angular/material/sidenav';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { PatientListComponent } from 'src/app/patients/patientlist/patientlist.component';
import { StaffDetails } from './StaffDetails';
import { Router } from '@angular/router';
import { CurrentUserService } from 'src/app/profiles/currentUserService';
import { AddStaffComponent } from '../StaffCRUD/add-staff/add-staff.component';

declare interface DataTable {
  headerRow: string[];
  footerRow: string[];
  dataRows: string[][];
}

declare const $: any;

interface FileReaderEventTarget extends EventTarget {
  result: string;
}

interface FileReaderEvent extends Event {
  target: FileReaderEventTarget;
  getMessage(): string;
}

@Component({
  selector: 'ehr-doctors',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['../admin.component.css', '../../app.component.css','./doctor-list.component.css'],
  standalone: true,
  imports: [MatSidenavModule, MatButtonModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatDialogModule] 
})
export class ListDoctorComponent {
    staff: StaffDetails[] = [];
    readonly panelOpenState = signal(false);
    staffImage: any;

    loggedInUser!: StaffMember;
    constructor(private staffDetailsService:StaffDetailsService,private route:Router,
      private dialog: MatDialog,
     private currentUserService:CurrentUserService){

    }
    ngOnInit(){
        this.getAllStaffMembers();
        this.getLoggedInUserDetails();
    }

    getLoggedInUserDetails(){
        this.currentUserService.getCurrentStaffMember()
        .subscribe(data => {
          this.loggedInUser = data;
          if (data.staffImage == null || data.staffImage == "") {
            this.staffImage = "./assets/img/default-avatar.png";
          }
          else{
              this.staffImage = data.staffImage;
          }
        })
    }

    openDialog(){
   
        this.dialog.open(AddStaffComponent);
      
        
    }

    


    
    logout() {
        //   this.currentUserService.getCurrentStaffMember()
        // .subscribe(data => {
            //   this.loggedInUser =  data;
            //  //console.log(this.loggedInUser)
            //  let staffToUpdate = new StaffMember(this.loggedInUser.staffId, this.loggedInUser.loginId, this.loggedInUser.loginKey, this.loggedInUser.firstName, '', 
            //   this.loggedInUser.lastName, this.loggedInUser.staffImage, this.loggedInUser.providerType, this.loggedInUser.designation, this.loggedInUser.providerFlag, 0, true, this.loggedInUser.clinicLocationId,
            //   this.loggedInUser.mobileNo, '',this.loggedInUser.email, this.loggedInUser.npiNumber, '', null, null, null, null, null, null, null, this.loggedInUser.licenseNumber, 
            //   this.loggedInUser.licenseNumber, this.loggedInUser.licenseExpDate, this.loggedInUser.deaNumber, this.loggedInUser.deaExpDate, this.loggedInUser.malpracticeCoverage,this.loggedInUser.malpracticeExpiration , 
            //   this.loggedInUser.dob, this.loggedInUser.gender, this.loggedInUser.ssn);
        
            //   this.loginService.updateLogoutTime(staffToUpdate)
            //   .subscribe(()=>{
          //     })
          // })  
        
        //   this.router.navigate(['/login']);
          location.reload(); 
          localStorage.removeItem('jwt');   
          
        }

        GoToPatientList(){
            this.route.navigate(['/list'])
          }
          
          displayClinic(){
            this.route.navigate(['/clinicLocation'])
          }

          AddPatient(){
            this.route.navigate(['/addpatient'])
          }


    getAllStaffMembers() {
      
        this.staffDetailsService.getAllStaffMembers()
          .subscribe(data => {
          console.log(data);
          
            this.staff = data;
          
          });
           
      }



 
}