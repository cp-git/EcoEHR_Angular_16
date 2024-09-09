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

import { StaffMember } from '../../staff-members/staffmember';
import { StaffMemberService } from 'src/app/patients/services/staffmemberservice';


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
    private  masterLookupService:MasterLookupService,
    private staffMemberService:StaffMemberService
  ){
    dialogRef.disableClose = true;
  }

  staffData: StaffMember = new StaffMember();
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
authority:any;


ngOnInit(){
  this.dropdownValues();
}


dropdownValues(){
  this.staffImage = "./assets/img/default-avatar.png";
  
  this.getPrimaryServiceLocation();
  this.getCredentials();
  this.getProviderTypes();


}





  createStaff(staff:StaffMember){
  
    let staffRoles=new StaffRole();
    this.staffMemberService.insertStaffMember(staff)
    .subscribe(data => {
      alert(data)
      console.log("Entered in api call")
   
      
      

      });
         
  
    
    
    
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
