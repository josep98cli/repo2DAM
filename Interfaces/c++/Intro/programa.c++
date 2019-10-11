
//Incluimos las librerias para poder pintar por pantalla
#include <stdio.h>
//libreria para printf

#include <iostream>
//libreria para cout

using namespace std;

int main(int argc, char *argv[] )
{
	int a= 'w';

	cout << "teclea un numero\n";
	cin >> a;
	
	//cin es la manera de pedir el valor de una variable por teclado
	
	//PROGRAMA PARA COMPROBAR SI EL NUMERO ES MAYOR O MENOR QUE DIEZ
/*	cout << "El valor de la variable a es " << a << endl;

	if (a<10){
		cout << "\n El valor de la variable a es menor que 10 \n";
	}else{
		cout << "\n El valor de la variable a es mayor que 10 \n";	
	}*/

	
//Se concatena strings con <<
	
	for (int cont=1; cont<11; cont++){
		cout << cont * a << "=" << cont << "*" << a << "\n";	
	}

	//Este for de abajo hace lo mismo que el anterior pero es una manera de en una sola linia meter todo el for.

	/*for (int cont=0; cont++<10;
		cout << cont * a << "=" << cont << "*" << a << "\n");*/	
	
	

	//cout sirve para mostrar datos por pantallas
	
}
