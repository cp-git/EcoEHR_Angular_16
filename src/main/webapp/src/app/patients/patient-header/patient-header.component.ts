import { Component, EventEmitter, Inject, Input, Output } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { PatientRecord } from '../models/PatientRecord';
import { PatientDetailsService } from '../services/patientDetailsService';
import { PatientAllergy } from '../models/patientAllergy';
import { Encounter } from '../models/encounter';
import { PatientAllergyService } from '../services/patientAllergyService';
import { EncounterService } from '../services/encounterService';
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
import { PatientListComponent } from '../patientlist/patientlist.component';
import { ActivatedRoute } from '@angular/router';
import { MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';
import { MedicationService } from '../services/medicationService';
import { PatientMedicationRecord } from '../models/patientMedicationRecord';
import { PatientPreventiveService } from '../services/patientPreventiveService';
import { PatientPreventiveCare } from '../models/patientPreventiveCare';

@Component({
  selector: 'app-patient-header',
  templateUrl: './patient-header.component.html',
  styleUrls: ['./patient-header.component.css'],
  standalone: true,
  imports: [MatSidenavModule, MatButtonModule,FormsModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule],
})
export class PatientHeaderComponent {
  encounterId:any;
  patientRecords!:PatientRecord;
  encounter!:Encounter
  description:any
  icdCode:any


  activeMedicationData: PatientMedicationRecord[] = [];
  medicationByEncId: PatientMedicationRecord[] = [];
  inactiveMedicationByEncId: PatientMedicationRecord[] = [];

  allPreventiveCare!: PatientPreventiveCare[];
  



  constructor(
   
    private patientDetailsService: PatientDetailsService,
    private patientAllergyService: PatientAllergyService,
    private encounterService: EncounterService, private spinner:NgxSpinnerService,
    private _activateRoute:ActivatedRoute,
    private medicationService:MedicationService,
    private preventiveService: PatientPreventiveService,
    @Inject(MAT_DIALOG_DATA) public data: { id: number,id1:number }
  ){

  }

  
  ngOnInit(){
    console.log(this.data.id);
    console.log(this.data.id1);


    this.getPatientRecordsByPatientId(this.data.id1);

    this.editEncounter(this.data.id);

    this.medicationService.getPatientMedications(this.data.id1)
      .subscribe(
        data => {
          console.log(data);
          this.activeMedicationData = data;
          for (let i = 0; i < data.length; i++) {
            //this.showActiveMedicationFlag = true;
            if (this.activeMedicationData[i].isActiveMedication == 'Y') {
              this.medicationByEncId.push(this.activeMedicationData[i]);
            }
            else {
              this.inactiveMedicationByEncId.push(this.activeMedicationData[i])
            }
          }
        });


      this.preventiveService.getPatientPreventitiveByPatientId(this.data.id1)
      .subscribe(data => {
        console.log(data);
        
        this.allPreventiveCare = data;
      
      })

    

    
  }

  getPatientRecordsByPatientId(patientId:any) {
 
    this.spinner.show();
      this.patientDetailsService.getPatientRecordsByPatientId(patientId)
        .subscribe(data => {
          console.log(data);
          
          this.patientRecords = data;
          this.spinner.hide();
          //console.log(this.patientRecords);
        
          
        })
    }

    editEncounter(encounterId:any){
      this.encounterId=encounterId;
      console.log(this.encounterId);
      this.encounterService.getEncounterByEncounterId(this.encounterId).subscribe(
        data=>{
          console.log(data);
          this.encounter=data
          
        }
      );
      this.encounterService.getAllChiefCompliantDetailsByEncounterId(encounterId).subscribe(
        response=>{
          console.log(response);
           for(let j=0;j<=response.length;j++){
            console.log(response[j]);
            this.description=response[j].icd10CodeDescription;
            this.icdCode=response[j].icd10Code;
            
           }
           
          
        }
      );
    
    
}
  



  
}
