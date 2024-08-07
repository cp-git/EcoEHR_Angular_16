import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup,FormBuilder,Validators} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {Router} from '@angular/router';
import { Recover } from './recover';
import {RecoverService} from './recoverService'
import { Http } from '@angular/http/src/http';
declare const $: any;
@Component({
    selector: 'ehr-home-recover',
	templateUrl: './recover.component.html',
	styleUrls: ['../home.component.css']
	
})

export class RecoverComponent implements OnInit {

	statusCode: number;
	requestProcessing = false;
	idToUpdate = null;
	processValidation = false;
	isDisabled: boolean;
    ForgotLoginform: FormGroup;
	test: Date = new Date();

    constructor(private formBuilder: FormBuilder, private router: Router,private recoverService:RecoverService) { }

    ngOnInit() {
    	this.ForgotLoginform = this.formBuilder.group({
			email: [null, [Validators.required,Validators.pattern(".+@.+\\.[a-z]+")]],
		  });
		  
    }

    isFieldValid(form: FormGroup, field: string) {
	    return !form.get(field).valid && form.get(field).touched;
    }

	onSubmit() {
		if (this.ForgotLoginform.valid) {
			this.preProcessConfigurations();
		document.getElementById("submit").innerText="Processing";
		this.isDisabled=true;
	  let email = this.ForgotLoginform.get('email').value.trim();
	  if (this.idToUpdate === null) {  
	    //Handle create article
	    let article= new Recover(null, email);	  
	    this.recoverService.recoverPassword(article)
	      .subscribe(successCode => {
					this.statusCode = successCode;
					
			if(this.statusCode)
				{
					document.getElementById("submit").innerText="Submit";
					this.isDisabled=false;
				}
				   
			    },
				errorCode => {this.statusCode = errorCode
					if(this.statusCode){
						document.getElementById("submit").innerText="Submit";
						this.isDisabled=false;
					}
				});
				}
	  	} else {
	    	this.validateAllFormFields(this.ForgotLoginform);
		  }	
	}

	preProcessConfigurations() {
		this.statusCode = null;
		this.requestProcessing = true;   
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