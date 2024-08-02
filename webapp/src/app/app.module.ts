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
import { TimerModalComponent } from './timer-modal/timer-modal.component';
import { AboutUsComponent } from './home/aboutus/aboutus.component';
import { LoginService } from './home/login/login.service';
import { CurrentUserService } from './profiles/currentUserService';
import { StudentMembersService } from './administration/student-members/student-members.service';
import { AuthService } from './timer/auth.service';
import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TimerModalComponent,
    AboutUsComponent
   
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
    HttpClientModule 
  ],
  providers: [// provideClientHydration(),
    provideHttpClient(),
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

