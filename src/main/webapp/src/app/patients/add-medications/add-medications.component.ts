import { Component, Inject } from '@angular/core';
import { EncounterService } from '../services/encounterService';
import { Medication } from '../models/medication';
import { CommonModule } from '@angular/common';
import { FormArray, FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { SearchPipe } from '../search.pipe';
import { StateServicesService } from '../services/state-services.service';
import { ChiefCompliantDtl } from '../models/chiefCompliantDtl';
import { MasterLookupService } from '../services/masterLookupService';
import { MasterLookup } from '../models/masterLookup';
import { PatientMedication } from '../models/PatientMedication';
import { MedicationService } from '../services/medicationService';

@Component({
  selector: 'app-add-medications',
  templateUrl: './add-medications.component.html',
  styleUrls: ['./add-medications.component.css'],
  standalone: true,
  imports: [FormsModule ,CommonModule,SearchPipe,TimerModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule,MatIconModule],
})
export class AddMedicationsComponent {
  search!: string;
  finalData!: Medication[];
  searchCount: any;
  flag!: boolean;
  searchText!: string;
  filteredData: any[] = []; 
  medicationFormArray: any;
  MedicationForm!: FormGroup;
  patientId:any;
  number:any;
  icd10Details!: ChiefCompliantDtl[];
  selectedIndicationValue: any[] = [];
  allFrequency!: MasterLookup[];
  selectedFrequencyValue: any[] = [];
  selectedRefillValue: any[] = [];
  refillData!: MasterLookup[];
  duration: any[] = [];
  date: any[] = [];
  mx = new Date().getFullYear() + 10;
  selectedEndDate: any[] = [];
  medicationFlag: boolean = false;
  isValid: number[] = [-1];
  isValidDuration: number[] = [-1];
  isValidDate: number[] = [-1];
  isValidIndication: number[] = [-1];
  isValidCount: number[] = [-1];
  patientMedicationList: PatientMedication[] = [];
  constructor( private encounterService:EncounterService,private formBuilder:FormBuilder,private stateService:StateServicesService,
    private masterLookupService:MasterLookupService,private medicationService:MedicationService,
    @Inject(MAT_DIALOG_DATA) public data: { id: number}
  ){}

  ngOnInit(){

    console.log(this.data.id);
 

       this.stateService.id$.subscribe(value => {
      this.patientId = value;
      console.log(this.patientId);
      
    });
    this.stateService.currentNumber.subscribe(number => {
      this.number = number;
   //   console.log(this.number);
      
    });

    console.log(this.medicationFormArray);
    

    this.encounterService.searchAllergy(this.search)
    .subscribe(results => {
    
      this.finalData = results;
      results=this.filteredData;
      console.log(this.finalData);
      
      for (let i = 0; i < this.finalData.length; i++) {
        this.finalData[i].dose = this.finalData[i].dose.replace(new RegExp(';', 'g'), ';&emsp;')
      }
    
      this.searchCount = this.finalData.length;
      this.searchCount == 0 ? this.flag = true : this.flag = false;
    });

    this.MedicationForm = this.formBuilder.group({
      MedIDS: this.formBuilder.array([]),
    });
    this.medicationFormArray = <FormArray>this.MedicationForm.controls['MedIDS'];
    this.MedicationForm = this.formBuilder.group({
      QuestionSelectedIDS: this.formBuilder.array([]),
    });

    this.getAllChiefCompliantDetails();
    this.getFrequency();
    this.getLookUpTypeREFILL();

  }

  search1(){
    const term = this.searchText.toLowerCase();
    this.filteredData = this.finalData.filter(item =>
      item.activeingredient.toLowerCase().includes(term) ||
      item.dose.toLowerCase().includes(term) ||
      item.drugname.toLowerCase().includes(term) ||
      item.form.toLowerCase().includes(term) ||
      item.schedule.toLowerCase().includes(term)
    );

  }

  getFrequency() {
    this.masterLookupService.getFrequency()
      .subscribe(
        data => {
          this.allFrequency = data;

        });
  }

  
  isCheckedMed(medicationId: number): boolean {
  
    
    for (var i = 0; i < this.medicationFormArray.length; i++) {
      if (this.medicationFormArray.at(i).value.data.medicationId == medicationId) {
        console.log(this.medicationFormArray);
        
        return true;
      }
    }
    return false;
  }

  checkedMedicationData(data:any) {
    if (data.checked) {
      data.startDate == undefined || data.startDate == "" ? this.isValidDate[data.medicationId] = data.medicationId : this.isValidDate[data.medicationId] = -1;
      data.indication == undefined ? this.isValidIndication[data.medicationId] = data.medicationId : this.isValidIndication[data.medicationId] = -1;
      data.frequency == undefined ? this.isValid[data.medicationId] = data.medicationId : this.isValid[data.medicationId] = -1;
      data.duration == undefined || data.duration == "" ? this.isValidDuration[data.medicationId] = data.medicationId : this.isValidDuration[data.medicationId] = -1;
      data.refillCount == undefined ? this.isValidCount[data.medicationId] = data.medicationId : this.isValidCount[data.medicationId] = -1;
      if (data.indication !== undefined && data.frequency !== undefined && data.duration !== undefined)
        this.medicationFlag = false;
    }
    else {
      this.isValidDate[data.medicationId] = -1;
      this.isValidIndication[data.medicationId] = -1;
      this.isValid[data.medicationId] = -1;
      this.isValidDuration[data.medicationId] = -1;
      this.isValidCount[data.medicationId] = -1;

    }
  }


  
  checkedMedication( event: Event, data: any) {
    this.checkedMedicationData(data);
 //   if (event.) {
      this.medicationFormArray.push(new FormControl({ 'data': data }));
  //   }
  //   else {
  //     let index = this.medicationFormArray.controls.findIndex((x: { value: { data: { medicationId: any; }; }; }) => x.value.data.medicationId == data.medicationId)
  //     this.medicationFormArray.removeAt(index);
  //   }
  //   if (this.medicationFormArray.length == 0) {
  //     this.medicationFlag = false;
    
  //   }
  //   else {
  //  //   this.buttonDisabled = false;
  //   }
  }



  getAllChiefCompliantDetails() {
    this.encounterService.getAllChiefCompliantDetailsByEncounterId(this.number)
      .subscribe(data => {
        this.icd10Details = data;
        console.log(data);
        
      })
  }


  getLookUpTypeREFILL() {
    this.masterLookupService.getLookUpTypeAsRefill()
      .subscribe(
        data => {
          this.refillData = data;

        });
  }

  calculateDuration(data:any) {
    let date = (document.getElementById("startDate" + data.medicationId) as HTMLInputElement).value;
    let startDate = new Date(date)
    let duration = this.duration[data.medicationId];
    let value = parseInt(duration);
    if (date !== "" && (duration !== undefined && duration !== "" && value >= 0)) {
      startDate.setDate(startDate.getDate() + value);
      data.endDate = startDate;
    }
  }

  startdatepicker(v:any, data:any) {
    var self = this;
    $("#startDate" + v)['datepicker']({
      changeMonth: true,
      yearRange: "1900:" + this.mx,
      defaultDate: new Date(),
      changeYear: true,
      beforeShow: function () {
        setTimeout(function () {
          $('.ui-datepicker').css('z-index', 99999999999999);
        }, 0);
      },
      onSelect: function (dateText:any, inst:any) {
        data.startDate = dateText;
       
        self.calculateDuration(data);
      }
    }).datepicker("show");
   
  }

  
  onChange(data: any, event: Event): void {
    const target = event.target as HTMLInputElement;
    const isChecked = target.checked;
    // console.log(data);
    this.patientMedicationList.push(data);
    // console.log(data, icdgroupName, isChecked);
    //  this.filterICd=data;
     console.log(this.patientMedicationList);
     
    
  }

  submitData() {
    this.medicationFlag = false;
    let patientMedicationList: PatientMedication[] = [];
    for (let i = 0; i < this.medicationFormArray.length; i++) {
      let indication = this.selectedIndicationValue[this.medicationFormArray.at(i).value.data.medicationId];
      let refill = this.selectedRefillValue[this.medicationFormArray.at(i).value.data.medicationId];
      let frequency = this.selectedFrequencyValue[this.medicationFormArray.at(i).value.data.medicationId];
      let duration = this.duration[this.medicationFormArray.at(i).value.data.medicationId];
      let startDate: any = (document.getElementById("startDate" + this.medicationFormArray.at(i).value.data.medicationId) as HTMLInputElement).value;
      let selectedEndDate: any = (document.getElementById("endDate" + this.medicationFormArray.at(i).value.data.medicationId) as HTMLInputElement).value;
      if (startDate !== "" && indication !== undefined && frequency !== undefined && refill !== undefined && (duration !== undefined && duration !== "")) {
    
        let patientMedication = new PatientMedication(0, this.patientId, this.number, this.medicationFormArray.at(i).value.data.medicationId, frequency, new Date(startDate), duration, new Date(selectedEndDate), refill, indication, "", 'Y', "", true, new Date(), "", new Date(), "", new Date());
        patientMedicationList.push(patientMedication);
      }
      else
        this.medicationFlag = true;
    }
    if (!this.medicationFlag) {
    //  console.log("in ifffffffffffffff");
    console.log(this.medicationFormArray);
    
      this.medicationService.insertAllMedication(patientMedicationList)
        .subscribe(successCode => {
        
        });
  }
  // getFrequency() {
  //   this.masterLookupService.getFrequency()
  //     .subscribe(
  //       data => {
  //         this.allFrequency = data;

  //       },
  //       errorCode => this.statusCode = errorCode);
  // }
}

 
}
