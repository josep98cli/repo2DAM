
//Incluimos las librerias para poder pintar por pantalla
#include <stdio.h>
//libreria para printf

#include <iostream>
//libreria para cout

#include <stdlib.h>
//libreria para random

using namespace std;

void mostrarVector(int numsPasados[10])
{
	for (int x = 0; x < 10; x++)
	{
		cout << "Numero " << numsPasados[x] << ". Posició: " << x << endl; 
	}

}

float mostrarMedia(int numsPasados[10])
{
	float media = 0;
	for (int i = 0; i < 10; i++)
	{
		media += numsPasados[i];
	}
	media = media/10;
	return media;
}

int cogerPosMax(int numsPasados[10])
{
	int numMax= numsPasados[0];
	int pos=0;

	for (int i = 0; i < 10; i++)
	{
		if (numMax<numsPasados[i])
		{
			numMax = numsPasados[i];
		}
	}

	for (int x = 0; x < 10; x++)
	{
		if (numMax==numsPasados[x])
		{
			pos = x;
		}
		
	}
	return pos;
}

int cogerPosMin(int numsPasados[10])
{
	int numMin= numsPasados[0];
	int pos = 0;

	for (int i = 0; i < 10; i++)
	{
		if (numMin>numsPasados[i])
		{
			numMin = numsPasados[i];
		}
	}

	for (int x = 0; x < 10; x++)
	{
		if (numMin==numsPasados[x])
		{
			pos = x;
		}
		
	}
	return pos;
}


void intercambiarPosicion(int numeros[10], int pos1, int pos2)
{
	int aux;

	aux = numeros[pos1];
	numeros[pos1] = numeros[pos2];
	numeros[pos2] = aux;	
}

void repetitsVector(int numeros[10])
{
	int aux = numeros[0];
	bool repetits = false;

	for (int i = 0; i < 10; i++)
	{
		for (int y = 0; y < 10; y++)
		{
			if (numeros[i]==numeros[y] && y!=i)
			{
				repetits = true;
			}
			
		}
		
	}
	if (repetits)
	{
		cout << "Hi han repetits" << endl;
	}else{
		cout << "No hi han repetits" << endl;
	}
	
}

void ordenarVectorMajorAMenor(int numero[10]){

	for (int i = 0; i < 10; i++)
	{
		for (int y = 0; y < 10; y++)
		{
			
		}	
	}
	
}

int main(int argc, char *argv[] )
{
	int pos1 = 2;
	int pos2 = 5;
	int numeros[10];

	/*Inicialización*/

	int num;

	//plenar vector en random 
	/*for (int i = 0; i < 10; i++)
	{
		num = random() % 10;
		numeros[i]=num;
	}*/


	//Comprobacio si funciona el repetits o no 
	for (int i = 0; i < 10; i++)
	{
		numeros[i]=i;
	}
	
	/*Mostrar valor dels elements del vector*/
	//mostrarVector(numeros);
	cout << "La media es: " << mostrarMedia(numeros) << endl;
	cout << "La posición mayor es :" << cogerPosMax(numeros)<< endl;
	cout << "La posición menor es :" << cogerPosMin(numeros)<<endl;
	
	
	mostrarVector(numeros);
	cout << "---------" << endl;
	intercambiarPosicion(numeros, pos1, pos2);
	mostrarVector(numeros);
	
	repetitsVector(numeros);
	
	mostrarVector(numeros);
	ordenarVectorMajorAMenor(numeros);
	cout << "---------" << endl;
	mostrarVector(numeros);
}
