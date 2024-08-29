// import { ViewChild, Component, OnInit } from '@angular/core';
// import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
// import { ClinicLocation } from './ClinicLocation';
// import { ClinicLocationService } from './clinicLocationService';
// import { Data } from 'app/data';
// import { NgxSpinnerService } from 'ngx-spinner';

import { Component, inject } from "@angular/core";
import { FormBuilder } from "@angular/forms";

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


// declare interface DataTable {
//     headerRow: string[];
//     footerRow: string[];
//     dataRows: string[][];
// }

// declare const $: any;

@Component({
    selector: 'ehr-locations',
    templateUrl: './locations.component.html',
    styleUrls: ['../admin.component.css', '../../app.component.css'],
    standalone: true,
    imports: [MatSidenavModule, MatButtonModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatDialogModule]  ,
})


export class LocationsComponent {
  
    showme: boolean = false;
    headerName:any;
    clinic: ClinicLocation[] = [];
  
    locName: any;

    constructor(private formBuilder: FormBuilder,
        private clinicLocationService: ClinicLocationService,
        private spinner : NgxSpinnerService,
        private route:Router,
        private dialog: MatDialog
    ) { }

    

    ngOnInit() {
        this.getClinicAllLocations();
    
     
     
  
    }
    addClinic(){
        this.route.navigate(['/addclinic'])
        
    }

    openDialog(): void {
        this.dialog.open(AddclinicComponent);
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
