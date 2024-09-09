import { CommonModule } from '@angular/common';
import { Component, Inject } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MAT_DIALOG_DATA, MatDialog, MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { Router } from '@angular/router';

import { TimerModule } from 'src/app/components/timer/timer.module';
import { MasterLookup } from 'src/app/patients/models/masterLookup';
import { MasterLookupService } from 'src/app/patients/services/masterLookupService';

@Component({
  selector: 'app-add-master-look-up',
  templateUrl: './add-master-look-up.component.html',
  styleUrls: ['./add-master-look-up.component.css'],
  standalone: true,
  imports: [FormsModule ,CommonModule,TimerModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatSelectModule,MatDatepickerModule,MatDialogModule,MatIconModule],

})
export class AddMasterLookUpComponent {

  masterLookUp: MasterLookup = new MasterLookup();

  masterLookUpType: MasterLookup[] = [];

  constructor(
    public dialog: MatDialog,
    public dialogRef: MatDialogRef<AddMasterLookUpComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private addMasterLookUp: MasterLookupService,
    private _route:Router,
    private  masterLookupService:MasterLookupService
  ) {
    dialogRef.disableClose = true;
  }

  ngOnInit(){

    this.getMasterLookupType();

  }



  getMasterLookupType() {
    this.masterLookupService.getAllMasterLookupType()
        .subscribe((master: any) => {
            console.log(master);
            this.masterLookUpType=master;
            
            
        });
}

createMaster(master:MasterLookup){
  this.masterLookupService.insertMasterLookup(master).subscribe(
    data=>{
      alert("added Successfully...")
      console.log(data);
      
    }
  )

}





}
