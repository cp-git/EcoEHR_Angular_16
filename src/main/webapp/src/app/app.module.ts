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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,

    AboutUsComponent,
    EHRLayoutComponent,

   
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
    TimerModalModule
  ],
  providers: [// provideClientHydration(),
   
    LoginService,
    CurrentUserService,
    StudentMembersService,
    AuthService,
    DatePipe
    // provideAnimationsAsync()
  
  ],
 bootstrap:[AppComponent]
 
})
export class AppModule { }
// function provideAnimationsAsync(): import("@angular/core").Provider | import("@angular/core").EnvironmentProviders {
//   throw new Error('Function not implemented.');
// }

