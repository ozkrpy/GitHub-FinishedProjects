import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Dieta } from '../models/dieta';
import { Alimento } from '../models/alimento';
import { DetalleDieta } from '../models/detalledieta';
import { WebservicesService } from '../webservices.service';
import {
  FormsModule,
  FormGroup,
  FormControl,
  ReactiveFormsModule,
  FormGroupName,
  FormControlName,
  Validators
} from '@angular/forms';

@Component({
  selector: 'app-dietas',
  templateUrl: './dietas.component.html',
  styleUrls: ['./dietas.component.css']
})
export class DietasComponent implements OnInit {

  private listaDietas: Observable<Dieta[]>;
  private alimentos: Observable<DetalleDieta[]>;
  itemSeleccionado: any;
  selectedObject: any;
  sinDieta: boolean = true;
  ocultaColumnas: boolean = true;

  tablaDieta: DetalleDieta[];

  /*acumuladores para datos de dieta*/
  sumaHidratos: number = 0;
  sumaProteinas: number = 0;
  sumaGrasas: number = 0;
  sumaFibras: number = 0;
  sumaCalorias: number = 0;


  constructor(private ws: WebservicesService) {
  }

  ngOnInit() {
    this.listaDietas = this.ws.listaDietas();
  }



  buscarDetallesDieta() {
    console.log("dieta especifica");
  }

  onInput($event) {
    this.itemSeleccionado = $event.target.value;
    console.log('selected: ' + this.itemSeleccionado);
  }

  updateSelectedValue(event: string): void {
    this.selectedObject = JSON.parse(event);
    if (this.selectedObject === 0) {
      this.sinDieta = true;
      this.setCero();
    }
    else {
      this.sinDieta = false;
      this.alimentos = this.ws.listaDietasPorCodigo(this.selectedObject);
      console.log("recupero los alimentos de la dieta: " + this.alimentos);
      this.alimentos.subscribe(res => {
        console.log("subscripcion res: " + res);
        this.tablaDieta = res;
        // console.log(this.tablaDieta);
        this.actualizarAcumuladores(this.tablaDieta);
      });
    }
    console.log("evento " + this.selectedObject + ", " + this.sinDieta);
  }

  actualizarAcumuladores(datos: DetalleDieta[]) {
    this.setCero();
    for (let entry of datos) {

      console.log(entry["alimento"]["hidratos_carbono"]);
      this.sumaHidratos = this.sumaHidratos + (entry["alimento"]["hidratos_carbono"] * entry["dieta"]["cantidad_alimento"]);
      this.sumaProteinas = this.sumaProteinas + (entry["alimento"]["proteina"] * entry["dieta"]["cantidad_alimento"]);
      this.sumaGrasas = this.sumaGrasas + (entry["alimento"]["grasa"] * entry["dieta"]["cantidad_alimento"]);
      this.sumaFibras = this.sumaFibras + (entry["alimento"]["fibra"] * entry["dieta"]["cantidad_alimento"]);
      this.sumaCalorias = this.sumaCalorias + (entry["alimento"]["calorias"] * entry["dieta"]["cantidad_alimento"]);
    }
  }

  setCero() {
    this.sumaHidratos = 0;
    this.sumaProteinas = 0;
    this.sumaGrasas = 0;
    this.sumaFibras = 0;
    this.sumaCalorias = 0;
    this.ocultaColumnas = true;
  }

  mostrarColumnas() {
    this.ocultaColumnas = !this.ocultaColumnas;
  }

}
