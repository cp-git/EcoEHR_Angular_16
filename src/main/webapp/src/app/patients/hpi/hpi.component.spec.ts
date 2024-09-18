import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HpiComponent } from './hpi.component';

describe('HpiComponent', () => {
  let component: HpiComponent;
  let fixture: ComponentFixture<HpiComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HpiComponent]
    });
    fixture = TestBed.createComponent(HpiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
