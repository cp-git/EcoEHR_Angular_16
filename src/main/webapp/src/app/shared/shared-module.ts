import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FieldErrorDisplayComponent } from './field-error-display/field-error-display.component';
import { SearchPipe } from '../patients/search.pipe';


@NgModule({ 
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    
    
  ],
  declarations: [
    FieldErrorDisplayComponent,
    
  ],
  exports: [
    FieldErrorDisplayComponent,
    
    
  ]
})

export class SharedModule {}
