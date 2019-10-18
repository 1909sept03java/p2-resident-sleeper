import { TestBed } from '@angular/core/testing';

import { CoinserviceService } from './coinservice.service';

describe('CoinserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CoinserviceService = TestBed.get(CoinserviceService);
    expect(service).toBeTruthy();
  });
});
