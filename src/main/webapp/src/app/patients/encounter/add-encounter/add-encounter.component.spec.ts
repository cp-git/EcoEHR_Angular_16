import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEncounterComponent } from './add-encounter.component';

describe('AddEncounterComponent', () => {
  let component: AddEncounterComponent;
  let fixture: ComponentFixture<AddEncounterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddEncounterComponent]
    });
    fixture = TestBed.createComponent(AddEncounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
