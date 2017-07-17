import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'multiplicador'
})
export class MultiplicadorPipe implements PipeTransform {

  transform(value: number, cantidad: number): number {
    let porCantidad = 0;
    if (value > 0)
      porCantidad = value * cantidad
    
    return porCantidad;
  }

}
