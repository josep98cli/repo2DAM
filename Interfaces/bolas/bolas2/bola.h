#ifndef BOLA_H
#define BOLA_H

#include <QPainter>

class Bola{

public:
        Bola(bool, float , float , float , float, float);
        Bola(bool, float , float , float , float, float, QColor );
	Bola(bool, float , float , float , float, float, QImage );
	void pintarBola(QPainter &);
	void mover(float, float);
	bool chocar(Bola &);
	float calcDistancia(Bola );
	static const int vidaInicial = 100;
	static int numBolas;
	int numBola;

	int vida;
        float x;
	float y;
	float vX;
	float vY;
	float radio;
	bool jugador;
	QColor color;
	bool resaltada = false;
	QImage imagen;
	int numColisiones;
	QVector <Bola*> bolasHijas;
	Bola * padre;
	bool pintarImg;

private:

};

#endif 
