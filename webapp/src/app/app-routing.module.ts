import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './home/aboutus/aboutus.component';
import { LoginComponent } from './home/login/login.component';

// Define your routes here
const routes: Routes = [
  {
    path: '', // Root path
    component: AboutUsComponent // Component to display at root path
  },
  {
    path: 'login', // Root path
    component: LoginComponent // Component to display at root path
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // Import and configure the router
  exports: [RouterModule] // Export RouterModule to make router directives available in the app
})
export class AppRoutingModule { }
