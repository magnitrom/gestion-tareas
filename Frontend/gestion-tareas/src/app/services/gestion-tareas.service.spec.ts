import { TestBed } from '@angular/core/testing';

import { GestionTareasService } from './gestion-tareas.service';

describe('GestionTareasService', () => {
  let service: GestionTareasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GestionTareasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
