import { Component } from '@angular/core';
import { SystemService } from '../services/systemService';
import { System } from '../models/system';
import { QuestionRecord } from '../models/questionRecord';
import { QuestionGroup } from '../models/questionGroup';
import { QuestionsService } from '../services/questionsService';
import { QuestionGroupService } from '../services/questionGroupService';
import { CommonModule } from '@angular/common';
import { FormArray, FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { PatientListComponent } from '../patientlist/patientlist.component';
import { StateServicesService } from '../services/state-services.service';
import { EncounterQuestionGroup } from '../models/encounterQuestionGroup';
import { EncounterQuestionOption } from '../models/encounterQuestionOption';
import { EncounterQuestionOptionService } from '../services/encounterQuestionOptionService';
import { EncounterQuestionGroupService } from '../services/encounterQuestionGroupService';
import { PatientMedicationRecord } from '../models/patientMedicationRecord';
import { MedicationService } from '../services/medicationService';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { AddMedicationsComponent } from '../add-medications/add-medications.component';
import { EncounterService } from '../services/encounterService';
import { Medication } from '../models/medication';
import { Router } from '@angular/router';
import { PatientMedication } from '../models/PatientMedication';
import { ViewPrescriptionComponent } from '../view-prescription/view-prescription.component';
import { data } from 'jquery';
import { DeleteMedicationComponent } from '../delete-medication/delete-medication.component';
import { PatientRecord } from '../models/PatientRecord';
import { PatientDetailsService } from '../services/patientDetailsService';




@Component({
  selector: 'app-medication',
  templateUrl: './medication.component.html',
  styleUrls: ['./medication.component.css'],
  standalone: true,
  imports: [MatSidenavModule, MatButtonModule,FormsModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule],
})
export class MedicationComponent {
  MedicationSystems: System[] = [];
  systemDesc: any;
  systemId: any;
  commonQuestions: QuestionRecord[] = [];
  questionGroups!: QuestionGroup[];
  questionGroupList!: QuestionGroup[];
  questionGroupName:any;
  questionGroupId: any;
  flag!: boolean;
  QuestionSelectedArray: any;
  MedicationForm!: FormGroup;
  QuestionSelectedArray1: any;
  commonQuestionsList: QuestionRecord[] = [];
  textVal: any[] = [];
  selectedRadioValue:any[]=[];
  number:any;
patientId:any
  sysName = "MEDICATION";

  isMedList: boolean = true;
  isMedData: boolean = false;

  activePatientMedications!: PatientMedicationRecord[];
  inActivePatientMedications!: PatientMedicationRecord[];
  patientMedications!: PatientMedicationRecord[];
  icd10Code!: string;
  search!: string;
  finalData!: Medication[];
  searchCount: any;

  updatePatientId:any;
  selectedIndicationValue: any[] = [];
  selectedEndDate: any[] = [];
  selectedRefillValue: any[] = [];
  medicationFormArray: any;


  //
  updatedEncounterId:any;
  updatedPatientId:any;
  patientRecords!:PatientRecord;


  
  constructor(private systemService:SystemService,private questionsService:QuestionsService,private questionGroupService:QuestionGroupService,
    private formBuilder:FormBuilder,private stateService:StateServicesService,private encounterQuestionOptionService:EncounterQuestionOptionService,
    private encounterQuestionGroupService:EncounterQuestionGroupService,private medicationService:MedicationService,
    private encounterService:EncounterService,
    private dialog: MatDialog,private router:Router,private patientDetailsService:PatientDetailsService
  ){}


  ngOnInit(){

console.log("welcome");


this.updatedEncounterId = sessionStorage.getItem('encounterId');
console.log(this.updatedEncounterId);

this.updatedPatientId = sessionStorage.getItem('patientId');
console.log(this.updatedPatientId);

this.patientDetailsService.getPatientRecordsByPatientId(this.updatedPatientId)
.subscribe(data => {
  console.log(this.updatePatientId);
  
  console.log(data);
  
  this.patientRecords = data;

  //console.log(this.patientRecords);

  
});


    
    

    //Retreive Patient Id Using Angular Subject Behaviour

    this.stateService.id$.subscribe(value => {
      this.patientId = value;
      console.log(this.patientId);
      
    });
  
  

    // this.patientId=this.updatePatientId;
    // console.log(this.patientId);
    


    //Get All Systems
    this.systemService.getAllSystems().subscribe(data => {
      for(let i=0;i<data.length;i++){
        if(data[i].systemType == "MEDICATION"){
         // console.log(data[i]);
          this.MedicationSystems.push(data[i]);    
        }       
      }
    //  console.log(this.MedicationSystems);
      
   });


   //Get Encounter 
   this.stateService.currentNumber.subscribe(number => {
    this.number = number;
   console.log(this.number);
    
  });

   
  //Medication Form
   this.MedicationForm = this.formBuilder.group({
    MedIDS: this.formBuilder.array([]),
  });
  this.medicationFormArray = <FormArray>this.MedicationForm.controls['MedIDS'];
  this.MedicationForm = this.formBuilder.group({
    QuestionSelectedIDS: this.formBuilder.array([]),
  });
 

   this.QuestionSelectedArray1 = <FormArray>this.MedicationForm.controls['QuestionSelectedIDS'];




   //Get All Question...
   this.questionGroupService.getAllQuestionGroups()
   .subscribe(data => {
     // console.log(data);
    this.questionGroups=data;
   // console.log(this.questionGroups);
    
      
   });




   //Fetching 

   this.medicationService.getPatientMedications(this.updatedPatientId)
       .subscribe(
         (       repsonse: any)=>{
        console.log(repsonse);
        this.patientMedications=repsonse;
        if(this.icd10Code == 'all' || this.icd10Code == null){
                    this.activePatientMedications = this.patientMedications.filter(t => t.isActiveMedication == 'Y');
                    this.inActivePatientMedications = this.patientMedications.filter(t => t.isActiveMedication == 'N');
          
                  }
                  // else{
                  //   this.activePatientMedications = this.patientMedications.filter(t => t.isActiveMedication == 'Y' && t.icd10Code == this.icd10Code);
                  //   this.inActivePatientMedications = this.patientMedications.filter(t => t.isActiveMedication == 'N' && t.icd10Code == this.icd10Code);
          
                  // }
       
        
       });


       this.encounterService.searchAllergy(this.search)
        .subscribe(results => {
        
          this.finalData = results;
          console.log(this.finalData);
          
          for (let i = 0; i < this.finalData.length; i++) {
            this.finalData[i].dose = this.finalData[i].dose.replace(new RegExp(';', 'g'), ';&emsp;')
          }
        
          this.searchCount = this.finalData.length;
          this.searchCount == 0 ? this.flag = true : this.flag = false;
        });
    

   
  
  }


  openPrescription(aactiveMedication: any): void {
    const dialogRef = this.dialog.open(ViewPrescriptionComponent, {
        data:aactiveMedication
      
      });
      dialogRef.afterClosed().subscribe(result => {
        console.log(`Dialog result: ${result}`);
      });
  }

  openInActiveMedication(aactiveMedication: any): void {
    const dialogRef = this.dialog.open(DeleteMedicationComponent, {
        data:aactiveMedication
      
      });
      dialogRef.afterClosed().subscribe(result => {
        console.log(`Dialog result: ${result}`);
      });
  }




  showDiv(group: any, event:Event) {
    {
        this.commonQuestionsList = this.commonQuestions.filter(t => t.questionGroupId == group.questionGroupId);
        this.systemId = group.systemId;
        this.questionGroupId=group.questionGroupId;
        this.questionGroupName = group.questionGroupName;
       // console.log(this.commonQuestionsList);
        
    }
}


  openTab(system:any) {
    
    this.systemDesc = system.systemDesc;
    this.systemId = system.systemId;
    
      this.questionsService.getAllQuestionsOfGroup(system.systemId)
        .subscribe(data => {
         // console.log(data);

          if(system.systemDesc=='MEDICATION'){
            console.log("welcome...");
            
          }
          
          this.commonQuestions = data;
          console.log(this.commonQuestions);
          localStorage.setItem('questionrecord_' + system.systemId, JSON.stringify(data));
          this.questionGroupList = this.questionGroups.filter(t => t.systemId == system.systemId);
         console.log(this.questionGroupList);
          
        })
    
  }

  openQuestionGroup(sysId:any, systemDesc:any) {
    // console.log(systemDesc);
     this.questionGroupId = null;
     
  
     this.systemId = sysId;
     this.systemDesc = systemDesc;
     this.questionsService.getAllQuestionsOfGroup(this.systemId)
       .subscribe(data => {
       // console.log(data);
        
         this.commonQuestions = data;
         this.questionGroupList = this.questionGroups.filter(t => t.systemId == this.systemId);
       
         if (systemDesc == 'MEDICATION') {
           this.isMedData = true;
           let group = this.questionGroupList.find(t => t.questionGroupName == 'Medication');
          //  this.questionGroupId = group.questionGroupId;
           this.isMedList = true;
          //  this.setInsertedValues();
         }
         else {
           this.isMedList = false;
         }
       })
   }


  onRowEdit(commonQues:any, option:any) {
    //console.log("row editt");
    //console.log(option);
    if (commonQues.optionType == 'radio') {
      commonQues.optionName = option.optionNames;
      commonQues.optionId = option.optionId;
    }
    //formArray for selected question
  let index = this.QuestionSelectedArray1.controls.findIndex((x: { value: { questionId: any; }; }) => x.value.questionId == commonQues.questionId)
  
  if (index == -1) {
      this.QuestionSelectedArray1.push(new FormControl(commonQues));
    }
    else {
      this.QuestionSelectedArray1.removeAt(index);
      if (commonQues.answer != "") {
        this.QuestionSelectedArray1.push(new FormControl(commonQues));
      }
    }
    for (let i = 0; i < this.QuestionSelectedArray1.length; i++) {
      //console.log(this.QuestionSelectedArray1.at(i).value)
    }
  }
  goToSelectedTab(questionGroup: any, i:any) {
    setTimeout(() => {
    
    if (!this.flag) {
        this.systemId = questionGroup.systemId;
        this.questionGroupName = questionGroup.questionGroupName;
        this.questionGroupId = questionGroup.questionGroupId;
    }
  });
  }

  isCheckedRadio(optionId: number): boolean {
    let index = this.QuestionSelectedArray1.controls.findIndex((x: { value: { optionId: number; }; }) => x.value.optionId == optionId)
    return (index == -1 ? false : true);
  
  }

  isChecked(group: any): boolean {
   
    if (group.questionGroupName == 'Medication' || this.QuestionSelectedArray1.length > 0) {
      if (group.questionGroupName == 'Medication')
        return true;
       for (var i = 0; i < this.QuestionSelectedArray1.length; i++) {
        if (this.QuestionSelectedArray1.at(i).value.questionGroupId == group.questionGroupId) {
          return true;
        }
      }
    }
    return false;
  }

  openDialog(id: number): void {
    this.dialog.open(AddMedicationsComponent, {
      data: { id: id}
    });
   
  }


  onSubmit() {
    
    
    //this.router.navigate(['/patients/planandassessment/' + this.encounterId]);
    (<HTMLInputElement>document.getElementById("saveNext")).disabled = true;

    this.encounterQuestionOptionService.deleteEncQustionOptions(this.number,this.sysName).subscribe(
      response=>{
        console.log(response);
        this.encounterQuestionGroupService.deleteEncQustionGroups(this.number,this.sysName).subscribe(
          data=>{
           this.insertData()
            console.log(data);
            this.stateService.changeNumber(this.number)
            this.router.navigate(['/history'])
            
          }
        )
        
      }
    )
  
  }

  getPatientMedications() {
 
  //   this.medicationService.getPatientMedications(patientId)
  //     .subscribe(
  //       data => {
  //         this.patientMedications = data;
  //         // this.patientMedications.length == 0 ? this.showListFlag = true : this.showListFlag = false;

  //         if(this.icd10Code == 'all' || this.icd10Code == null){
  //           this.activePatientMedications = this.patientMedications.filter(t => t.isActiveMedication == 'Y');
  //           this.inActivePatientMedications = this.patientMedications.filter(t => t.isActiveMedication == 'N');
  
  //         }else{
  //           this.activePatientMedications = this.patientMedications.filter(t => t.isActiveMedication == 'Y' && t.icd10Code == this.icd10Code);
  //           this.inActivePatientMedications = this.patientMedications.filter(t => t.isActiveMedication == 'N' && t.icd10Code == this.icd10Code);
  
  //         }
         
  //         this.activePatientMedications.length == 0 ? this.showActiveList = true : this.showActiveList = false;
  //         this.inActivePatientMedications.length == 0 ? this.showInActiveList = true : this.showInActiveList = false;
  //       },
     
  // }
  }

  insertData() {
    let encounterQuestionGroupList: EncounterQuestionGroup[] = [];
    let encounterQuestionOptionList: EncounterQuestionOption[] = [];

    //seperation questionGroup id and system id from QuestionSelectedArray
    let uniqueQuestionId = Array.from(new Set(this.QuestionSelectedArray1.controls.map((item: any) => item.value.questionGroupId)))
    //console.log(uniqueQuestionId);
    if (uniqueQuestionId.length > 0) {
      for (let i = 0; i < uniqueQuestionId.length; i++) {
        let obj = this.QuestionSelectedArray1.controls.find((t: { value: { questionGroupId: unknown; }; }) => t.value.questionGroupId == uniqueQuestionId[i]);
        let encounterQuestionGroup = new EncounterQuestionGroup(0, this.updatedEncounterId, obj.value.questionGroupId, obj.value.systemId, 'Yes', new Date, "", new Date, "");
        encounterQuestionGroupList.push(encounterQuestionGroup);
      }
      this.encounterQuestionGroupService.insertQuestionGroups(encounterQuestionGroupList)
        .subscribe(successCode => {
         
          });
    }

    //inserting questions into DB 
    if (this.QuestionSelectedArray1.length > 0) {
      for (let i = 0; i < this.QuestionSelectedArray1.length; i++) {
        let encounterQuestionOption = new EncounterQuestionOption(0, this.updatedEncounterId, this.QuestionSelectedArray1.at(i).value.questionId,
          this.QuestionSelectedArray1.at(i).value.questionGroupId, this.QuestionSelectedArray1.at(i).value.systemId, this.QuestionSelectedArray1.at(i).value.optionId, this.QuestionSelectedArray1.at(i).value.optionName, this.QuestionSelectedArray1.at(i).value.answer, new Date, "", new Date, "", "");
        encounterQuestionOptionList.push(encounterQuestionOption);
      }
     // console.log(encounterQuestionOptionList)
      this.encounterQuestionOptionService.insertQuestionOptions(encounterQuestionOptionList)
        .subscribe(successCode => {
          console.log(successCode);
          
         
        
          });
    }
  
  }


  
  HpiComp(){
    this.router.navigate(['hpi'])
}

Roscomp(){
  this.router.navigate(['ros'])

}

Medicationcomp(){
  this.router.navigate(['medication'])

}

Historycomp(){
  this.router.navigate(['history'])

}

plancomp(){
  this.router.navigate(['plan'])

}

Examcomp(){
  this.router.navigate(['exam'])

}




}
