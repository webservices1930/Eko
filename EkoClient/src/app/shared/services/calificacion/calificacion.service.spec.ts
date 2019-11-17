import { TestBed } from '@angular/core/testing';

import { CalificacionService } from './calificacion.service';

describe('CalificacionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CalificacionService = TestBed.get(CalificacionService);
    expect(service).toBeTruthy();
  });
});
