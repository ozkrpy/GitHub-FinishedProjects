import { Component, OnInit } from '@angular/core';
import { WebservicesService } from '../webservices.service';
import { Observable } from 'rxjs';
import { Paciente } from '../Models/paciente';

@Component({
  selector: 'app-pacientes',
  templateUrl: './pacientes.component.html',
  styleUrls: ['./pacientes.component.css']
})
export class PacientesComponent implements OnInit {

  private listaPacientes: Observable<Paciente[]>;
  
  constructor(private ws: WebservicesService) {
  }

  ngOnInit() {
    this.listaPacientes = this.ws.listaPacientes();
  }

}
