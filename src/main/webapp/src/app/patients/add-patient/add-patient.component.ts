import { ChangeDetectionStrategy, Component, signal } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { PatientListComponent } from '../patientlist/patientlist.component';
import { CommonModule, DatePipe } from '@angular/common';
import { MatExpansionModule } from '@angular/material/expansion';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { Data, Router } from '@angular/router';
import { PatientDetailsService } from '../services/patientDetailsService';
import { CurrentUserService } from 'src/app/profiles/currentUserService';
import { LoginService } from 'src/app/home/login/login.service';
import { StaffMember } from 'src/app/administration/staff-members/staffmember';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { StaffDetails } from 'src/app/administration/staff-members/StaffDetails';
import { ClinicLocation } from 'src/app/administration/clinic-locations/ClinicLocation';
import { MasterLookup } from 'src/app/administration/master-lookup/masterLookup';
import { NgxSpinnerService } from 'ngx-spinner';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MasterLookupService } from '../services/masterLookupService';
import { StaffDetailsService } from '../services/staffDetailsService';
import { ClinicLocationService } from '../services/clinicLocationService';
import { PatientDetails } from '../models/PatientDetails';
import {MatDatepickerModule} from '@angular/material/datepicker';





@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css'],
  standalone: true,
  imports: [MatSidenavModule, MatButtonModule,FormsModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AddPatientComponent {

  //Sidebar Data
  readonly panelOpenState = signal(false);

  public minDate: Date;
  public maxDate: Date;
  public startDate: Date;
  

  loggedInUser!: StaffMember;
  staffImage: any;
  

// Add Patient Variables

dob = new FormControl('', Validators.required);
AddPatientForm!: FormGroup;
AddInsuranceForm!: FormGroup;
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
datePattern = /^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d$/;

patientDetail: PatientDetails = new PatientDetails();
selectedFile: File | undefined; // To store the selected file
selectedImageUrl: string | null = null;
isFileSelected: boolean = false;








  // constructor(private router: Router, private patientService: PatientDetailsService, private currentUserService: CurrentUserService,  private loginService : LoginService) {
  //   this.minDate = new Date(1900, 0, 1);
  //   this.maxDate = new Date();
  //   this.startDate = new Date();
  // }


  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private patientDetailsService: PatientDetailsService,

   // private sharedData: Data, 
   private datePipe: DatePipe,
    private spinner: NgxSpinnerService,
    private currentUserService: CurrentUserService,
    private masterLookupService: MasterLookupService,
    private staffDetailsService: StaffDetailsService,
    private clinicLocationService: ClinicLocationService,
) { 
  this.minDate = new Date(1900, 0, 1);
  this.maxDate = new Date();
  this.startDate = new Date();
}

  ngOnInit(){
   
   this.dropdownValues();

    

 
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


  
GoToPatientList(){
  this.router.navigate(['/list'])
}

  createEmployee(patient:PatientDetails){

    this.patientDetailsService.inserPatientDetails(patient)
    .subscribe(data => {
      alert("welcome");
      console.log(data);
      this.router.navigate(['/list']);
      
     
    })

  }


  GoToList(){
    this.router.navigate(['/list']);
  }


  AddPatient(){
    this.router.navigate(['addpatient'])
  }

  Clinic(){
    this.router.navigate(['clinicLocation'])
  }

  Staff(){
    this.router.navigate(['stafflist'])
  }


  Student(){
    this.router.navigate(['studentlist'])
  }

  Master(){
    this.router.navigate(['masterlookup'])
  }

  
  


  


  
  



}





