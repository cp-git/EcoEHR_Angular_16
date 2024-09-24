import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output, signal } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { PatientListComponent } from '../../patientlist/patientlist.component';
import { PatientHeaderComponent } from '../../patient-header/patient-header.component';
import { NgxSpinnerService } from 'ngx-spinner';

import { PatientAllergy } from '../../models/patientAllergy';
import { PatientRecord } from '../../models/PatientRecord';
import { EncounterService } from '../../services/encounterService';
import { PatientAllergyService } from '../../services/patientAllergyService';

import { Encounter } from '../../models/encounter';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { PatientDetailsService } from '../../services/patientDetailsService';
import { Observable } from 'rxjs';
import { combineLatest } from 'rxjs';
import { ChiefCompliantDtl } from '../../models/chiefCompliantDtl';
import { ICD10 } from '../../models/ICD10';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { SearchPipe } from '../../search.pipe';
import { HttpClient } from '@angular/common/http';
import { ICD10Group } from '../../models/ICD10Group';
import { ListEncounterComponent } from '../list-encounter/list-encounter.component';
import { StateServicesService } from '../../services/state-services.service';
import { data } from 'jquery';
import { CurrentUserService } from 'src/app/profiles/currentUserService';
import { StaffMember } from 'src/app/administration/staff-members/staffmember';

@Component({
  selector: 'app-add-encounter',
  templateUrl: './add-encounter.component.html',
  styleUrls: ['./add-encounter.component.css'],
  standalone: true,
  imports: [MatSidenavModule,FormsModule,ListEncounterComponent,ReactiveFormsModule,SearchPipe, MatButtonModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatDialogModule] 
})
export class AddEncounterComponent {
  @Output() 
  idChange = new EventEmitter();
  @Input() patientId!:any;
  @Input() encounterId!:number;
  patientRecords!:PatientRecord;
  patientAllergies!:PatientAllergy[]
   today: number = Date.now();
   value=false;
   statusCode:any;
   encounterdata!:Encounter;
   show!:boolean;

   @Output() onEncounter = new EventEmitter<any>();




   allEncounterList: Encounter[]=[];
   allEncounters!: Encounter[];
   acuityData!: any[];
   acuityNumber: any;
   insertedCodes!:ChiefCompliantDtl[];
   IcdCodesArray: any;
   AddIcdForm!: FormGroup;
   AddEncounterForm!: FormGroup;
  httpService: any;

  readonly panelOpenState = signal(false);
  ICD10Group!: ICD10Group[];

  ICD10: ICD10Group[]=[];
  //receivedData: any[] = [];

  receivedData: ICD10[] = [];

  staffImage: any;

  loggedInUser!: StaffMember;
   

  constructor(
    private patientDetailsService: PatientDetailsService,
    private patientAllergyService: PatientAllergyService,
    private encounterService: EncounterService, private spinner:NgxSpinnerService,
    private _activateRoute:ActivatedRoute,
    public dialog: MatDialog,
    private formBuilder:FormBuilder,
    httpService: HttpClient,
    private stateService: StateServicesService,
    private route:Router,
    private currentUserService: CurrentUserService
  
  ) { }


  ngOnInit() {

    this._activateRoute.paramMap.subscribe(params => {
      this.patientId = params.get('id');
      console.log(this.patientId);
      
      // Now you can use the 'id' parameter in your component
    });

     
    

    this.getEncounterByPatientId();
    this.value=false;
    //this.spinner.show();
   // console.log("Patient headerrrrr");
    console.log(this.patientId);
    //console.log(this.encounterId);
    
    this.getPatientRecordsByPatientId(this.patientId);

   

    this.AddEncounterForm = this.formBuilder.group({
      chiefCompliant: [null, [Validators.required]],
      patientUniqueCharacter: [null, [Validators.required]]
    });

    this.getAcutityDate();
    this.getAllICD10Groups();



    this.stateService.data$.subscribe(data => {
      this.receivedData = data;  // Update receivedData when new data is emitted
      console.log('Data received from child:', this.receivedData);
    });
   
   
  }

  getPatientRecordByPatientId(patientId: number){ 
    this.patientDetailsService.getPatientRecordsByPatientId(patientId)
    .subscribe(data => {
      this.patientRecords = data;
    })
    
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



  handleData(data: ICD10[]): void {
    this.receivedData = data;
    console.log('Data received from child:', this.receivedData);
  }
  

  // selectedRadioValue(acuityName:any, acuityNumber:any) {
  //   this.acuityNumber=null;
  //   this.acuityName = acuityName;
  //   this.acuityNumber = acuityNumber;
  //   this.acuityFlag=false;
  // }
  onSubmit(val:any) {
    // console.log("on submit encounter called");
    let icdCodesList: ChiefCompliantDtl[] = [];
    let cardioTempId, detailtedNeuroTempId, eyeTempId, physicalTempId, simpleNeuroTempId: number = 0;
    let isEdited = "no";

   
    
    

      
    // (<HTMLInputElement>document.getElementById(val)).disabled = true;
    let chiefCompliant = this.AddEncounterForm.get('chiefCompliant')?.value.trim();
    console.log(chiefCompliant);
    
    let patientUniqueCharacter = this.AddEncounterForm.get('patientUniqueCharacter')?.value.trim();

    let encToInsert = new Encounter(this.encounterId, this.patientId, this.patientRecords.primaryProvider, this.patientRecords.primaryLocation, 0,
      new Date(), chiefCompliant, this.acuityNumber, true, 1, 3, 2, 4, 5, new Date(), "", new Date(), "", patientUniqueCharacter,isEdited,new Date);
    //insert encounter  
    this.encounterService.insertEncounter(encToInsert).subscribe(
      data=>{  
        this.encounterId = data.encounterId;
        console.log(this.encounterId);
        this.stateService.changeNumber(this.encounterId)
        sessionStorage.setItem('encounterId',data.encounterId.toString());


       
        this.patientId=data.patientId;
        console.log(this.patientId);

        sessionStorage.setItem('patientId',this.patientId.toString());

      
        
        this.stateService.setId(this.patientId);

       
        

        for (let i = 0; i < this.receivedData.length; i++) {
          
          
          let icdDetail = new ChiefCompliantDtl(0, this.encounterId, this.receivedData[i].ICD10Code, this.receivedData[i].Description, true, new Date, "",new Date, "");
          icdCodesList.push(icdDetail);
        }

        console.log(icdCodesList);

        console.log("*******"+this.encounterId);
        
        

        this.encounterService.insertChiefCompliantDtl(icdCodesList,this.encounterId).subscribe(
          response=>{
            console.log("In Response");
         
           
            
            console.log(response);
            
          });
        
      });
      this.route.navigate(['hpi']);

    
    

    
  }

  

  
  getEncounterByEncounterId(encounterId:any) {
    this.spinner.show();
    this.encounterService.getEncounterByEncounterId(encounterId)
        .subscribe(data => {
          this.encounterdata = data;
     //     console.log(this.encounterdata);
            this.patientId = data.patientId;
            this.idChange.emit(this.patientId);
            this.getAllAllergies(this.patientId);
            this.getPatientRecordsByPatientId(this.patientId);
            
        },
       
            errorCode => this.statusCode = errorCode);
            
}

  getPatientRecordsByPatientId(patientId:any) {
 
  this.spinner.show();
    this.patientDetailsService.getPatientRecordsByPatientId(patientId)
      .subscribe(data => {
        console.log(data);
        
        this.patientRecords = data;
        this.spinner.hide();
        //console.log(this.patientRecords);
      
        
      })
  }

  getAllAllergies(patientId:any) {
   // console.log("get all allergiesssssss");
   // console.log(patientId);
    //this.spinner.show();
    this.patientAllergyService.getPatientAllergies(patientId)
      .subscribe(data => {
      
        this.patientAllergies = data;
        //console.log(this.patientAllergies);
       // this.spinner.hide();
      })
  }

  openDialog(id: number,id1:number): void {
    this.dialog.open(PatientHeaderComponent, {
      data: { id: id,id1:id1 }
    });
  }


  //Add Encounter 
  getEncounterByPatientId() {
    //console.log("get encounter by patient id calledd");
    this.encounterService.getEncounterByPatientId(this.patientId)
      .subscribe(data => {
        console.log(data);
        
        this.allEncounterList = data;
  //      console.log("Encounters List"+this.allEncounterList);
        let completedEncounter= this.allEncounterList.find(t=>t.completionDate!==null)
        if (data.length < 5) {
       
          this.allEncounters = data;
          }
        else {
       
          this.allEncounters = data.slice(0, 5);
         
        }
      });

    }

    editEncounter(encounterId:any){
      this.encounterId=encounterId;
      console.log(this.encounterId);
      this.encounterService.getEncounterByEncounterId(encounterId).subscribe(
        data=>{
          console.log(data);
          
        }
      );
      this.encounterService.getAllChiefCompliantDetailsByEncounterId(encounterId).subscribe(
        response=>{
          console.log(response);
          
        }
      );
    
      // combineLatest([
      //   this.encounterService.getEncounterByEncounterId(encounterId),
      //   this.encounterService.getAllChiefCompliantDetailsByEncounterId(encounterId)]).
      //   subscribe(
      //     combined=>{ 
           
      //       if(this.acuityData.find(t => t.NEW == combined[0].emId)!==undefined){
      //         this.acuityNumber=combined[0].emId;   //setting Acuity No.
      //       }
       
      //       this.insertedCodes=[]=combined[1]
      //       this.IcdCodesArray= <FormArray> this.AddIcdForm.get('icdIDS');
      //       this.IcdCodesArray.controls=[]
      //       for (let i = 0; i < this.insertedCodes.length; i++) {
      //         let truthValue=false;
      //         truthValue= (this.insertedCodes[i].primaryFlag === true); 
      //         let icd=new ICD10(this.insertedCodes[i].icd10Code,this.insertedCodes[i].icd10CodeDescription,"","",truthValue,"");
      //         this.IcdCodesArray.push(new FormControl(icd));    
      //       }
      //      this.AddEncounterForm.get('chiefCompliant')?.setValue(combined[0].chiefCompliant);     //setting chiefCompliant.
      //      this.AddEncounterForm.get('patientUniqueCharacter')?.setValue(combined[0].patientUniqueCharacters); //setting patientUniqueCharacters.
      //     })
}


getAcutityDate(){
  this.encounterService.getData().subscribe(
    (data) => {
      this.acuityData = data;
      console.log(this.acuityData);
    },
    (error) => {
      console.error('Error fetching data', error);
    }
  );
   
}

getAllICD10Groups() {
  this.encounterService.getAllICD10Groups()
    .subscribe(data => {
      this.ICD10Group = data;
      console.log(this.ICD10Group);
      
      
    })

    
    
}

toICDCode(){
  console.log("welcome...");
  this.dialog.open(ListEncounterComponent);
  
}


deleteIcd(data:any){
  let index= this.IcdCodesArray.controls.findIndex((x: { value: { ICD10Code: any; }; }) => x.value.ICD10Code == data.ICD10Code) //Remove from IcdCodesArray 
  this.IcdCodesArray.removeAt(index);
  for (let i = 0; i < this.ICD10Group.length; i++) {
    if (this.ICD10Group[i].groupDescription == data.icdgroupName) {
      this.ICD10Group[i].count = this.ICD10Group[i].count - 1;
    }
  }
 }


 GoToPatientList(){
  this.route.navigate(['/list']);
}


AddPatient(){
  this.route.navigate(['/addpatient'])
}

Clinic(){
  this.route.navigate(['clinicLocation'])
}

Staff(){
  this.route.navigate(['stafflist'])
}


Student(){
  this.route.navigate(['studentlist'])
}

Master(){
  this.route.navigate(['masterlookup'])
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
  
  //   this.router.navigate(['/login']);
    location.reload(); 
    localStorage.removeItem('jwt');   
    
  }



}
