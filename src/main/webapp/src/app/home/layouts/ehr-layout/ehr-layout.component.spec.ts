import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EhrLayoutComponent } from './ehr-layout.component';

describe('EhrLayoutComponent', () => {
  let component: EhrLayoutComponent;
  let fixture: ComponentFixture<EhrLayoutComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EhrLayoutComponent]
    });
    fixture = TestBed.createComponent(EhrLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
