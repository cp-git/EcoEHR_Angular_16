import { Component } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import * as moment from 'moment';
import { MasterLookup } from 'src/app/administration/master-lookup/masterLookup';
import { StaffMember } from 'src/app/administration/staff-members/staffmember';
import { StaffRole } from 'src/app/administration/staff-members/staffrole';
import { MasterLookupService } from 'src/app/patients/services/masterLookupService';
import { StaffMemberService } from 'src/app/patients/services/staffmemberservice';

@Component({
  selector: 'app-student-registration',
  templateUrl: './student-registration.component.html',
  styleUrls: ['./student-registration.component.css']
})
export class StudentRegistrationComponent {
  registerForm!: FormGroup;
  value = false;
  statusCode: any;
  buttonName!: string;
  providerType_search: string = '';
  flag: boolean = false;
  allProviderTypes!: MasterLookup[];

  constructor(private masterLookupService:MasterLookupService ,
    private formBuilder: FormBuilder,
    private staffMemberService:StaffMemberService
  ){
  }


  ngOnInit(){
    this.getProviderTypes();

    this.registerForm = this.formBuilder.group({
      firstName: [null, [Validators.required, Validators.maxLength(50)]],
      lastName: [null, [Validators.required, Validators.maxLength(50)]],
      gender: [null, [Validators.required]],
      dob: [null, [Validators.required]],
      other: [null, [Validators.maxLength(50)]],
      providerType: [null, [Validators.required, Validators.maxLength(50)]],
      mobileNo: [null, [Validators.required, Validators.minLength(12)]],
      email: [null, [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]]
    });
  }


  getProviderTypes() {
    this.masterLookupService.getSpecializationTypes()
      .subscribe(data => {
        this.allProviderTypes = data;
      });
  }

  onsubmit(event: any) {
      console.log("callleddd..........." + this.registerForm.valid);
  
      //  console.log("callleddd iffffffffff...........");
        (<HTMLInputElement>document.getElementById("save")).disabled = true;
        let firstName = this.registerForm.get('firstName')?.value;
        console.log(firstName);
        let lastName = this.registerForm.get('lastName')?.value
        let gender = this.registerForm.get('gender')?.value
        let dob = moment.utc((document.getElementById("dob") as HTMLInputElement).value).toDate();
        let email = this.registerForm.get('email')?.value
        let mobileNo = this.registerForm.get('mobileNo')?.value;
        let pType = this.registerForm.get('providerType')?.value;
        let other = "";
  
         let loginId = firstName;
        // let staffImage = "";
         let providerType = "";
  
        // if (pType == 'Others') {
        //   other = this.registerForm.get('other').value.trim();
        //   providerType = other;
        // } else {
        //   providerType = pType;
        // }
  
  
        let staffMemToInsert = new StaffMember(0, loginId, "password", firstName, '', lastName,
          null, providerType, "TRY_ME", "N", 0, false, 1,
          mobileNo, "", email, "", "", "", "", "", dob, "", dob, "", "", "",
          "", "", "", "", dob, dob, gender, "");
        console.log(staffMemToInsert)
        this.staffMemberService.insertStaffMember(staffMemToInsert)
          .subscribe(data => {
            //console.log(data.staffId)
            let staffRoleToInsert = new StaffRole(0, data.staffId, "TRY_ME", true, dob, "", dob, "");
            this.staffMemberService.insertStaffRole(staffRoleToInsert)
              .subscribe(sucessCode => {
                alert("added...")
                this.statusCode = sucessCode;
  
                
              });
               
          });
  
  
  
      //       ErrorCode => {
      //         (<HTMLInputElement>document.getElementById("save")).disabled = false;
      //         this.statusCode = ErrorCode;
      //         console.log("statusCode Value  " +this.statusCode)
      //         this.setTimeOut();
        
            
      //       })
  
  
      // }
      // else {
      //   this.validateAllFormFields(this.registerForm);
      // }
        
        }
  
  
    

}
