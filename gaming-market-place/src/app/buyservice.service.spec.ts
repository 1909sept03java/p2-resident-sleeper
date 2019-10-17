import { TestBed } from '@angular/core/testing';

import { BuyserviceService } from './buyservice.service';

describe('BuyserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BuyserviceService = TestBed.get(BuyserviceService);
    expect(service).toBeTruthy();
  });
});
