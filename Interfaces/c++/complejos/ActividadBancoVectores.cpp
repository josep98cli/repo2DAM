#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <vector>

#define BORRAPANTALLA(X) for (int i=0; i<X; i++, cout << endl);

using namespace std;

char * nombres[]={"juan","perico","andres","ramona","luci","pepi","mari","vengano","fulano","sotano"};

class Cuenta {
public:
    string titular;
    int numCuenta;
    float saldo;

    Cuenta(int numCuenta,float saldoInicial, string titular){
	this->numCuenta = numCuenta;
	saldo = saldoInicial;
	this->titular = titular;
    }
 
    Cuenta(){}

    bool  reintegrar(float cantidad){
	  if (cantidad > this->saldo) return false;
	  this->saldo -= cantidad;
	  return true;
	}
    void ingresar(float cantidad) { this->saldo += cantidad; }
private:
    float interes;
};


void menu(void){
	BORRAPANTALLA(40);
	cout << "        1 - Elegir Cuenta " << endl;
	cout << "        2 - Ingresar " << endl;
	cout << "        3 - Reintegrar " << endl;
	cout << "        4 - Ver saldo " << endl;
	cout << "        5 - Seleccionar la cuenta con más saldo " << endl;
	cout << "        6 - mostrar Todas las cuentas "<< endl;
	cout << "        7 - Crear una cuenta nueva " << endl;
	cout << "        q - Salir a MSDOS " << endl;

	cout << " Pulsa una opción "<< endl;
	BORRAPANTALLA(10);
}

void inicializarCuentas(vector <Cuenta> & cuentas){
	
    for (int i=0; i<5; i++) {
    cuentas.push_back(Cuenta(100+i, i*1000,nombres[i]));
    }

}


void mostrar(Cuenta cuentaMostrar){
    cout << "La cuenta " << cuentaMostrar.numCuenta 
	<< " de " << cuentaMostrar.titular
        << " tiene " << cuentaMostrar.saldo
	<<" euros " <<endl;
}

void mostrarCuentas(vector <Cuenta> todas){

	for (int i = 0; i < todas.size(); i++)
	{
			mostrar(todas[i]);		
	}
}


int main (int argc, char *argv[] ) {
  vector <Cuenta> cuentas; 

  inicializarCuentas(cuentas);
  mostrarCuentas(cuentas);

} // main