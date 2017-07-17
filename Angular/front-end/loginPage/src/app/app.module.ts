import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';

import { WebservicesService } from '../app/webservices.service';
import { ListarAlimentosComponent } from './listar-alimentos/listar-alimentos.component';
import { DietasComponent } from './dietas/dietas.component';
import { MultiplicadorPipe } from './pipes/multiplicador.pipe';

import { AngularFontAwesomeModule } from 'angular-font-awesome/angular-font-awesome';
import { PacientesComponent } from './pacientes/pacientes.component';
import { routesClass } from './routes';
import { FormateadorFechaPipe } from './pipes/formateador-fecha.pipe';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListarAlimentosComponent,
    DietasComponent,
    MultiplicadorPipe,
    PacientesComponent,
    FormateadorFechaPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    JsonpModule,
    AngularFontAwesomeModule,
    RouterModule.forRoot(routesClass, {useHash: true})
  ],
  providers: [ WebservicesService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
