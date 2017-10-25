import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-alimentos',
  templateUrl: './alimentos.component.html',
  styleUrls: ['./alimentos.component.css']
})
export class AlimentosComponent implements OnInit {

  private loading: boolean = false;
  
  constructor() { }

  ngOnInit() {
    this.loading = true;
  }

}
