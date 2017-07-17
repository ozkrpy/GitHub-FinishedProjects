import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'formateadorFecha'
})
export class FormateadorFechaPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return null;
  }

}
