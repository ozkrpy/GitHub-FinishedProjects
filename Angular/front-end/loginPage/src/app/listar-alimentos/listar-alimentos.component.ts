import { Component, OnInit } from '@angular/core';
import {
          FormsModule,
          FormGroup,
          FormControl,
          ReactiveFormsModule,
          FormGroupName,
          FormControlName,
          Validators
       } from '@angular/forms';
import { WebservicesService } from '../webservices.service';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/switchMap';
import 'rxjs/add/operator/do';
import { Alimento } from '../models/alimento';


@Component({
  selector: 'app-listar-alimentos',
  templateUrl: './listar-alimentos.component.html',
  styleUrls: ['./listar-alimentos.component.css']
})
export class ListarAlimentosComponent implements OnInit {

  myForm: FormGroup;
  alimento: FormControl;
  private results: Observable<Alimento[]>;
  private loading: boolean = false;
  
  constructor(private ws: WebservicesService) {
  }

  ngOnInit() {
    this.alimento = new FormControl('', [
                                          Validators.required,
                                          Validators.minLength(1)
                                        ]);
    this.results = this.alimento.valueChanges
        .debounceTime(400)
        .distinctUntilChanged()
        .do ( () => this.loading = true) //para que maneje propiedades locales en el ejemplo el texto loading
        .switchMap( term => this.ws.listaAlimentos(term) ) // une el map y switch para evitar 2 emits
        .do ( () => this.loading = false) //para que maneje propiedades locales en el ejemplo el texto loading
        ;
  }

}
