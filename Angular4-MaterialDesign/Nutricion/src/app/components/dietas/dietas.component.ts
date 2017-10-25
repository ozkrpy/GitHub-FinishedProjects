import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dietas',
  templateUrl: './dietas.component.html',
  styleUrls: ['./dietas.component.css']
})
export class DietasComponent implements OnInit {
  
  private loading: boolean = false;
  
  constructor() {

  }

  ngOnInit() {
    this.loading = true;
  }


}
