import { Routes } from '@angular/router';
import { LocationsComponent } from './clinic-locations/locations.component';
import { ListMasterLookupComponent } from './master-lookup/list-master-lookup.component';
import { ListDoctorComponent } from './staff-members/doctor-list.component';
import { StudentMembersComponent } from './student-members/student-members.component';


export const AdminRoutes: Routes = [
  {
    path: '',
    children: [{
      path: 'liststaffmembers',
      component: ListDoctorComponent
    }]
  },
  {
    path: '',
    children: [{
      path: 'listcliniclocations',
      component: LocationsComponent
    }]
  },
  {
    path: '',
    children: [{
      path: 'listmasterlookup',
      component: ListMasterLookupComponent
    }]
  },
  {
    path: '',
    children: [{
      path: 'liststudentmembers',
      component: StudentMembersComponent
    }]
  }
];