// import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
// import { FormBuilder, FormControl, FormGroup, Validators, ValidatorFn, AbstractControl } from '@angular/forms';
// import { Router } from '@angular/router';
// import { ClinicLocation } from '../../administration/clinic-locations/ClinicLocation';
// import { StaffDetails } from '../../administration/staff-members/StaffDetails';
// import { Data } from '../../data';
// import { ClinicLocationService } from 'app/administration/clinic-locations/clinicLocationService';
// import { StaffDetailsService } from 'app/administration/staff-members/staffDetailsService';
// import { CurrentUserService } from 'app/profiles/currentUserService';
// import { MasterLookupService } from 'app/administration/master-lookup/masterLookupService';
// import { MasterLookup } from 'app/administration/master-lookup/masterLookup';
// import { StaffMember } from 'app/administration/staff-members/staffMember';
// import { StaffMemberService } from 'app/administration/staff-members/staffMemberservice';
// import { StaffRole } from 'app/administration/staff-members/staffRole';
// import { NgxSpinnerService } from 'ngx-spinner';
// import * as moment from 'moment';

// declare const $:any;
// interface FileReaderEventTarget extends EventTarget {
//   result: string;
// }

// interface FileReaderEvent extends Event {
//   target: FileReaderEventTarget;
//   getMessage(): string;
// }


// @Component({
//   selector: 'ehr-edit-profile',
//   templateUrl: './edit-profile.component.html',
//   styleUrls: ['../../app.component.css', '../profile.component.css']
// })

// export class EditProfileComponent implements OnInit {
//   allStates: MasterLookup[];
//   allCliniclocations: ClinicLocation[];
//   requestProcessing = false;
//   staffImage: any;
//   statusCode: number;
//   staffMemberForm: FormGroup;
//   allCredentials: MasterLookup[];
//   allProviderTypes: MasterLookup[];
//   isNotValidImageSize: boolean = false;
//   currentFileUpload: any;
//   imageUrl: File;
//   currentUser: StaffMember;
//   adminFlag = "";
//   selectedStaff: StaffDetails;
//   _search: string = '';
//   providerType_search: string = '';
//   staffAddressId_search: string = '';
//   allStaffDetails: StaffDetails[] = [];
//   showProviderType: boolean = false;
//   isCredential:any;
//   isadmin: boolean;
//   staffId:any;
//   constructor(
//     private router: Router,
//     private formBuilder: FormBuilder,
//     private staffDetailsService: StaffDetailsService,
//     private masterLookupService: MasterLookupService,
//     private clinicLocationService: ClinicLocationService,
//     private currentuserservice: CurrentUserService,
//     private staffMemberService: StaffMemberService,
//     private sharedData: Data,
//     private spinner: NgxSpinnerService
//   ) { }

//   ngOnInit() {
//     this.spinner.show();
   
//     this.staffMemberForm = this.formBuilder.group({
//       firstName: [null, [Validators.required, Validators.pattern("[a-zA-Z]*")]],
//       gender: [null, [Validators.required]],
//       licNumber: [null],
//       dob: [null, [Validators.required]],
//       licExpirationDate: [null],
//       deaNumber: [null],
//       deaExpirationDate: [null],
//       malPracExpirationDate: [null],
//       lastName: [null, [Validators.required, Validators.pattern("[a-zA-Z]*")]],
//       staffImage: [null],
//       providerFlag: [null, Validators.required],
//       authority: [null, [Validators.required]],
//       designation: [null],
//       loginId: [null],
//       npiNumber: [null],
//       mobileNo: [null, [Validators.required, Validators.minLength(12)]],
//       staffAddressState: [null],
//       email: [null, [Validators.required, this.ValidateEmail(), Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]],
//       providerType: [null],
//       ssn: [null, [Validators.required]],
//       malPracCoverage: [null],
//       staffAddressId: [null, [Validators.required]]
//     });
   
   
//     $('#ssn').mask('000-00-0000');
//     $('#mobileNo').mask('000-000-0000');
//     $('#npiNumber').mask('000-000-0000');
//     $("#authority1").prop("disabled", "disabled");
//     $("#authority2").prop("disabled", "disabled");
  
//     this.getClincAllLocations();
//     this.getCredentials();
//     this.getProviderTypes();
//     this.getAllStaffMembers();
//     this.getAddressState();

//     this.currentuserservice.getCurrentStaffMember().switchMap(            
//       data => {
//         this.currentUser = data;
//        this.staffId= data.staffId
//        return this.staffDetailsService.getStaffDetailsById(data.staffId)      
//       }).subscribe(data => {
//             this.selectedStaff = data;
//             $.material.options.autofill = true;
//             $.material.init();
//             this.isCredential=data.designation;
//             this.spinner.hide();
//             this.staffMemberForm.get("firstName").setValue(data.firstName);
//             this.staffMemberForm.get("lastName").setValue(data.lastName);
//             this.staffMemberForm.get('mobileNo').setValue(data.mobileNo);
//             this.staffMemberForm.get('email').setValue(data.email);
//             this.staffMemberForm.get('loginId').setValue(data.loginId);
//             this.staffMemberForm.get('npiNumber').setValue(data.npiNumber);
//             this.staffMemberForm.get('gender').setValue(data.gender);
//             this.staffMemberForm.get('providerFlag').setValue(data.providerFlag);
//             this.staffMemberForm.get('staffAddressState').setValue(data.licenseState);
//             this.staffMemberForm.get('dob').setValue(moment.utc(new Date(data.dob)).format('MM/DD/YYYY'));
//             this.staffMemberForm.get('ssn').setValue(data.ssn);
//             this.staffMemberForm.get('staffAddressId').setValue(data.staffAddressId);
//             this.staffMemberForm.get('designation').setValue(data.designation);
//             this.staffMemberForm.get('malPracCoverage').setValue(data.malpracticeCoverage);
//             this.staffMemberForm.get('licNumber').setValue(data.licenseNumber);
//             this.staffMemberForm.get('deaNumber').setValue(data.deaNumber);
//             if(data.licenseExpDate != null){
//               this.staffMemberForm.get('licExpirationDate').setValue(moment.utc(new Date(data.licenseExpDate)).format('MM/DD/YYYY'));
//             }
//             if(data.deaExpDate != null){
//               this.staffMemberForm.get('deaExpirationDate').setValue(moment.utc(new Date(data.deaExpDate)).format('MM/DD/YYYY'));
//             }
//             if(data.malpracticeExpiration != null){
//               this.staffMemberForm.get('malPracExpirationDate').setValue(moment.utc(new Date(data.malpracticeExpiration)).format('MM/DD/YYYY'));
//             }
//             data.staffrole == "Admin" ? this.adminFlag = "ROLE_ADMIN" : this.adminFlag = "ROLE_USER";
//             if (this.adminFlag == 'ROLE_ADMIN') {
//               this.showProviderType = true;
//             }
//             else {
//               this.showProviderType = false;
//               this.staffMemberForm.get('providerType').setValue(data.providerType);
//             }
//             this.staffMemberForm.get("authority").setValue(this.adminFlag);
//       },
//       errorCode => {
//         this.statusCode = errorCode;});
//       }
    
//     datepicker(val, val1) {
//       var minDate = new Date();
//       minDate.setDate(minDate.getDate() + 1);
//       var self = this;
//       let dateVal = (document.getElementById(val) as HTMLInputElement).value;
//       $("#" + val).datepicker({
//         minDate: minDate,
//         changeMonth: true,
//         changeYear: true,
//         beforeShow: function () {
//           setTimeout(function () {
//             $('.ui-datepicker').css('z-index', 99999999999999);
//           }, 0);
//         },
//         onSelect: function () {
//           self.staffMemberForm.get(val).setValue((document.getElementById(val) as HTMLInputElement).value);
         
//         }
//       }).datepicker("show");
//     }

//   getCredentials() {
//     this.masterLookupService.getCredentials()
//       .subscribe(data => {
//         this.allCredentials = data
//       },
//         errorCode => this.statusCode = errorCode);
//   }
//   getAddressState() {
//     this.masterLookupService.getAddressState()
//       .subscribe(
//         data => {
//           this.allStates = data;
//         },
//         errorCode => this.statusCode = errorCode);
//   }
//   getProviderTypes() {
//     this.masterLookupService.getProviderTypes()
//       .subscribe(data => {
//         this.allProviderTypes = data;
//       },
//         errorCode => this.statusCode = errorCode);
//   }

//   isFieldValid(field: string, form: FormGroup) {
//     return !form.get(field).valid && form.get(field).touched;
//   }

//   getClincAllLocations() {
//     this.clinicLocationService.getAllClinicLocations()
//       .subscribe(data => {
//         this.allCliniclocations = data
//       },
//         errorCode => this.statusCode = errorCode)
//   }

//   getSelectedCredentials(designation:any){
//     this.isCredential=designation;
//     if (designation == 'Nurse') {
//     this.staffMemberForm.get("deaNumber").setValue('');
//     this.staffMemberForm.get("deaExpirationDate").setValue('');
//     this.staffMemberForm.get("malPracCoverage").setValue('');
//     this.staffMemberForm.get("malPracExpirationDate").setValue('');
//      }
  
//      if (designation == 'Admin Staff') {
//       this.staffMemberForm.get("providerType").setValue('');
//       this.staffMemberForm.get("npiNumber").setValue('');
//       this.staffMemberForm.get("staffAddressState").setValue('');
//       this.staffMemberForm.get("licNumber").setValue('');
//       this.staffMemberForm.get("licExpirationDate").setValue('');
//       this.staffMemberForm.get("deaNumber").setValue('');
//       this.staffMemberForm.get("deaExpirationDate").setValue('');
//       this.staffMemberForm.get("malPracCoverage").setValue('');
//       this.staffMemberForm.get("malPracExpirationDate").setValue('');
//        }
//     }
//   clearField(val:any) {
//     this._search = '';
//     this.providerType_search = '';
//     this.staffAddressId_search = '';
   
//   }

//   isAdminChange(event: any) {
//     if (event.target.value == 'ROLE_ADMIN') {
//       this.isadmin = false;
//       this.showProviderType = true;
//       this.staffMemberForm.get("providerType").setValue('');
//     }
//     else {
//       this.isadmin = true;
//       this.showProviderType = false;
//     }
//   }
  
//   onSubmitStaff() {
//     if (this.staffMemberForm.valid) {
//       $('#staffButton').prop('disabled', true);
//       let firstName = this.staffMemberForm.get('firstName').value.trim();
//       let lastName = this.staffMemberForm.get('lastName').value.trim();
//       let staffImage = $('#staffImageId').val();
//       let loginId = this.staffMemberForm.get('loginId').value.trim();
//       let npiNumber = this.staffMemberForm.get('npiNumber').value.trim();
//       let designation = this.staffMemberForm.get('designation').value;
//       let providerFlag = this.staffMemberForm.get('providerFlag').value.trim();
//       let authority = this.staffMemberForm.get('authority').value;
//       let providerType = this.staffMemberForm.get('providerType').value;
//       let mobileNo = this.staffMemberForm.get('mobileNo').value.trim();
//       let email = this.staffMemberForm.get('email').value.trim();
//       let staffAddressId = this.staffMemberForm.get('staffAddressId').value;
//       let licState = this.staffMemberForm.get('staffAddressState').value;
//       let licNumber = this.staffMemberForm.get('licNumber').value;
//       let licExpirationDate:any = moment.utc((document.getElementById("licExpirationDate") as HTMLInputElement).value).toDate();
//       if(licExpirationDate == 'Invalid Date') {
//         licExpirationDate = null
//       }
//       else{
//         licExpirationDate = licExpirationDate.toISOString();
//       }
//       let deaNumber = this.staffMemberForm.get('deaNumber').value;
//       let deaExpirationDate:any = moment.utc((document.getElementById("deaExpirationDate") as HTMLInputElement).value).toDate();
//       if(deaExpirationDate == 'Invalid Date') {
//         deaExpirationDate = null
//       }
//       else{
//         deaExpirationDate = deaExpirationDate.toISOString();
//       }
//       let malPracCoverage = this.staffMemberForm.get('malPracCoverage').value;
//       let malPracExpirationDate = moment.utc((document.getElementById("malPracExpirationDate") as HTMLInputElement).value).toDate();

//       let dob = moment.utc((document.getElementById("dob") as HTMLInputElement).value).toDate();
//       let gender = this.staffMemberForm.get('gender').value;
//       let ssn = this.staffMemberForm.get('ssn').value;

//       let staffToUpdate = new StaffMember(this.staffId, loginId, this.selectedStaff.loginKey, firstName, null, lastName, staffImage, providerType, designation, providerFlag, 0, true, staffAddressId,
//         mobileNo, null, email, npiNumber, null, null, null, null, null, null, null, null, licState, licNumber, licExpirationDate, deaNumber, deaExpirationDate, malPracCoverage, malPracExpirationDate, dob, gender, ssn);
//       let staffRoleToUpdate = new StaffRole(this.selectedStaff.staffRoleId, this.staffId, authority,
//         true, null, null, null, null);
// //console.log(staffToUpdate)
//       this.staffMemberService.updateStaffMember(staffToUpdate)
//         .subscribe(data => {
//           this.staffMemberService.updateStaffRole(staffRoleToUpdate)
//             .subscribe(successCode => {
//               if (successCode == 200) {
//                 let fullName = data.firstName + " " + data.lastName;
//                 // this.sharedData.successMsg = fullName;
//                 // this.sharedData.statusCode = 200;
//                 this.router.navigate(['patients/patientlist']);
//               }
//             },
//               ErrorCode => {
//                 $('#staffButton').prop('disabled', false);
//               })
//         })
//     }
//     else {
//       this.validateAllFormFields(this.staffMemberForm);
//     }
//   }

//   validateAllFormFields(formGroup: FormGroup) {
//     Object.keys(formGroup.controls).forEach(field => {
//       const control = formGroup.get(field);
//       if (control instanceof FormControl) {
//         control.markAsTouched({ onlySelf: true });
//       } else if (control instanceof FormGroup) {
//         this.validateAllFormFields(control);
//       }
//     });
//   }

//   preProcessConfigurations() {
//     this.statusCode = null;
//     this.requestProcessing = true;
//   }

//   selectFile(event) {
//     if (event.target.files[0].size < 30000) {
//       this.isNotValidImageSize = false;
//       this.imageUrl = event.target.files;
//       this.currentFileUpload = event.target.files[0];
//       if (event.target.files && this.currentFileUpload) {
//         const reader = new FileReader();
//         reader.onload = function (e: FileReaderEvent) {
//           $('#wizardPicturePreview').attr('src', e.target.result).fadeIn('slow');
//           $('#staffImageId').attr('value', reader.result);
//         };
//         reader.readAsDataURL(this.currentFileUpload);
//       }
//     }
//     else {
//       this.isNotValidImageSize = true;
//       this.staffImage = "./assets/img/default-avatar.png";
//     }
//   }

//   getAllStaffMembers() {
//     this.staffDetailsService.getAllStaffMembers()
//       .subscribe(data => {
//         this.allStaffDetails = data;
//       },
//         errorCode => this.statusCode = errorCode);
//   }

//   ValidateEmail(): ValidatorFn {
//     return (control: AbstractControl): { [key: string]: boolean } | null => {
//       let email = control.value;
//       let staff: any[] = this.allStaffDetails.filter(staff => staff.email == email);
//       if (staff.length > 0 && (this.selectedStaff.email != undefined)) {
//         if (email.trim() == this.selectedStaff.email) {
//           return null;
//         }
//         else {
//           return { 'validEmail': true };
//         }
//       }
//       return null;
//     }
//   }

// }




// @Pipe({ name: 'primarylocation' })
// export class PrimaryLocationPipe implements PipeTransform {
//   transform(array: any[], query: string): any {
//     if (query) {
//       query = query.toLowerCase();
//       return array.filter((value: any) => value.locationName &&
//         value.locationName.toLowerCase().indexOf(query) > -1);
//     }
//     return array;
//   }
// }



// @Pipe({ name: 'lookupPipe' })
// export class lookupPipe implements PipeTransform {
//   transform(array: any[], query: string): any {
//     if (query) {
//       query = query.toLowerCase();
//       return array.filter((value: any) => value.lookupCode &&
//         value.lookupCode.toLowerCase().indexOf(query) > -1);
//     }
//     return array;
//   }
// }