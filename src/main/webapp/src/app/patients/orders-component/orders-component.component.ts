import { Component, signal } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientRecord } from '../models/PatientRecord';
import { Orders } from '../models/orders';
import { PatientMedicationRecord } from '../models/patientMedicationRecord';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EncAsessment } from '../models/EncAsessment';
import { ChiefCompliantDtl } from '../models/chiefCompliantDtl';
import { Encounter } from '../models/encounter';
import { System } from '../models/system';
import { CommonModule } from '@angular/common';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { OrdersService } from '../services/ordersService';
import * as moment from 'moment';
import { StateServicesService } from '../services/state-services.service';
import { PatientDetailsService } from '../services/patientDetailsService';
import { MatSidenavModule } from '@angular/material/sidenav';
import { StaffMember } from 'src/app/administration/staff-members/staffmember';
import { CurrentUserService } from 'src/app/profiles/currentUserService';
import { MatExpansionModule } from '@angular/material/expansion';

@Component({
  selector: 'app-orders-component',
  templateUrl: './orders-component.component.html',
  styleUrls: ['./orders-component.component.css'],
  standalone: true,
  imports: [FormsModule ,CommonModule,TimerModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule,MatIconModule,MatSidenavModule,MatExpansionModule],
})
export class OrdersComponentComponent {

  encounterId:any

  showData:boolean=false;
  icd10Details!: ChiefCompliantDtl[];

  tabList!: any[];
  patientId:any;
  assessmentForm!:FormGroup;
  encounterassessmentdata:EncAsessment[]=[];
  number:any;

  updateIcdCode:any;
  updateIcdDesc:any;




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



  readonly panelOpenState = signal(false);
  locName: any;
  staffImage: any;

  loggedInUser!: StaffMember;


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

  updatedPatient:any;
  updatedIcdCode:any;
  updatedIcdDesc:any;



  allOrdersData: Orders[] = [];


  constructor(private _activateRoute:ActivatedRoute,private formBuilder:FormBuilder,private orderService:OrdersService,private stateService:StateServicesService
    ,private patientDetailsService:PatientDetailsService,private route:Router,  private currentUserService: CurrentUserService
   ){}


  ngOnInit(){

    this.updatedPatient = sessionStorage.getItem('patientId');
    console.log(this.updatedPatient);


    this.patientDetailsService.getPatientRecordsByPatientId(this.updatedPatient)
.subscribe(data => {
  console.log(data);
  
  this.patientRecords = data;

  //console.log(this.patientRecords);

  
});

    


    this.updatedIcdCode = sessionStorage.getItem('IcdCode');
    console.log(this.updatedIcdCode);
    

    this.updatedIcdDesc = sessionStorage.getItem('IcdDesc');
    console.log(this.updatedIcdDesc);
    




    this._activateRoute.paramMap.subscribe(params => {
      this.encounterId = params.get('id');
      console.log(this.encounterId);
      
      // Now you can use the 'id' parameter in your component
    });

    


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
  this.tabList = ["Condition", "Lab", "Imaging", "Consulting", "Follow up"];

  this.getAllOrdersByPatientId(this.patientId,this.encounterId);

    this.getLoggedInUserDetails();

  }


  selectTab(tab: string) {
    this.viewMode = tab;
  }

  changeIcdCode(icd: string) {
    // console.log(this.icdCode);
     this.showComponent = false;
    //  setTimeout(x => this.showComponent = true);
    //  this.getAllOrdersByPatientId(this.patientId, icd);
     this.icdCode = icd;
  }


  
  onSave() {
  
        let icd = this.icdCode;
        if (this.viewMode == 'Lab') {
            icd = this.updatedIcdCode;
            // this.icdCode = this.ordersForm.get('icd').value;
        }
        if (this.viewMode == 'Imaging') {
            icd = this.updatedIcdCode;
            // this.icdCode = this.ordersForm.get('imagingIcd').value;
        }
        if (this.viewMode == 'Condition') {
            icd = this.updatedIcdCode;
            // this.icdCode = this.ordersForm.get('imagingIcd').value;
        }
        if (this.viewMode == 'Consulting') {
          icd = this.updatedIcdCode;
          // this.icdCode = this.ordersForm.get('imagingIcd').value;
      }

      if (this.viewMode == 'Follow up') {
        icd = this.updatedIcdCode;
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
            followUpDate, followUpComments, this.updatedPatient, this.encounterId, icd, "", new Date(), "", new Date(), true,conditionType,condiitonComments,this.updatedIcdDesc);
       // console.log(icd);
        this.orderService.insertOrders(orderToInsert)
            .subscribe(data => {
              console.log(data);
              this.allOrdersData.push(data);
              
              console.log("Saved....");
              

              
              
            })
    
 
     this.ordersForm.reset();
}


getAllOrdersByPatientId(patientId: number, icd: string) {
  //console.log(patientId);
  this.orderService.getOrdersByPatientIdEncId(patientId,this.encounterId)
      .subscribe(data => {
          //console.log(data);
          if ((icd == 'all' || icd == null)) {
              this.allOrders = data;
              this.icdCode = icd;
          } else {
              //console.log("in elseeeeeeeee")
              this.allOrders = data.filter(item => item.icd10Code == icd);
              this.icdCode = icd;
          }
      })

      //console.log("all orders-------------->"+this.allOrders);
}

deleteLabRecord(orderId:any) {
  this.orderService.deletOrdertData(orderId)
      .subscribe(successCode => {
          this.statusCode = successCode;
          this.getAllOrdersByPatientId(this.patientId, this.icdCode);
      }, errorCode => {
          this.statusCode = errorCode;
      });
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

  PlanChange(){
    this.route.navigate(['plan'])
  }




}
