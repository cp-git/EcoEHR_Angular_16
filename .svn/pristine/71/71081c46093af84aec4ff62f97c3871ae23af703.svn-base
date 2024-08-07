import { Component, OnInit, NgModule } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators, AbstractControl} from '@angular/forms';
// import { MdModule } from '../../shared/md/md.module';
import { EHRModule, MaterialModule } from '../../app.module';
import {MatFormFieldModule} from '@angular/material/form-field';
import {Router, ActivatedRoute} from '@angular/router';
import { FormControlName } from '@angular/forms/src/directives/reactive_directives/form_control_name';
import {passwordValidation} from './passwordMatch.component';
import {ResetService} from './resetService';
import { Reset } from './reset';


declare const $: any;
interface FileReaderEventTarget extends EventTarget {
    result: string;
}

interface FileReaderEvent extends Event {
    target: FileReaderEventTarget;
    getMessage(): string;
}


@Component({
    selector: 'ehr-home-reset',
    templateUrl: './reset.component.html',
    styleUrls: ['../home.component.css']
})

export class ResetComponent implements OnInit {
    resetForm: FormGroup;
    test: Date = new Date();
    token : String;
    statusCode: number;
    resetStatusCode: number;
    isDisabled: boolean;
    userid:number;
    onload=true;

    ngOnInit()
    {
        if(this.onload)
        {
            this.activatedRoute.queryParams.subscribe(params => {
                this.token = params['token'];
                console.log(this.token)
           });
           this.checkToken(this.token);
         }
        
    }

    constructor(private activatedRoute: ActivatedRoute,private formBuilder: FormBuilder, private router: Router,private resetService:ResetService)    {

        


        this.resetForm = this.formBuilder.group({
            newpassword: [null, [Validators.required, Validators.pattern("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}")]],
            confirmpassword: [null, [Validators.required]]
        },
        {
            validator: passwordValidation.passMatch
        }
    );
    }

    isFieldValid(form: FormGroup, field: string) {
	    return !form.get(field).valid && form.get(field).touched;
    }

     checkToken(token)
     {
        this.resetService.checkToken(token)
           .subscribe(
                  successCode => this.statusCode = successCode,
                  errorCode =>  this.statusCode = errorCode);   
     }
 

    onSubmit() {
		if (this.resetForm.valid){
            document.getElementById("submit").innerText="Processing";
		    this.isDisabled=true;
            let password = this.resetForm.get('newpassword').value.trim();
            let reset= new Reset(this.token, password);	 
            this.resetService.updatePassword(reset)
            .subscribe(successCode => {
                this.resetStatusCode = successCode;
                
        if(this.resetStatusCode===201)
            {
                document.getElementById("submit").innerText="Sent";
            }
               
            },
            errorCode => this.resetStatusCode = errorCode);
            
            
	  	} else {
            this.validateAllFormFields(this.resetForm);	
	  	}
    }

    preProcessConfigurations() {
		this.statusCode = null;  
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
}