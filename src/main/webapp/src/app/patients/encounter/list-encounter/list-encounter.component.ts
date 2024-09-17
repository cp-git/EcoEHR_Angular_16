import { Component, ElementRef, EventEmitter, Input, Output, ViewChild } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ICD10Group } from '../../models/ICD10Group';
import { ICD10 } from '../../models/ICD10';
import { CommonModule } from '@angular/common';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { TimerModule } from 'src/app/components/timer/timer.module';
import { EncounterService } from '../../services/encounterService';
import { SearchPipe } from '../../search.pipe';
import { TemplateService } from '../../services/templateService';
import { Template } from '../../models/template';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { StateServicesService } from '../../services/state-services.service';


@Component({
  selector: 'app-list-encounter',
  templateUrl: './list-encounter.component.html',
  styleUrls: ['./list-encounter.component.css'],
  standalone: true,
  imports: [FormsModule ,CommonModule,SearchPipe,TimerModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule,MatIconModule],

})
export class ListEncounterComponent {
  @ViewChild('searchRef') searchRef!: ElementRef;
  AddIcdForm!: FormGroup;
  flag: boolean = false;
  showFlag!: boolean;
  searchText!: string;
  groupId:any;
  icdgroupName!: string;
  searchCount: any;
  IcdCodesArray: any;
  ICD10Group!: ICD10Group[];
  templates!: Template[];
  finalData!: ICD10[];
  search!: string;
  ICDData:ICD10[]=[];

  filterICd:ICD10[]=[];

  @Output() onIcdCode = new EventEmitter<any>();

  filteredData: any[] = []; 

  selectedItems: any[] = [];

  icdPrimaryErrorFlag!: boolean;
  primaryErrorFlag: boolean=true;
  icdErrorFlag: boolean = false;
  hideTable!: boolean;


  constructor(private formBuilder:FormBuilder,
    private encounterService:EncounterService,
    private templateService: TemplateService,
    private router:Router,
    private location: Location,
    private stateService: StateServicesService
  ){}

  ngOnInit(){
    this.AddIcdForm = this.formBuilder.group({
      icdIDS:new FormArray([]),
    });

    this.getAllICD10Groups();
    this.getAllActiveTemplates();
    
    this.encounterService.getDataAll().subscribe(
      data=>{
        console.log(data);
        this.ICDData=data;
        data=this.filteredData;
        
      }
    )


    



  }

  search1(){
    const term = this.searchText.toLowerCase();
    this.filteredData = this.ICDData.filter(item =>
      item.Description.toLowerCase().includes(term) ||
      item.SearchInclusion.toLowerCase().includes(term) ||
      item.ClinicalNotes.toLowerCase().includes(term) ||
      item.ICD10Code.toLowerCase().includes(term)
    );

  }


  onClicking(group: any) {
    this.flag = true;
    this.showFlag = false;
    this.searchText = '';
    this.groupId=group.groupId;
    this.icdgroupName = group.groupDescription;
  }

  onChangePrimary(icd: any, isChecked: boolean) {
    if (this.IcdCodesArray.length > 0) {
      for (let i = 0; i < this.IcdCodesArray.length; i++) {
        this.IcdCodesArray.at(i).value.primary = false;
        if (this.IcdCodesArray.at(i).value.ICD10Code == icd)
          this.IcdCodesArray.at(i).value.primary = isChecked;
      }
   //  this.isCheckedPrimaryFlag();
      for (let i = 0; i < this.IcdCodesArray.length; i++) {
       // console.log(this.IcdCodesArray.at(i).value)
      }
    }
  }

  isChecked(ICD10Code: number): boolean {
    for (var i = 0; i < this.IcdCodesArray.length; i++) {
      if (this.IcdCodesArray.at(i).value.ICD10Code == ICD10Code) {
        return true;
      }
    }
    return false;
  }


  // onChange(data: ICD10, icdgroupName: any, event:Event) {
  //   data.primary= ((document.getElementById("primary_" + data.ICD10Code) as HTMLInputElement).checked);
  //   data.icdgroupName=icdgroupName;
  //   const isChecked = target.checked;
  //    this.IcdCodesArray = <FormArray> this.AddIcdForm.get('icdIDS');
  //   if (isChecked) {
  //     for (let i = 0; i < this.ICD10Group.length; i++) {
  //       if (this.ICD10Group[i].groupDescription == icdgroupName) {
  //         this.ICD10Group[i].count = this.ICD10Group[i].count + 1;
  //       }
  //     }
  //     this.IcdCodesArray.push(new FormControl(data));
  //   }
  //   else {
  //     for (let i = 0; i < this.ICD10Group.length; i++) {
  //       if (this.ICD10Group[i].groupDescription == icdgroupName) {
  //         this.ICD10Group[i].count = this.ICD10Group[i].count - 1;
  //       }
  //     }
  //  //  let index = this.IcdCodesArray.controls.findIndex(x => x.value.ICD10Code == data.ICD10Code)
  //   // this.IcdCodesArray.removeAt(index);
  //   }
  //   for (let i = 0; i < this.IcdCodesArray.length; i++) {
  //     //console.log(this.IcdCodesArray.at(i).value)
  //   }
  //   // this.IcdCodesArray.length == 0 ? this.buttonDisabled = true : this.buttonDisabled = false;
  // }

  onChange(data: any, icdgroupName: string, event: Event): void {
    const target = event.target as HTMLInputElement;
    const isChecked = target.checked;
    // console.log(data);
    this.filterICd.push(data);
    // console.log(data, icdgroupName, isChecked);
    //  this.filterICd=data;
     console.log(this.filterICd);
     
    
  }

  getAllICD10Groups() {
    this.encounterService.getAllICD10Groups()
      .subscribe(data => {
        console.log(ICD10Group);
        
        this.ICD10Group = data;
        
      })
  }

  getAllActiveTemplates() {
    this.templateService.getAllActiveTemplates()
      .subscribe(data => {
        console.log(data);
        
        this.templates = data;
      })
      
  }

  submitData() {
    console.log(this.filterICd);
   
    

    this.stateService.setData(this.filterICd)
    
    
   
    // this.router.navigate(['/addencounter/:id'], { state: { data: this.selectedItems } });
    //    this.isCheckedPrimaryFlag();
        if (!this.icdPrimaryErrorFlag) {
          this.primaryErrorFlag=true;
           let element: HTMLElement|any= document.getElementById("dismissmodal");
           element.click();
          if(this.IcdCodesArray>0){
            this.icdErrorFlag = false;
            this.hideTable = false;
          }
          else{
          this.icdErrorFlag = true
          this.hideTable = true;
          }
        }
      }

  



}
