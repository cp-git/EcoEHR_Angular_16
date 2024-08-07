import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './home/aboutus/aboutus.component';
import { LoginComponent } from './home/login/login.component';
import { EHRLayoutComponent } from './home/layouts/ehr-layout/ehr-layout.component';
import { AuthGuard } from './shared/AuthGuard/auth-guard';
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
    /** SECURE ROUTES declared here **/
    // CCM Module secure content area
    //  Access only for logged in User */
    path: '',
    component: EHRLayoutComponent,
    canActivateChild: [AuthGuard],
    children: [
      {
        path: 'profiles',
        loadChildren: () => import('../app/profiles/profiles.module').then(m => m.Profiles)
      },
      {
        path: 'patients',
        loadChildren: () => import('../app/patients/patients.module').then(m => m.Patients)
      },
      // {
      //   path: 'admin',
      //   // canActivateChild: [RoleGuard],
      //   // loadChildren: () => import('../app/administration/admin.module').then(m => m.AdminModule)
      // },
      // {
      //   path: 'error',
      //   // component: GlobalErrorComponent
      // },
      {
        path: '**',
        // redirectTo: '/patients/patientlist'
        redirectTo: '' // Redirect unknown paths to the root or a specific route

      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // Import and configure the router
  exports: [RouterModule] // Export RouterModule to make router directives available in the app
})
export class AppRoutingModule { }
