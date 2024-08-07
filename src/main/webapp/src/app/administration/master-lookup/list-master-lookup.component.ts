// import { Component, OnInit, PipeTransform, Pipe } from "@angular/core";
// import { FormGroup, FormBuilder, Validators, FormControl } from "@angular/forms";
// import { MasterLookupService } from "app/administration/master-lookup/masterLookupService";
// import { MasterLookup } from "app/administration/master-lookup/masterLookup";
// import { NgxSpinnerService } from "ngx-spinner";

// declare const $: any;

// declare interface DataTable {
//     headerRow: string[];
//     footerRow: string[];
//     dataRows: string[][];
// }

// @Component({
//     selector: 'ehr-list-master-lookup',
//     templateUrl: './list-master-lookup.component.html',
//     styleUrls: ['../admin.component.css', '../../app.component.css']
// })

// export class ListMasterLookupComponent implements OnInit {
//     public dataTable: DataTable = {
//         headerRow: ['Lookup Id', 'Lookup Type', 'Lookup Code', 'Active', 'Disable'],
//         footerRow: [],
//         dataRows: []
//     };
//     addMasterLookupForm: FormGroup;
//     statusCode: number;
//     requestProcessing = false;
//     allLookupType: string;
//     lookupCode: string;
//     showme: boolean = false;
//     type_selectedValue: string = '';
//     name: any;
//     buttonName:any;
//     deleteConfirmForm: FormGroup;
//     _search:string = '';
//     masterFloatLable: string = '';
    
//     constructor(private formBuilder: FormBuilder,
//                 private masterLookupService: MasterLookupService,
//                 private spinner:NgxSpinnerService) { }


//     ngOnInit() {
//         this.addMasterLookupForm = this.formBuilder.group({
//             type: [null, [Validators.required]],
//             code: [null, [Validators.required]],
//             description: [null, [Validators.required]],
//         });

//         this.deleteConfirmForm = this.formBuilder.group({
//             lookupId: [null],
//             lookupCode: [null]
//         });

//         this.getMasterLookupType();
//         this.getAllMasterlookup();
//     }

//     openMasterLookupForm(){
//         this.type_selectedValue = '';
//         $('#masterLookupButton').prop('disabled', false);
//         this.showme = true;
//     }

//     getAllMasterlookup() {
//         this.setTimeOut();
//         this.spinner.show();
//         var self = this;
//         this.masterLookupService.getAllMasterlookup()
//             .subscribe(
//                 data => {
//                     this.spinner.hide();
//                     $('#datatables').DataTable().destroy();
//                     this.dataTable.dataRows = <any>data;
//                     setTimeout(function () {
//                         self.initTable();
//                     }, 10);
//                 },
//                 errorCode => this.statusCode = errorCode);
//     }

//     getMasterLookupType() {
//         this.masterLookupService.getAllMasterLookupType()
//             .subscribe(master => {
//                 this.allLookupType = master;
//             },
//                 errorCode => this.statusCode = errorCode);
//     }

//     clearField(val: any) {
//         $(val).addClass('customfloat');
//     }

//     onSubmit() {
//         if (this.addMasterLookupForm.valid) {
//             this.preProcessConfigurations();
//             $('#masterLookupButton').prop('disabled', true);
//             let type = this.addMasterLookupForm.get('type').value.trim();
//             let code = this.addMasterLookupForm.get('code').value.trim();
//             let description = this.addMasterLookupForm.get('description').value.trim();
//             let masterLookup = new MasterLookup(0, type, code, description, true, 0, null, null, null, null);
//             this.name = code;
//             this.masterLookupService.insertMasterLookup(masterLookup)
//                 .subscribe(successCode => {
//                     this.statusCode = successCode;
//                     if (this.statusCode === 201) {
//                         setTimeout(() => {
//                             let element: HTMLElement = document.getElementById("dismissModal");
//                             element.click();
//                         }, 200);
//                         this.lookupCode = masterLookup.lookupCode;
//                         this.getAllMasterlookup();
//                     }
//                 },
//                 errorCode => { 
//                     this.statusCode = errorCode; 
//                     this.setTimeOut();
//                 })
//         }
//         else {
//             this.validateAllFormFields(this.addMasterLookupForm);
//         }
//     }

//     loadDeleteConfirmModal(lookupId: number, lookupCode: string) {
//         this.deleteConfirmForm.get("lookupId").setValue(lookupId);
//         this.deleteConfirmForm.get("lookupCode").setValue(lookupCode);
//     }

//     closeDeleteConfirmationModal() {
//         $('#deleteConfirmationModal').modal('hide');
//     }

//     deleteMasterLookup(lookupId: number, lookupCode: string) {
//         this.name = lookupCode;
//         this.preProcessConfigurations();
//         $('#masterLookupdelete').prop('disabled', true);
//         this.masterLookupService.deleteMasterLookup(lookupId)
//             .subscribe(successCode => {
//                 this.statusCode = successCode;
//                 if (this.statusCode === 204) {
//                     $('#deleteConfirmationModal').modal('hide');
//                     this.getAllMasterlookup();
//                 }
//             },
//                 errorCode => {
//                     $('#masterLookupdelete').prop('disabled', false);
//                     this.statusCode = errorCode;
//                 });
//     }

//     setTimeOut(){
//         window.setTimeout(function () {
//             $(".alert").fadeTo(2000, 500).slideUp(500, function () {
//                 $(".alert").slideUp(500);
//             });
//         }, 4000);
//     }

//     preProcessConfigurations() {
//         this.statusCode = null;
//         this.requestProcessing = true;
//     }

//     searchdata(v) {
//         var table = $('#datatables').DataTable();
//         table.search(v.target.value).draw();
//     }

//     isFieldValid(form: FormGroup, field: string) {
//         return !form.get(field).valid && form.get(field).touched;
//     }

//     onCancel() {
//         $('.label-floating').addClass('is-empty');
//         $('#master_floatToLabel').removeClass('customfloat');
//         this.addMasterLookupForm.reset();
//     }

//     floatLable(val: any) {
//         this.masterFloatLable = '';
//         $(val).addClass('customfloat');
//     }

//     validateAllFormFields(formGroup: FormGroup) {
//         Object.keys(formGroup.controls).forEach(field => {
//             const control = formGroup.get(field);
//             if (control instanceof FormControl) {
//                 control.markAsTouched({ onlySelf: true });
//             }
//             else if (control instanceof FormGroup) {
//                 this.validateAllFormFields(control);
//             }
//         });
//     }

//     private initTable() {
//         var table = $('#datatables').DataTable({
//             "ordering": true,
//             columnDefs: [
//                 { orderable: false, targets: [3,4] }],
//             "language": {
//                 "emptyTable": " "
//             },
//             "info": false,
//             "bLengthChange": false,
//             "dom": 'lrtip'
//         });

//         //var table = $('#datatables').DataTable();
//         // Delete a record
//         table.on('click', '.remove', function (e: any) {
//             const $tr = $(this).closest('tr');
//             table.row($tr).remove().draw();
//             e.preventDefault();

//         });

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
// }

// @Pipe({ name: 'masterType' })
// export class MasterPipe implements PipeTransform {
//     transform(array: any[], query: string): any {
//         if (query) {
//             query = query.toLowerCase();
//             return array.filter((value: any) => value &&
//                 value.toLowerCase().indexOf(query) > -1);
//         }
//         return array;
//     }

// }