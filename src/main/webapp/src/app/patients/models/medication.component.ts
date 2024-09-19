import { Component, OnInit, ViewChild, ElementRef, Input, Output, EventEmitter, ChangeDetectorRef } from "@angular/core";
import { FormBuilder, FormGroup, FormControl, FormArray, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { MasterLookupService } from "app/administration/master-lookup/masterLookupService";
import { MasterLookup } from "app/administration/master-lookup/masterLookup";
import { EncounterService } from "app/patients/services/encounterService";
import { Medication } from "app/patients/models/Medication";
import { ChiefCompliantDtl } from 'app/patients/models/chiefCompliantDtl';
import { PatientMedication } from "app/patients/models/PatientMedication";
import { MedicationService } from "app/patients/services/medicationService";
import { PatientMedicationRecord } from "app/patients/models/patientMedicationRecord";
import { NgxSpinnerService } from 'ngx-spinner';
import { PatientAllergy } from "../models/patientAllergy";
import { System } from "app/patients/models/system";
import { QuestionsService } from "app/patients/services/questionsService";
import { EncounterQuestionOptionService } from "app/patients/services/encounterQuestionOptionService";
import { EncounterQuestionOption } from "app/patients/models/encounterQuestionOption";
import { Location } from '@angular/common';

import _ from 'lodash';
import { QuestionGroup } from "app/patients/models/questionGroup";
import { EncounterQuestionGroup } from "app/patients/models/encounterQuestionGroup";
import { EncounterQuestionGroupService } from "app/patients/services/encounterQuestionGroupService";
import { PatientAllergyService } from "app/patients/services/patientAllergyService";

import { EncounterHistoryService } from "app/patients/services/encounterHistoryService";
import { EncounterHistory } from "app/patients/models/encounterHistory";
import { QuestionRecord } from "app/patients/models/questionRecord";

declare const $: any;

@Component({
  selector: 'ehr-medication',
  templateUrl: 'medication.component.html',
  styleUrls: ['medication.component.css', '../../app.component.css']
})
export class MedicationComponent implements OnInit {
  @ViewChild('searchRef') searchRef: ElementRef;
  search: string;
  @Input() patientId: number;
  @Input() icd10Code: string;
  finalData: Medication[];
  statusCode: number;
  InActiveMedicationForm: FormGroup;
  systemDesc: any;
  systemId: any;
  editMed: boolean = true;
  myFlag = true;

  activePatientMedications: PatientMedicationRecord[];
  inActivePatientMedications: PatientMedicationRecord[];
  patientMedications: PatientMedicationRecord[];
  isValid: number[] = [-1];
  isValidDuration: number[] = [-1];
  isValidDate: number[] = [-1];
  MedicationForm: FormGroup;
  QuestionSelectedArray1: any;
  isValidIndication: number[] = [-1];
  isValidCount: number[] = [-1];
  encounterId: number = 0;
  flag: Boolean = true;
  textMedicationVal: any[] = [];

  commonQuestions: QuestionRecord[] = [];
  commonQuestionsList: QuestionRecord[] = [];
  selectedRadioValue: any[] = [];
  questionGroupName: any;
  data: any;
  title: any;
  buttonName: any = 'SAVE';
  currentPatientId: any;
  patientAllergies: PatientAllergy[] = [];
  isDisabled = false;
  showMedicationList: Boolean = true;
  isMedList: boolean = true;
  isMedData: boolean = false;

  icd10Details: ChiefCompliantDtl[];
  medicationFormArray: any;
  allFrequency: MasterLookup[];
  questionGroupList: QuestionGroup[];
  questionGroups: QuestionGroup[];
  textVal: any[] = [];
  questionGroupId: any;
  commonQues: any;

  refillData: MasterLookup[];
  discontinuedReasonList: MasterLookup[];
  medicationFlag: boolean = false;
  selectedFrequencyValue: any[] = [];
  date: any[] = [];
  duration: any[] = [];
  selectedEndDate: any[] = [];
  selectedRefillValue: any[] = [];
  activeMedicationRecord: PatientMedicationRecord;
  showInActiveList: Boolean = true
  selectedIndicationValue: any[] = [];
  showActiveList: Boolean = true;
  searchCount: any;
  showFlag: boolean;
  showMedicationModal: boolean = true;
  searchText: string;
  buttonDisabled = true;
  showListFlag: boolean = false;
  value = false;
  display: boolean = true;
  system: System[];
  sysName = "MEDICATION";
  MedicationSystems: System[] = [];
  allSystemTypes: any[] = [];
  mx = new Date().getFullYear() + 10;
  @Input() pageName: string;
  @Output() patientIdChange = new EventEmitter();
  
  existingList: EncounterHistory[];
  selectedTValue: any[] = [];

  constructor(private formBuilder: FormBuilder,
    private location: Location,
    private route: ActivatedRoute, private router: Router,
    private masterLookupService: MasterLookupService,
    private encounterService: EncounterService,
    private medicationService: MedicationService,
    private cd : ChangeDetectorRef,
    private questionsService: QuestionsService,
    private patientAllergyService: PatientAllergyService,
    private encounterHistoryService: EncounterHistoryService,
    private encounterQuestionGroupService: EncounterQuestionGroupService,
    private encounterQuestionOptionService: EncounterQuestionOptionService,
    private spinner: NgxSpinnerService) { }

  cancel() {
    this.location.back(); // <-- go back to previous location on cancel
  }

  isFieldValid(form: FormGroup, field: string) {
    return !form.get(field).valid && form.get(field).touched;
  }

  

  isFieldValidOne(event, type) {
    let id = event.target.id;
    let rowNo = id.replace(/\D/g, "");
    if (event.target.value == "") {
      this.selectedTValue[rowNo] = undefined;
    }
    if ((type == "text") || (type == "textarea")) {
      if (((event.target.value.length > 100) && (type == "text")) ||
        ((event.target.value.length > 500) && (type == "textarea"))) {
        this.isValid[rowNo] = rowNo;
      }
      else {
        this.isValid[rowNo] = -1;
      }
    }
    else {
      this.isValid[rowNo] = -1;
    }
  }


  displayFieldCss(form: FormGroup, field: string) {
    return {
      'has-error': this.isFieldValid(form, field),
      'has-feedback': this.isFieldValid(form, field)
    };
  }

  ngOnInit() {
    //console.log("on initttttt");
    // this.selectedIndicationValue = [this.icd10Code];
    this.route.params.subscribe(params => {
      this.encounterId = +params['encounterId'];
      this.data = params['data'];
      this.getEncOptionDataForUpdate(this.encounterId);
      if (this.data == 'edit') {
        this.title = '- UPDATE'
        this.buttonName = 'UPDATE'
      }
    });
    this.medicationFormArray = [];
    this.QuestionSelectedArray1 = [];
    Observable.fromEvent(this.searchRef.nativeElement, 'keyup')
      .map((evt: any) => evt.target.value)
      .debounceTime(2000)
      .distinctUntilChanged()
      .subscribe((text: string) => this.submit(text));
    this.getEncounterByEncounterId(this.encounterId);

    var data = localStorage.getItem('system');
    if (data) {
      this.system = JSON.parse(data);
      this.system.filter(t => this.allSystemTypes.push(t.systemType))
      this.MedicationSystems = this.system.filter(t => t.systemType == 'MEDICATION');
      this.allSystemTypes = _.uniq(this.allSystemTypes);
    }
    var group = localStorage.getItem('questionGroup');
    if (group) {
      this.questionGroups = JSON.parse(group);
      this.questionGroups = this.questionGroups.sort((a, b) => a.questionGroupId - b.questionGroupId);
    }

    this.MedicationForm = this.formBuilder.group({
      MedIDS: this.formBuilder.array([]),
    });
    this.medicationFormArray = <FormArray>this.MedicationForm.controls.MedIDS;
    this.MedicationForm = this.formBuilder.group({
      QuestionSelectedIDS: this.formBuilder.array([]),
    });
    this.QuestionSelectedArray1 = <FormArray>this.MedicationForm.controls.QuestionSelectedIDS;
    let system = this.system.find(t => t.systemCode == 'MEDICATION');
    this.openTab(system);
    // console.log(this.pageName)
    if (this.pageName == "orders") {
      this.display = false;
      this.patientIdChange.emit(this.patientId);
      this.getIcd10DetailsOfLastFiveEncounters(this.patientId);
    }
    else {
      this.getAllChiefCompliantDetails(this.encounterId);
      this.getEncounterByEncounterId(this.encounterId);
      if (this.pageName == "plan"){
        this.display = false;
        this.getIcd10DetailsOfLastFiveEncounters(this.patientId);
      }
       
    }
    this.getFrequency();
    this.getLookUpTypeREFILL();
    this.getLookUpTypeDiscontinuedReason();
    Observable.fromEvent(this.searchRef.nativeElement, 'keyup')
      .map((evt: any) => evt.target.value)
      .debounceTime(2000)
      .distinctUntilChanged()
      .subscribe((text: string) => this.submit(text));
    this.MedicationForm = this.formBuilder.group({
      MedIDS: this.formBuilder.array([]),
    });
    this.medicationFormArray = <FormArray>this.MedicationForm.controls.MedIDS;

    this.InActiveMedicationForm = this.formBuilder.group({
      endDate: [null, [Validators.required]],
      reason: [null, [Validators.required]]
    });

  }
  openTab(system) {
    this.spinner.show();
    this.systemDesc = system.systemDesc;
    this.systemId = system.systemId;
    
    var record = localStorage.getItem('questionrecord_' + system.systemId);
   
    if (record) {
      this.spinner.hide();
      this.commonQuestions = JSON.parse(record);
      this.questionGroupList = this.questionGroups.filter(t => t.systemId == system.systemId);

    }
    else {
      this.questionsService.getAllQuestionsOfGroup(system.systemId)
        .subscribe(data => {
          this.commonQuestions = data;
          localStorage.setItem('questionrecord_' + system.systemId, JSON.stringify(data));
          this.questionGroupList = this.questionGroups.filter(t => t.systemId == system.systemId);
         // console.log(this.questionGroupList);
          this.spinner.hide();
        })
    }
  }
 
  onRowEdit(commonQues, option) {
    //console.log("row editt");
    //console.log(option);
    if (commonQues.optionType == 'radio') {
      commonQues.optionName = option.optionNames;
      commonQues.optionId = option.optionId;
    }
    //formArray for selected question
  let index = this.QuestionSelectedArray1.controls.findIndex(x => x.value.questionId == commonQues.questionId)
  
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





  onSubmit() {
    
    //this.router.navigate(['/patients/planandassessment/' + this.encounterId]);
    (<HTMLInputElement>document.getElementById("saveNext")).disabled = true;
    if (this.existingList.length !== 0) {
      let readyToinsert: boolean = false;
      this.encounterQuestionOptionService.deleteEncQustionOptions(this.encounterId, this.sysName).switchMap(            //delete already inserted question groups
        successCode => {
          return this.encounterQuestionGroupService.deleteEncQustionGroups(this.encounterId, this.sysName)         //elete already inserted question options
        }).subscribe(successCode => {
          readyToinsert = true;
          if (readyToinsert)
            this.insertData();
        },
          errorCode => {
            this.statusCode = errorCode;
          });
    }
    else {
      this.insertData();
    }
  }

  // 
  insertData() {
    let encounterQuestionGroupList: EncounterQuestionGroup[] = [];
    let encounterQuestionOptionList: EncounterQuestionOption[] = [];

    //seperation questionGroup id and system id from QuestionSelectedArray
    let uniqueQuestionId = Array.from(new Set(this.QuestionSelectedArray1.controls.map((item: any) => item.value.questionGroupId)))
    //console.log(uniqueQuestionId);
    if (uniqueQuestionId.length > 0) {
      for (let i = 0; i < uniqueQuestionId.length; i++) {
        let obj = this.QuestionSelectedArray1.controls.find(t => t.value.questionGroupId == uniqueQuestionId[i]);
        let encounterQuestionGroup = new EncounterQuestionGroup(0, this.encounterId, obj.value.questionGroupId, obj.value.systemId, 'Yes', null, null, null, null);
        encounterQuestionGroupList.push(encounterQuestionGroup);
      }
      this.encounterQuestionGroupService.insertQuestionGroups(encounterQuestionGroupList)
        .subscribe(successCode => {
          this.statusCode = successCode;
        },
          errorCode => {
            (<HTMLInputElement>document.getElementById("saveNext")).disabled = false;
            this.statusCode = errorCode;
          });
    }

    //inserting questions into DB 
    if (this.QuestionSelectedArray1.length > 0) {
      for (let i = 0; i < this.QuestionSelectedArray1.length; i++) {
        let encounterQuestionOption = new EncounterQuestionOption(0, this.encounterId, this.QuestionSelectedArray1.at(i).value.questionId,
          this.QuestionSelectedArray1.at(i).value.questionGroupId, this.QuestionSelectedArray1.at(i).value.systemId, this.QuestionSelectedArray1.at(i).value.optionId, this.QuestionSelectedArray1.at(i).value.optionName, this.QuestionSelectedArray1.at(i).value.answer, null, null, null, null, null);
        encounterQuestionOptionList.push(encounterQuestionOption);
      }
     // console.log(encounterQuestionOptionList)
      this.encounterQuestionOptionService.insertQuestionOptions(encounterQuestionOptionList)
        .subscribe(successCode => {
          if (this.data == "edit")
            this.router.navigate(['/patients/history/', this.encounterId, 'edit']);
          else
            this.router.navigate(['/patients/history/' + this.encounterId]);
        },
          errorCode => {
            (<HTMLInputElement>document.getElementById("saveNext")).disabled = false;
            this.statusCode = errorCode;
          });
    }
    else {
      if (this.data == "edit")
        this.router.navigate(['/patients/history/', this.encounterId, 'edit']);
      else
        this.router.navigate(['/patients/history/' + this.encounterId]);
    }
  }
  // 
  //Setting values while update operation
  getEncOptionDataForUpdate(encId: any) {
    //console.log("getEncOptionDataForUpdate called");
    
    this.pageName !== 'orders' && this.encounterHistoryService.getEncounterListEncounterId(encId, this.sysName)
      .subscribe(data => {
        this.existingList = data;
    //    console.log(this.existingList);
        for (let i = 0; i < this.existingList.length; i++) {
          let questionRecord = new QuestionRecord(this.existingList[i].optionId, this.existingList[i].questionId, this.existingList[i].systemId, this.existingList[i].questionGroupId, this.existingList[i].questionDesc, this.existingList[i].questionType, null, this.existingList[i].answer, this.existingList[i].optionValue);
          this.QuestionSelectedArray1.push(new FormControl(questionRecord));
       
        /*  var option = {optionNames:null,optionId:null}; 
          option.optionId=this.existingList[i].optionId;
          option.optionNames=this.existingList[i].optionValue;*/
         

          if (this.existingList[i].questionType == 'text') {                  // Setting Values for Text Box
            this.textVal[this.existingList[i].questionId] = this.existingList[i].answer;
          }
          if (this.existingList[i].questionType == 'radio') {       // Setting Values for Text Box
            this.selectedRadioValue[this.existingList[i].questionId] = this.existingList[i].optionId;
          }
        }
      })
  }


  getEncounterByEncounterId(encounterId: number) {
    this.encounterService.getEncounterByEncounterId(encounterId)
      .subscribe(data => {
        this.patientId = data.patientId;
        this.getAllAllergies(this.patientId);

        this.patientIdChange.emit(this.patientId);
        this.getPatientMedications(this.patientId);
      },
        errorCode => this.statusCode = errorCode);
  }
  getAllAllergies(patientId) {
    this.spinner.show();
    this.currentPatientId = patientId;
    
    
    this.patientAllergyService.getPatientAllergies(patientId)
      .subscribe(data => {
        this.spinner.hide();
        this.patientAllergies = data;
        if(this.patientAllergies.length > 0){
         // console.log("ifffffffff");
          
        } 
        this.patientAllergies.length == 0 ? this.showMedicationList = true : this.showMedicationList = false;
      })
  }
  deletePatientAllergy(patientAllergyId: number) {
    this.patientAllergyService.deletePatientAllergies(patientAllergyId)
      .subscribe(successCode => {
        this.statusCode = successCode;
        this.getAllAllergies(this.patientId);
      },
        errorCode => {
          this.statusCode = errorCode
        });
  }

  showDiv(group: any, isChecked: boolean, rowId) {
    
    if (isChecked) {
      this.commonQuestionsList = this.commonQuestions.filter(t => t.questionGroupId == group.questionGroupId);
      this.systemId = group.systemId;
      this.questionGroupId = group.questionGroupId;
      this.questionGroupName = group.questionGroupName;
    }
    else {
      if (this.questionGroupId == group.questionGroupId) {
        this.questionGroupId = null;
      }
    }
  }


  //logic to set Yes/No option to all radio buttons
  resetAll(sysId: any, questionGroupId: any, optionValue: any) {
    let radioQuestions = this.commonQuestions.filter(t => t.questionGroupId == questionGroupId && t.optionType == 'radio');
    for (let i = 0; i < radioQuestions.length; i++) {
      let index = this.QuestionSelectedArray1.controls.findIndex(x => x.value.questionId == radioQuestions[i].questionId)
      let option = radioQuestions[i].optionRecord.find(t => t.optionNames == optionValue);
      if (index !== -1) {
        this.QuestionSelectedArray1.removeAt(index);
      }
      radioQuestions[i].optionId = option.optionId;
      radioQuestions[i].optionName = option.optionNames;
      this.QuestionSelectedArray1.push(new FormControl(radioQuestions[i]));
    }
  }
  showAllergiesModal() {
    this.value = !this.value;
    $("#expansionPanel3").show();
  }

  getAllChiefCompliantDetails(encounterId) {
    this.encounterService.getAllChiefCompliantDetailsByEncounterId(encounterId)
      .subscribe(data => {
        this.icd10Details = data;

      },
        errorCode => this.statusCode = errorCode);
  }

  getIcd10DetailsOfLastFiveEncounters(patientId) {
    this.encounterService.getIcd10DetailsOfLastFiveEncounters(patientId)
      .subscribe(data => {
        this.icd10Details = data;
       // console.log(this.icd10Details)
        this.getPatientMedications(this.patientId)
      },
        errorCode => this.statusCode = errorCode);
  }

  openInActiveMedication(activeMedication) {
    this.InActiveMedicationForm.reset();
    this.activeMedicationRecord = activeMedication;
    $('#InActiveMedication').modal('show');
  }

  openPrescription(activeMedication) {
    this.activeMedicationRecord = activeMedication;
    $('#Prescription').modal('show');
  }

  //logic to check validation for selected medication record
  checkedMedicationData(data) {
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

  startdatepicker(v, data) {
    var self = this;
    $("#startDate" + v).datepicker({
      changeMonth: true,
      yearRange: "1900:" + this.mx,
      defaultDate: new Date(),
      changeYear: true,
      beforeShow: function () {
        setTimeout(function () {
          $('.ui-datepicker').css('z-index', 99999999999999);
        }, 0);
      },
      onSelect: function (dateText, inst) {
        data.startDate = dateText;
        self.checkedMedicationData(data);
        self.calculateDuration(data);
      }
    }).datepicker("show");
    this.checkedMedicationData(data);
  }

  endDate() {
    var self = this;
    $("#endDate").datepicker({
      changeMonth: true,
      changeYear: true,
      beforeShow: function () {
        setTimeout(function () {
          $('.ui-datepicker').css('z-index', 99999999999999);
        }, 0);
      },
      onSelect: function (dateText, inst) {
        self.InActiveMedicationForm.get('endDate').setValue(dateText);
      }
    }).datepicker("show");
  }

  //Calculate End Date from Start Date and Duration in Days
  calculateDuration(data) {
    let date = (document.getElementById("startDate" + data.medicationId) as HTMLInputElement).value;
    let startDate = new Date(date)
    let duration = this.duration[data.medicationId];
    let value = parseInt(duration);
    if (date !== "" && (duration !== undefined && duration !== "" && value >= 0)) {
      startDate.setDate(startDate.getDate() + value);
      data.endDate = startDate;
    }
  }
  goToSelectedTab(group: any, i: any) {
    this.questionGroupId = group.questionGroupId;
    setTimeout(() => {
      document.getElementById("systemName").scrollIntoView({ behavior: 'smooth' });
    }, 1000);
    this.systemId = group.systemId;
    this.commonQuestionsList = this.commonQuestions.filter(t => t.questionGroupId == group.questionGroupId);
    this.commonQuestionsList = this.commonQuestionsList.sort((a, b) => a.questionId - b.questionId);
    this.questionGroupName = group.questionGroupName;
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


  isCheckedRadio(optionId: number): boolean {
    //console.log("is checkd  radio called");
    let index = this.QuestionSelectedArray1.controls.findIndex(x => x.value.optionId == optionId)
    return (index == -1 ? false : true);
  }


  submit(text) {
   // console.log(text);
    this.finalData = [];
    this.search = text;
    if (this.search == "" || this.search.length < 3) {
      this.showFlag = false;
    }
    else {
      this.spinner.show();
      this.encounterService.searchAllergy(this.search)
        .subscribe(results => {
        
          this.finalData = results;
          for (let i = 0; i < this.finalData.length; i++) {
            this.finalData[i].dose = this.finalData[i].dose.replace(new RegExp(';', 'g'), ';&emsp;')
          }
          this.spinner.hide();
          this.searchCount = this.finalData.length;
          this.searchCount == 0 ? this.flag = true : this.flag = false;
        });
    }
  }
  saveAllergy() {
    this.isDisabled = true;
    let patientAllergyList: PatientAllergy[] = [];
    if (this.medicationFormArray.length > 0) {
      for (let i = 0; i < this.medicationFormArray.length; i++) {
        let patientAllergy = new PatientAllergy(0, this.medicationFormArray.at(i).value.productName, this.medicationFormArray.at(i).value.form, this.medicationFormArray.at(i).value.route, this.medicationFormArray.at(i).value.dose, true, this.medicationFormArray.at(i).value.medicationId, null, null, null, null, this.encounterId, this.patientId);
        patientAllergyList.push(patientAllergy);
      }
      this.patientAllergyService.insertAllergy(patientAllergyList)
        .subscribe(successCode => {
          this.statusCode = successCode;
          let element: HTMLElement = document.getElementById("dismissmodal") as HTMLElement;
          element.click();
          this.getAllAllergies(this.patientId);
        },
          errorCode => {
            this.statusCode = errorCode;
          });
    }
  }
  //Logic to insert patient medications
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
        $('#addClose').prop('disabled', true);
        let patientMedication = new PatientMedication(0, this.patientId, this.encounterId, this.medicationFormArray.at(i).value.data.medicationId, frequency, new Date(startDate), duration, new Date(selectedEndDate), refill, indication, null, 'Y', null, true, null, null, null, null, null);
        patientMedicationList.push(patientMedication);
      }
      else
        this.medicationFlag = true;
    }
    if (!this.medicationFlag) {
    //  console.log("in ifffffffffffffff");
      this.medicationService.insertAllMedication(patientMedicationList)
        .subscribe(successCode => {
          this.statusCode = successCode;
          $('#addClose').prop('disabled', false);
          let element: HTMLElement = document.getElementById("dismissmodal") as HTMLElement;
          element.click();
          this.getPatientMedications(this.patientId);
        },
          errorCode => {
            this.statusCode = errorCode;
          });
    }
  }

  getFrequency() {
    this.masterLookupService.getFrequency()
      .subscribe(
        data => {
          this.allFrequency = data;

        },
        errorCode => this.statusCode = errorCode);
  }

  getLookUpTypeREFILL() {
    this.masterLookupService.getLookUpTypeAsRefill()
      .subscribe(
        data => {
          this.refillData = data;

        },
        errorCode => this.statusCode = errorCode);
  }

  getLookUpTypeDiscontinuedReason() {
    this.masterLookupService.getLookUpTypeAsDiscontinued_Reason()
      .subscribe(
        data => {
          this.discontinuedReasonList = data;

        },
        errorCode => this.statusCode = errorCode);
  }

  getPatientMedications(patientId) {
    this.spinner.show();
    this.medicationService.getPatientMedications(patientId)
      .subscribe(
        data => {
          this.spinner.hide();
          this.patientMedications = data;
          // this.patientMedications.length == 0 ? this.showListFlag = true : this.showListFlag = false;

          if(this.icd10Code == 'all' || this.icd10Code == null){
            this.activePatientMedications = this.patientMedications.filter(t => t.isActiveMedication == 'Y');
            this.inActivePatientMedications = this.patientMedications.filter(t => t.isActiveMedication == 'N');
  
          }else{
            this.activePatientMedications = this.patientMedications.filter(t => t.isActiveMedication == 'Y' && t.icd10Code == this.icd10Code);
            this.inActivePatientMedications = this.patientMedications.filter(t => t.isActiveMedication == 'N' && t.icd10Code == this.icd10Code);
  
          }
         
          this.activePatientMedications.length == 0 ? this.showActiveList = true : this.showActiveList = false;
          this.inActivePatientMedications.length == 0 ? this.showInActiveList = true : this.showInActiveList = false;
        },
        errorCode => this.statusCode = errorCode);
  }

  //Submit for Discontinue Medication
  onSubmitInActiveList() {
    if (this.InActiveMedicationForm.valid) {
      $('#saveInactive').prop('disabled', true);
      let reason = this.InActiveMedicationForm.get('reason').value;
      let endDate = this.InActiveMedicationForm.get('endDate').value;
      let patientMedication = new PatientMedication(this.activeMedicationRecord.patientMedicationId, null, this.encounterId, null, null, null, null, null, null, null, null, 'N', reason, true, null, null, null, null, new Date(endDate));
      this.medicationService.discontinueMedication(patientMedication)
        .subscribe(successCode => {
          this.statusCode = successCode;
          $('#saveInactive').prop('disabled', false);
          let element: HTMLElement = document.getElementById("dismissModalOnsubmit") as HTMLElement;
          element.click();
          this.getPatientMedications(this.patientId);
        },
          ErrorCode => {
            this.statusCode = ErrorCode;
          })
    }
    else {
      this.validateAllFormFields(this.InActiveMedicationForm);
    }
  }

  clearFields() {
    this.selectedFrequencyValue = [];
    this.selectedIndicationValue = [];
    this.selectedRefillValue = [];
    this.duration = [];
    this.isValidDate = [-1];
    this.isValidIndication = [-1];
    this.isValid = [-1];
    this.isValidDuration = [-1];
    this.isValidCount = [-1];
  }
  openQuestionGroup(sysId, systemDesc) {
   // console.log(systemDesc);
    this.questionGroupId = null;
    this.spinner.show();
    this.checkedMedicationList();
    this.systemId = sysId;
    this.systemDesc = systemDesc;
    this.questionsService.getAllQuestionsOfGroup(this.systemId)
      .subscribe(data => {
        this.commonQuestions = data;
        this.questionGroupList = this.questionGroups.filter(t => t.systemId == this.systemId);
        this.spinner.hide();
        if (systemDesc == 'MEDICATION') {
          this.isMedData = true;
          let group = this.questionGroupList.find(t => t.questionGroupName == 'Medication');
          this.questionGroupId = group.questionGroupId;
          this.isMedList = true;
          this.setInsertedValues();
        }
        else {
          this.isMedList = false;
        }
      })
  }

  //setting text/TextArea values in FAMILY HISTORY while update
  setInsertedValues() {
    for (let i = 0; i < this.existingList.length; i++) {
      if (this.existingList[i].questionType !== 'checkbox' && this.existingList[i].systemId == 26 && this.editMed) {
        let textQuestions = this.commonQuestions.filter(t => t.questionId == this.existingList[i].questionId);
        let answer = this.existingList[i].answer.split("-");
        for (let k = 0; k < textQuestions.length; k++) {
          for (let j = 0; j < textQuestions[k].optionRecord.length; j++) {
            this.textMedicationVal[textQuestions[k].optionRecord[j].optionId] = answer[j];
          }
        }
      }
    }
    this.editMed = false;
  }

  checkedMedicationList() {
   // console.log("checckedddddd");
    let commonQuestionsList = this.commonQuestions.filter(t => t.systemId == 26 && t.optionType !== 'checkbox');
    for (let i = 0; i < commonQuestionsList.length; i++) {
      let lastanswer = "";
      for (let j = 0; j < commonQuestionsList[i].optionRecord.length; j++) {
        lastanswer = lastanswer.concat(((document.getElementById("textMedication_" + commonQuestionsList[i].optionRecord[j].optionId) as HTMLInputElement).value) + "-");
      }
      commonQuestionsList[i].answer = lastanswer.substring(0, lastanswer.length - 1);
      let index = this.QuestionSelectedArray1.controls.findIndex(x => x.value.questionId == commonQuestionsList[i].questionId)
      if (index !== -1)
        this.QuestionSelectedArray1.at(index).setValue((commonQuestionsList[i]));
    }
  }
  clearFormArray = (formArray: FormArray) => {
    while (formArray.length !== 0) {
      formArray.removeAt(0)
    }
  }

  closeMedicationAllergyModel() {
    $('#MedicationAllergy').modal('hide');

  }

  showModal(commonQues) {
    this.isDisabled = false;
    this.commonQues = commonQues;

    this.finalData = [];
    this.medicationFormArray = <FormArray>this.MedicationForm.controls.MedIDS;
    this.clearFormArray(this.medicationFormArray);
    this.buttonDisabled = true;
    this.flag = true;
    this.searchText = '';
    this.clearFields();

    $('#MedicationAllergy').modal('show');

  }

  validateAllFormFields(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(field => {
      const control = formGroup.get(field);
      if (control instanceof FormControl) {
        control.markAsTouched({ onlySelf: true });
      } else if (control instanceof FormGroup) {
        this.validateAllFormFields(control);
      }
    });
  }

  checkedMedication(checked: boolean, data: any) {
    this.checkedMedicationData(data);
    if (checked) {
      this.medicationFormArray.push(new FormControl({ 'data': data }));
    }
    else {
      let index = this.medicationFormArray.controls.findIndex(x => x.value.data.medicationId == data.medicationId)
      this.medicationFormArray.removeAt(index);
    }
    if (this.medicationFormArray.length == 0) {
      this.medicationFlag = false;
      this.buttonDisabled = true;
    }
    else {
      this.buttonDisabled = false;
    }
  }

  isCheckedMed(medicationId: number): boolean {
    for (var i = 0; i < this.medicationFormArray.length; i++) {
      if (this.medicationFormArray.at(i).value.data.medicationId == medicationId) {
        return true;
      }
    }
    return false;
  }
  isDisableAllergy(medicationId: number): boolean {
    let index = this.patientAllergies.findIndex(x => x.medicationId == medicationId)
    return (index == -1 ? false : true);
  }

}