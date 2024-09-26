import { Component, signal } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { QuestionGroupService } from '../services/questionGroupService';
import { QuestionGroup } from '../models/questionGroup';
import { MatSidenavModule } from '@angular/material/sidenav';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { PatientListComponent } from '../patientlist/patientlist.component';
import { SystemService } from '../services/systemService';
import { System } from '../models/system';
import { QuestionsService } from '../services/questionsService';
import { QuestionRecord } from '../models/questionRecord';
import { EncounterHistory } from '../models/encounterHistory';
import { EncounterQuestionOptionService } from '../services/encounterQuestionOptionService';
import { EncounterQuestionGroupService } from '../services/encounterQuestionGroupService';
import { Router } from '@angular/router';
import { StateServicesService } from '../services/state-services.service';
import { EncounterQuestionOption } from '../models/encounterQuestionOption';
import { EncounterQuestionGroup } from '../models/encounterQuestionGroup';
import { PatientDetailsService } from '../services/patientDetailsService';
import { PatientRecord } from '../models/PatientRecord';
import { StaffMember } from 'src/app/administration/staff-members/staffmember';
import { CurrentUserService } from 'src/app/profiles/currentUserService';

@Component({
  selector: 'app-ros',
  templateUrl: './ros.component.html',
  styleUrls: ['./ros.component.css'],
  standalone: true,
  imports: [MatSidenavModule, MatButtonModule,FormsModule ,PatientListComponent,CommonModule,TimerModule,MatExpansionModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,],
})
export class RosComponent {

  ROSForm!: FormGroup;
  questionGroups!: QuestionGroup[];
  ROSSystems: System[] = [];
  systemDesc: any;
  systemId: any;
  commonQuestions: QuestionRecord[] = [];
  questionGroupList!: QuestionGroup[];
  questionGroupName:any;
  questionGroupId: any;
  QuestionSelectedArray: any;
  commonQuestionsList: QuestionRecord[] = [];
  flag!: boolean;

  calenderVal: any[] = [];
  textDropdownVal: any[] = [];
  selectedValue: any[] = [];
  multiSelectedValue: any[] = [];
  selectedTValue: any[] = [];
  textVal: any[] = [];
  list!:EncounterHistory[];
  selectedRadioValue:any[]=[];
  number:any;
  sysName="ROS";

  readonly panelOpenState = signal(false);
  locName: any;
  staffImage: any;

  loggedInUser!: StaffMember;

  patientRecords!:PatientRecord;
  updatedEncounterId:any
  updatedPatientId:any
  constructor(private questionGroupService:QuestionGroupService,private formBuilder: FormBuilder,private systemService:SystemService,
    private questionsService:QuestionsService,private encounterQuestionOptionService:EncounterQuestionOptionService,
    private encounterQuestionGroupService:EncounterQuestionGroupService, private route:Router,private stateService:StateServicesService,
    private patientDetailsService:PatientDetailsService, private currentUserService: CurrentUserService
  ){}

  ngOnInit(){

    
    this.updatedEncounterId = sessionStorage.getItem('encounterId');
    console.log(this.updatedEncounterId);

    this.updatedPatientId = sessionStorage.getItem('patientId');
    console.log(this.updatedPatientId);


    
    this.patientDetailsService.getPatientRecordsByPatientId(this.updatedPatientId)
    .subscribe(data => {
      console.log(data);
      
      this.patientRecords = data;
   
      //console.log(this.patientRecords);
    
      
    });


    this.ROSForm = this.formBuilder.group({
      QuestionSelectedIDS: this.formBuilder.array([]),
  });

    //GetAll Questions...
    this.questionGroupService.getAllQuestionGroups()
   .subscribe(data => {
    //  console.log(data);
    this.questionGroups=data;
    console.log(this.questionGroups);
    
      
   })

   this.stateService.currentNumber.subscribe(number => {
    this.number = number;
    console.log(this.number);
    
  });



   this.systemService.getAllSystems().subscribe(data => {
    for(let i=0;i<data.length;i++){
      if(data[i].systemType == "ROS"){
       // console.log(data[i]);
        this.ROSSystems.push(data[i]);    
      }       
    }
    console.log(this.ROSSystems);
    
 });


 this.QuestionSelectedArray = <FormArray>this.ROSForm.controls['QuestionSelectedIDS'];

 this.getLoggedInUserDetails();

  }

  isCheckedRadio(optionId: number): boolean {
    let index = this.QuestionSelectedArray.controls.findIndex((x: { value: { optionId: number; }; }) => x.value.optionId == optionId)
    return (index == -1 ? false : true);
  
  }

  goToSelectedTab(questionGroup: any, i:any) {
    setTimeout(() => {
    
    if (!this.flag) {
      this.commonQuestionsList = this.commonQuestions.filter(t => t.questionGroupId == questionGroup.questionGroupId);
        this.systemId = questionGroup.systemId;
        this.questionGroupName = questionGroup.questionGroupName;
        this.questionGroupId = questionGroup.questionGroupId;
    }
  });
  }






  openTab(system:any) {
 
    this.systemDesc = system.systemDesc;
    this.systemId = system.systemId;
  
    this.questionsService.getAllQuestionsOfGroup(system.systemId)
        .subscribe(data => {


          console.log(data);
          
            this.commonQuestions = data;
            localStorage.setItem('questionrecord_' + system.systemId, JSON.stringify(data));
            this.questionGroupList = this.questionGroups.filter(t => t.systemId == system.systemId);
            console.log(this.questionGroupList);
            
         
        })}

        isChecked(questionGroupId: number): boolean {
          let index = this.QuestionSelectedArray.controls.findIndex((x: { value: { questionGroupId: number; }; }) => x.value.questionGroupId == questionGroupId)
          return (index == -1 ? false : true);
      }

      showDiv(group: any, event:Event) {
        {
            this.commonQuestionsList = this.commonQuestions.filter(t => t.questionGroupId == group.questionGroupId);
            this.systemId = group.systemId;
            this.questionGroupId=group.questionGroupId;
            this.questionGroupName = group.questionGroupName;
        }
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


    onSubmit() {
      this.encounterQuestionOptionService.deleteEncQustionOptions(this.number,this.sysName).subscribe(
        response=>{
          console.log(response);
          this.encounterQuestionGroupService.deleteEncQustionGroups(this.number,this.sysName).subscribe(
            data=>{
            
              console.log(data);
              this.insertData();

              this.route.navigate(['medication'])
              
            }
          )
          
        }
      )
   
  }

  insertData(){
    // console.log("insert dataaaa called");
     let encounterQuestionGroupList: EncounterQuestionGroup[] = [];
     let encounterQuestionOptionList: EncounterQuestionOption[] = [];
     //seperation questionGroup id and system id from QuestionSelectedArray
     let uniqueQuestionId = Array.from(new Set(this.QuestionSelectedArray.controls.map((item: any) => item.value.questionGroupId)))
     if (uniqueQuestionId.length > 0) {
         for (let i = 0; i < uniqueQuestionId.length; i++) {
          console.log(uniqueQuestionId);
          
             console.log("insert dataaaa called for loop");
             let obj = this.QuestionSelectedArray.controls.find((t: { value: { questionGroupId: unknown; }; }) => t.value.questionGroupId == uniqueQuestionId[i]);
             
             console.log(this.number);
             
             
             let encounterQuestionGroup = new EncounterQuestionGroup(0, this.updatedEncounterId, obj.value.questionGroupId, obj.value.systemId, 'Yes', new Date, "", new Date, "");
             encounterQuestionGroupList.push(encounterQuestionGroup);
         }
         this.encounterQuestionGroupService.insertQuestionGroups(encounterQuestionGroupList)
             .subscribe(response => {
              console.log(response);
              
                // console.log("insert dataaaa called insert question service");
               
                 
             })
     }
     //inserting questions into DB 
     if (this.QuestionSelectedArray.length > 0) {
      console.log(this.QuestionSelectedArray);
      
         for (let i = 0; i < this.QuestionSelectedArray.length; i++) {
          console.log(this.QuestionSelectedArray.at(i).value.optionName);
          
             let encounterQuestionOption = new EncounterQuestionOption(0, this.updatedEncounterId, this.QuestionSelectedArray.at(i).value.questionId, this.QuestionSelectedArray.at(i).value.questionGroupId, this.QuestionSelectedArray.at(i).value.systemId, this.QuestionSelectedArray.at(i).value.optionId, this.QuestionSelectedArray.at(i).value.optionName, this.QuestionSelectedArray.at(i).value.answer, new Date, "", new Date, "","");
             encounterQuestionOptionList.push(encounterQuestionOption);
             console.log(encounterQuestionOptionList);
             
         }
        
         
         this.encounterQuestionOptionService.insertQuestionOptions(encounterQuestionOptionList)
             .subscribe(successCode => {
              console.log(successCode);
              
              
               
               
             });
                
            }
        }


        HpiComp(){
          this.route.navigate(['hpi'])
      }
      
      Roscomp(){
        this.route.navigate(['ros'])
      
      }
      
      Medicationcomp(){
        this.route.navigate(['medication'])
      
      }
      
      Historycomp(){
        this.route.navigate(['history'])
      
      }
      
      plancomp(){
        this.route.navigate(['plan'])
      
      }
      
      Examcomp(){
        this.route.navigate(['exam'])
      
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

        back(){
          this.route.navigate(['hpi'])
        }
      
  

}
