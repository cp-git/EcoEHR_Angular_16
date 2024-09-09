import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMasterLookUpComponent } from './add-master-look-up.component';

describe('AddMasterLookUpComponent', () => {
  let component: AddMasterLookUpComponent;
  let fixture: ComponentFixture<AddMasterLookUpComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddMasterLookUpComponent]
    });
    fixture = TestBed.createComponent(AddMasterLookUpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
