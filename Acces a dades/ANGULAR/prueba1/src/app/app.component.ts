import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  nombre:string = 'Josep';
  edad:number = 16;
  numeros:number[]=[2,4,5];

  contador:number = 1;

  direccion():string{
      
      return 'Calle';
  }

  incrementar(){
    this.contador++;
  }

  decrementar(){
    this.contador--;
  }
}
