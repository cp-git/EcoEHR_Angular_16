import { Routes } from '@angular/router';

import { PatientListComponent } from './patientlist/patientlist.component';

// import { StudentListComponent } from './studentlist/studentlist.component';
export const PatientsRoutes: Routes = [
  {
      path: '',
      component: PatientListComponent
    
  },

  
  // {
  //   path: '',
  //   children: [{
  //     path: 'studentlist',
  //     component: StudentListComponent
  //   }]
  // },






];
