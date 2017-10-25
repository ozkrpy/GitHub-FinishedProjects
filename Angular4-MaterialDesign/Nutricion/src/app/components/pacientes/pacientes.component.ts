import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ApisService } from '../../services/apis.service';
import { MatDialog } from '@angular/material';

import { PacienteDetallesComponent } from '../../dialogs/paciente-detalles/paciente-detalles.component';
import { CrearPacienteComponent } from '../../dialogs/crear-paciente/crear-paciente.component';

import { PacienteDetalle } from '../../data-model/paciente-detalle';

@Component({
  selector: 'app-pacientes',
  templateUrl: './pacientes.component.html',
  styleUrls: ['./pacientes.component.css']
})
export class PacientesComponent implements OnInit {
  dialogResult: string = "";
  
  todosLosPacientes: Observable<PacienteDetalle[]>;
  
  constructor(private ws: ApisService, 
              public dialog: MatDialog
             ) {
  }
 
  ngOnInit() {
    this.actualizaListaPacientes();
  }

  verDetallesPaciente(idPaciente: number) {
    let dialogRef = this.dialog.open( 
                                      PacienteDetallesComponent, 
                                      { width: '70%', height: '', data: idPaciente}
    );
    dialogRef.afterClosed().subscribe(result => {
                                        console.log(`Dialogo cerrado: ${result}`);
                                        this.dialogResult = result;
                                        this.actualizaListaPacientes();//this.todosLosPacientes = this.ws.todosLosPacientes();
    });
  }

  agregarPaciente() {
    console.log("agregar nuevo paciente");
    let dialogRef = this.dialog.open( 
                                     CrearPacienteComponent, 
                                     { width: '80%', height: ''}
    );
    dialogRef.afterClosed().subscribe(result => {
                                        console.log(`Dialogo cerrado: ${result}`);
                                        this.dialogResult = result;
                                        this.actualizaListaPacientes();
    });
  }

  actualizaListaPacientes() {
    this.todosLosPacientes = this.ws.todosLosPacientes();
  }
}
