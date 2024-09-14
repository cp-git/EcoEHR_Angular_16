import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators, ValidatorFn, AbstractControl, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ClinicLocation } from '../../administration/clinic-locations/ClinicLocation';
import { StaffDetails } from '../../administration/staff-members/StaffDetails';
import { Data } from '../../data';

import { NgxSpinnerService } from 'ngx-spinner';
import * as moment from 'moment';
import { MasterLookup } from 'src/app/administration/master-lookup/masterLookup';
import { StaffMember } from 'src/app/administration/staff-members/staffmember';
import { StaffRole } from 'src/app/administration/staff-members/staffrole';
import { ClinicLocationService } from 'src/app/patients/services/clinicLocationService';
import { MasterLookupService } from 'src/app/patients/services/masterLookupService';
import { StaffDetailsService } from 'src/app/patients/services/staffDetailsService';

import { CurrentUserService } from '../currentUserService';
import { CommonModule } from '@angular/common';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { StaffMemberService } from 'src/app/administration/staff-members/staffmemberservice';

declare const $:any;
interface FileReaderEventTarget extends EventTarget {
  result: string;
}

interface FileReaderEvent extends Event {
  target: FileReaderEventTarget;
  getMessage(): string;
}


@Component({
  selector: 'ehr-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: [ './edit-profile.component.css'],
  standalone: true,
  imports: [FormsModule ,CommonModule,TimerModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule,MatIconModule],
})

export class EditProfileComponent implements OnInit {
  allStates!: MasterLookup[];
  allCliniclocations!: ClinicLocation[];
  requestProcessing = false;
  staffImage: any;
  statusCode!: number;
  staffMemberForm!: FormGroup;
  allCredentials!: MasterLookup[];
  allProviderTypes!: MasterLookup[];
  isNotValidImageSize: boolean = false;
  currentFileUpload: any;
  imageUrl!: File;
  currentUser!: StaffMember;
  adminFlag = "";
  selectedStaff!: StaffDetails;
  _search: string = '';
  providerType_search: string = '';
  staffAddressId_search: string = '';
  allStaffDetails: StaffDetails[] = [];
  showProviderType: boolean = false;
  isCredential:any;
  isadmin!: boolean;
  staffId:any;
  loggedInUser!: StaffMember;

  loggedStaff!:StaffDetails;
  
  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private staffDetailsService: StaffDetailsService,
    private masterLookupService: MasterLookupService,
    private clinicLocationService: ClinicLocationService,
    private currentUserService: CurrentUserService,
    private staffMemberService: StaffMemberService,
    private sharedData: Data,
    private spinner: NgxSpinnerService
  ) { }

  ngOnInit() {


    this.getClincAllLocations();
    this.getCredentials();
    this.getProviderTypes();
    this.getAllStaffMembers();
    this.getAddressState();

  this.getLoggedInUserDetails();
  
  
    console.log(this.selectedStaff);
    

    
    this.staffMemberForm = this.formBuilder.group({
      firstName: [null, [Validators.required, Validators.pattern("[a-zA-Z]*")]],
      gender: [null, [Validators.required]],
      licNumber: [null],
      dob: [null, [Validators.required]],
      licExpirationDate: [null],
      deaNumber: [null],
      deaExpirationDate: [null],
      malPracExpirationDate: [null],
      lastName: [null, [Validators.required, Validators.pattern("[a-zA-Z]*")]],
      staffImage: [null],
      providerFlag: [null, Validators.required],
      authority: [null, [Validators.required]],
      designation: [null],
      loginId: [null],
      npiNumber: [null],
      mobileNo: [null, [Validators.required, Validators.minLength(12)]],
      staffAddressState: [null],
      email: [null, [Validators.required, this.ValidateEmail(), Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]],
      providerType: [null],
      ssn: [null, [Validators.required]],
      malPracCoverage: [null],
      staffAddressId: [null, [Validators.required]]
    });

   

   
          
    
    
    }

   getLoggedInUserDetails(){
      this.currentUserService.getCurrentStaffMember()
      .subscribe(data => {
        this.currentUser = data;
        this.staffId= data.staffId
        //console.log(this.loggedInUser.firstName);
        
        if (data.staffImage == null || data.staffImage == "") {
          this.staffImage = "./assets/img/default-avatar.png";
        }
        else{
            this.staffImage = data.staffImage;
        }

        this.staffDetailsService.getStaffDetailsById(data.staffId).subscribe(
          data => {
            //console.log(data);
            this.selectedStaff=data;
            console.log(this.selectedStaff);
            this.staffMemberForm.get("firstName")?.setValue(data.firstName);
            this.staffMemberForm.get("lastName")?.setValue(data.lastName);
            this.staffMemberForm.get('mobileNo')?.setValue(data.mobileNo);
            this.staffMemberForm.get('email')?.setValue(data.email);
            this.staffMemberForm.get('loginId')?.setValue(data.loginId);
            this.staffMemberForm.get('npiNumber')?.setValue(data.npiNumber);
            this.staffMemberForm.get('gender')?.setValue(data.gender);
            this.staffMemberForm.get('providerFlag')?.setValue(data.providerFlag);
            this.staffMemberForm.get('staffAddressState')?.setValue(data.licenseState);
            this.staffMemberForm.get('dob')?.setValue(moment.utc(new Date(data.dob)).format('MM/DD/YYYY'));
            this.staffMemberForm.get('ssn')?.setValue(data.ssn);
            this.staffMemberForm.get('staffAddressId')?.setValue(data.staffAddressId);
            this.staffMemberForm.get('designation')?.setValue(data.designation);
            this.staffMemberForm.get('malPracCoverage')?.setValue(data.malpracticeCoverage);
            this.staffMemberForm.get('licNumber')?.setValue(data.licenseNumber);
            this.staffMemberForm.get('deaNumber')?.setValue(data.deaNumber);
            if(data.licenseExpDate != null){
              this.staffMemberForm.get('licExpirationDate')?.setValue(moment.utc(new Date(data.licenseExpDate)).format('MM/DD/YYYY'));
            }
            if(data.deaExpDate != null){
              this.staffMemberForm.get('deaExpirationDate')?.setValue(moment.utc(new Date(data.deaExpDate)).format('MM/DD/YYYY'));
            }
            if(data.malpracticeExpiration != null){
              this.staffMemberForm.get('malPracExpirationDate')?.setValue(moment.utc(new Date(data.malpracticeExpiration)).format('MM/DD/YYYY'));
            }
            data.staffrole == "Admin" ? this.adminFlag = "ROLE_ADMIN" : this.adminFlag = "ROLE_USER";
            if (this.adminFlag == 'ROLE_ADMIN') {
              this.showProviderType = true;
            }
            else {
              this.showProviderType = false;
              this.staffMemberForm.get('providerType')?.setValue(data.providerType);
            }
            this.staffMemberForm.get("authority")?.setValue(this.adminFlag);
            
          });
      })
  }

  getCredentials() {
    this.masterLookupService.getCredentials()
      .subscribe(data => {
        this.allCredentials = data
      },
        errorCode => this.statusCode = errorCode);
  }
  getAddressState() {
    this.masterLookupService.getAddressState()
      .subscribe(
        data => {
          this.allStates = data;
        },
        errorCode => this.statusCode = errorCode);
  }
  getProviderTypes() {
    this.masterLookupService.getProviderTypes()
      .subscribe(data => {
        this.allProviderTypes = data;
      },
        errorCode => this.statusCode = errorCode);
  }

  
  getClincAllLocations() {
    this.clinicLocationService.getAllClinicLocations()
      .subscribe(data => {
        this.allCliniclocations = data
      },
        errorCode => this.statusCode = errorCode)
  }


  clearField(val:any) {
    this._search = '';
    this.providerType_search = '';
    this.staffAddressId_search = '';
   
  }

  

 
  
  onSubmitStaff() {
    console.log("@@@");
    console.log(this.staffMemberForm.valid);
      
      let firstName = this.staffMemberForm.get('firstName')?.value.trim();
      let lastName = this.staffMemberForm.get('lastName')?.value.trim();
      let staffImage = this.staffMemberForm.get('staffImage')?.value;
      let loginId = this.staffMemberForm.get('loginId')?.value.trim();
      let npiNumber = this.staffMemberForm.get('npiNumber')?.value.trim();
      let designation = this.staffMemberForm.get('designation')?.value;
      let providerFlag = this.staffMemberForm.get('providerFlag')?.value.trim();
      let authority = this.staffMemberForm.get('authority')?.value;
      let providerType = this.staffMemberForm.get('providerType')?.value;
      let mobileNo = this.staffMemberForm.get('mobileNo')?.value.trim();
      let email = this.staffMemberForm.get('email')?.value.trim();
      let staffAddressId = this.staffMemberForm.get('staffAddressId')?.value;
      let licState = this.staffMemberForm.get('staffAddressState')?.value;
      let licNumber = this.staffMemberForm.get('licNumber')?.value;
      let licExpirationDate:any = moment.utc((document.getElementById("licExpirationDate") as HTMLInputElement).value).toDate();
      if(licExpirationDate == 'Invalid Date') {
        licExpirationDate = null
      }
      else{
        licExpirationDate = licExpirationDate.toISOString();
      }
      let deaNumber = this.staffMemberForm.get('deaNumber')?.value;
      let deaExpirationDate:any = moment.utc((document.getElementById("deaExpirationDate") as HTMLInputElement).value).toDate();
      if(deaExpirationDate == 'Invalid Date') {
        deaExpirationDate = null
      }
      else{
        deaExpirationDate = deaExpirationDate.toISOString();
      }
      let malPracCoverage = this.staffMemberForm.get('malPracCoverage')?.value;
      let malPracExpirationDate = moment.utc((document.getElementById("malPracExpirationDate") as HTMLInputElement).value).toDate();

      let dob = moment.utc((document.getElementById("dob") as HTMLInputElement).value).toDate();
      let gender = this.staffMemberForm.get('gender')?.value;
      let ssn = this.staffMemberForm.get('ssn')?.value;

      let staffToUpdate = new StaffMember(this.staffId, loginId, this.selectedStaff.loginKey, firstName, "", lastName, staffImage, providerType, designation, providerFlag, 0, true, staffAddressId,
        mobileNo, "", email, npiNumber, "", "", "", "", dob, "", dob, "", licState, licNumber, licExpirationDate, deaNumber, deaExpirationDate, malPracCoverage, malPracExpirationDate, dob, gender, ssn);
      let staffRoleToUpdate = new StaffRole(this.selectedStaff.staffRoleId, this.staffId, authority,
        true, dob, "", dob, "");

      this.staffMemberService.updateStaffMember(staffToUpdate)
        .subscribe(data => {
          this.staffMemberService.updateStaffRole(staffRoleToUpdate)
            .subscribe(successCode => {
              alert("updated..")
             
            });
        })
    
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


  

  getAllStaffMembers() {
    this.staffDetailsService.getAllStaffMembers()
      .subscribe(data => {
        this.allStaffDetails = data;
      },
        errorCode => this.statusCode = errorCode);
  }

  ValidateEmail(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: boolean } | null => {
      let email = control.value;
      let staff: any[] = this.allStaffDetails.filter(staff => staff.email == email);
      if (staff.length > 0 && (this.selectedStaff.email != undefined)) {
        if (email.trim() == this.selectedStaff.email) {
          return null;
        }
        else {
          return { 'validEmail': true };
        }
      }
      return null;
    }
  }

}




@Pipe({ name: 'primarylocation' })
export class PrimaryLocationPipe implements PipeTransform {
  transform(array: any[], query: string): any {
    if (query) {
      query = query.toLowerCase();
      return array.filter((value: any) => value.locationName &&
        value.locationName.toLowerCase().indexOf(query) > -1);
    }
    return array;
  }
}



@Pipe({ name: 'lookupPipe' })
export class lookupPipe implements PipeTransform {
  transform(array: any[], query: string): any {
    if (query) {
      query = query.toLowerCase();
      return array.filter((value: any) => value.lookupCode &&
        value.lookupCode.toLowerCase().indexOf(query) > -1);
    }
    return array;
  }
}