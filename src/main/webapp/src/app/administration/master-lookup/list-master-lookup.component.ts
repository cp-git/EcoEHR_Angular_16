import { CommonModule } from "@angular/common";
import { Component, OnInit, PipeTransform, Pipe, signal } from "@angular/core";
import { FormGroup, FormBuilder, Validators, FormControl, FormsModule } from "@angular/forms";
import { MatButtonModule } from "@angular/material/button";
import { MatDialog, MatDialogModule } from "@angular/material/dialog";
import { MatExpansionModule } from "@angular/material/expansion";
import { MatSidenavModule } from "@angular/material/sidenav";

import { NgxSpinnerService } from "ngx-spinner";
import { TimerModule } from "src/app/components/timer/timer.module";
import { MasterLookup } from "src/app/patients/models/masterLookup";
import { PatientListComponent } from "src/app/patients/patientlist/patientlist.component";
import { MasterLookupService } from "src/app/patients/services/masterLookupService";
import { StaffMember } from "../staff-members/staffmember";
import { CurrentUserService } from "src/app/profiles/currentUserService";
import { Router } from "@angular/router";
import { AddMasterLookUpComponent } from "../add-master-look-up/add-master-look-up.component";
import { SearchPipe } from "src/app/search.pipe";


declare const $: any;

declare interface DataTable {
    headerRow: string[];
    footerRow: string[];
    dataRows: string[][];
}

@Component({
    selector: 'ehr-list-master-lookup',
    templateUrl: './list-master-lookup.component.html',
    styleUrls: ['../admin.component.css', '../../app.component.css','./list-master-lookup.component.css'],
    standalone: true,
    imports: [MatSidenavModule,FormsModule,SearchPipe, MatButtonModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatDialogModule]  ,
})

export class ListMasterLookupComponent implements OnInit {

    masterLookUp: MasterLookup[] = [];

    searchMaster='';
  
  


    showme: boolean = false;
    type_selectedValue: string = '';
    name: any;
    buttonName:any
    _search:string = '';
    masterFloatLable: string = '';

    readonly panelOpenState = signal(false);
    locName: any;
    staffImage: any;

    loggedInUser!: StaffMember;


    items: any[] = [];
    paginatedItems: any[] = [];
    currentPage: number = 1;
    pageSize: number = 10;

    pageSizeOptions: number[] = [5, 10, 15];
    
    constructor(
                private masterLookupService: MasterLookupService,
                private spinner:NgxSpinnerService,
                private currentUserService: CurrentUserService,
            private route:Router,
            private dialog: MatDialog,) { }


    ngOnInit() {
       

        this.getMasterLookupType();
        this.getAllMasterlookup();
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
        console.log("welcome");
        
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

  

    getAllMasterlookup() {

        this.masterLookupService.getAllMasterlookup().subscribe(
            (            response: any)=>{
                console.log(response);
               this.masterLookUp=response;
               this.updatePaginatedItems();
                

            }
        )
           
                
    }

    getMasterLookupType() {
        this.masterLookupService.getAllMasterLookupType()
            .subscribe((master: any) => {
                console.log(master);
                
                
            });
    }



    openDialog(): void {
        this.dialog.open(AddMasterLookUpComponent);
      }


    // Pagination
updatePaginatedItems(): void {
    const startIndex = (this.currentPage - 1) * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    this.paginatedItems = this.masterLookUp.slice(startIndex, endIndex);
  }

 
  
  
  
  OnPageChange(page: number): void {
    this.currentPage = page;
    this.updatePaginatedItems();
  }
  
  get totalPages(): number {
    //console.log(this.items.length);
    
    return Math.ceil(this.masterLookUp.length / this.pageSize);
  }

  deleteMasterLookup(lookupId: number, lookupCode: string) {
    this.name = lookupCode;
    this.masterLookupService.deleteMasterLookup(lookupId)
        .subscribe(successCode => {
            alert("Deleted...")
          
        });
}

GoToList(){
  this.route.navigate(['/list']);
}


// AddPatient(){
//   this.router.navigate(['addpatient'])
// }

Clinic(){
  this.route.navigate(['clinicLocation'])
}

Staff(){
  this.route.navigate(['stafflist'])
}


Student(){
  this.route.navigate(['studentlist'])
}

Master(){
  this.route.navigate(['masterlookup'])
}

   

  

 
    

  
}

