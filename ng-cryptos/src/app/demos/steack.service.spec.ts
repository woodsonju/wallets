import { TestBed, inject } from '@angular/core/testing';

import { SteackService } from './steack.service';

describe('SteackService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SteackService]
    });
  });

  it('should be created', inject([SteackService], (service: SteackService) => {
    expect(service).toBeTruthy();
  }));
});
