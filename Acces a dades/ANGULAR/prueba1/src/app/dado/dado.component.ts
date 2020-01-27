import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-dado',
  templateUrl: './dado.component.html',
  styleUrls: ['./dado.component.css']
})
export class DadoComponent implements OnInit {

  @Input() numero;
  @Output() es6 = new EventEmitter();

  constructor() { }

  ngOnInit() {
      if(this.numero == 6){
        this.es6.emit("Ha sacado un 6");
      }

  }

  lanzarDado(){ 
    this.numero = Math.trunc(Math.random()*6) + 1;
  }

}
