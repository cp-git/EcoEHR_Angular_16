import { CommonModule } from '@angular/common';
import { Component, Inject } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
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


@Component({
  selector: 'app-add-staff',
  templateUrl: './add-staff.component.html',
  styleUrls: ['./add-staff.component.css'],
  standalone: true,
  imports: [FormsModule ,CommonModule,TimerModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule,MatIconModule],
})
export class AddStaffComponent {
  constructor(
    public dialogRef: MatDialogRef<AddStaffComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private clinicLocationService:ClinicLocationService,
    private  masterLookupService:MasterLookupService
  ){
    dialogRef.disableClose = true;
  }

  staffData: StaffDetails = new StaffDetails();
  staffRole: StaffRole = new StaffRole();

  allProvider!: StaffDetails[];
allCliniclocations!: ClinicLocation[];
isNotValidImageSize: boolean = false;
statusCode!: number;
allStates!: MasterLookup[];
allTitles!: MasterLookup[];
allLanguages!: MasterLookup[];
allRace!: MasterLookup[];
allEthnicity!: MasterLookup[];
alladditionalInfo!: MasterLookup[];
staffImage: any;
allCredentials!: MasterLookup[];
allProviderTypes!: MasterLookup[];


ngOnInit(){
  this.dropdownValues();
}


dropdownValues(){
  this.staffImage = "./assets/img/default-avatar.png";
  
  this.getPrimaryServiceLocation();
  this.getCredentials();


}





  createStaff(){
    
  }


  getPrimaryServiceLocation() {
   
    this.clinicLocationService.getAllClinicLocations()
        .subscribe(data => {
            this.allCliniclocations = data;
        })
  }

  getCredentials() {
    this.masterLookupService.getCredentials()
      .subscribe(data => {
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
