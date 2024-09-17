import { TestBed } from '@angular/core/testing';

import { StateServicesService } from './state-services.service';

describe('StateServicesService', () => {
  let service: StateServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StateServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
