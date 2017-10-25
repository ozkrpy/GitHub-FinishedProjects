import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PacienteDetallesComponent } from './paciente-detalles.component';

describe('PacienteDetallesComponent', () => {
  let component: PacienteDetallesComponent;
  let fixture: ComponentFixture<PacienteDetallesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PacienteDetallesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PacienteDetallesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
