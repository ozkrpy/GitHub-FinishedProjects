import { Component, OnInit } from '@angular/core';
import { FormsModule, 
         FormGroup, 
         FormControl, 
         ReactiveFormsModule, 
         FormGroupName,
         FormControlName,
         Validators } from '@angular/forms';
import { Observable } from 'rxjs';

import { WebservicesService } from '../webservices.service';
import { Usuarios } from '../models/usuarios';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  myForm: FormGroup;
  username: FormControl;
  password: FormControl;
  private results: Observable<boolean>;
  lista: Observable<Usuarios[]>;
  trabajando: boolean = false;
  
  constructor(private ws: WebservicesService) {
    this.createFormControls();
    this.createForm();
  }

  ngOnInit() {
  }

  createFormControls() {
    this.username = new FormControl('',Validators.required);
    this.password = new FormControl('',[ 
      Validators.required,
      Validators.minLength(1)
    ]);
    
  }

  createForm() {
    this.myForm = new FormGroup({
      data: new FormGroup ({
        username: this.username,
        password: this.password
      })
    })
  }

  onSubmit() {
    this.trabajando = true;
    if (this.myForm.valid) {
      console.log("SUBMITIDO: ", this.myForm.value);
      // this.ws.validar(this.username.value, this.password.value)//this.username.value, this.password.value)
      //        .subscribe(data => {
      //           this.trabajando = false;
      //           console.log(data.json());
      //        });
      // this.ws.listaUsuarios(this.username.value, this.password.value)
      //        .subscribe( (data) => {
      //         	this.trabajando = false;
      //           this.lista = data;
      //        });
      this.lista = this.ws.listaUsuarios(this.username.value, this.password.value);
      this.trabajando = false;
      // this.myForm.reset;
      
    } else {
      console.log("Form invalido");
    }
  }

}
