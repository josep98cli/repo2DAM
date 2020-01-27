import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PruebaserviceService {

  constructor() {
  }

  retornar(){
      
    return['Josep', 'Pepe', 'Juan'];
  }
}
