#include "bola.h"
#include <math.h>
#include <QPainter>

Bola::Bola(float  posX, float  posY, float velX, float velY)
{
	x = posX;
	y = posY;
	vX = velX;
	vY = velY;
	
}

void Bola::pintarBola(QPainter & pintor, float ancho, float alto){
	pintor.drawEllipse(x,y,ancho,alto);
    	
    	
    	
}

void Bola::mover(float altura, float anchura){
	/*Rebotes izquierda y derecha*/
    	
    	if(x > anchura-40){
    		vX = -fabs(vX);
    	}
    	
    	if(x <= 10 ){
    		vX = fabs(vX);
    	}
    	
    	x = x + vX;
    	
    	
    	/*Rebotes arriba y abajo*/
    	
    	if(y > altura-40){
    		vY = -fabs(vY);
    	}
    	
    	if(y <= 10 ){
    		vY = fabs(vY);
    	}
    	
    	y = y + vY;
}

void Bola::chocar(Bola & otra){
	Bola * izquierda;
	Bola * derecha;
	Bola * arriba;
	Bola * abajo;

	if(calcDistancia(otra) > 60) return;
	
	/* CHOQUE HORIZONTAL*/
	
	if(otra.x > x){
		derecha = &otra;
		izquierda = this;
	}else{
		derecha = this;
		izquierda = &otra;
	}
	
	
	if(izquierda->vX > derecha->vX){
		float aux = izquierda -> vX;
		izquierda->vX = derecha->vX;
		derecha->vX = aux;
	}
	
	/*CHOQUE VERTICAL*/
	
	if(otra.y > y){
		abajo = &otra;
		arriba = this;
	}else{
		arriba = &otra;
		abajo = this;
	}
	
	if(abajo->vY > arriba->vY){
		float aux2 = abajo -> vY;
		abajo->vY = arriba -> vY;
		arriba->vY = aux2;
	}	

}

float Bola::calcDistancia(Bola otra){
	float distancia;
	
	distancia = sqrt((powf(otra.x - x,2))+(powf(otra.y - y,2)));
	
	return distancia;
}











