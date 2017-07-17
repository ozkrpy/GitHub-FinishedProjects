import { Component } from '@angular/core';
import {Router} from "@angular/router"; 

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Nutricion';

  constructor(private router: Router) {

  }

  goHome() {
     this.router.navigate(['']);
  }

  goAlimentos() {
     this.router.navigate(['alimentos']);
  }

  goPacientes() {
     this.router.navigate(['pacientes']);
  }

}
