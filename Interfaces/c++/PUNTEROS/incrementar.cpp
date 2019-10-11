#include <stdio.h>
#include <iostream>

using namespace std;


/* El metode incrementar no funcionaria ja que en C les variables es pasen per copia, aleshores per a poder incrementar 
una variable en un metode necessitem pasar la direccio de memória de ka variable i amb un punter podem incrementarla. */


void incrementar(int numero) {
    numero++;
}

void incrementar2(int * p){
    (*p)++;
}

void incrementar3(int & numero){
    numero++;
}

int &maxNum(int &a, int &b){
    if (a>b)
    {
        return a;
    }
    return b;
}
int * max(int *uno, int *dos){

    if (*uno > *dos) return uno;
    else return dos;

}

int main(int argc, char *argv[]){

    int i=0;
    int a = 5;
    int b = 9;
    
    //el & en una declaracio de variable significa una referencia
    
    cout << "i vale " << i << " antes de incrementar " << endl;

    incrementar3(i);

    cout << "i vale " << i << " despues de incrementar " << endl;
 //incrementado numero mayor con punteros
    int * devueltoPuntero = max(&a, &b);
    
    (*devueltoPuntero)++;

    cout << "b vale : " << b <<endl;

//incrementado numero mayor con referencia
    int &devuelto = maxNum(a,b);
    devuelto++;

    cout << "El valor maximo es incrementado es: "<< b <<endl;
}