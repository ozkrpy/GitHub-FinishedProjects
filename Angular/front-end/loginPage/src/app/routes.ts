import { Routes, RouterModule } from '@angular/router';
import { DietasComponent } from './dietas/dietas.component';
import { PacientesComponent } from './pacientes/pacientes.component';
import { ListarAlimentosComponent } from './listar-alimentos/listar-alimentos.component';

export const routesClass: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', component: DietasComponent },
    { path: 'pacientes', component: PacientesComponent },
    { path: 'alimentos', component: ListarAlimentosComponent },
    { path: '**', component: DietasComponent }
];