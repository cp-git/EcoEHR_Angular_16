// import { ViewChild, Component, OnInit } from '@angular/core';
// import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
// import { ClinicLocation } from './ClinicLocation';
// import { ClinicLocationService } from './clinicLocationService';
// import { Data } from 'app/data';
// import { NgxSpinnerService } from 'ngx-spinner';

// declare interface DataTable {
//     headerRow: string[];
//     footerRow: string[];
//     dataRows: string[][];
// }

// declare const $: any;

// @Component({
//     selector: 'ehr-locations',
//     templateUrl: './locations.component.html',
//     styleUrls: ['../admin.component.css', '../../app.component.css']
// })

// export class LocationsComponent implements OnInit {
//     public dataTable: DataTable = {
//         headerRow: ['Location Name', 'Street Name','Building Number' ,'Unit / Suite', 'City, State - Zipcode', 'Fax Number', 'Phone Number', 'Location NPI', 'Actions'],
//         footerRow: [],

//         dataRows: []
//     };
//     showme: boolean = false;
//     headerName:any;
//     clinicLocationForm: FormGroup;
//     buttonName:any;
//     locationId: number;
//     requestProcessing = false;
//     deleteConfirmForm: FormGroup;
//     statusCode: number;
//     locName: any;

//     constructor(private formBuilder: FormBuilder,
//         private clinicLocationService: ClinicLocationService,
//         private spinner : NgxSpinnerService
//     ) { }

//     ngOnInit() {
//         this.clinicLocationForm = this.formBuilder.group({
//             locationName: [null, [Validators.required, Validators.pattern("[a-zA-Z ]*"),Validators.maxLength(100)]],
//             buildingNumber: [null,[Validators.required, Validators.pattern("[0-9_ ]+$"),Validators.maxLength(25)]],
//             addressDoorNo: [null,[Validators.pattern("[a-zA-Z0-9_ ]+$"),Validators.maxLength(25)]],
//             addressCity: [null, [Validators.required, Validators.pattern("[a-zA-Z ]*"),Validators.maxLength(50)]],
//             addressState: [null, [Validators.required, Validators.pattern("[a-zA-Z ]*"),Validators.maxLength(50)]],
//             addressStreet: [null, [Validators.required,Validators.pattern("^[a-zA-Z0-9_ ]+$"),Validators.maxLength(100)]],
//             contactName: [null,  [Validators.required, Validators.pattern("[a-zA-Z ]*"),Validators.maxLength(100)]],
//             contactEmail: [null,[Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"),Validators.maxLength(200)]],
//             einNumber: [null, [Validators.required,Validators.pattern("^[a-zA-Z0-9_ ]+$"),Validators.maxLength(50)]],
//             addressZip: [null, [Validators.required,Validators.minLength(5)]],
//             primaryNo: [null, [Validators.required,Validators.minLength(12)]],
//             faxNo: [null, [Validators.required,Validators.minLength(12)]]
//         });

//         this.deleteConfirmForm = this.formBuilder.group({
//             locationId: [null],
//             locationName: [null]
//         });

//         $('#addressZip').mask('00000');
//         $('#primaryNo').mask('000-000-0000');
//         $('#faxNo').mask('000-000-0000');

//         this.getClinicAllLocations();
//     }

//     isFieldValid(field: string) {
//         return !this.clinicLocationForm.get(field).valid && this.clinicLocationForm.get(field).touched;
//     }

//     displayFieldCss(form: FormGroup, field: string) {
//         return {
//             'has-error': this.isFieldValid(field),
//             'has-feedback': this.isFieldValid(field),
//         };
//     }

//     onCancel() {
//         this.clinicLocationForm.reset();
//         $('.label-floating').addClass('is-empty');
//         this.showme = false;
//     }

//     openClinicLocationForm(value:any,cliniclocation:ClinicLocation) {
//         this.preProcessConfigurations();
//         this.showme = true;
//         if(value=='editClinicLocation'){
//             $('.label-floating').removeClass('is-empty');
//             this.headerName = 'Update Clinic Location';
//             this.buttonName = 'UPDATE';
//             this.locationId = cliniclocation.locationId;
//             this.clinicLocationForm.get('locationName').setValue(cliniclocation.locationName);
//             this.clinicLocationForm.get('buildingNumber').setValue(cliniclocation.buildingNo);
//             this.clinicLocationForm.get('addressStreet').setValue(cliniclocation.addressStreet);
//             this.clinicLocationForm.get('addressDoorNo').setValue(cliniclocation.addressDoorNo);
//             this.clinicLocationForm.get('addressCity').setValue(cliniclocation.addressCity);
//             this.clinicLocationForm.get('addressState').setValue(cliniclocation.addressState);
//             this.clinicLocationForm.get('addressZip').setValue(cliniclocation.addressZip);
//             this.clinicLocationForm.get('contactName').setValue(cliniclocation.contactName);
//             this.clinicLocationForm.get('contactEmail').setValue(cliniclocation.contactEmail);
//             this.clinicLocationForm.get('primaryNo').setValue(cliniclocation.primaryNo);
//             this.clinicLocationForm.get('faxNo').setValue(cliniclocation.faxNo);
//             this.clinicLocationForm.get('einNumber').setValue(cliniclocation.einNumber);
//         }
//         else{
//             this.clinicLocationForm.reset();
//             $('.label-floating').addClass('is-empty');
//             this.headerName = 'Add Clinic Location';
//             this.buttonName = 'ADD';
//         }
//     }

//     onSubmit(value:any){
//         if (this.clinicLocationForm.valid) {
//             this.preProcessConfigurations();
//             (<HTMLInputElement> document.getElementById("clinicLocButton")).disabled = true;
//             let locationName = this.clinicLocationForm.get('locationName').value.trim();
//             let buildingNumber = this.clinicLocationForm.get('buildingNumber').value;
//             let addressStreet = this.clinicLocationForm.get('addressStreet').value.trim();
//             let addressDoorNo = this.clinicLocationForm.get('addressDoorNo').value;
//             let addressCity = this.clinicLocationForm.get('addressCity').value;
//             let addressState = this.clinicLocationForm.get('addressState').value;
//             let addressZip = this.clinicLocationForm.get('addressZip').value.trim();
//             let contactName = this.clinicLocationForm.get('contactName').value;
//             let contactEmail = this.clinicLocationForm.get('contactEmail').value;
//             let primaryNo = this.clinicLocationForm.get('primaryNo').value.trim();
//             let faxNo = this.clinicLocationForm.get('faxNo').value.trim();
//             let einNumber = this.clinicLocationForm.get('einNumber').value;
//             this.locName = locationName;
//             if(value == 'UPDATE'){
//                 let clinicLocToUpdate = new ClinicLocation(this.locationId, locationName, addressStreet, addressDoorNo, addressCity, addressState, addressZip,
//                     contactName, contactEmail, primaryNo, faxNo, einNumber, true, 0,buildingNumber, null, null, null, null);
//                 this.clinicLocationService.updateClinicLocation(clinicLocToUpdate)
//                 .subscribe(successCode => {
                   
//                     this.statusCode = successCode;
//                     this.dissmissModalOnSubmit();
//                 },
//                 ErrorCode => {
//                     this.statusCode = ErrorCode;
//                     this.setTimeOut();
//                     (<HTMLInputElement> document.getElementById("clinicLocButton")).disabled = false;
//                 })
//             }
//             else{
//                 let clinicLocToInsert = new ClinicLocation(0, locationName, addressStreet, addressDoorNo, addressCity, addressState, addressZip,
//                     contactName, contactEmail, primaryNo, faxNo, einNumber, true, 0, buildingNumber,null, null, null, null);
//                 this.clinicLocationService.insertClinicLocation(clinicLocToInsert)
//                 .subscribe(successCode => {
//                     this.statusCode = successCode;
//                     this.dissmissModalOnSubmit();
//                 },
//                 ErrorCode => {
//                     this.statusCode = ErrorCode;
//                     this.setTimeOut();
//                     (<HTMLInputElement> document.getElementById("clinicLocButton")).disabled = false;
//                 })
//             }
//         }
//         else {
//             this.validateAllFormFields(this.clinicLocationForm);
//         }
//     }

//     setTimeOut() {
//         window.setTimeout(function () {
//             $(".alert").fadeTo(2000, 500).slideUp(500, function () {
//                 $(".alert").slideUp(500);
//             });
//         }, 4000);
//     }

//     dissmissModalOnSubmit(){
//         (<HTMLInputElement> document.getElementById("clinicLocButton")).disabled = false;
//         setTimeout(() => {
//             let element: HTMLElement = document.getElementById("dismissModalOnSubmit");
//             element.click();
//         }, 200);
//         this.getClinicAllLocations();
//     }

//     getClinicAllLocations() {
//         this.setTimeOut();
//         var self = this;
//         this.spinner.show();
//         this.clinicLocationService.getAllClinicLocations()
//             .subscribe(
//                 data => {
//                     this.spinner.hide();
//                      $('#datatables').DataTable().destroy();
//                     this.dataTable.dataRows = <any>data;
//                     setTimeout(function () {
//                         self.initTable();
//                     }, 10);
//                 },
//                 errorCode => this.statusCode = errorCode);
//     }

//     loadDeleteConfirmModal(locationId: number, locationName: string) {
//         this.deleteConfirmForm.get("locationId").setValue(locationId);
//         this.deleteConfirmForm.get("locationName").setValue(locationName);
//     }

//     closeDeleteConfirmationModal() {
//         $('#deleteConfirmationModal').modal('hide');
//         $('#clinicLocdelete').prop('disabled', false);
//     }

//     deleteClinicLocation(locationId: number, locationName: string) {
//         this.locName = locationName;
//         this.preProcessConfigurations();
//         $('#clinicLocdelete').prop('disabled', true);
//         let clinicLocation = new ClinicLocation(locationId,null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
//         this.clinicLocationService.deleteClinicLocation(clinicLocation)
//             .subscribe(successCode => {
//                 this.statusCode = successCode;
//                 if (this.statusCode === 204) { 
//                     this.closeDeleteConfirmationModal();
//                     this.getClinicAllLocations();
//                 }
//             },
//                 errorCode => {
//                     $('#clinicLocdelete').prop('disabled', false);
//                     this.statusCode = errorCode
//                     if (this.statusCode === 428) {
//                         this.closeDeleteConfirmationModal();
//                     }
//                     this.setTimeOut();
//                 });
               
//     }


//     //Perform preliminary processing configurations
//     preProcessConfigurations() {
//         this.statusCode = null;
//         this.requestProcessing = true;
//     }

//     private initTable() {
//         var table = $('#datatables').DataTable({
//             "ordering": true,
//             columnDefs: [
//                 { orderable: false, targets: ["All"] },
//                 { searchable: false , targets: [1,2,3,4,5,6,7,8] }
//             ],
//             "language": {
//                 "emptyTable": " "
//             },
//             "info": false,
//             "bLengthChange": false,
//             "dom": 'lrtip'
//         });

//         table.on('click', '.remove', function (e: any) {
//             const $tr = $(this).closest('tr');
//             table.row($tr).remove().draw();
//             e.preventDefault();
//         });
//     }

//     searchdata(v) {
//         var table = $('#datatables').DataTable();
//         table.search(v.target.value).draw();
//     }

//     changePage(x) {
//         if (x.target.value == -1) {
//             $('#datatables').DataTable().destroy();
//             $('#datatables').DataTable({
//                 "pagingType": "full_numbers",
//                 "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
//                 "dom": '<lrt<t>p>',
//                 "pageLength": -1,
//                 "bLengthChange": false,
//             });
//         }
//         else {
//             $('#datatables').DataTable().destroy();
//             $('#datatables').DataTable({

//                 "dom": '<lrt<t>p>',
//                 "pageLength": x.target.value,
//                 "bLengthChange": false,
//             });
//         }
//     }

//     validateAllFormFields(formGroup: FormGroup) {
//         Object.keys(formGroup.controls).forEach(field => {
//             const control = formGroup.get(field);
//             if (control instanceof FormControl) {
//                 control.markAsTouched({ onlySelf: true });
//             } else if (control instanceof FormGroup) {
//                 this.validateAllFormFields(control);
//             }
//         });
//     }
// }
