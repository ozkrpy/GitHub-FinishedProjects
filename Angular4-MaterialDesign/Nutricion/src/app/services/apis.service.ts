import { Injectable } from '@angular/core';
import { Jsonp, Http, HttpModule, RequestOptions, Response, Headers, URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import * as moment from 'moment';

import { PacienteDetalle } from '../data-model/paciente-detalle';
import { Servidor } from '../data-model/datos-servidor';

@Injectable()
export class ApisService {

  apiRoot = 'http://' + Servidor[0].server.host + ':' + Servidor[0].server.port;
  
  constructor(private httpRequest: Http) { }

  todosLosPacientes(): Observable<PacienteDetalle[]> {
    let apiURL = `${this.apiRoot}` + Servidor[0].server.methods.pacientes;
    console.log("metodo recupera todos los pacientes: " + apiURL);
    return  this.httpRequest
                .get(apiURL)
                .map(
                      res => {
                        let result = res.json().map(
                          item => {
                            return new PacienteDetalle(
                              item.codigo_paciente,
                              item.nombre,
                              item.apellido,
                              item.sexo,
                              item.talla,
                              item.estado_civil,
                              item.fecha_nacimiento,
                              item.peso_actual,
                              item.peso_habitual,
                              item.peso_ajusta,
                              item.peso_saludable,
                              item.porcentaje_peso_ideal,
                              item.imc,
                              item.cia_muneca,
                              item.cia_brazo,
                              item.biotipo,
                              item.antecedente_obesidad,
                              item.antecedente_cardiopatias,
                              item.antecedente_hta,
                              item.antecedente_diabetes,
                              item.medicacion,
                              item.diagnostico_medico,
                              item.diagnostico_nutricional,
                              item.laboratorio_glicemia_basal,
                              item.laboratorio_creatinina,
                              item.laboratorio_proteinas_totales,
                              item.laboratorio_urea,
                              item.laboratorio_acido_urico,
                              item.laboratorio_proteinuria,
                              item.laboratorio_albumina,
                              item.laboratorio_triglicerios,
                              item.laboratorio_colesterol_total,
                              item.laboratorio_ldl,
                              item.laboratorio_hdl,
                              item.laboratorio_glucosa,
                              item.laboratorio_hb,
                              item.laboratorio_hematocrito,
                              item.laboratorio_globulos_rojos,
                              item.laboratorio_potasio,
                              item.laboratorio_ci,
                              item.laboratorio_na,
                              item.laboratorio_globulos_blancos,
                              item.laboratorio_hba,
                              item.cia_cintura1,
                              item.cia_cintura2)
                          });
                        return result;
                });
  }

  pacientePorCodigo(codigoPaciente: number): Observable<PacienteDetalle> {
    let apiURL = `${this.apiRoot}` + Servidor[0].server.methods.pacientePorId + codigoPaciente;
    return this.httpRequest
               .get(apiURL)
               .map((r: Response) => r.json() as PacienteDetalle) 
               .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  pacienteEditInfo(codigoPacienteParam: number, sexoParam: string, civilParam: string, fechaNacimientoParam) {
    let apiURL = `${this.apiRoot}` + Servidor[0].server.methods.pacienteEditarInfo;
    let body: any = {codigoPaciente: codigoPacienteParam, 
                     sexo: sexoParam, 
                     estadoCivil: civilParam, 
                     fechaNacimiento: fechaNacimientoParam};
    console.log("metodo que actualiza informacion del paciente: " + codigoPacienteParam + ", URL: " + apiURL + " Body: " + body);
    return this.httpRequest.post(apiURL, body)
    ;
  }

  pacienteEditPeso(codigoPacienteParam: number, nuevoActualParam: number, nuevoHabitualParam) {
    let apiURL = `${this.apiRoot}` + Servidor[0].server.methods.pacienteEditarPeso;
    let body: any = {codigoPaciente: codigoPacienteParam, nuevoActual: nuevoActualParam, nuevoHabitual: nuevoHabitualParam};
    console.log("metodo que actualiza el peso del paciente: " + codigoPacienteParam + ", URL: " + apiURL + " Body: " + body);
    return this.httpRequest.post(apiURL, body)
    ;
  }

  pacienteEditTalla(codigoPacienteParam: number, tallaParam: number, munecaParam: number, brazoParam: number, cintura1Param: number, cintura2Param: number) {
    let apiURL = `${this.apiRoot}` + Servidor[0].server.methods.pacienteEditarTalla;
    let body: any = {codigoPaciente: codigoPacienteParam, talla: tallaParam, muneca: munecaParam, brazo: brazoParam, cintura1: cintura1Param, cintura2: cintura2Param};
    console.log("metodo que actualiza talla del paciente: " + codigoPacienteParam + ", URL: " + apiURL + " Body: " + body);
    return this.httpRequest.post(apiURL, body)
    ;
  }

  pacienteEditAntecedente(codigoPacienteParam: number, obesidadParam: number, cardiopatiasParam: number, htaParam: number, diabetesParam: number, medicacionParam: string, medicoParam: string, nutricionistaParam: string) {
    let apiURL = `${this.apiRoot}` + Servidor[0].server.methods.pacienteEditarAntecedentes;
    let body: any = {codigoPaciente: codigoPacienteParam, 
                     obesidad: obesidadParam, 
                     cardiopatias: cardiopatiasParam, 
                     hta: htaParam, 
                     diabetes: diabetesParam, 
                     medicacion: medicacionParam,
                     medico: medicoParam, 
                     nutricionista: nutricionistaParam};
    console.log("metodo que actualiza antecedentes del paciente: " + codigoPacienteParam + ", URL: " + apiURL + " Body: " + body);
    return this.httpRequest.post(apiURL, body)
    ;
  }

  pacienteEditLaboratorio(codigoPacienteParam: number, glicemiaParam: number, creatininaParam: number, proteinasTotalesParam: number, ureaParam: number, acidoUricoParam: number, proteinuraParam: number, albuminaParam: number, trigliceridosParam: number, ldlParam: number, hdlParam: number, colesterolTotalParam: number, glucosaParam: number, hbParam: number, hematocritoParam: number, globulosRojosParam: number, globulosBlancosParam: number, potasioParam: number, ciParam: number, sodioParam: number, hbaParam: number) {
    let apiURL = `${this.apiRoot}` + Servidor[0].server.methods.pacienteEditarLaboratorio;
    let body: any = {codigoPaciente: codigoPacienteParam, 
                     glicemia: glicemiaParam,
                     creatinina: creatininaParam,
                     proteinasTotales: proteinasTotalesParam,
                     urea: ureaParam,
                     acidoUrico: acidoUricoParam,
                     proteinura: proteinuraParam,
                     albumina: albuminaParam,
                     trigliceridos: trigliceridosParam,
                     ldl: ldlParam,
                     hdl: hdlParam,
                     colesterolTotal: colesterolTotalParam,
                     glucosa: glucosaParam,
                     hb: hbParam,
                     hematocrito: hematocritoParam,
                     globulosRojos: globulosRojosParam,
                     globulosBlancos: globulosBlancosParam,
                     potasio: potasioParam,
                     ci: ciParam,
                     sodio: sodioParam,
                     hba: hbaParam};
    console.log("metodo que actualiza laboratorio del paciente: " + codigoPacienteParam + ", URL: " + apiURL + " Body: " + body.json);
    return this.httpRequest.post(apiURL, body)
    ;
  }

  pacientePesosIdeales(sexoParam: string, tallaParam: number): Observable<Object[]> {
    let apiURL = `${this.apiRoot}` + Servidor[0].server.methods.pacientePesoIdeal ;
    let body: any = {sexo: sexoParam,
                     talla: tallaParam};
    console.log("metodo que recupera los pesos ideales segun sexo y talla, URL: ", apiURL, " Body: ", body);
    return this.httpRequest
               .post(apiURL, body)
               .map((r: Response) => r.json()) 
               .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  pacienteAlta(paciente: PacienteDetalle) {
    let fechaNac = moment(paciente.fecha_nacimiento).format('YYYY-MM-DD');
    if (paciente.antecedente_obesidad) { paciente.antecedente_obesidad = true; } else { paciente.antecedente_obesidad = false; } 
    if (paciente.antecedente_cardiopatias) { paciente.antecedente_cardiopatias = true; } else { paciente.antecedente_cardiopatias = false; } 
    if (paciente.antecedente_hta) { paciente.antecedente_hta = true; } else { paciente.antecedente_hta = false; } 
    if (paciente.antecedente_diabetes) { paciente.antecedente_diabetes = true; } else { paciente.antecedente_diabetes = false; } 
    let apiURL = `${this.apiRoot}` + Servidor[0].server.methods.pacienteAlta;
    let body: any = {codigoParam: null,
                     nombreParam: paciente.nombre,
                     apellidoParam: paciente.apellido,
                     sexoParam: paciente.sexo,
                     tallaParam: paciente.talla,
                     civilParam: paciente.estado_civil,
                     nacimientoParam: fechaNac,
                     actualParam: paciente.peso_actual,
                     habitualParam: paciente.peso_habitual,
                     pesoAjustadoParam: paciente.peso_ajusta,
                     pesoSaludableParam: paciente.peso_saludable,
                     porcentajePesoIdealParam: paciente.porcentaje_peso_ideal,
                     imcParam: paciente.imc,
                     munecaParam: paciente.cia_muneca,
                     brazoParam: paciente.cia_brazo,
                     biotipoParam: paciente.biotipo,
                     obesidadParam: paciente.antecedente_obesidad,
                     cardiopatiasParam: paciente.antecedente_cardiopatias,
                     htaParam: paciente.antecedente_hta,
                     diabetesParam: paciente.antecedente_diabetes,
                     medicacionParam: paciente.medicacion,
                     medicoParam: paciente.diagnostico_medico,
                     nutricionistaParam: paciente.diagnostico_nutricional,
                     glicemiaBasalParam: paciente.laboratorio_glicemia_basal,
                     creatininaParam: paciente.laboratorio_creatinina,
                     proteinasTotalesParam: paciente.laboratorio_proteinas_totales,
                     ureaParam: paciente.laboratorio_urea,
                     acidoUricoParam: paciente.laboratorio_acido_urico,
                     proteinuraParam: paciente.laboratorio_proteinuria,
                     albuminaParam: paciente.laboratorio_albumina,
                     trigliceridosParam: paciente.laboratorio_triglicerios,
                     ldlParam: paciente.laboratorio_colesterol_total,
                     hdlParam: paciente.laboratorio_ldl,
                     colesterolTotalParam: paciente.laboratorio_hdl,
                     glucosaParam: paciente.laboratorio_glucosa,
                     hbParam: paciente.laboratorio_hb,
                     hematocritoParam: paciente.laboratorio_hematocrito,
                     globulosRojosParam: paciente.laboratorio_globulos_rojos,
                     globulosBlancosParam: paciente.laboratorio_potasio,
                     potasioParam: paciente.laboratorio_ci,
                     ciParam: paciente.laboratorio_na,
                     sodioParam: paciente.laboratorio_globulos_blancos,
                     hbaParam: paciente.laboratorio_hba,
                     cintura1Param: paciente.cia_cintura1,
                     cintura2Param: paciente.cia_cintura2};
    console.log("alta del paciente, URL: ", apiURL, " Body: ", body);
    return this.httpRequest.put(apiURL, body)
                           .map(res => { console.log(res); })
                           .catch((error:any) => Observable.throw(error.json().error || 'Server error')); 
  }

  eliminarPaciente(idPaciente: number) {
    let apiURL = `${this.apiRoot}` + Servidor[0].server.methods.pacienteEliminar ;
    let body: any = {codigoParam: idPaciente}; 
    console.log("metodo para eliminar un paciente: ", apiURL, " codigo paciente:", body);
    return this.httpRequest
               .post(apiURL, body)
               .map(res => { console.log("MAP inside API",res); })
               .catch((error:any) => Observable.throw(error.json() || 'catch en la API Server error')); 
  }
}
