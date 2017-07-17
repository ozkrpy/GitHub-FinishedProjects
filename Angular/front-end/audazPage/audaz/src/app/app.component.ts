import { Component } from '@angular/core';
import { WsService } from './ws.service';
import { Observable } from 'rxjs';
import { Response } from '@angular/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  oscar: Observable<Response>;
  constructor(private ws: WsService) {
  }

  ngOnInit() {
    this.oscar = this.ws.holaMundo();
    console.log(this.oscar);
  }
}
