import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule, DatePipe } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NouisliderModule } from 'ng2-nouislider';
import { TagInputModule } from 'ngx-chips';
// import { MaterialModule } from '../app.module';
// import { PatientsRoutes } from './patients.routing';
// import { NewPatientComponent, lookupPipe, PrimaryProviderPipe, PrimaryServiceLocationPipe} from './newpatient/newpatient.component';
// import { PatientListComponent } from './patientlist/patientlist.component';
// import { UpdatePatientComponent} from './update/update.component';
// import { ExamComponent, SafeHtmlPipe, GroupByPipe } from './exam/exam.component';
// import { HPIComponent } from './hpi/hpi.component';
// import { PlanAndAssessmentComponent } from './planandassessment/planandassessment.component';
//import { PatientHeaderComponent } from './patientheader/PatientHeader.component';
// import { ROSComponent } from './ros/ros.component';
// import { HistoryComponent } from './history/history.component';
import { SharedModule } from '../shared/shared-module';
// import { LoadingModule, ANIMATION_TYPES } from 'ngx-loading';
import { Md2Module } from 'md2';
// import { SystemService } from 'app/patients/services/systemService';
// import { QuestionGroupService } from 'app/patients/services/questionGroupService';
// import { EncounterQuestionGroupService } from 'app/patients/services/encounterQuestionGroupService';
// import { EncounterQuestionOptionService } from 'app/patients/services/encounterQuestionOptionService';
// import { QuestionsService } from 'app/patients/services/questionsService';
// import { PatientDetailsService } from 'app/patients/services/patientDetailsService';
// import { EncounterService } from './services/encounterService';
// import { EncounterModule } from './encounter/encounter.module';
// import { QuillEditorModule } from 'ngx-quill-editor';
// import { ClinicLocationService } from 'app/administration/clinic-locations/clinicLocationService';
// import { TemplateService } from './services/templateService';
// import { StaffDetailsService } from 'app/administration/staff-members/staffDetailsService';
// import { MasterLookupService } from 'app/administration/master-lookup/masterLookupService';
import { RoleGuardService } from '../../app/shared/AuthGuard/RoleGuardService';
// import { MedicationService } from 'app/patients/services/medicationService';
// import { NgxSpinnerModule } from 'ngx-spinner';
// import { MedicationModule } from './medication/medication.module';
// import { EncounterHistoryService } from 'app/patients/services/encounterHistoryService';
// import { PatientAllergyService } from 'app/patients/services/patientAllergyService';
// import { LabResultService } from './services/labResultService';
// import { PatientHeaderModule } from './patientheader/patientheader.module';
// import { PlanAndAssessmentModule } from './planandassessment/planandassessment.module';
// import { PatientHeaderComponent } from 'app/patients/patientheader/patientheader.component';
// import { SystemNavigationModule } from 'app/patients/systemNavigation/systemNavigation.module';
// import { HistoryModule } from './history/history.module';
import { LoginService } from '../../app/home/login/login.service';
// import { ListEncounterComponent } from './encounter/list-encounter/list-encounter.component';
// // import { StudentListComponent } from './studentlist/studentlist.component';
// import { StudentDetailsService } from './services/studentDetailsService';

@NgModule({
  imports: [
    // NgxSpinnerModule,
    // Md2Module,
    RouterModule,
    CommonModule,
    // RouterModule.forChild(PatientsRoutes),
    FormsModule,
    // MedicationModule,
    // HistoryModule,
    SharedModule,
    ReactiveFormsModule,
    // NouisliderModule,
    // TagInputModule,
    // MaterialModule,
    // EncounterModule,
    // QuillEditorModule,
    // PatientHeaderModule,
    // PlanAndAssessmentModule,
    // SystemNavigationModule,
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
      // PatientListComponent,
      // UpdatePatientComponent,
      // lookupPipe,
      // PrimaryProviderPipe,
      // PrimaryServiceLocationPipe,
      // ExamComponent,
      //HistoryComponent,
      // ROSComponent,
      // HPIComponent,
     // ListEncounterComponent,
      //SystemNavigationComponent,
    //  PatientHeaderComponent,
      // SafeHtmlPipe,
      // GroupByPipe
      // StudentListComponent
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
  RoleGuardService,
  DatePipe,
  LoginService,
  // EncounterHistoryService,
  // PatientAllergyService,
  // LabResultService
  // StudentDetailsService


]
})

export class Patients {}
