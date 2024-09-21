import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanAssementComponent } from './plan-assement.component';

describe('PlanAssementComponent', () => {
  let component: PlanAssementComponent;
  let fixture: ComponentFixture<PlanAssementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PlanAssementComponent]
    });
    fixture = TestBed.createComponent(PlanAssementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
