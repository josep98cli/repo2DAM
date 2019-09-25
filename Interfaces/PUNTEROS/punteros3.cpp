#include <stdio.h>
#include <iostream>

using namespace std;

void mostrar(int numsPasados[10]) {
    for (int i=0; i<10 ; i++ )
      cout  << numsPasados[i]
        << " "  ;
    cout << endl;
}


int * maximo (int *numeros, int *ultimaPosicion){
    
   // int *p= &numeros[0];
   

    /*for (int i = 0; i < 10; i++)
    {
       if (numeros[i]>aux)
       {
           p = &(numeros[i]);
           aux= numeros[i];
       }
    }
    return p;*/

     int * maxDir = numeros;
   while (numeros <= ultimaPosicion)
    {   
        
        if(*numeros>*maxDir){
            maxDir = numeros;
            cout << "*MAX DIR -->" <<*maxDir << endl;
            cout << "&MAX DIR -->" <<&maxDir <<endl;
        }
        cout << "*NUMEROS--> " <<*numeros <<endl;
        numeros++;
    }
    
    return maxDir;
}

int main (int argc, char *argv[] ) {

    int numeros[10] ;

    /* inicialización */
    for ( int i=0; i< 10 ; i++ ) {
       int numero =  rand() % 10;
       numeros[ i ] = numero;
    }
    mostrar(numeros);

    int * ultimo = &(numeros[9]);
    int * max = maximo(numeros, ultimo);

    *max = 0;
 
    mostrar(numeros);
    
}

