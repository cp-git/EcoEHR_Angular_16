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
import { ActivatedRoute } from '@angular/router';
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

@Component({
  selector: 'app-add-encounter',
  templateUrl: './add-encounter.component.html',
  styleUrls: ['./add-encounter.component.css'],
  standalone: true,
  imports: [MatSidenavModule,FormsModule,ReactiveFormsModule,SearchPipe, MatButtonModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatDialogModule] 
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

  receivedData: any[] = [];
   

  constructor(
    private patientDetailsService: PatientDetailsService,
    private patientAllergyService: PatientAllergyService,
    private encounterService: EncounterService, private spinner:NgxSpinnerService,
    private _activateRoute:ActivatedRoute,
    public dialog: MatDialog,
    private formBuilder:FormBuilder,
    httpService: HttpClient,
    private stateService: StateServicesService
  
  ) { }


  ngOnInit() {

    this._activateRoute.paramMap.subscribe(params => {
      this.patientId = params.get('id');
      console.log(this.patientId);
      
      // Now you can use the 'id' parameter in your component
    });

    this.receivedData = this.stateService.getState() || [];
    console.log(this.receivedData);
    

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


}
