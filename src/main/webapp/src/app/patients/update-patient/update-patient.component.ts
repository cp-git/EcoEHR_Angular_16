import { Component, signal } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientDetailsService } from '../services/patientDetailsService';
import { PatientDetails } from '../models/PatientDetails';
import { CommonModule, DatePipe } from '@angular/common';
import { NgxSpinnerService } from 'ngx-spinner';
import { CurrentUserService } from 'src/app/profiles/currentUserService';
import { ClinicLocationService } from '../services/clinicLocationService';
import { MasterLookupService } from '../services/masterLookupService';
import { StaffDetailsService } from '../services/staffDetailsService';

import { StaffDetails } from 'src/app/administration/staff-members/StaffDetails';
import { StaffMember } from 'src/app/administration/staff-members/staffmember';
import { ClinicLocation } from '../models/ClinicLocation';
import { MasterLookup } from '../models/masterLookup';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { PatientListComponent } from '../patientlist/patientlist.component';


@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrls: ['./update-patient.component.css'],
  standalone: true,
  imports: [MatSidenavModule, MatButtonModule,FormsModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,],
})
export class UpdatePatientComponent {

  data:any;
  patientDetail!:PatientDetails;

  //Sidebar Data
  readonly panelOpenState = signal(false);

  public minDate: Date;
  public maxDate: Date;
  public startDate: Date;
  

  loggedInUser!: StaffMember;
  staffImage: any;
  

// Add Patient Variables



patientAddressState_search: string = '';
additionalInfo_search: string = '';
patientAddressId_search: string = '';
staffId_search: string = '';
allProvider!: StaffDetails[];
allCliniclocations!: ClinicLocation[];
isNotValidImageSize: boolean = false;
statusCode!: number;
allStates!: MasterLookup[];
allTitles!: MasterLookup[];
allLanguages!: MasterLookup[];
allRace!: MasterLookup[];
allEthnicity!: MasterLookup[];
alladditionalInfo!: MasterLookup[];
patientImage: any;
isValid = false;
value = false;

// patientDetail: PatientDetails = new PatientDetails();
selectedFile: File | undefined; // To store the selected file
selectedImageUrl: string | null = null;
isFileSelected: boolean = false;
  constructor(private _activateRoute:ActivatedRoute, private patientDetailsService: PatientDetailsService,
    private datePipe: DatePipe,
  private spinner: NgxSpinnerService,
  private currentUserService: CurrentUserService,
  private masterLookupService: MasterLookupService,
  private staffDetailsService: StaffDetailsService,
  private clinicLocationService: ClinicLocationService,
  private router:Router
  ){
    this.minDate = new Date(1900, 0, 1);
    this.maxDate = new Date();
    this.startDate = new Date();
  }
  ngOnInit(): void {
    console.log("welcome");
    this.dropdownValues();
    this._activateRoute.paramMap.subscribe(params => {
      this.data = params.get('id');
      console.log(this.data);
      
      // Now you can use the 'id' parameter in your component
    });

    this.patientDetailsService.getPatientDetailsByPatientId(this.data).subscribe(
      response=>{
        console.log(response);
        this.patientDetail=response;
      }
    )  
  }



  GoToList(){
    this.router.navigate(['/list']);
  }
  selectFile(event:any){
    this.selectedFile = event.target.files[0];
    if (this.selectedFile) {
      this.isFileSelected = true;
      const reader = new FileReader();
      reader.readAsDataURL(this.selectedFile);
      reader.onload = () => {
        this.selectedImageUrl = reader.result as string;
      };
    } else {
      this.selectedImageUrl = null;
    }
  
  }
  
  
   dropdownValues(){
    this.getLoggedInUserDetails();
    this.patientImage = "./assets/img/default-avatar.png";
    this.getAddressState();
    this.getCCMProvider();
    this.getPrimaryServiceLocation();
    this.getPatientLanguage();
    this.getPatientRace();
    this.getPatientEthnicity();
    this.getPatientStatus();
    this.getPatientTitle();
  
  }
  
  
  getPatientTitle() {
    this.spinner.show();
    this.masterLookupService.getTitles()
        .subscribe(
            data => {
                this.spinner.hide();
                this.allTitles = data;
            },
            errorCode => this.statusCode = errorCode);
  }
  
  
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
  
  
  getPatientStatus() {
  this.spinner.show();
  this.masterLookupService.getPatientStatus()
      .subscribe(
          data => {
              this.spinner.hide();
              this.alladditionalInfo = data;
          },
          errorCode => this.statusCode = errorCode);
  }
  
  
  getAddressState() {
  this.spinner.show();
  this.masterLookupService.getAddressState()
      .subscribe(
          data => {
            console.log(data);
            
              this.spinner.hide();
              this.allStates = data;
          },
          errorCode => this.statusCode = errorCode);
  }
  
  getPatientRace() {
  this.spinner.show();
  this.masterLookupService.getRace()
      .subscribe(
          data => {
              this.spinner.hide();
              this.allRace = data;
          },
          errorCode => this.statusCode = errorCode);
  }
  
  
  getCCMProvider() {
  this.spinner.show();
  this.staffDetailsService.getCCMProvider()
      .subscribe(
          data => {
            console.log(data);
            
              this.spinner.hide();
              this.allProvider = data;
          },
          errorCode => this.statusCode = errorCode);
  }
  
  getPrimaryServiceLocation() {
  this.spinner.show();
  this.clinicLocationService.getAllClinicLocations()
      .subscribe(data => {
          this.spinner.hide();
          this.allCliniclocations = data;
      })
  }
  
  getPatientLanguage() {
  this.spinner.show();
  this.masterLookupService.getLanguage()
      .subscribe(
          data => {
              this.spinner.hide();
              this.allLanguages = data;
          },
          errorCode => this.statusCode = errorCode);
  }
  
  getPatientEthnicity() {
  this.spinner.show();
  this.masterLookupService.getEthnicity()
      .subscribe(
          data => {
              this.spinner.hide();
              this.allEthnicity = data;
          },
          errorCode => this.statusCode = errorCode);
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
  
  updateEmployeeByEmployeeId(patient:PatientDetails){
    this.patientDetailsService.updatePatientDetails(patient)
    .subscribe(data => {
      console.log(data);
      alert("data Saved....")
      this.router.navigate(['/list'])
      
        
    });
  
  }
}
