import { Component } from '@angular/core';
import { ChiefCompliantDtl } from '../models/chiefCompliantDtl';
import { EncounterService } from '../services/encounterService';
import { StateServicesService } from '../services/state-services.service';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { EncAsessment } from '../models/EncAsessment';
import { EncAssessmentService } from '../services/encAssessmentService';
import { DateAdapter } from '@angular/material/core';
import { System } from '../models/system';
import { Encounter } from '../models/encounter';
import { PatientRecord } from '../models/PatientRecord';
import { Orders } from '../models/orders';
import { PatientMedicationRecord } from '../models/patientMedicationRecord';
import * as moment from 'moment';
import { OrdersService } from '../services/ordersService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-plan-assement',
  templateUrl: './plan-assement.component.html',
  styleUrls: ['./plan-assement.component.css'],
  standalone: true,
  imports: [FormsModule ,CommonModule,TimerModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule,MatIconModule],
})
export class PlanAssementComponent {

  showData:boolean=false;
  icd10Details!: ChiefCompliantDtl[];

  tabList!: any[];
  patientId:any;
  assessmentForm!:FormGroup;
  encounterassessmentdata:EncAsessment[]=[];
  number:any;




  tabListdata!: any[];
  icdCode!:string;
  description!:string;
  system!: System[];
  sysName="PLAN";
  PLANSystems: System[] = [];
  statusCode!: number;
  allSystemTypes: any[] = [];
  headerdisplay:boolean=false;
  pageName:any="plan";
  encounter = {} as Encounter;

  requestProcessing = false;
  showListModal!: boolean;
  acuityData!: any[];
  patientRecords!: PatientRecord;

  showplanTable:boolean=false;



  /////
  mySubscription: any;

  header: boolean = true;

  ordersForm!: FormGroup;
  
  selectedTab: any;
  des!: string;

  selectedValue: any[] = [];
  allOrders: Orders[] = [];
  viewMode = "Condition";
  showInActiveList: Boolean = true
  selectedIndicationValue: any[] = [];
  showActiveList: Boolean = true;
  activePatientMedications!: PatientMedicationRecord[];
  inActivePatientMedications!: PatientMedicationRecord[];
  patientMedications!: PatientMedicationRecord[];
  showComponent: boolean = true;
  tabChoosen!: string;
  mx = new Date().getFullYear() + 10;


  constructor(private encounterService:EncounterService,private stateService:StateServicesService,private formBuilder:FormBuilder,
    private encAssessmentService:EncAssessmentService,private orderService:OrdersService,private route:Router
  ){}

  ngOnInit(){
    this.stateService.id$.subscribe(value => {
      this.patientId = value;
      console.log(this.patientId);
      
    });

    this.stateService.currentNumber.subscribe(number => {
      this.number = number;
     console.log(this.number);
      
    });
    this.assessmentForm = this.formBuilder.group({
      icdCode: [null],
   
  })
  this.getIcd10DetailsOfLastFiveEncounters();
  this.getEncAssessmentbyEncounterId(this.number)

    this.tabList = ["Assessment"]; 

    this.ordersForm = this.formBuilder.group({
      conditionType :  [null],
      conditionComments  : [null],
      icd: [null],
      labComments: [null],
      labDate: [null],
      imagingComments: [null],
      imagingDate: [null],
      imagingIcd: [null],
      consultingComments: [null],
      consultingDate: [null],
      followupComments: [null],
      followupDate: [null]

  })
  this.tabListdata= ["Condition","Medication", "Lab", "Imaging", "Consulting", "Follow up"];

  }

  toggelChange(){
    this.showData=!this.showData

  }

  getIcd10DetailsOfLastFiveEncounters() {
    this.encounterService.getIcd10DetailsOfLastFiveEncounters(this.patientId)
        .subscribe(data => {
            this.icd10Details = data;
        })
}

getEncAssessmentbyEncounterId(encounterId:any)
{
   // console.log("getEncAssessmentbyEncounterId calllledddd");
    
  this.encAssessmentService.getAssessmentByEncId(encounterId)
  .subscribe(data => {
    this.encounterassessmentdata = data; 
    if(this.encounterassessmentdata.length > 0){
        this.patientId = this.encounterassessmentdata[0].patientId;
    }
   // console.log("enc assessment data"+data);
  });
}


onSubmit(){
  if (this.assessmentForm.valid) {
      (<HTMLInputElement>document.getElementById("save")).disabled = true;
      let asessmentList: EncAsessment[] = [];
      let icd = this.assessmentForm.get('icdCode')?.value;
      for (let i = 0; i < icd.length; i++) {
        console.log(icd[i]);
        
       let asessment = new EncAsessment(0, this.number,this.patientId,icd[i].icd10Code, icd[i].icd10CodeDescription, "", new Date(), "", new Date(),true);
       asessmentList.push(asessment);
      }
       this.encAssessmentService.insertassessmentData(asessmentList)
       .subscribe(successCode => {
       
         this.getEncAssessmentbyEncounterId(this.number);
         this.assessmentForm.reset();
         (<HTMLInputElement>document.getElementById("save")).disabled = false;
       });
    
  } 
}


openPlan(icd10Code:string, des:string,number:any){
  this.icdCode = icd10Code;
  this.description = des;
//   console.log(this.icdCode);
  this.showplanTable=!this.showplanTable;
  this.route.navigate(['order',this.number])
}

changeIcdCode(icd: string) {
  // console.log(this.icdCode);
   this.showComponent = false;
  //  setTimeout(x => this.showComponent = true);
  //  this.getAllOrdersByPatientId(this.patientId, icd);
   this.icdCode = icd;
}



onSave() {
  if (this.ordersForm.valid) {
      (<HTMLInputElement>document.getElementById("save")).disabled = true;
      let icd = this.icdCode;
      if (this.viewMode == 'Lab') {
          icd = this.ordersForm.get('icd')?.value;
          // this.icdCode = this.ordersForm.get('icd').value;
      }
      if (this.viewMode == 'Imaging') {
          icd = this.ordersForm.get('imagingIcd')?.value;
          // this.icdCode = this.ordersForm.get('imagingIcd').value;
      }
      if (this.viewMode == 'Condition') {
          icd = this.icdCode;
          // this.icdCode = this.ordersForm.get('imagingIcd').value;
      }
      let labComments = this.ordersForm.get('labComments')?.value;
      let labDate = moment.utc(this.ordersForm.get('labDate')?.value).toDate();
      let imagingDate = moment.utc(this.ordersForm.get('imagingDate')?.value).toDate();
      let imagingComments = this.ordersForm.get('imagingComments')?.value;
      let consultingComments = this.ordersForm.get('consultingComments')?.value;
      let consultingDate = moment.utc(this.ordersForm.get('consultingDate')?.value).toDate();
      let followUpComments = this.ordersForm.get('followupComments')?.value;
      let followUpDate = moment.utc(this.ordersForm.get('followupDate')?.value).toDate();
      let conditionType = this.ordersForm.get('conditionType')?.value;
      let condiitonComments =  this.ordersForm.get('conditionComments')?.value;
      //console.log(conditionType);
      //console.log(condiitonComments);
      let orderToInsert = new Orders(0, labDate, labComments, imagingDate, imagingComments, consultingDate, consultingComments,
          followUpDate, followUpComments, this.patientId, this.number, icd, "", new Date(), "", new Date(), true,conditionType,condiitonComments,this.des);
     // console.log(icd);
      this.orderService.insertOrders(orderToInsert)
          .subscribe(data => {
              // this.getpatientId(this.patientId);
              // (<HTMLInputElement>document.getElementById("save")).disabled = false;
              // this.closeOrdersModal();
          })
  }

  //  this.ordersForm.reset();
}


}
