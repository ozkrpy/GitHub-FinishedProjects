import { Dieta } from '../Models/dieta';
import { Alimento } from '../Models/alimento';
import { ReferenciasXDieta } from '../Models/referenciasxdieta';

export class DetalleDieta {
    constructor(private dieta: Dieta
                ,private alimento: Alimento
                // ,private referencias: ReferenciasXDieta
               ) {

    }
}