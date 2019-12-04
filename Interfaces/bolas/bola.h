#ifndef BOLA_H
#define BOLA_H

#include <QPainter>
#include <QColor>


class Bola{

public:
        Bola(float , float , float , float );
	Bola(float , float , float , float , QColor);
	void pintarBola(QPainter &, float, float);
	void mover(float, float);
	void chocar(Bola &);
	float calcDistancia(Bola );
	QColor color;

private:
        float x;
	float y;
	float vX;
	float vY;
	
};

#endif 
