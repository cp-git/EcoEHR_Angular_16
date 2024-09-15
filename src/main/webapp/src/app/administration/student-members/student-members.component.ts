import { Component, OnInit, Pipe, PipeTransform, signal } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators, ValidatorFn, AbstractControl, FormsModule } from '@angular/forms';

import { NgxSpinnerService } from 'ngx-spinner';
import * as moment from 'moment';
import { StudentMembers } from './student-members';
import { StudentMembersService } from './student-members.service';
import { Router } from '@angular/router';
import { CurrentUserService } from 'src/app/profiles/currentUserService';
import { StaffMemberService } from 'src/app/patients/services/staffmemberservice';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatSidenavModule } from '@angular/material/sidenav';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { PatientListComponent } from 'src/app/patients/patientlist/patientlist.component';
import { StaffMember } from '../staff-members/staffmember';
import { SearchPipe } from 'src/app/search.pipe';


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
  selector: 'ehr-student-members',
  templateUrl: './student-members.component.html',
  styleUrls: ['../admin.component.css', '../../app.component.css','./student-members.component.css'],
  standalone: true,
    imports: [MatSidenavModule,FormsModule,SearchPipe, MatButtonModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatDialogModule]  ,
})
export class StudentMembersComponent implements OnInit {
  public dataTable: DataTable = {
    headerRow: ['Full Name', 'Email', 'DOB', 'Gender', 'Active Status','Payment Status', 'Action'],

    // headerRow: ['Full Name', 'User Role', 'Provider', 'Login Id', 'Default Location', 'NPI Number', 'Actions'],
    footerRow: [],
    dataRows: []
  };
  
//   statusCode: number;
//   fullName: any;
  
//   selectedStudent: StudentMembers;
  
//   _search: string = '';
//   showme: boolean = false;
//   requestProcessing: boolean;

//   headerName: any;
//   buttonName: any;
//   studentmemberForm: FormGroup;
//   showRadio: boolean = false;
//   adminFlag = "";
  
//   isadmin: boolean;
  allStudentDetails: StudentMembers[] = [];
  readonly panelOpenState = signal(false);

  searchStudent=''

  staffImage: any;
  

  loggedInUser!: StaffMember;

  items: any[] = [];
  paginatedItems: any[] = [];
  currentPage: number = 1;
  pageSize: number = 10;
  
  constructor(private formBuilder: FormBuilder,
    private route: Router,
    private studentMemberService: StudentMembersService,
    private currentUserservice: CurrentUserService,
    private staffMemberService: StaffMemberService,
    private spinner: NgxSpinnerService) { }


  ngOnInit() {

    this.getAllStudentMembers();
    this.getLoggedInUserDetails();
  

    

    // this.studentmemberForm = this.formBuilder.group({
    //   firstName: [null, [Validators.required, Validators.pattern("[a-zA-Z]*")]],
    //   gender: [null, [Validators.required]],
    //   dob: [null, [Validators.required]],
      
    //   lastName: [null, [Validators.required, Validators.pattern("[a-zA-Z]*")]],
      
    //   designation: [null],
    //   email: [null, [Validators.required, this.ValidateEmail(), Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]]
    //          // 1] First name+last name...2]email...3]dob...4]gender.....5].Active status..6]active bttn

    // });


  }

  getLoggedInUserDetails(){
    this.currentUserservice.getCurrentStaffMember()
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

updatePaginatedItems(): void {
    const startIndex = (this.currentPage - 1) * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    this.paginatedItems = this.allStudentDetails.slice(startIndex, endIndex);
  }
  
  
  
  OnPageChange(page: number): void {
    this.currentPage = page;
    this.updatePaginatedItems();
  }
  
  get totalPages(): number {
    //console.log(this.items.length);
    
    return Math.ceil(this.allStudentDetails.length / this.pageSize);
  }


updateStudStatus(status: boolean,roleId: number, staff: StaffMember){
    //console.log(status)
    //onsole.log(roleId)
    staff.activeFlag = status;
    this.staffMemberService.updateStaffMember(staff)
    .subscribe(data => {
     // let staffRoleToInsert = new StaffRole(0, data.staffId, "TRY_ME", true, null, null, null, null);
      // this.staffMemberService.insertStaffRole(staffRoleToInsert)
      //   .subscribe(sucessCode => {
      //     this.statusCode = sucessCode;
      //   },
      //     errorCode => this.statusCode = errorCode);
    });
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



//   isFieldValid(field: string, form: FormGroup) {
//     return !form.get(field).valid && form.get(field).touched;
//   }


//   selectVal() {
//     this.isadmin = false;
//   }

//   DateOfBirth(date) {
//     return new Date(date);
// }
  
// updateStudStatus(status: boolean,roleId: number, staff: StaffMember){
//   //console.log(status)
//   //onsole.log(roleId)
//   staff.activeFlag = status;
//   this.staffMemberService.updateStaffMember(staff)
//   .subscribe(data => {
//     let staffRoleToInsert = new StaffRole(0, data.staffId, "TRY_ME", true, null, null, null, null);
//     // this.staffMemberService.insertStaffRole(staffRoleToInsert)
//     //   .subscribe(sucessCode => {
//     //     this.statusCode = sucessCode;
//     //   },
//     //     errorCode => this.statusCode = errorCode);
//   },
//     ErrorCode => {
//       this.statusCode = ErrorCode;
//     })
// }

//   setTimeOut() {
//     window.setTimeout(function () {
//       $(".alert").fadeTo(2000, 500).slideUp(500, function () {
//         $(".alert").slideUp(500);
//       });
//     }, 4000);
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
//         self.studentmemberForm.get(val).setValue((document.getElementById(val) as HTMLInputElement).value);
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
//         defaultDate: '01/01/2020',
//         maxDate: new Date(),
//         changeYear: true,
//         beforeShow: function () {
//             setTimeout(function () {
//                 $('.ui-datepicker').css('z-index', 99999999999999);
//             }, 0);     
//         },
//         onSelect: function(){ 
//             self.studentmemberForm.get(val).setValue((document.getElementById(val) as HTMLInputElement).value);
//              }
//     }).datepicker("show");
// }



  

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

  getAllStudentMembers() {

    this.studentMemberService.getAllStudentMembers()
      .subscribe(data => {
      
        this.allStudentDetails = data;
        console.log("details", data)
        this.updatePaginatedItems();

      
      });
  }
 

  //Perform preliminary processing configurations
//   preProcessConfigurations() {
//     this.statusCode = null;
//     this.requestProcessing = true;
//   }

//   ValidateEmail(): ValidatorFn {
//     return (control: AbstractControl): { [key: string]: boolean } | null => {
//       let email = control.value;
//       if (email != null) {
//         let student: any[] = this.allStudentDetails.filter(student =>
//             student.email.trim() == email.trim())
//         if (student.length > 0) {
//           if (this.buttonName == 'ADD') {
//             return { 'validEmail': true }
//           }
//           else {
//             if (email == this.selectedStudent.email) {
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
  //}
}