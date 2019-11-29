#ifndef BOLA_H
#define BOLA_H

#include <QPainter>

class Bola{

public:
        Bola(float , float , float , float );
	void pintarBola(QPainter &, float, float);
	void mover(float, float);
	void chocar(Bola &);
	float calcDistancia(Bola );

private:
        float x;
	float y;
	float vX;
	float vY;


};

#endif 
