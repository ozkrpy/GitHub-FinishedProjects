import { Injectable } from '@angular/core';
import { datos } from './models/sharedData';
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
import 'rxjs/add/operator/map';

@Injectable()
export class WsService {

  private apiRoot: string = 'http://' + datos.server.host + ':' + datos.server.port;
  
  constructor(private httpRequest: Http) { }

  holaMundo() {
    let apiURL = `${this.apiRoot}` + datos.server.methodAllAudio;
    console.log("hola mundo desde la aplicacion.", apiURL);
    return this.httpRequest.get(apiURL) // get es solo para http
      .map(data => {
        console.log("llamo a",datos.server.methodAllAudio);
        let results = data.json().map(data => {
          console.log(data.text);
        });
        return data;
      });
  }
}
