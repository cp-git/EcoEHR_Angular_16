import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMedicationsComponent } from './add-medications.component';

describe('AddMedicationsComponent', () => {
  let component: AddMedicationsComponent;
  let fixture: ComponentFixture<AddMedicationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddMedicationsComponent]
    });
    fixture = TestBed.createComponent(AddMedicationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
