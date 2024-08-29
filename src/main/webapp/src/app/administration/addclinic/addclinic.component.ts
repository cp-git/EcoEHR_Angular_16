import { CommonModule } from '@angular/common';
import { ChangeDetectionStrategy, Component, Inject } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatSidenavModule } from '@angular/material/sidenav';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { PatientListComponent } from 'src/app/patients/patientlist/patientlist.component';
import { MAT_DIALOG_DATA, MatDialog, MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { ClinicLocation } from '../clinic-locations/ClinicLocation';
import { ClinicLocationService } from 'src/app/patients/services/clinicLocationService';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-addclinic',
  templateUrl: './addclinic.component.html',
  styleUrls: ['./addclinic.component.css'],
  standalone: true,
  imports: [FormsModule ,CommonModule,TimerModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule],

})
export class AddclinicComponent {

  clinicLoc: ClinicLocation = new ClinicLocation();

  constructor(
    public dialog: MatDialog,
    public dialogRef: MatDialogRef<AddclinicComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private clinicLocationService: ClinicLocationService,
    private _route:Router
  ) {
    dialogRef.disableClose = true;
  }


  createClinic(clinic:ClinicLocation){

    this.clinicLocationService.insertClinicLocation(clinic)
    .subscribe(data => {
      alert("welcome");
      console.log(data);
    
      
     
    })

  }

  onCancel(){
    this._route.navigate(['/clinicLocation'])
  }



}
