// import { ViewChild, Component, OnInit } from '@angular/core';
// import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
// import { ClinicLocation } from './ClinicLocation';
// import { ClinicLocationService } from './clinicLocationService';
// import { Data } from 'app/data';
// import { NgxSpinnerService } from 'ngx-spinner';

import { Component, inject, signal } from "@angular/core";
import { FormBuilder, FormsModule } from "@angular/forms";

import { NgxSpinnerService } from "ngx-spinner";
import { ClinicLocationService } from "src/app/patients/services/clinicLocationService";
import { ClinicLocation } from "./ClinicLocation";
import { CommonModule } from "@angular/common";
import { MatButtonModule } from "@angular/material/button";
import { MatExpansionModule } from "@angular/material/expansion";
import { MatSidenavModule } from "@angular/material/sidenav";
import { TimerModule } from "src/app/components/timer/timer.module";
import { PatientListComponent } from "src/app/patients/patientlist/patientlist.component";
import { Route, Router } from "@angular/router";
import { MatDialog, MatDialogModule } from "@angular/material/dialog";
import { AddclinicComponent } from "../addclinic/addclinic.component";
import { UpdateclinicComponent } from "../updateclinic/updateclinic.component";
import { CurrentUserService } from "src/app/profiles/currentUserService";
import { StaffMember } from "../staff-members/staffmember";
import { SearchPipe } from "src/app/search.pipe";



// declare interface DataTable {
//     headerRow: string[];
//     footerRow: string[];
//     dataRows: string[][];
// }

// declare const $: any;

@Component({
    selector: 'ehr-locations',
    templateUrl: './locations.component.html',
    styleUrls: ['../admin.component.css', '../../app.component.css','./locations.component.css'],
    standalone: true,
    imports: [MatSidenavModule,SearchPipe,FormsModule, MatButtonModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatDialogModule]  ,
})


export class LocationsComponent {
  
    showme: boolean = false;
    headerName:any;
    clinic: ClinicLocation[] = [];
  
    readonly panelOpenState = signal(false);
    locName: any;
    staffImage: any;

    loggedInUser!: StaffMember;

    searchClinic='';

    constructor(private formBuilder: FormBuilder,
        private clinicLocationService: ClinicLocationService,
        private spinner : NgxSpinnerService,
        private route:Router,
        private dialog: MatDialog,
        private currentUserService: CurrentUserService
    ) { }

    

    ngOnInit() {
        this.getClinicAllLocations();
        this.getLoggedInUserDetails();
    
     
     
  
    }
    addClinic(){
        this.route.navigate(['/addclinic'])
        
    }

    openDialog(): void {
        this.dialog.open(AddclinicComponent);
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



      updateLocation(clinic:ClinicLocation): void {
        const dialogRef = this.dialog.open(UpdateclinicComponent, {
            data: { clinic: Object.assign({}, clinic) }
          });
          dialogRef.afterClosed().subscribe(result => {
            console.log(`Dialog result: ${result}`);
          });
      }

    

    
    

    getClinicAllLocations() {
       
      
        this.clinicLocationService.getAllClinicLocations()
            .subscribe(
                data => {
                    console.log(data);
                    this.clinic=data;
                    
                });
    }

    // deleteClinicLocation(locationId: number, locationName: string) {
    //     this.locName = locationName;
        
       
      
    //     this.clinicLocationService.deleteClinicLocation(locationId)
    //         .subscribe(successCode => {
    //           console.log(successCode);
              
    //         },
               
    //     );      
    //     }

 
}
