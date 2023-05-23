import { TestBed } from '@angular/core/testing';

import { GestionEstadosService } from './gestion-estados.service';

describe('GestionEstadosService', () => {
  let service: GestionEstadosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GestionEstadosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
