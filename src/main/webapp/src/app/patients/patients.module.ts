import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule, DatePipe } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NouisliderModule } from 'ng2-nouislider';
import { TagInputModule } from 'ngx-chips';

import { PatientsRoutes } from './patients.routing';

import { PatientListComponent } from './patientlist/patientlist.component';

//import { PatientHeaderComponent } from './patientheader/PatientHeader.component';


import { SharedModule } from '../shared/shared-module';

import { Md2Module } from 'md2';
import { NgxSpinnerModule } from "ngx-spinner";
import { AddPatientComponent } from './add-patient/add-patient.component';
import { UpdatePatientComponent } from './update-patient/update-patient.component';
import { SearchPipe } from './search.pipe';
import { AddEncounterComponent } from './encounter/add-encounter/add-encounter.component';
import { PatientHeaderComponent } from './patient-header/patient-header.component';
import { ListEncounterComponent } from './encounter/list-encounter/list-encounter.component';
import { HpiComponent } from './hpi/hpi.component';
import { RosComponent } from './ros/ros.component';
import { MedicationComponent } from './medication/medication.component';
import { AddMedicationsComponent } from './add-medications/add-medications.component';
import { HistoryCompComponent } from './history-comp/history-comp.component';
import { ExaminationComponent } from './examination/examination.component';
import { ViewPrescriptionComponent } from './view-prescription/view-prescription.component';
import { DeleteMedicationComponent } from './delete-medication/delete-medication.component';


// import { StudentListComponent } from './studentlist/studentlist.component';
// import { StudentDetailsService } from './services/studentDetailsService';

@NgModule({
  imports: [
    NgxSpinnerModule,
   // Md2Module,
    RouterModule,
    CommonModule,
    RouterModule.forChild(PatientsRoutes),
    FormsModule,
    ReactiveFormsModule,
    
  //  MedicationModule,
    //HistoryModule,
    SharedModule,
    //ReactiveFormsModule,
   // NouisliderModule,
    //TagInputModule,
  //  MaterialModule,
    //EncounterModule,
  //  QuillEditorModule,
  //  PatientHeaderModule,
  // PlanAndAssessmentModule,
  //  SystemNavigationModule,
    //EncounterModule,
  //   LoadingModule.forRoot({animationType: ANIMATION_TYPES.threeBounce,
  //     backdropBackgroundColour: 'rgba(255,255,255,0.3)', 
  //     backdropBorderRadius: '10px',
  //     primaryColour: '#0073e6', 
  //     secondaryColour: '#3399ff', 
  //     tertiaryColour: '#99d6ff' 
  // })
  ],
  declarations: [
     // NewPatientComponent,
      //PatientListComponent,
     // UpdatePatientComponent,
      //lookupPipe,
     // PrimaryProviderPipe,
     // PrimaryServiceLocationPipe,
    //  ExamComponent,
      //HistoryComponent,
    //  ROSComponent,
    //  HPIComponent,
     // ListEncounterComponent,
      //SystemNavigationComponent,
    //  PatientHeaderComponent,
     // SafeHtmlPipe,
     // GroupByPipe
      // StudentListComponent
  
    
  
    
  
    UpdatePatientComponent,
     SearchPipe,
     AddEncounterComponent,
     PatientHeaderComponent,
     ListEncounterComponent,
     HpiComponent,
     RosComponent,
     MedicationComponent,
     AddMedicationsComponent,
     HistoryCompComponent,
     ExaminationComponent,
     ViewPrescriptionComponent,
     DeleteMedicationComponent
  ],
  providers: [
  // EncounterService,
  // SystemService,
  // QuestionGroupService,
  // EncounterQuestionGroupService,
  // EncounterQuestionOptionService,
  // MasterLookupService,
  // QuestionsService,
  // PatientDetailsService,
  // ClinicLocationService,
  // TemplateService,
  // StaffDetailsService,
  // MedicationService,
  // RoleGuardService,
  DatePipe,
  // LoginService,
  // EncounterHistoryService,
  // PatientAllergyService,
  // LabResultService
  // StudentDetailsService


]
})

export class Patients {}
