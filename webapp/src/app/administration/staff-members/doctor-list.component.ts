// import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
// import { FormBuilder, FormControl, FormGroup, Validators, ValidatorFn, AbstractControl } from '@angular/forms';
// import { ClinicLocationService } from 'app/administration/clinic-locations/clinicLocationService';
// import { ClinicLocation } from 'app/administration/clinic-locations/ClinicLocation';
// import { StaffMember } from 'app/administration/staff-members/staffMember';
// import { StaffRole } from 'app/administration/staff-members/staffRole';
// import { StaffDetails } from 'app/administration/staff-members/StaffDetails';
// import { StaffDetailsService } from 'app/administration/staff-members/staffDetailsService';
// import { MasterLookup } from 'app/administration/master-lookup/masterLookup';
// import { MasterLookupService } from 'app/administration/master-lookup/masterLookupService';
// import { StaffMemberService } from './staffMemberservice';
// import { CurrentUserService } from 'app/profiles/currentUserService';
// import { NgxSpinnerService } from 'ngx-spinner';import { StaffPaymentDetails } from '../../home/payment/staffpaymentdetails';


// import * as moment from 'moment';

// declare interface DataTable {
//   headerRow: string[];
//   footerRow: string[];
//   dataRows: string[][];
// }

// declare const $: any;

// interface FileReaderEventTarget extends EventTarget {
//   result: string;
// }

// interface FileReaderEvent extends Event {
//   target: FileReaderEventTarget;
//   getMessage(): string;
// }

// @Component({
//   selector: 'ehr-doctors',
//   templateUrl: './doctor-list.component.html',
//   styleUrls: ['../admin.component.css', '../../app.component.css']
// })
// export class ListDoctorComponent implements OnInit {
//   public dataTable: DataTable = {
//     headerRow: ['Full Name', 'User Role', 'Provider', 'Login Id', 'Default Location', 'NPI Number', 'Actions'],
//     footerRow: [],

//     dataRows: []
//   };
//   addNewCredentailForm: FormGroup;
//   deleteConfirmForm: FormGroup;
//   statusCode: number;
//   fullName: any;
//   staffAddressState_search: string = '';
//   currentFileUpload: any;
//   requestProcessing: boolean;
//   allCliniclocations: ClinicLocation[];
//   imageUrl: File;
//   staffImage: any;
//   allStates: MasterLookup[];
//   sizeofimage: number;
//   lastAction = "";
//   isNotValidImageSize: boolean;
//   allCredentials: MasterLookup[];
//   allProviderTypes: MasterLookup[];
//   selectedStaff: StaffDetails;
//   providerType_search: string = '';
//   _search: string = '';
//   showme: boolean = false;
//   headerName: any;
//   buttonName: any;
//   staffMemberForm: FormGroup;
//   showRadio: boolean = false;
//   adminFlag = "";
//   loggedInUserId: any;
//   staffMemberId: number;
//   isadmin: boolean;
//   allStaffDetails: StaffDetails[] = [];
//   showProviderType: boolean = false;
//   showLoginId: boolean = false;
//   selMalExpDate: string;
//   isCredential:any;
//   constructor(private formBuilder: FormBuilder,
//     private staffMemberService: StaffMemberService,
//     private clinicLocationService: ClinicLocationService,
//     private masterLookupService: MasterLookupService,
//     private staffDetailsService: StaffDetailsService,
//     private currentUserservice: CurrentUserService,
//     private spinner: NgxSpinnerService) { }


//   ngOnInit() {

//     this.getLoggedInUserDetails();
//     this.getCredentials();

//     this.getAllStaffMembers();
//     this.getProviderTypes();
//     this.getClincAllLocations();
//     this.getAddressState();


//     this.deleteConfirmForm = this.formBuilder.group({
//       staffId: [null],
//       firstName: [null],
//       lastName: [null]
//     });

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
//       loginId: [null, [Validators.required, this.ValidateLoginId(), Validators.pattern("[a-z]*"), Validators.minLength(5), Validators.maxLength(8)]],
//       npiNumber: [null],
//       mobileNo: [null, [Validators.required, Validators.minLength(12)]],
//       staffAddressState: [null],
//       email: [null, [Validators.required, this.ValidateEmail(), Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]],
//       providerType: [null],
//       ssn: [null, [Validators.required]],
//       malPracCoverage: [null],
//       staffAddressId: [null, [Validators.required]]
//     });

//     this.addNewCredentailForm = this.formBuilder.group({
//       newCredentials: [null, Validators.required]
//     });

//     $('#ssn').mask('000-00-0000');
//     $('#mobileNo').mask('000-000-0000');
//     $('#npiNumber').mask('000-000-0000');
//   }

//   isFieldValid(field: string, form: FormGroup) {
//     return !form.get(field).valid && form.get(field).touched;
//   }

//   openStaffForm(value: any, staff: StaffDetails) {
//     this.showme = true;
//     this.isNotValidImageSize = false;
//     if (value == 'editStaffMember') {
//       this.selectedStaff = staff;
//       this.showRadio = true;
//       this.staffMemberId = staff.staffId;
//       this.showLoginId = true;
//       this.headerName = 'UPDATE STAFF MEMBER';
//       this.buttonName = 'UPDATE';
//       this.isCredential=staff.designation;
//       this.staffMemberForm.get('firstName').setValue(staff.firstName);
//       this.staffMemberForm.get('lastName').setValue(staff.lastName);
//       this.staffMemberForm.get('loginId').setValue(staff.loginId);
//       this.staffMemberForm.get('providerFlag').setValue(staff.providerFlag);
//       this.staffMemberForm.get('designation').setValue(staff.designation);
//       this.staffMemberForm.get('mobileNo').setValue(staff.mobileNo);
//       this.staffMemberForm.get('email').setValue(staff.email);
//       this.staffMemberForm.get('npiNumber').setValue(staff.npiNumber);
//       this.staffMemberForm.get('staffAddressId').setValue(staff.staffAddressId);
//       this.staffMemberForm.get('gender').setValue(staff.gender);
//       this.staffMemberForm.get('dob').setValue(moment.utc(new Date(staff.dob)).format('MM/DD/YYYY'));
//       this.staffMemberForm.get('ssn').setValue(staff.ssn);
//       this.staffMemberForm.get('staffAddressState').setValue(staff.licenseState);
//       this.staffMemberForm.get('licNumber').setValue(staff.licenseNumber);
//       if(staff.licenseExpDate != null){
//         this.staffMemberForm.get('licExpirationDate').setValue(moment.utc(new Date(staff.licenseExpDate)).format('MM/DD/YYYY'));
//       }
//       this.staffMemberForm.get('deaNumber').setValue(staff.deaNumber);
//       if(staff.deaExpDate != null){
//         this.staffMemberForm.get('deaExpirationDate').setValue(moment.utc(new Date(staff.deaExpDate)).format('MM/DD/YYYY'));
//       }
//       this.staffMemberForm.get('malPracCoverage').setValue(staff.malpracticeCoverage);
//       if(staff.malpracticeExpiration != null){
//         this.staffMemberForm.get('malPracExpirationDate').setValue(moment.utc(new Date(staff.malpracticeExpiration)).format('MM/DD/YYYY'));
//       }
//       staff.staffrole == "Admin" ? this.adminFlag = "ROLE_ADMIN" : this.adminFlag = "ROLE_USER";
//       if (this.adminFlag == 'ROLE_ADMIN') {
//         this.showProviderType = true;
//       }
//       else {
//         this.showProviderType = false;
//         this.staffMemberForm.get('providerType').setValue(staff.providerType);
//       }
//       this.staffMemberForm.get("authority").setValue(this.adminFlag);
//       this.lastAction = staff.lastAction;
//       if (staff.staffImage != "") {
//         this.staffImage = staff.staffImage;
//       }
//       else {
//         this.staffImage = "./assets/img/default-avatar.png";
//       }
//     }
//     else {
      
//      // $('.label-floating').addClass('is-empty');
//       this.staffMemberForm.reset();
//       this.showRadio = false;
//       this.staffImage = "./assets/img/default-avatar.png";
//       this.staffMemberForm.get("authority").setValue("ROLE_USER");
//       this.showLoginId = false;
//       this.showProviderType = false;
//       this.isadmin = true;
//       this.headerName = 'ADD STAFF MEMBER';
//       this.buttonName = 'ADD';
//    //   this.staffMemberForm.get('firstName').setValue("");
//       //this.staffMemberForm.reset();
//     }
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

//   selectVal() {
//     this.isadmin = false;
//   }

//   onStaffCancel() {
//     $('.label-floating').addClass('is-empty')
//     this.staffMemberForm.reset();
//     this.showme = false;
//   }

//   getAddressState() {
//     this.masterLookupService.getAddressState()
//       .subscribe(
//         data => {
//           this.allStates = data;
//         },
//         errorCode => this.statusCode = errorCode);
//   }

//   onSubmitStaff(event: any) {
//     console.log("eNTERED IN onSubmitStaff(event: any) ")
//     if (this.staffMemberForm.valid) {
//       console.log("in  if (this.staffMemberForm.valid) ")
//       this.preProcessConfigurations();
//         // $('#staffButton').prop('disabled', true);
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
//       //console.log(licExpirationDate);
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

//       this.fullName = firstName + " " + lastName;
//       if (event == "UPDATE") {
//         let staffToUpdate = new StaffMember(this.staffMemberId, loginId, this.selectedStaff.loginKey, firstName, null, 
//           lastName, staffImage, providerType, designation, providerFlag, 0, true, staffAddressId,
//           mobileNo, null, email, npiNumber, null, null, null, null, null, null, null, null, licState, 
//           licNumber, licExpirationDate, deaNumber, deaExpirationDate, malPracCoverage, malPracExpirationDate, 
//           dob, gender, ssn);
//         let staffRoleToUpdate = new StaffRole(this.selectedStaff.staffRoleId, this.staffMemberId, authority,
//           true, null, null, null, null);
//         this.staffMemberService.updateStaffMember(staffToUpdate)
//           .subscribe(data => {
//             this.staffMemberService.updateStaffRole(staffRoleToUpdate)
//               .subscribe(successCode => {
//                 this.statusCode = successCode;
//                 this.dissmissModalOnSubmit();
//               },
//                 errorCode => this.statusCode = errorCode)
//           },
//             ErrorCode => {
//               this.statusCode = ErrorCode;
//               $('#staffButton').prop('disabled', false);
//               this.setTimeOut();
//             })
//       }
//       else if (event == "ADD"){
//         console.log("Entered into else loop of add")
//         let staffMemToInsert = new StaffMember(0, loginId, "password", firstName, null, lastName, staffImage, 
//         providerType, designation, providerFlag, 0, true, staffAddressId,
//           mobileNo, null, email, npiNumber, null, null, null, null, null, null, null, null, 
//           licState, licNumber, licExpirationDate, deaNumber, deaExpirationDate, 
//           malPracCoverage, malPracExpirationDate, dob, gender, ssn);
//         //console.log(staffMemToInsert)
//         this.staffMemberService.insertStaffMember(staffMemToInsert)
//           .subscribe(data => {
//             console.log("Entered in api call")
//             let staffRoleToInsert = new StaffRole(0, data.staffId, authority, true, null, null, null, null);
//             this.staffMemberService.insertStaffRole(staffRoleToInsert)
//             .subscribe(successCode => {
//               this.statusCode = successCode;
//              // .subscribe(sucessCode => {
//               //  this.statusCode = sucessCode;
//                 this.dissmissModalOnSubmit();
//               },
//                 errorCode => this.statusCode = errorCode);
//           },
//             ErrorCode => {
//               this.statusCode = ErrorCode;
//               $('#staffButton').prop('disabled', false);
//               this.setTimeOut();
//             })

//       }
//     }
//     else {
//       this.validateAllFormFields(this.staffMemberForm)
//       console.log("elseeeeee")
//     }
//   }

//   getSelectedCredentials(designation:any){
//   this.isCredential=designation;
//   if (designation == 'Nurse') {
//   this.staffMemberForm.get("deaNumber").setValue('');
//   this.staffMemberForm.get("deaExpirationDate").setValue('');
//   this.staffMemberForm.get("malPracCoverage").setValue('');
//   this.staffMemberForm.get("malPracExpirationDate").setValue('');
//    }

//    if (designation == 'Admin Staff') {
//     this.staffMemberForm.get("providerType").setValue('');
//     this.staffMemberForm.get("npiNumber").setValue('');
//     this.staffMemberForm.get("staffAddressState").setValue('');
//     this.staffMemberForm.get("licNumber").setValue('');
//     this.staffMemberForm.get("licExpirationDate").setValue('');
//     this.staffMemberForm.get("deaNumber").setValue('');
//     this.staffMemberForm.get("deaExpirationDate").setValue('');
//     this.staffMemberForm.get("malPracCoverage").setValue('');
//     this.staffMemberForm.get("malPracExpirationDate").setValue('');
//      }
//   }
  
//   dissmissModalOnSubmit() {
//     $('#staffButton').prop('disabled', false);
//     setTimeout(() => {
//       let element: HTMLElement = document.getElementById("dismissModalOnSubmit");
//       element.click();
//     }, 200);
//     this.getAllStaffMembers();
//   }

//   getLoggedInUserDetails() {
//     this.currentUserservice.getCurrentStaffMember()
//       .subscribe(data => {
//         this.loggedInUserId = data.staffId
//       })
//   }

//   setTimeOut() {
//     window.setTimeout(function () {
//       $(".alert").fadeTo(2000, 500).slideUp(500, function () {
//         $(".alert").slideUp(500);
//       });
//     }, 4000);
//   }

//   loadDeleteConfirmModal(staffId: number, firstName: string, lastName: string) {
//     this.deleteConfirmForm.get("staffId").setValue(staffId);
//     this.deleteConfirmForm.get("firstName").setValue(firstName);
//     this.deleteConfirmForm.get("lastName").setValue(lastName);
//   }

//   deleteStaffMember(staffId: number, firstName: string, lastName: string) {
//     $('#deleteStaff').prop('disabled', true);
//     this.fullName = firstName + " " + lastName;
//     this.preProcessConfigurations();
//     this.staffMemberService.deleteStaffMember(staffId)
//       .subscribe(successCode => {
//         this.statusCode = successCode;
//         if (this.statusCode === 204) {
//           $('#deleteConfirmationModal').modal('hide');
//           this.getAllStaffMembers();
//         }
//       },
//         errorCode => {
//           $('#deleteStaff').prop('disabled', false);
//           this.statusCode = errorCode;
//           if (this.statusCode === 428) {
//             this.closeDeleteConfirmationModal();
//           }
//           this.setTimeOut();
//         });
//   }

//   getCredentials() {
//     this.masterLookupService.getCredentials()
//       .subscribe(data => {
//         this.allCredentials = data;
//         this.setTimeOut();
//       },
//         errorCode => this.statusCode = errorCode);
//   }

//   getProviderTypes() {
//     this.masterLookupService.getProviderTypes()
//       .subscribe(data => {
//         this.allProviderTypes = data;
//       },
//         errorCode => this.statusCode = errorCode);
//   }

//   closeDeleteConfirmationModal() {
//     $('#deleteConfirmationModal').modal('hide');
//   }

//   clearField(val: any) {
//     this._search = '';
//     this.staffAddressState_search = '';
//     this.providerType_search = '';
//     $(val).addClass('customfloat');
//   }

//   datepicker(val, val1) {
//     var minDate = new Date();
//     minDate.setDate(minDate.getDate() + 1);
//     var self = this;
//     let btnName=this.buttonName;
//     let dateVal = (document.getElementById(val) as HTMLInputElement).value;
//     $("#" + val).datepicker({
//       minDate: minDate,
//       changeMonth: true,
//       changeYear: true,
//       beforeShow: function () {
//         setTimeout(function () {
//           $('.ui-datepicker').css('z-index', 99999999999999);
//         }, 0);
//       },
//       onSelect: function () {
//         self.staffMemberForm.get(val).setValue((document.getElementById(val) as HTMLInputElement).value);
//         if(btnName == 'ADD' || (btnName == 'UPDATE' && dateVal=='' )){
//           $(val1).addClass('customfloat');
//         }
//       }
//     }).datepicker("show");
//   }

//   dobDatepicker(val,val1) {
//     var self = this;
//     if(this.buttonName == 'ADD'){
//       $(val1).addClass('customfloat');
//     }
//     $("#"+val).datepicker({
//         Style:"padding-top:10px;",
//         changeMonth: true,
//         yearRange: "1900:+0",
//         defaultDate: '01/01/1953',
//         maxDate: new Date(),
//         changeYear: true,
//         beforeShow: function () {
//             setTimeout(function () {
//                 $('.ui-datepicker').css('z-index', 99999999999999);
//             }, 0);     
//         },
//         onSelect: function(){ 
//             self.staffMemberForm.get(val).setValue((document.getElementById(val) as HTMLInputElement).value);
//              }
//     }).datepicker("show");
// }


//   getClincAllLocations() {
//     this.clinicLocationService.getAllClinicLocations()
//       .subscribe(data => {
//         this.allCliniclocations = data
//       },
//         errorCode => this.statusCode = errorCode);
//   }

//   selectFile(event) {
//     this.sizeofimage = event.target.files[0].size;
//     if (this.sizeofimage < 30000) {
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
//       this.staffImage = "../../assets/img/default-avatar.png";
//     }
//   }

//   validateAllFormFields(formGroup: FormGroup) {
//     //console.log("validate form field called");
//     Object.keys(formGroup.controls).forEach(field => {
//       const control = formGroup.get(field);
//       if (control instanceof FormControl) {
//        // console.log("iffffff");
//         control.markAsTouched({ onlySelf: true });
//       } else if (control instanceof FormGroup) {
//         //console.log("else");
//         this.validateAllFormFields(control);
//       }
//     });
//   }

//   getAllStaffMembers() {
//     this.spinner.show();
//     this.setTimeOut();
//     var self = this;
//     this.staffDetailsService.getAllStaffMembers()
//       .subscribe(data => {
//         this.spinner.hide();
//         $('#datatables').DataTable().destroy();
//         this.dataTable.dataRows = <any>data;
//         this.allStaffDetails = data;
//         setTimeout(function () {
//           self.initTable();
//         }, 10);
//       },
//         errorCode => this.statusCode = errorCode);
//   }

//   //Perform preliminary processing configurations
//   preProcessConfigurations() {
//     console.log("Entered IN  preProcessConfigurations() ")
//     this.statusCode = null;
//     this.requestProcessing = true;
//   }

//   ValidateEmail(): ValidatorFn {
//     return (control: AbstractControl): { [key: string]: boolean } | null => {
//       let email = control.value;
//       if (email != null) {
//         let staff: any[] = this.allStaffDetails.filter(staff =>
//           staff.email.trim() == email.trim())
//         if (staff.length > 0) {
//           if (this.buttonName == 'ADD') {
//             return { 'validEmail': true }
//           }
//           else {
//             if (email == this.selectedStaff.email) {
//               return null;
//             }
//             else {
//               return { 'validEmail': true }
//             }
//           }
//         }
//         else {
//           return null;
//         }
//       }
//       else {
//         return null;
//       }
//     }
//   }

//   // ValidateLoginId(): ValidatorFn {
//   //   return (control: AbstractControl): { [key: string]: boolean } | null => {
//   //     let loginId = control.value;
//   //     if (loginId != null) {
//   //       let staff: any[] = this.allStaffDetails.filter(staff =>
//   //         staff.loginId.trim() == loginId.trim())
//   //       if (staff.length > 0) {
//   //         if (this.buttonName == 'ADD') {
//   //           return { 'validLoginId': true }
//   //         }
//   //         else {
//   //           if (loginId == this.selectedStaff.loginId) {
//   //             return null;
//   //           }
//   //           else {
//   //             return { 'validLoginId': true }
//   //           }
//   //         }
//   //       }
//   //       else {
//   //         return null;
//   //       }
//   //     }
//   //     else {
//   //       return null;
//   //     }
//   //   },
//   // }
//   ValidateLoginId(): ValidatorFn {
//     return (control: AbstractControl): { [key: string]: boolean } | null => {
//       let loginId = control.value;
//       if (loginId != null) {
//         let staff: any[] = this.allStaffDetails.filter(staff =>
//           staff.loginId.trim() == loginId.trim()
//         );
//         if (staff.length > 0) {
//           if (this.buttonName == 'ADD') {
//             return { 'validLoginId': true };
//           } else {
//             if (loginId == this.selectedStaff.loginId) {
//               return null;
//             } else {
//               return { 'validLoginId': true };
//             }
//           }
//         } else {
//           return null;
//         }
//       } else {
//         return null;
//       }
//     };
//   }
  

//   private initTable() {
//     var table = $('#datatables').DataTable({
//       "ordering": true,
//       columnDefs: [
//         { orderable: false, targets: ["All"] }],
//       "language": {
//         "emptyTable": " "
//       },
//       "info": false,
//       "bLengthChange": false,
//       "dom": 'lrtip'
//     });

//     // Delete a record
//     table.on('click', '.remove', function (e: any) {
//       const $tr = $(this).closest('tr');
//       table.row($tr).remove().draw();
//       e.preventDefault();
//     });
//   }


//   searchdata(v) {
//     var table = $('#datatables').DataTable();
//     table.search(v.target.value).draw();
//   }

//   changePage(x) {
//     if (x.target.value == -1) {
//       $('#datatables').DataTable().destroy();
//       $('#datatables').DataTable({
//         "pagingType": "full_numbers",
//         "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
//         "dom": '<lrt<t>p>',
//         "pageLength": -1,
//         "bLengthChange": false,
//       });
//     }
//     else {
//       $('#datatables').DataTable().destroy();
//       $('#datatables').DataTable({
//         "dom": '<lrt<t>p>',
//         "pageLength": x.target.value,
//         "bLengthChange": false,
//       });
//     }
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