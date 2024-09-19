import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoryCompComponent } from './history-comp.component';

describe('HistoryCompComponent', () => {
  let component: HistoryCompComponent;
  let fixture: ComponentFixture<HistoryCompComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HistoryCompComponent]
    });
    fixture = TestBed.createComponent(HistoryCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
