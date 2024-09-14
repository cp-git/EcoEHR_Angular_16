import { Component, Inject } from '@angular/core';
import { ClinicLocation } from '../clinic-locations/ClinicLocation';
import { MAT_DIALOG_DATA, MatDialog, MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { PatientListComponent } from 'src/app/patients/patientlist/patientlist.component';
import { ClinicLocationService } from 'src/app/patients/services/clinicLocationService';
import { MatIconModule } from '@angular/material/icon';



@Component({
  selector: 'app-updateclinic',
  templateUrl: './updateclinic.component.html',
  styleUrls: ['./updateclinic.component.css'],
  standalone: true,
  imports: [MatSidenavModule, MatButtonModule,FormsModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule,MatIconModule],
})
export class UpdateclinicComponent {
  clinic!: ClinicLocation;
  
  
  constructor(
    private clinicLocationService: ClinicLocationService,
    public dialog: MatDialog,
    public dialogRef: MatDialogRef<UpdateclinicComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
   
  ) {
    dialogRef.disableClose = true;
  }


  ngOnInit(): void {
    this.clinic = this.data.clinic;
  }


  updateClinic(clinic:ClinicLocation){
    this.clinicLocationService.updateClinicLocation(clinic).subscribe(
      response=>{
        alert("Updated...")
        console.log(response);
        
      }
    )
  }

}
