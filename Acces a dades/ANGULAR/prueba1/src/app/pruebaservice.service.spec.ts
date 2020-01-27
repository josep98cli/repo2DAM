import { TestBed } from '@angular/core/testing';

import { PruebaserviceService } from './pruebaservice.service';

describe('PruebaserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PruebaserviceService = TestBed.get(PruebaserviceService);
    expect(service).toBeTruthy();
  });
});
