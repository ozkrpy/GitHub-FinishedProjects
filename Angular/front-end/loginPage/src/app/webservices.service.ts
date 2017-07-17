import { Injectable } from '@angular/core';
import {
  Jsonp,
  Http,
  HttpModule,
  RequestOptions,
  Response,
  Headers,
  URLSearchParams
} from '@angular/http';
import { Observable } from 'rxjs';
import { Usuarios } from '../app/models/usuarios';
import { Alimento } from '../app/models/alimento';
import { Dieta } from '../app/models/dieta';
import { DetalleDieta } from '../app/models/detalledieta';
import { Paciente } from '../app/models/paciente';
let data = require('../app/Models/serverData');

@Injectable()
export class WebservicesService {

  private apiRoot: string = 'http://' + data.server.host + ':' + data.server.port;//'http://localhost:8000/';
  results: Usuarios[];

  constructor(private httpRequest: Http) {
  
  }

  validar(u: string, p: string) {
    // console.log("WS metodo validar: " + u + ", " + p);
    let apiURL = `${this.apiRoot}` + data.server.methods.helloWorld;
    console.log("WS " + apiURL);
    return this.httpRequest.get(apiURL) // get es solo para http
      .map(data => {
        console.log("llamo al http request map");
        let results = data.json().map(data => {
          console.log(data.text);
        })
          ;
        return data;
      })
      // //...errors if any
      // .catch((error:any) => Observable.throw(error.json().error || 'Server error'))
      ;
    //return null;
  }

  listaUsuarios(u: string, p: string): Observable<Usuarios[]> {
    console.log("WS metodo listaUsuarios");
    let apiURL = `${this.apiRoot}users`;

    return this.httpRequest.get(apiURL) // get es solo para http
      .map(
      res => {
        console.log("MAP1: " + res.json().results);
        let result = res.json().map(
          item => {
            console.log("MAP2: " + item);
            return new Usuarios(
              0,
              item.usuario,
              item.palabra_clave
            )
          });
        console.log("SearchService: " + result);
        return result;
      });

  }


  listaDietas(): Observable<Dieta[]> {
    console.log(`WebSide WS` + data.server.methods.dietas);
    let apiURL = `${this.apiRoot}` + data.server.methods.dietas;
    // let search = new URLSearchParams();
    // search.set('busqueda', texto);
    // console.log("parametro de busqueda: " + texto);
    return this.httpRequest.get(apiURL) //, {search} get es solo para http
      .map(
      res => {

        // console.log("MAP1: " + res.json().results);
        let result = res.json().map(
          item => {
            // console.log("MAP2 codigo_dieta: " + item.codigo_dieta + ", codigo_alimento: " + item.codigo_alimento);
            return new Dieta(item.codigo_dieta,
              item.codigo_alimento,
              item.cantidad_alimento,
              item.numero_item
            )
          });
        console.log("Resultado dietas: " + result);
        return result;
      });
  }

  listaPacientes(): Observable<Paciente[]> {
    console.log("WS metodo listaPacientes");
    let apiURL = `${this.apiRoot}pacientes`;
    // let search = new URLSearchParams();
    // search.set('busqueda', texto);
    // console.log("parametro de busqueda: " + texto);
    return this.httpRequest.get(apiURL) //, {search} get es solo para http
      .map(
      res => {

        // console.log("MAP1: " + res.json().results);
        let result = res.json().map(
          item => {
            // console.log("MAP2 codigo_dieta: " + item.codigo_dieta + ", codigo_alimento: " + item.codigo_alimento);
            return new Paciente(
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
              item.cia_cintura2
            )
          });
        console.log("Resultado dietas: " + result);
        return result;
      });
  }

  listaDietasPorCodigo(texto: string): Observable<DetalleDieta[]> {
    console.log("WS metodo listaDietasPorCodigo para dieta: " + texto);
    let apiURL = `${this.apiRoot}dietas/` + texto;
    // let search = new URLSearchParams();
    // search.set('busqueda', texto);
    console.log("URL: " + apiURL + ", codigo dieta length " + texto.length);
    if (texto.length !== null) {
      return this.httpRequest.get(apiURL) //, {search} get es solo para http
        .map(
        res => {

          console.log("MAP1: " + res.json().results);
          let result = res.json().map(
            item => {
              console.log("MAP2 unidad_medida_potasio: " + item.unidad_medida_potasio);
              return new DetalleDieta(
                new Dieta(item.codigo_dieta,
                  item.codigo_alimento,
                  item.cantidad_alimento,
                  item.numero_item),
                new Alimento(item.codigo_alimento,
                  item.descripcion_alimento,
                  item.tipo_alimento,
                  item.medida_casera,
                  item.medida_casera_unidad,
                  item.medida_real,
                  item.medida_real_unidad,
                  item.hidratos_carbono,
                  item.unidad_medida_hidratos_carbono,
                  item.proteina,
                  item.unidad_medida_proteina,
                  item.grasa,
                  item.unidad_medida_grasa,
                  item.sodio,
                  item.unidad_medida_sodio,
                  item.potasio,
                  item.unidad_medida_potasio,
                  item.fosforo,
                  item.unidad_medida_fosforo,
                  item.calcio,
                  item.unidad_medida_calcio,
                  item.hierro,
                  item.unidad_medida_hierro,
                  item.colesterol,
                  item.unidad_medida_colesterol,
                  item.purinas,
                  item.unidad_medida_purinas,
                  item.fibra,
                  item.unidad_medida_fibra,
                  item.agua,
                  item.unidad_medida_agua,
                  item.calorias)
              )
            });
          console.log("Resultado dietas: " + result);
          return result;
        });
    }
    return Observable.of([]);


  }

  listaAlimentos(texto: string): Observable<Alimento[]> {
    console.log("WS metodo listaAlimentos");
    let apiURL = `${this.apiRoot}alimentosPorDescripcion/` + texto;
    // let search = new URLSearchParams();
    // search.set('busqueda', texto);
    // console.log("parametro de busqueda: " + texto);
    if (texto.length > 0) {
      return this.httpRequest.get(apiURL) //, {search} get es solo para http
        .map(
        res => {

          console.log("MAP1: " + res.json().results);
          let result = res.json().map(
            item => {
              console.log("MAP2: " + item);
              return new Alimento(
                item.codigo_alimento,
                item.descripcion_alimento,
                item.tipo_alimento,
                item.medida_casera,
                item.medida_casera_unidad,
                item.medida_real,
                item.medida_real_unidad,
                item.hidratos_carbono,
                item.unidad_medida_hidratos_carbono,
                item.proteina,
                item.unidad_medida_proteina,
                item.grasa,
                item.unidad_medida_grasa,
                item.sodio,
                item.unidad_medida_sodio,
                item.potasio,
                item.unidad_medida_potasio,
                item.fosforo,
                item.unidad_medida_fosforo,
                item.calcio,
                item.unidad_medida_calcio,
                item.hierro,
                item.unidad_medida_hierro,
                item.colesterol,
                item.unidad_medida_colesterol,
                item.purinas,
                item.unidad_medida_purinas,
                item.fibra,
                item.unidad_medida_fibra,
                item.agua,
                item.unidad_medida_agua,
                item.calorias
              )
            });
          console.log("Resultado: " + result);
          return result;
        });
    }
    return Observable.of([]);


  }

  dummy(text: string): Observable<Alimento[]> {
    let obs = Observable
      .interval(1000)
      .take(3)
      .map(v => text);
    return null;
  }

}
