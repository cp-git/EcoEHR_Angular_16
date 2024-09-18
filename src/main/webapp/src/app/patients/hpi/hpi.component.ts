import { Component } from '@angular/core';
import { System } from '../models/system';
import { SystemService } from '../services/systemService';
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
import { QuestionGroupService } from '../services/questionGroupService';
import { QuestionGroup } from '../models/questionGroup';
import { QuestionRecord } from '../models/questionRecord';
import { QuestionsService } from '../services/questionsService';
import { EncounterHistory } from '../models/encounterHistory';
import { EncounterQuestionOptionService } from '../services/encounterQuestionOptionService';
import { StateServicesService } from '../services/state-services.service';
import { EncounterQuestionGroup } from '../models/encounterQuestionGroup';
import { EncounterQuestionGroupService } from '../services/encounterQuestionGroupService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hpi',
  templateUrl: './hpi.component.html',
  styleUrls: ['./hpi.component.css'],
  standalone: true,
  imports: [MatSidenavModule, MatButtonModule,FormsModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,],
})
export class HpiComponent {

  system!: System[];
  HPISystems: System[] = [];
  allSystemTypes: any[] = [];
  HPIForm!: FormGroup;
  questionGroupId: any;
  flag!: boolean;
  questionGroupList: QuestionGroup[] = [];
  systemId: any;
  systemDesc: any;
  sysCode!: string;
  commonQuestions: QuestionRecord[] = [];
  questionGroups!: QuestionGroup[];
  questionGroupName:any;
  QuestionSelectedArray: any;
  calenderVal: any[] = [];
  textDropdownVal: any[] = [];
  selectedValue: any[] = [];
  multiSelectedValue: any[] = [];
  selectedTValue: any[] = [];
  textVal: any[] = [];
  list!:EncounterHistory[];
  sysName="HPI";

  encounterId!:number;

  number:any;
  
  
   

  

  constructor(private systemService:SystemService,private formBuilder:FormBuilder,private questionGroupService:QuestionGroupService,
    private questionsService:QuestionsService,
    private encounterQuestionOptionService:EncounterQuestionOptionService,
    private stateService: StateServicesService,
     private encounterQuestionGroupService: EncounterQuestionGroupService,
     private route:Router
   ){}

  ngOnInit(){

   

    this.stateService.currentNumber.subscribe(number => {
      this.number = number;
      console.log(this.number);
      
    });
    

    this.HPIForm = this.formBuilder.group({
      QuestionSelectedIDS: this.formBuilder.array([])
  });
    //Get the All Systems
   this.systemService.getAllSystems().subscribe(data => {
      for(let i=0;i<data.length;i++){
        if(data[i].systemType == "HPI"){
         // console.log(data[i]);
          this.HPISystems.push(data[i]);    
        }       
      }
    //  console.log(this.HPISystems);
      
   });

   this.QuestionSelectedArray = <FormArray>this.HPIForm.controls['QuestionSelectedIDS'];


   //Get All Question Groups

   this.questionGroupService.getAllQuestionGroups()
   .subscribe(data => {
    //  console.log(data);
    this.questionGroups=data;
    console.log(this.questionGroups);
    
      
   })


   this.HPIForm = this.formBuilder.group({
    QuestionSelectedIDS: this.formBuilder.array([])
  });
  }


  
  openTab(sysId:any, systemDesc:any, sysCode:any) {

    if (!this.flag) {
        this.questionGroupId=null;
      
        this.questionGroupList = [];
        this.systemId = sysId;
        this.systemDesc = systemDesc;
        this.sysCode = sysCode;
      
            this.questionsService.getAllQuestionsOfGroup(sysId)
                .subscribe(data => {
                    this.commonQuestions = data;
                  
                    // localStorage.setItem('questionrecord_' + this.systemId, JSON.stringify(data));
                     this.questionGroupList = this.questionGroups.filter(t => t.systemId == this.systemId);
                    console.log(this.questionGroupList);
                    
                   
                })
        
       // console.log(this.commonQuestions);
      
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


onSave(val:any) {

  console.log();
  

  this.encounterQuestionOptionService.deleteEncQustionOptions(this.number,this.sysName).subscribe(
    response=>{
      console.log(response);
      this.encounterQuestionGroupService.deleteEncQustionGroups(this.number,this.sysName).subscribe(
        data=>{
          alert("Added..")
          console.log(data);
          this.route.navigate(['ros'])
          
        }
      )
      
    }
  )
 
  // if (!this.flag) {
  //     (<HTMLInputElement>document.getElementById(val)).disabled = true;
  //     let readyToinsert:boolean=false;
  //     if(this.list.length !==0){
  //     this.encounterQuestionOptionService.deleteEncQustionOptions(this.encounterId,this.sysName).switchMap(            //delete already inserted question groups
  //         successCode => {
  //           return this.encounterQuestionGroupService.deleteEncQustionGroups(this.encounterId,this.sysName)         //delete already inserted question options
  //         }).subscribe(successCode => {
  //           readyToinsert=true;
  //           if(readyToinsert)
  //           this.insertData(val);
  //         },
  //         errorCode => {
  //           this.statusCode = errorCode;});
  //         }
  //         else{
  //             this.insertData(val);
  //         }
  // }
}



isChecked(questionGroupId: number): boolean {
  let index = this.QuestionSelectedArray.controls.findIndex((x: { value: { questionGroupId: number; }; }) => x.value.questionGroupId == questionGroupId)
  return (index == -1 ? false : true);
}

isCheckedRadio(optionId: number): boolean {
  let index = this.QuestionSelectedArray.controls.findIndex((x: { value: { optionId: number; }; }) => x.value.optionId == optionId)
  return (index == -1 ? false : true);

}

onRowEdit(commonQues:any, option:any) {
      
  if (option != undefined) {
      commonQues.optionName = option.optionNames;
      commonQues.optionId = option.optionId;
  }
  if (commonQues.optionType == 'calender') {
      
      this.calenderVal[commonQues.questionId] = "";
  }
  if (commonQues.optionType == 'tdropdown' && option === undefined) {
      commonQues.optionName = option;
      commonQues.optionId = option;
      this.textDropdownVal[commonQues.questionId] = "";
  }
  if (commonQues.optionType == 'mdropdown') {
      commonQues.optionName = Array.prototype.map.call(option, function (item) { return item.optionId; }).join("-");
      commonQues.answer = Array.prototype.map.call(option, function (item) { return item.optionNames; }).join(",");
  }
  //formArray for selected question
  let index = this.QuestionSelectedArray.controls.findIndex((x: { value: { questionId: any; }; }) => x.value.questionId == commonQues.questionId)
  if (index == -1) {
      this.QuestionSelectedArray.push(new FormControl(commonQues));
    }
  else {
      this.QuestionSelectedArray.removeAt(index);
          if (option !== undefined && commonQues.answer != "") {
          this.QuestionSelectedArray.push(new FormControl(commonQues));
      }
  }
 
}






getAllQuestions(group: any,  event: Event) {
  
  
 

  
      if (!this.flag) {
          this.systemId = group.systemId;
          this.questionGroupName = group.questionGroupName;
          this.questionGroupId = group.questionGroupId;
          console.log(this.questionGroupId);
          
      }
  }


  




  
}
