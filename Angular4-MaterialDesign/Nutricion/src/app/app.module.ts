import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms'

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {  
  MatButtonModule, 
  MatMenuModule, 
  MatToolbarModule, 
  MatIconModule, 
  MatCardModule, 
  MatGridListModule, 
  MatDialogModule,
  MatInputModule,
  MatExpansionModule,
  MatSelectModule,
  MatDatepickerModule,
  MatNativeDateModule,  
  MatCheckboxModule,
  MatTabsModule,
  MatStepperModule,
  MatProgressSpinnerModule,
  MatSnackBarModule
} from '@angular/material';
import 'hammerjs';

import { routesClass } from './rutas.navegacion';

import { ApisService } from './services/apis.service';

import { AppComponent } from './app.component';
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import { PacientesComponent } from './components/pacientes/pacientes.component';
import { AlimentosComponent } from './components/alimentos/alimentos.component';
import { DietasComponent } from './components/dietas/dietas.component';
import { PacienteDetallesComponent } from './dialogs/paciente-detalles/paciente-detalles.component';
import { CrearPacienteComponent } from './dialogs/crear-paciente/crear-paciente.component';


@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    PacientesComponent,
    AlimentosComponent,
    DietasComponent,
    PacienteDetallesComponent,
    CrearPacienteComponent,
  ],
  imports: [
    BrowserModule,
    HttpModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule, 
    MatMenuModule, 
    MatToolbarModule, 
    MatIconModule, 
    MatCardModule, 
    MatGridListModule, 
    MatDialogModule,
    MatInputModule,
    MatExpansionModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,  
    MatCheckboxModule,
    MatTabsModule,
    MatStepperModule,
    MatProgressSpinnerModule,
    MatSnackBarModule,
    RouterModule.forRoot(routesClass, { useHash: true })
  ],
  providers: [
    ApisService
  ],
  entryComponents: [
    PacienteDetallesComponent,
    CrearPacienteComponent
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
