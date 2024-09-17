import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientHeaderComponent } from './patient-header.component';

describe('PatientHeaderComponent', () => {
  let component: PatientHeaderComponent;
  let fixture: ComponentFixture<PatientHeaderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PatientHeaderComponent]
    });
    fixture = TestBed.createComponent(PatientHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
