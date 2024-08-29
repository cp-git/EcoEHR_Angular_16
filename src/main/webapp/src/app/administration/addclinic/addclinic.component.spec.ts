import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddclinicComponent } from './addclinic.component';

describe('AddclinicComponent', () => {
  let component: AddclinicComponent;
  let fixture: ComponentFixture<AddclinicComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddclinicComponent]
    });
    fixture = TestBed.createComponent(AddclinicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
