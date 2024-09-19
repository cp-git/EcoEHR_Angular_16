import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './home/aboutus/aboutus.component';
import { LoginComponent } from './home/login/login.component';
import { EHRLayoutComponent } from './home/layouts/ehr-layout/ehr-layout.component';
import { AuthGuard } from './shared/AuthGuard/auth-guard';
import { PatientListComponent } from './patients/patientlist/patientlist.component';
import { AddPatientComponent } from './patients/add-patient/add-patient.component';
import { UpdatePatientComponent } from './patients/update-patient/update-patient.component';
import { LocationsComponent } from './administration/clinic-locations/locations.component';
import { AddclinicComponent } from './administration/addclinic/addclinic.component';
import { UpdateclinicComponent } from './administration/updateclinic/updateclinic.component';
import { ListDoctorComponent } from './administration/staff-members/doctor-list.component';
import { StudentMembers } from './administration/student-members/student-members';
import { StudentMembersComponent } from './administration/student-members/student-members.component';
import { ListMasterLookupComponent } from './administration/master-lookup/list-master-lookup.component';
import { AddMasterLookUpComponent } from './administration/add-master-look-up/add-master-look-up.component';
import { StudentRegistrationComponent } from './home/student-registration/student-registration.component';
import { EditProfileComponent } from './profiles/edit-profile/edit-profile.component';
import { ContactUsComponent } from './profiles/contactus/contactus.component';
import { AddEncounterComponent } from './patients/encounter/add-encounter/add-encounter.component';
import { HpiComponent } from './patients/hpi/hpi.component';
import { RosComponent } from './patients/ros/ros.component';
import { MedicationComponent } from './patients/medication/medication.component';
import { AddMedicationsComponent } from './patients/add-medications/add-medications.component';
import { HistoryCompComponent } from './patients/history-comp/history-comp.component';
import { ExaminationComponent } from './patients/examination/examination.component';


// import { RoleGuard } from '../app/shared/'; // Assuming you have a RoleGuard
// import { GlobalErrorComponent } from './shared/global-error/global-error.component'; // Assuming you have a GlobalErrorComponent

// Define your routes here
const routes: Routes = [
  {
    path: '', // Root path
    component: AboutUsComponent // Component to display at root path
  },

  {
    path: 'login', // Root path
    component: LoginComponent // Component to display at root path
  },  
  {
    path: 'list', // Root path
    component: PatientListComponent // Component to display at root path
  },

  {
    path:'addpatient',
    component:AddPatientComponent
  },

  {
    path:'updatepatient/:id',
    component:UpdatePatientComponent
  },

  {
    path:'clinicLocation',
    component:LocationsComponent
  },

  {
    path:'addclinic',
    component:AddclinicComponent
  },

  {
    path:'updateclinic',
    component:UpdateclinicComponent
  },

  {
    path:'stafflist',
    component:ListDoctorComponent
  },
  {
    path:'studentlist',
    component:StudentMembersComponent

  },
  {
    path:'masterlookup',
    component:ListMasterLookupComponent
  },
  {
    path:'addMasterLookUp',
    component:AddMasterLookUpComponent
  },
  {
    path:'stduentRegister',
    component:StudentRegistrationComponent
  },
  {
    path:'editProfile',
    component:EditProfileComponent
  },
  {
    path:'feedback',
    component:ContactUsComponent
  },

  //add encounter
  {
    path:'addencounter/:id',
    component:AddEncounterComponent
  },

  {
    path:'hpi',
    component:HpiComponent
  },
  
  {
    path:'ros',
    component:RosComponent
  },
  {
    path:'medication',
    component:MedicationComponent
  },
  {
    path:'addMedication',
    component:AddMedicationsComponent
  },
  {
    path:'history',
    component:HistoryCompComponent
  },
  {
    path:'exam',
    component:ExaminationComponent
  }


  // {
  //   /** SECURE ROUTES declared here **/
  //   // CCM Module secure content area
  //   //  Access only for logged in User */
  //   path: '',
  //   component: EHRLayoutComponent,
  //   canActivateChild: [AuthGuard],
  //   children: [
  //     {
  //       path: 'profiles',
  //       loadChildren: () => import('../app/profiles/profiles.module').then(m => m.Profiles)
  //     },
  //     // {
  //     //   path: 'patients',
  //     //   loadChildren: () => import('./patients/patients.module').then(m => m.Patients)
  //     // },
  //     // {
  //     //   path: 'admin',
  //     //   // canActivateChild: [RoleGuard],
  //     //   // loadChildren: () => import('../app/administration/admin.module').then(m => m.AdminModule)
  //     // },
  //     // {
  //     //   path: 'error',
  //     //   // component: GlobalErrorComponent
  //     // },
  //     {
  //       path: '**',
  //       // redirectTo: '/patients/patientlist'
  //       redirectTo: '' // Redirect unknown paths to the root or a specific route

  //     }
  //   ]
  // },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // Import and configure the router
  exports: [RouterModule] // Export RouterModule to make router directives available in the app
})
export class AppRoutingModule { }
