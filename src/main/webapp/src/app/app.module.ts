import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { LoginComponent } from './home/login/login.component';
import { HttpClientModule, provideHttpClient } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AboutUsComponent } from './home/aboutus/aboutus.component';
import { LoginService } from './home/login/login.service';
import { CurrentUserService } from './profiles/currentUserService';
import { StudentMembersService } from './administration/student-members/student-members.service';
import { AuthService } from './timer/auth.service';
import { DatePipe } from '@angular/common';
import { EHRLayoutComponent } from './home/layouts/ehr-layout/ehr-layout.component';

import { SidebarModule } from './components/sidebar/sidebar.module';
import { NavbarModule } from './components/navbar/navbar.module';
import { FooterModule } from './components/footer/footer.module';
import { PluginModule } from './components/plugin/plugin.module';
import { TimerComponent } from './components/timer/timer.component';
import { TimerModule } from './components/timer/timer.module';
import { TimerModalModule } from './components/timer-modal/timerModal.module';
import { PatientDetailsService } from './patients/services/patientDetailsService';
import { MatNativeDateModule, MatRippleModule } from '@angular/material/core';
import { MasterLookupService } from './patients/services/masterLookupService';
import { StaffDetailsService } from './patients/services/staffDetailsService';
import { ClinicLocationService } from './patients/services/clinicLocationService';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { StaffMemberService } from './patients/services/staffmemberservice';
import { StudentRegistrationComponent } from './home/student-registration/student-registration.component';
import { SearchPipe } from './patients/search.pipe';
import { PatientAllergyService } from './patients/services/patientAllergyService';
import { EncounterService } from './patients/services/encounterService';
import { TemplateService } from './patients/services/templateService';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AboutUsComponent,
    EHRLayoutComponent,
    StudentRegistrationComponent,
  ],
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
   ReactiveFormsModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    HttpClientModule,
    SidebarModule,
    NavbarModule,
    FooterModule,
    PluginModule,
    TimerModule,
    TimerModalModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatRippleModule, 
    ReactiveFormsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    FormsModule,
    
  ],
  providers: [// provideClientHydration(), 
    LoginService,
    CurrentUserService,
    StudentMembersService,
    AuthService,
    DatePipe,
    PatientDetailsService,
    MasterLookupService,
    StaffDetailsService,
    ClinicLocationService,
    StaffMemberService,
    PatientAllergyService,
    EncounterService,
    TemplateService
    
    // provideAnimationsAsync()
  ],
 bootstrap:[AppComponent],
 exports:[
  MatButtonModule,
  MatFormFieldModule,
  MatInputModule,
  MatRippleModule,
  ReactiveFormsModule,
  
 ]
 
})
export class AppModule { }
// function provideAnimationsAsync(): import("@angular/core").Provider | import("@angular/core").EnvironmentProviders {
//   throw new Error('Function not implemented.');
// }

