import { TestBed } from '@angular/core/testing';

import { MasterLookupServiceService } from './master-lookup-service.service';

describe('MasterLookupServiceService', () => {
  let service: MasterLookupServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MasterLookupServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
