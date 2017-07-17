/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { WebservicesService } from './webservices.service';

describe('WebservicesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [WebservicesService]
    });
  });

  it('should ...', inject([WebservicesService], (service: WebservicesService) => {
    expect(service).toBeTruthy();
  }));
});
