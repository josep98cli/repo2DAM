#include <stdio.h>
#include <stdlib.h>
#include <iostream>

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

void inicializarCuentas(Cuenta * cuentas[10]){
   for (int i=0; i<10; i++) {
    cuentas[i]=NULL;
    }

	for (int i=0; i<5; i++) {
    Cuenta * temporal = new Cuenta(100+i, i*1000,nombres[i]);
    cuentas[i] = temporal;
    }

}

/*void inicializarCuentas(  Cuenta cuentas[10]){
   for (int i=0; i<10; i++) {
	Cuenta unaCueta(100+i,i*1000,nombres[i]);
	cuentas[i] = &unaCuenta
	}
}*/



void crearCuenta(Cuenta * cuentas[10]){
	cout << "introduce el titular" ;
	string tit;
	cin >> tit;
	cout << endl;

	cout << "introduce el numero de cuenta" ;
	int numCuenta;
	cin >> numCuenta;
	cout << endl;


	for (int i=0; i<10; i++)
		if (cuentas[i]==NULL)  { 
			cuentas[i] = new Cuenta(numCuenta,0.5,tit);
			break;
		}

}

void mostrar(Cuenta * cuentaMostrar){
    cout << "La cuenta " << cuentaMostrar->numCuenta 
	<< " de " << cuentaMostrar->titular
        << " tiene " << cuentaMostrar->saldo
	<<" euros " <<endl;
}

void mostrarCuentas(Cuenta * todas[]){

	for (int i = 0; i < 10; i++)
	{
		if (todas[i]!=NULL)
		{
			cout << "La cuenta " << todas[i]->numCuenta 
			<< " de " << todas[i]->titular
        	<< " tiene " << todas[i]->saldo
			<<" euros " <<endl;
		}
		
	}
}

Cuenta * mostrarCuentaConMasSaldo(Cuenta * cuentas[10]){

	Cuenta * cMaxima = cuentas[0];

	for(int i; cMaxima == NULL && i<10; i++, cMaxima=cuentas[i]);
	

	float saldoMax =cuentas[0]->saldo;
	for (int i = 0; i < 10 && cMaxima; i++)
	{
		if (cuentas[i] && cMaxima->saldo < cuentas[i]->saldo)
		{
			cMaxima=cuentas[i];
		}
	}
	
	return cMaxima;
}

Cuenta * seleccionarCuenta(Cuenta * cts[]) {
	cout << "méteme el numero de cuenta. Machote!" <<endl;
	int numCuenta ;
	cin >> numCuenta;
    for (int i = 0; i < 10; i++)
    {
        if (cts[i]!=NULL && cts[i]->numCuenta == numCuenta)
        {
            return cts[i];
        }
    }
  return NULL;  //EXPLICA ESTO devuelve null porque en caso de que no encuentre la cuenta hace que el puntero apunte a null y no salte error
	
}
void ingresar(Cuenta * c) {
	float cantidad;
	cout << "Dame la cantidad a ingresar en la cuenta "<< c->numCuenta << endl;
	cin >> cantidad;
	c->ingresar(cantidad);	
}

bool reintegrar(Cuenta * c) {
	float cantidad;
	cout << " Introduce la cantidad a reintegrar:" << endl;
	cin >> cantidad;
	bool resultado =  c->reintegrar(cantidad);
	return resultado;
}
int main (int argc, char *argv[] ) {

  Cuenta * cuentas[10];

  
  //for (int i=0; i < 10; i++) cuentas[i]=NULL;  // EXPLÍCATE ESTO

  Cuenta * cuentaSeleccionada;

  cuentaSeleccionada =  NULL;

  inicializarCuentas(cuentas);
  mostrarCuentas(cuentas);

  char opcion;
  while ( true ) {
   menu();
   cin >> opcion;
   switch (opcion) {
	case '1': // opción uno es la de seleccionar una cuenta
	        cuentaSeleccionada = seleccionarCuenta(cuentas);
			 if (cuentaSeleccionada)
			 	mostrar(cuentaSeleccionada);
			else
			{
				cout << "No existe la cuenta seleccionada" <<endl;
			}
			
		break;

	case '2': if (cuentaSeleccionada != NULL)
			ingresar(cuentaSeleccionada); 
			break;
	case '3': if ((cuentaSeleccionada!=NULL)&&(!reintegrar(cuentaSeleccionada))) 
			cout << "Error sacando pasta" << endl;
		  break;
	case '4': if (cuentaSeleccionada!=NULL ) mostrar(cuentaSeleccionada); break;
	case '5': cuentaSeleccionada = mostrarCuentaConMasSaldo(cuentas); cout <<"Cuenta con mas saldo seleccionada"<<endl; break;
	case '6': mostrarCuentas(cuentas); break;
	/*case '7': crearCuenta(cuentas);break;
	case '8': eliminarCuenta(cuentas,cuentaSeleccionada);
		  cuentaSeleccionada = NULL; break;*/
        case 'q': exit(0);
  };// switch
  cout << "Pulse una tecla y enter para seguir" << endl;
  cin >> opcion ;
 }//while
} // main