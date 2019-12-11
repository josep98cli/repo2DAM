#ifndef BOLA_H
#define BOLA_H

#include <QPainter>

class Bola{

public:
        Bola(bool, float , float , float , float, float );
        Bola(bool, float , float , float , float, float, QColor );
	void pintarBola(QPainter &);
	void mover(float, float);
	bool chocar(Bola &);	
	
	float calcDistancia(Bola );
	float radio;
	int vida;
        float x;
	float y;
	float vX;
	float vY;
	float vidaIncial;
	bool jugador;
	QColor color;


};

#endif 
