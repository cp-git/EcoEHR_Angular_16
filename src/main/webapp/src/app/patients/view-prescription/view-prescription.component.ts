import { Component, Inject } from '@angular/core';
import { PatientMedicationRecord } from '../models/patientMedicationRecord';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';
import { UpdateclinicComponent } from 'src/app/administration/updateclinic/updateclinic.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { PatientListComponent } from '../patientlist/patientlist.component';

@Component({
  selector: 'app-view-prescription',
  templateUrl: './view-prescription.component.html',
  styleUrls: ['./view-prescription.component.css'],
  standalone: true,
  imports: [MatSidenavModule, MatButtonModule,FormsModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule,MatIconModule],
})
export class ViewPrescriptionComponent {

  record!: PatientMedicationRecord;
  
  
  constructor(
   
    public dialog: MatDialog,
    public dialogRef: MatDialogRef<ViewPrescriptionComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
   
  ) {
    dialogRef.disableClose = true;
  }


  ngOnInit(): void {
    console.log(this.data);
    
  }

}
