import { CommonModule } from '@angular/common';
import { Component, Inject, Pipe, PipeTransform } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, ValidatorFn } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MAT_DIALOG_DATA, MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { StaffDetails } from '../../staff-members/StaffDetails';
import { StaffRole } from '../../staff-members/staffrole';

import { ClinicLocation } from '../../clinic-locations/ClinicLocation';
import { MasterLookup } from '../../master-lookup/masterLookup';
import { MasterLookupService } from 'src/app/patients/services/masterLookupService';
import { MasterLookupServiceService } from 'src/app/patients/services/master-lookup-service.service';
import { ClinicLocationService } from 'src/app/patients/services/clinicLocationService';

import { StaffMember } from '../../staff-members/staffmember';
import { StaffMemberService } from 'src/app/patients/services/staffmemberservice';
import { Validators } from '@angular/forms';
import * as moment from 'moment';



@Component({
  selector: 'app-add-staff',
  templateUrl: './add-staff.component.html',
  styleUrls: ['./add-staff.component.css'],
  standalone: true,
  imports: [FormsModule ,CommonModule,TimerModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule,MatIconModule],
})
export class AddStaffComponent {


  addNewCredentailForm!: FormGroup;
  deleteConfirmForm!: FormGroup;
  statusCode!: number;
  fullName: any;
  staffAddressState_search: string = '';
  currentFileUpload: any;
  requestProcessing!: boolean;
  allCliniclocations: ClinicLocation[]=[];
  imageUrl!: File;
  staffImage: any;
  allStates: MasterLookup[]=[];
  sizeofimage!: number;
  lastAction = "";
  isNotValidImageSize!: boolean;
  allCredentials: MasterLookup[]=[];
  allProviderTypes: MasterLookup[]=[];
  selectedStaff!: StaffDetails;
  providerType_search: string = '';
  _search: string = '';
  showme: boolean = false;
  headerName: any;
  buttonName: any;
  staffMemberForm!: FormGroup;
  showRadio: boolean = false;
  adminFlag = "";
  loggedInUserId: any;
  staffMemberId!: number;
  isadmin!: boolean;
  allStaffDetails: StaffDetails[] = [];
  showProviderType: boolean = false;
  showLoginId: boolean = false;
  selMalExpDate!: string;
  isCredential:any;
  allTitles!: MasterLookup[];
allLanguages!: MasterLookup[];
allRace!: MasterLookup[];
allEthnicity!: MasterLookup[];
alladditionalInfo!: MasterLookup[];
authority:any;



  constructor(
    public dialogRef: MatDialogRef<AddStaffComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private clinicLocationService:ClinicLocationService,
    private  masterLookupService:MasterLookupService,
    private staffMemberService:StaffMemberService,
    private formBuilder: FormBuilder
  ){
    dialogRef.disableClose = true;
  }

  //staffData: StaffMember = new StaffMember();
  //staffRole: StaffRole = new StaffRole();

  allProvider!: StaffDetails[];




ngOnInit(){
  this.dropdownValues();


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
    loginId: [null, [Validators.required, this.ValidateLoginId(), Validators.pattern("[a-z]*"), Validators.minLength(5), Validators.maxLength(8)]],
    npiNumber: [null],
    mobileNo: [null, [Validators.required, Validators.minLength(12)]],
    staffAddressState: [null],
    email: [null, [Validators.required, this.ValidateEmail(), Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]],
    providerType: [null],
    ssn: [null, [Validators.required]],
    malPracCoverage: [null],
    staffAddressId: [null, [Validators.required]]
  });

  this.addNewCredentailForm = this.formBuilder.group({
    newCredentials: [null, Validators.required]
  });


}


ValidateLoginId(): ValidatorFn {
  return (control: AbstractControl): { [key: string]: boolean } | null => {
    let loginId = control.value;
    if (loginId != null) {
      let staff: any[] = this.allStaffDetails.filter(staff =>
        staff.loginId.trim() == loginId.trim()
      );
      if (staff.length > 0) {
        if (this.buttonName == 'ADD') {
          return { 'validLoginId': true };
        } else {
          if (loginId == this.selectedStaff.loginId) {
            return null;
          } else {
            return { 'validLoginId': true };
          }
        }
      } else {
        return null;
      }
    } else {
      return null;
    }
  };
}


ValidateEmail(): ValidatorFn {
  return (control: AbstractControl): { [key: string]: boolean } | null => {
    let email = control.value;
    if (email != null) {
      let staff: any[] = this.allStaffDetails.filter(staff =>
        staff.email.trim() == email.trim())
      if (staff.length > 0) {
        if (this.buttonName == 'ADD') {
          return { 'validEmail': true }
        }
        else {
          if (email == this.selectedStaff.email) {
            return null;
          }
          else {
            return { 'validEmail': true }
          }
        }
      }
      else {
        return null;
      }
    }
    else {
      return null;
    }
  }
}

// selectFile(event) {
//   this.sizeofimage = event.target.files[0].size;
//   if (this.sizeofimage < 30000) {
//     this.isNotValidImageSize = false;
//     this.imageUrl = event.target.files;
//     this.currentFileUpload = event.target.files[0];
//     if (event.target.files && this.currentFileUpload) {
//       const reader = new FileReader();
//       reader.onload = function (e: FileReaderEvent) {
//         $('#wizardPicturePreview').attr('src', e.target.result).fadeIn('slow');
//         $('#staffImageId').attr('value', reader.result);
//       };
//       reader.readAsDataURL(this.currentFileUpload);
//     }
//   }
//   else {
//     this.isNotValidImageSize = true;
//     this.staffImage = "../../assets/img/default-avatar.png";
//   }
// }


onSubmitStaff(event: any) {
  console.log("eNTERED IN onSubmitStaff(event: any) ")
  console.log(this.staffMemberForm.valid);
  
 
    console.log("in  if (this.staffMemberForm.valid) ")
   // this.preProcessConfigurations();
      // $('#staffButton').prop('disabled', true);
    let firstName = this.staffMemberForm.get('firstName')?.value.trim()
    let lastName = this.staffMemberForm.get('lastName')?.value.trim();
    let staffImage = this.staffMemberForm.get('staffImage')?.value
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
    //console.log(licExpirationDate);
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

    let dob = this.staffMemberForm.get('')?.value;
    let gender = this.staffMemberForm.get('gender')?.value;

    let ssn = this.staffMemberForm.get('ssn')?.value;

    this.fullName = firstName + " " + lastName;
    
 
    
      console.log("Entered into else loop of add")
      let staffMemToInsert = new StaffMember(0, loginId, "password", firstName, "", lastName, staffImage, 
      providerType, designation, providerFlag, 0, true, staffAddressId,
        mobileNo, "", email, npiNumber, "", "", "", "", dob, "", dob, "", 
        licState, licNumber, licExpirationDate, deaNumber, deaExpirationDate, 
        malPracCoverage, malPracExpirationDate, dob, gender, ssn);
      //console.log(staffMemToInsert)
      this.staffMemberService.insertStaffMember(staffMemToInsert)
        .subscribe(data => {
          console.log("Entered in api call")
          let staffRoleToInsert = new StaffRole(0, data.staffId, authority, true, dob, "", dob, "");
          this.staffMemberService.insertStaffRole(staffRoleToInsert)
          .subscribe(successCode => {
            alert("data added...")
            this.statusCode = successCode;
           // .subscribe(sucessCode => {
            //  this.statusCode = sucessCode;
           
            },
              errorCode => this.statusCode = errorCode);
        });

      
         
    
  
  
}

isAdminChange(event: any) {
  if (event.target.value == 'ROLE_ADMIN') {
    this.isadmin = false;
    this.showProviderType = true;
    //this.staffMemberForm.get("providerType").setValue('');
  }
  else {
    this.isadmin = true;
    this.showProviderType = false;
  }
}


dropdownValues(){
  this.staffImage = "./assets/img/default-avatar.png";
  
  this.getPrimaryServiceLocation();
  this.getCredentials();
  this.getProviderTypes();


}





  // createStaff(staff:StaffMember){
  
  //   let staffRoles=new StaffRole();
  //   this.staffMemberService.insertStaffMember(staff)
  //   .subscribe(data => {
  //     alert(data)
  //     console.log("Entered in api call")
   
      
      

  //     });
         
  
    
    
    
  // }


  getPrimaryServiceLocation() {
   
    this.clinicLocationService.getAllClinicLocations()
        .subscribe(data => {
            this.allCliniclocations = data;
        })
  }

  getCredentials() {
    this.masterLookupService.getCredentials()
      .subscribe(data => {
        console.log(data);
        
        this.allCredentials = data;
      
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
