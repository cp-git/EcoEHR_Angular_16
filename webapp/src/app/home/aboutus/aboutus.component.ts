import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';
import { RequestDemo } from './request-for-demo';

@Component({
  selector: 'ehr-home-aboutus',
  templateUrl: './aboutus.component.html',
  styleUrls: ['../../../assets/css/styles.css']
})
export class AboutUsComponent implements OnInit {
  @ViewChild('homeSection') homeSection!: ElementRef;
  @ViewChild('aboutUsSection') aboutUsSection!: ElementRef;
  @ViewChild('demoRequestSection') demoRequestSection!: ElementRef;
  
  demoForm!: FormGroup;
  statusCode!: number;
  isSubmitting = false;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private loginService: LoginService
  ) { }

  ngOnInit(): void {
    this.demoForm = this.formBuilder.group({
      fname: [null, [Validators.required, Validators.minLength(3)]],
      lname: [null, Validators.required],
      email: [null, [Validators.required, Validators.email]],
      mobileNo: [null, [Validators.required, Validators.pattern(/^\d{10}$/)]],
      useFor: [null, Validators.required]
    });
  }

  // isFieldInvalid(field: string): boolean {
  //   const control = this.demoForm.get(field);
  //   return control?.invalid && control?.touched;
  // }

  isFieldInvalid(field: string): boolean {
    const control = this.demoForm.get(field);
    return !!control && control.invalid && control.touched;
  }
  

  onSubmit(): void {
    if (this.demoForm.valid) {
      this.isSubmitting = true;
      const demoObj = new RequestDemo(
        this.demoForm.get('fname')?.value.trim(),
        this.demoForm.get('lname')?.value.trim(),
        this.demoForm.get('email')?.value.trim(),
        this.demoForm.get('mobileNo')?.value,
        this.demoForm.get('useFor')?.value.trim()
      );

      this.loginService.requestForDemo(demoObj).subscribe({
        next: successCode => {
          this.statusCode = successCode;
          this.demoForm.reset();
          this.isSubmitting = false;
        },
        error: ErrorCode => {
          this.statusCode = ErrorCode;
          this.isSubmitting = false;
        }
      });
    }
  }

  scrollTo(section: 'home' | 'aboutUs' | 'demoRequest'): void {
    const sectionRef = this[`${section}Section`];
    sectionRef?.nativeElement.scrollIntoView({ behavior: 'smooth' });
  }

  navigateToLogin(): void {
    this.router.navigate(['/login']);
  }
}
