import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA, MatSnackBar } from '@angular/material';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { MatCheckbox } from '@angular/material';

import { ApisService } from '../../services/apis.service';

import { PacienteDetalle } from '../../data-model/paciente-detalle';

import { SexosArray, EstadoCivil } from '../../data-model/datos-varios';

@Component({
  selector: 'app-paciente-detalles',
  templateUrl: './paciente-detalles.component.html',
  styleUrls: ['./paciente-detalles.component.css']
})
export class PacienteDetallesComponent implements OnInit {

  detallePacienteObservable: Observable<PacienteDetalle>;

  sexos = SexosArray;
  estadosCiviles = EstadoCivil;

  statusEditInfo: boolean = true;
  panelEditInfo: boolean = false;

  statusEditPeso: boolean = true;
  panelEditPeso: boolean = false;

  statusEditTalla: boolean = true;
  panelEditTalla: boolean = false;

  statusEditAntecedente: boolean = true;
  panelEditAntecedente: boolean = false;

  statusEditLaboratorio: boolean = true;
  panelEditLaboratorio: boolean = false;

  constructor(
    public thisDialogRef: MatDialogRef<PacienteDetallesComponent>,
    @Inject(MAT_DIALOG_DATA)
    public data: number,
    private ws: ApisService,
    public snackbar: MatSnackBar) { }

  ngOnInit() {
    this.actualizaDatosPaciente(this.data);
  }

  editInfoPaciente(idPaciente: number, sexo: string, sexoNuevo: string, civil: string, civilNuevo: string, fechaNacimiento: Date, fechaNacimientoNueva: Date) {
    console.log("editar datos personales del paciente.", idPaciente, sexo, sexoNuevo, civil, civilNuevo, fechaNacimiento, fechaNacimientoNueva);
    if (sexo != sexoNuevo
      || civil != civilNuevo
      || this.comparaFechas(fechaNacimiento, fechaNacimientoNueva)) {
      let fechaNac = moment(fechaNacimientoNueva).format('YYYY-MM-DD');
      this.ws.pacienteEditInfo(idPaciente, sexoNuevo, civilNuevo, fechaNac)
        .subscribe(res => {
          this.openSnackbar('Los datos personales del paciente han sido actualizados.');
          this.actualizaDatosPaciente(idPaciente);
        });
      //setea a abierto el expansion del panel de informacion 
      this.panelEditInfo = true;
      this.panelEditPeso = false;
      this.panelEditTalla = false;
      this.panelEditAntecedente = false;
      this.panelEditLaboratorio = false;
    }
    this.statusEditInfo = !this.statusEditInfo;
  }

  editPesoPaciente(idPaciente: number, actualAntes: number, actualDespues: number, habitualAntes: number, habitualDespues: number) {
    if (actualAntes != actualDespues
      || habitualAntes != habitualDespues) {
      this.ws.pacienteEditPeso(idPaciente, actualDespues, habitualDespues)
        .subscribe(res => {
          this.openSnackbar('Los datos de peso del paciente han sido actualizados.');
          this.actualizaDatosPaciente(idPaciente);
        });
      //setea a abierto el expansion del panel de peso 
      this.panelEditInfo = false;
      this.panelEditPeso = true;
      this.panelEditTalla = false;
      this.panelEditAntecedente = false;
      this.panelEditLaboratorio = false;
    }
    this.statusEditPeso = !this.statusEditPeso;
  }

  editTallaPaciente(idPaciente: number, tallaVieja: number, talla: number, ciaMunecaVieja: number, muneca: number, ciaBrazoVieja: number, brazo: number, ciaCintura1Vieja: number, cintura1: number, ciaCintura2Vieja: number, cintura2: number) {
    console.log("editar talla y medidas del paciente.", tallaVieja, talla, ciaMunecaVieja, muneca, ciaBrazoVieja, brazo, ciaCintura1Vieja, cintura1, ciaCintura2Vieja, cintura2);
    if (tallaVieja != talla
      || ciaMunecaVieja != muneca
      || ciaBrazoVieja != brazo
      || ciaCintura1Vieja != cintura1
      || ciaCintura2Vieja != cintura2) {
      this.ws.pacienteEditTalla(idPaciente, talla, muneca, brazo, cintura1, cintura2)
        .subscribe(res => {
          this.openSnackbar('Los datos de talla y medidas del paciente han sido actualizados.');
          this.actualizaDatosPaciente(idPaciente);
        });
      //setea a abierto el expansion del panel 
      this.panelEditInfo = false;
      this.panelEditPeso = false;
      this.panelEditTalla = true;
      this.panelEditAntecedente = false;
      this.panelEditLaboratorio = false;
    }
    this.statusEditTalla = !this.statusEditTalla;
  }

  editAntecedentePaciente(idPaciente: number, antecedenteObesidad: number, obesidad, antecedenteCardiopatias: number, cardiopatias, antecedenteHta: number, hta, antecedenteDiabetes: number, diabetes, antecedenteMedicacion: string, medicacion: string, AntecedenteDiagnosticoMedico: string, medico: string, antecedenteDiagnosticoNutricional: string, nutricionista: string) {
    console.log("editar antedecedentes del paciente:", idPaciente, "obesidad antes", antecedenteObesidad, "despues", obesidad, "cardiopatia antes", antecedenteCardiopatias, "despues", cardiopatias, "hta antes", antecedenteHta, "despues", hta, "diabetes antes", antecedenteDiabetes, "despues", diabetes, "medicacion antes", antecedenteMedicacion, "despues", medicacion, "medico antes", AntecedenteDiagnosticoMedico, "despues", medico, "nutricionista antes", antecedenteDiagnosticoNutricional, "despues", nutricionista);
    if (obesidad) { obesidad = 1 } else { obesidad = 0; }
    if (cardiopatias) { cardiopatias = 1 } else { cardiopatias = 0; }
    if (hta) { hta = 1 } else { hta = 0; }
    if (diabetes) { diabetes = 1 } else { diabetes = 0; }
    if (antecedenteObesidad != obesidad
      || antecedenteCardiopatias != cardiopatias
      || antecedenteHta != hta
      || antecedenteDiabetes != diabetes
      || antecedenteMedicacion != medicacion
      || AntecedenteDiagnosticoMedico != medico
      || antecedenteDiagnosticoNutricional != nutricionista) {
      this.ws.pacienteEditAntecedente(idPaciente, obesidad, cardiopatias, hta, diabetes, medicacion, medico, nutricionista)
        .subscribe(res => {
          this.openSnackbar('Los datos de antecedentes del paciente han sido actualizados.');
          this.actualizaDatosPaciente(idPaciente);
        });
      //setea a abierto el expansion del panel 
      this.panelEditInfo = false;
      this.panelEditPeso = false;
      this.panelEditTalla = false;
      this.panelEditAntecedente = true;
      this.panelEditLaboratorio = false;
    }
    this.statusEditAntecedente = !this.statusEditAntecedente;
  }

  editLaboratorioPaciente(datosPaciente: PacienteDetalle, glicemia, creatinina, proteinasTotales, urea, acidoUrico, proteinura, albumina, trigliceridos, ldl, hdl, colesterolTotal, glucosa, hb, hematocrito, globulosRojos, globulosBlancos, potasio, ci, sodio, hba) {
    console.log("editar laboratorio del paciente.", datosPaciente.codigo_paciente, datosPaciente.laboratorio_glicemia_basal, glicemia, datosPaciente.laboratorio_creatinina, creatinina, datosPaciente.laboratorio_proteinas_totales, proteinasTotales, datosPaciente.laboratorio_urea, urea, datosPaciente.laboratorio_acido_urico, acidoUrico, datosPaciente.laboratorio_proteinuria, proteinura, datosPaciente.laboratorio_albumina, albumina, datosPaciente.laboratorio_triglicerios, trigliceridos, datosPaciente.laboratorio_ldl, ldl, datosPaciente.laboratorio_hdl, hdl, datosPaciente.laboratorio_colesterol_total, colesterolTotal, datosPaciente.laboratorio_glucosa, glucosa, datosPaciente.laboratorio_hb, hb, datosPaciente.laboratorio_hematocrito, hematocrito, datosPaciente.laboratorio_globulos_rojos, globulosRojos, datosPaciente.laboratorio_globulos_blancos, globulosBlancos, datosPaciente.laboratorio_potasio, potasio, datosPaciente.laboratorio_ci, ci, datosPaciente.laboratorio_na, sodio, datosPaciente.laboratorio_hba, hba);
    if (datosPaciente.laboratorio_glicemia_basal != glicemia
      || datosPaciente.laboratorio_creatinina != creatinina
      || datosPaciente.laboratorio_proteinas_totales != proteinasTotales
      || datosPaciente.laboratorio_urea != urea
      || datosPaciente.laboratorio_acido_urico != acidoUrico
      || datosPaciente.laboratorio_proteinuria != proteinura
      || datosPaciente.laboratorio_albumina != albumina
      || datosPaciente.laboratorio_triglicerios != trigliceridos
      || datosPaciente.laboratorio_ldl != ldl
      || datosPaciente.laboratorio_hdl != hdl
      || datosPaciente.laboratorio_colesterol_total != colesterolTotal
      || datosPaciente.laboratorio_glucosa != glucosa
      || datosPaciente.laboratorio_hb != hb
      || datosPaciente.laboratorio_hematocrito != hematocrito
      || datosPaciente.laboratorio_globulos_rojos != globulosRojos
      || datosPaciente.laboratorio_globulos_blancos != globulosBlancos
      || datosPaciente.laboratorio_potasio != potasio
      || datosPaciente.laboratorio_ci != ci
      || datosPaciente.laboratorio_na != sodio
      || datosPaciente.laboratorio_hba != hba) {
      this.ws.pacienteEditLaboratorio(datosPaciente.codigo_paciente, glicemia, creatinina, proteinasTotales, urea, acidoUrico, proteinura, albumina, trigliceridos, ldl, hdl, colesterolTotal, glucosa, hb, hematocrito, globulosRojos, globulosBlancos, potasio, ci, sodio, hba)
        .subscribe(res => {
          this.openSnackbar('Los datos de laboratorio del paciente han sido actualizados.');
          this.actualizaDatosPaciente(datosPaciente.codigo_paciente);
        });
      //setea a abierto el expansion del panel de peso 
      this.panelEditInfo = false;
      this.panelEditPeso = false;
      this.panelEditTalla = false;
      this.panelEditAntecedente = false;
      this.panelEditLaboratorio = true;

    }

    this.statusEditLaboratorio = !this.statusEditLaboratorio;
  }

  eliminarPaciente(idPaciente: number) {
    this.ws.eliminarPaciente(idPaciente)
           .subscribe(res => {
             console.log(res);
             this.openSnackbar('El paciente ha sido dado eliminado correctamente');
             this.thisDialogRef.close('Delete patient');
           }, err => {
             console.log("[ERROR] component PacienteDetalle", err);
             this.openSnackbar('El paciente cuenta con dietas activas, no se puede eliminar.');
             this.thisDialogRef.close('Delete patient');
           });
  }

  actualizaDatosPaciente(idPaciente: number) {
    this.detallePacienteObservable = this.ws.pacientePorCodigo(this.data)
      .map(res => {
        res[0].fecha_nacimiento = new Date(res[0].fecha_nacimiento);
        return res;
      });
  }

  comparaFechas(fechaVieja, fechaNueva) {
    let momentoFechaVieja = moment(fechaVieja).format('DD/MM/YYYY');
    let momentoFechaNueva = moment(fechaNueva).format('DD/MM/YYYY');
    if (momentoFechaVieja != momentoFechaNueva)
      return true;
    else
      return false;
  };

  openSnackbar(message: string) {
    this.snackbar.open(message, "OK", { duration: 5000 });
  }

  onCloseCancel() {
    this.thisDialogRef.close('Cancel');
  }

}
