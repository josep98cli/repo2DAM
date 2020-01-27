import { Component, ViewChild } from '@angular/core';
import { DadoComponent } from './dado/dado.component';
import { PruebaserviceService } from './pruebaservice.service';
import { runInThisContext } from 'vm';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  constructor (private pruebaServicio: PruebaserviceService){
    
  }
  nombre:string = 'Josep';
  edad:number = 19;
  numeros:number[]=[2,4,5];
  nombres = null;
  contador:number = 1;
  mensaje = "No ha acertado";

  @ViewChild('dado1', null) dado1: DadoComponent;

  lanzar(){
    this.dado1.lanzarDado();
  }
  direccion():string{
      
      return 'Calle';
  }

  incrementar(){
    this.contador++;
  }

  decrementar(){
    this.contador--;
  }

  actualizarMensaje(auxMensaje){

      this.mensaje = auxMensaje;

  }

  ngOnInit():void{
    this.nombres = this.pruebaServicio.retornar();
  }

}
