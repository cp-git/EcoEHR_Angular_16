import { CommonModule } from '@angular/common';
import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MAT_DIALOG_DATA, MatDialog, MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { PatientListComponent } from '../patientlist/patientlist.component';
import { PatientMedicationRecord } from '../models/patientMedicationRecord';
import { ViewPrescriptionComponent } from '../view-prescription/view-prescription.component';
import { MasterLookup } from 'src/app/administration/master-lookup/masterLookup';
import { MasterLookupService } from '../services/masterLookupService';
import { PatientMedication } from '../models/PatientMedication';
import { MedicationService } from '../services/medicationService';
import { StateServicesService } from '../services/state-services.service';

@Component({
  selector: 'app-delete-medication',
  templateUrl: './delete-medication.component.html',
  styleUrls: ['./delete-medication.component.css'],
  standalone: true,
  imports: [MatSidenavModule, MatButtonModule,FormsModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule,MatIconModule],
})
export class DeleteMedicationComponent {

  record!: PatientMedicationRecord;
  discontinuedReasonList!: MasterLookup[];
  InActiveMedicationForm!: FormGroup;
  number:any
  
  constructor(
   
    public dialog: MatDialog,
    public dialogRef: MatDialogRef<DeleteMedicationComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private masterLookupService:MasterLookupService,
    private formBuilder:FormBuilder,
    private medicationService:MedicationService,
    private stateService:StateServicesService
   
  ) {
    dialogRef.disableClose = true;
  }


  ngOnInit(): void {
    console.log(this.data);
    this.record=this.data;
    this.getLookUpTypeDiscontinuedReason();

    this.InActiveMedicationForm = this.formBuilder.group({
      endDate: [null, [Validators.required]],
      reason: [null, [Validators.required]]
    });

    this.stateService.currentNumber.subscribe(number => {
      this.number = number;
      console.log(this.number);
      
    });

    
  }

  getLookUpTypeDiscontinuedReason() {
    this.masterLookupService.getLookUpTypeAsDiscontinued_Reason()
      .subscribe(
        data => {
          this.discontinuedReasonList = data;

        });
  }


  onSubmitInActiveList() {
   
   
      let reason = this.InActiveMedicationForm.get('reason')?.value;
      let endDate = this.InActiveMedicationForm.get('endDate')?.value;
      let patientMedication = new PatientMedication(this.record.patientMedicationId, 0, this.number, 0, "", new Date(), 0, new Date(), 0, "", "", 'N', reason, true, new Date(), "", new Date(), "", new Date(endDate));
      this.medicationService.discontinueMedication(patientMedication)
        .subscribe(successCode => {
          console.log("deleted...");
          
         
        });
          
    }
 
  


}
