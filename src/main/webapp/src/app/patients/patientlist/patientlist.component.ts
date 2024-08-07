import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientDetailsService } from '../services/patientDetailsService';

@Component({
  selector: 'app-patientlist',
  templateUrl: './patientlist.component.html',
//   styleUrls: ['./patientlist.component.css'],
})
export class PatientListComponent implements OnInit {
  public dataTable: any;
  public statusCode: number | undefined;
  public fullName: string = '';
  public msgName: string = '';
  public minDate: Date;
  public maxDate: Date;
  public startDate: Date;

  constructor(private router: Router, private patientService: PatientDetailsService) {
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
        'Additional Info',
      ],
      dataRows: [],
    };

    this.patientService.getAllPatients().subscribe(
      (data) => {
        this.dataTable.dataRows = data;
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
}
