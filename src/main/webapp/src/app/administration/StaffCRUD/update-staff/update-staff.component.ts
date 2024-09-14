import { Component, Inject } from '@angular/core';
import { StaffDetails } from '../../staff-members/StaffDetails';
import { ClinicLocationService } from 'src/app/patients/services/clinicLocationService';
import { MAT_DIALOG_DATA, MatDialog, MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { CommonModule } from '@angular/common';
import { AbstractControl, FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, ValidatorFn, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { PatientListComponent } from 'src/app/patients/patientlist/patientlist.component';
import { ClinicLocation } from '../../clinic-locations/ClinicLocation';
import { MasterLookup } from '../../master-lookup/masterLookup';
import { MasterLookupService } from 'src/app/patients/services/masterLookupService';
import { StaffMemberService } from '../../staff-members/staffmemberservice';
import * as moment from 'moment';
import { StaffMember } from '../../staff-members/staffmember';
import { StaffRole } from '../../staff-members/staffrole';

@Component({
  selector: 'app-update-staff',
  templateUrl: './update-staff.component.html',
  styleUrls: ['./update-staff.component.css'],
  standalone: true,
  imports: [MatSidenavModule, MatButtonModule,FormsModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule,MatIconModule],
})
export class UpdateStaffComponent {
  staff!: StaffDetails;
  
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

checkVal!:boolean

  
  
  constructor(
    private clinicLocationService: ClinicLocationService,
    public dialog: MatDialog,
    public dialogRef: MatDialogRef<UpdateStaffComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private formBuilder: FormBuilder,
    private  masterLookupService:MasterLookupService,
    private staffMemberService:StaffMemberService,
   
  ) {
    dialogRef.disableClose = true;
  }


  ngOnInit(): void {
    this.staff = this.data.staff;
    console.log(this.staff);

    this.dropdownValues();

    this.staffMemberForm = this.formBuilder.group({
      firstName: this.staff.firstName,
      gender: this.staff.gender,
      licNumber:this.staff.licenseNumber,
      dob: this.staff.dob,
      licExpirationDate: this.staff.licenseExpDate,
      deaNumber:this.staff.deaNumber,
      deaExpirationDate:this.staff.deaExpDate,
      malPracExpirationDate:this.staff.malpracticeExpiration,
      lastName: this.staff.lastName,
      staffImage: this.staff.staffImage,
      providerFlag: this.staff.providerFlag,
      authority: this.staff.staffrole,
      designation:this.staff.designation,
      loginId:this.staff.loginId,
      npiNumber: this.staff.npiNumber,
      mobileNo:this.staff.mobileNo,
      staffAddressState: this.staff.addressState,
      email: this.staff.email,
      providerType: this.staff.providerType,
      ssn:this.staff.ssn,
      malPracCoverage: this.staff.malpracticeCoverage,
      staffAddressId: this.staff.locationId
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
    let providerFlag = this.staffMemberForm.get('providerFlag')?.value;
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

    let dob = this.staffMemberForm.get('dob')?.value;
    let gender = this.staffMemberForm.get('gender')?.value;

    let ssn = this.staffMemberForm.get('ssn')?.value;

    this.fullName = firstName + " " + lastName;
   
    let staffToUpdate = new StaffMember(this.staff.staffId, loginId, this.staff.loginKey, firstName, "", 
      lastName, staffImage, providerType, designation, providerFlag, this.staff.organizationId, true, staffAddressId,
      mobileNo, "", email, npiNumber, "", "", "", "", dob, "", dob, "", licState, 
      licNumber, licExpirationDate, deaNumber, deaExpirationDate, malPracCoverage, malPracExpirationDate, 
      dob, gender, ssn);
    
    this.staffMemberService.updateStaffMember(staffToUpdate)
      .subscribe(data => {
        console.log("update api member");
        let staffRoleToUpdate = new StaffRole(this.staff.staffRoleId, this.staff.staffId, this.staff.staffrole,
          true, dob, "", dob, "");
        
        this.staffMemberService.updateStaffRole(staffRoleToUpdate)
          .subscribe(successCode => {
            alert("Updated Successfully....")
            console.log("update api staff");
            this.statusCode = successCode;
          
          });
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
