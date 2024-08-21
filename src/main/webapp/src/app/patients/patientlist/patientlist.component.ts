import { Component, OnInit, signal, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { PatientDetailsService } from '../services/patientDetailsService';
import {MatButtonModule} from '@angular/material/button';
import {MatSidenavModule} from '@angular/material/sidenav';
import { CommonModule } from '@angular/common';
import { TimerModule } from 'src/app/components/timer/timer.module';
import {MatExpansionModule} from '@angular/material/expansion';
import { CurrentUserService } from 'src/app/profiles/currentUserService';
import { StaffMember } from 'src/app/administration/staff-members/staffmember';
import { LoginService } from 'src/app/home/login/login.service';



@Component({
  selector: 'app-patientlist',
  templateUrl: './patientlist.component.html',
  styleUrls: ['./patient.component.css', '../../app.component.css'],
  standalone: true,
  imports: [MatSidenavModule, MatButtonModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule]  ,
})
export class PatientListComponent implements OnInit {
  public dataTable: any;
  public statusCode: number | undefined;
  public fullName: string = '';
  public msgName: string = '';
  public minDate: Date;
  public maxDate: Date;
  public startDate: Date;
  showFiller = false;
  readonly panelOpenState = signal(false);


  loggedInUser!: StaffMember;
  staffImage: any;

  items: any[] = [];
  paginatedItems: any[] = [];
  currentPage: number = 1;
  pageSize: number = 10;

  


  @ViewChild('sidebar') sidebar: any;
  constructor(private router: Router, private patientService: PatientDetailsService, private currentUserService: CurrentUserService,  private loginService : LoginService) {
    this.minDate = new Date(1900, 0, 1);
    this.maxDate = new Date();
    this.startDate = new Date();
  }

  ngOnInit(): void {
    this.dataTable = {
      headerRow: [
        'Patient Name',
        'MRN',
        'Gender',
        'DOB',
        'Provider',
        'Address',
        'Encounter',
        'Edit',
        'Status',
      ],
      dataRows: [],
    };

    this.getLoggedInUserDetails();
    this.patientService.getAllPatients().subscribe(
      (data) => {
        console.log(data);
        this.dataTable.dataRows = data;
        this.updatePaginatedItems();
      },
      (error) => {
        console.error('Error fetching patient data:', error);
      }
    );
  }

  changePage(event: Event): void {
    const target = event.target as HTMLSelectElement;
    console.log('Selected value:', target.value);
    // Add logic to handle page change
  }

  searchdata(event: Event): void {
    const target = event.target as HTMLInputElement;
    console.log('Search text:', target.value);
    // Add logic to handle search functionality
  }

  addPatient(): void {
    this.router.navigate(['/patients/add']);
  }

  openUpdatePatient(patientId: string): void {
    this.router.navigate(['/patients/edit', patientId]);
  }

  datepicker(id: string): void {
    // Assuming you have some datepicker library integrated
    const datepickerElement = document.getElementById(id);
    if (datepickerElement) {
      datepickerElement.focus();
    }
  }

  DateOfBirth(dob: string): Date {
    return new Date(dob);
  }

  displayPatientAddress(patient: any): string {
    return `${patient.address}, ${patient.city}, ${patient.state}, ${patient.zipCode}`;
  }

  disabled(additionalInfo: any): boolean {
    return !additionalInfo || additionalInfo.length === 0;
  }

  advanceSearchPatient(): void {
    // Logic for advanced search
    console.log('Advanced search triggered');
    // You can add form controls to take advanced search inputs and process them here
  }

  resetAdvanceSearch(): void {
    // Logic to reset advanced search fields
    console.log('Advanced search reset');
    // Reset form controls here
  }

  closeAdvanceSearchModal(): void {
    // Logic to close the advanced search modal
    console.log('Closing advanced search modal');
    const modalElement = document.getElementById('advanceSearchModal');
    if (modalElement) {
      modalElement.style.display = 'none';
    }
  }

  AddPatient(){
    this.router.navigate(['/addpatient'])
  }



  //getting staff image using api
  getLoggedInUserDetails(){
    this.currentUserService.getCurrentStaffMember()
    .subscribe(data => {
      this.loggedInUser = data;
      if (data.staffImage == null || data.staffImage == "") {
        this.staffImage = "./assets/img/default-avatar.png";
      }
      else{
          this.staffImage = data.staffImage;
      }
    })
}



logout() {
//   this.currentUserService.getCurrentStaffMember()
// .subscribe(data => {
    //   this.loggedInUser =  data;
    //  //console.log(this.loggedInUser)
    //  let staffToUpdate = new StaffMember(this.loggedInUser.staffId, this.loggedInUser.loginId, this.loggedInUser.loginKey, this.loggedInUser.firstName, '', 
    //   this.loggedInUser.lastName, this.loggedInUser.staffImage, this.loggedInUser.providerType, this.loggedInUser.designation, this.loggedInUser.providerFlag, 0, true, this.loggedInUser.clinicLocationId,
    //   this.loggedInUser.mobileNo, '',this.loggedInUser.email, this.loggedInUser.npiNumber, '', null, null, null, null, null, null, null, this.loggedInUser.licenseNumber, 
    //   this.loggedInUser.licenseNumber, this.loggedInUser.licenseExpDate, this.loggedInUser.deaNumber, this.loggedInUser.deaExpDate, this.loggedInUser.malpracticeCoverage,this.loggedInUser.malpracticeExpiration , 
    //   this.loggedInUser.dob, this.loggedInUser.gender, this.loggedInUser.ssn);

    //   this.loginService.updateLogoutTime(staffToUpdate)
    //   .subscribe(()=>{
  //     })
  // })  

  this.router.navigate(['/login']);
  location.reload(); 
  localStorage.removeItem('jwt');   
  
}

// Pagination
updatePaginatedItems(): void {
  const startIndex = (this.currentPage - 1) * this.pageSize;
  const endIndex = startIndex + this.pageSize;
  this.paginatedItems = this.dataTable.dataRows.slice(startIndex, endIndex);
}



OnPageChange(page: number): void {
  this.currentPage = page;
  this.updatePaginatedItems();
}

get totalPages(): number {
  console.log(this.items.length);
  
  return Math.ceil(this.dataTable.dataRows.length / this.pageSize);
}

}
