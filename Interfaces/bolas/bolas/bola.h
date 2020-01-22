#ifndef BOLA_H
#define BOLA_H


class Bola{

public:
<<<<<<< HEAD:Interfaces/bolas/bola.h
	
	float posX, posY;
	float velX, velY;
	
	Bola(float pX, float pY, float vX, float vY);
	void mover(int altura, int anchura);
	void chocar(Bola &otra);
	int distancia(Bola otra);
=======
        Bola(bool, float , float , float , float, float);
        Bola(bool, float , float , float , float, float, QColor );
	 Bola(bool, float , float , float , float, float, QImage );
	void pintarBola(QPainter &);
	void mover(float, float);
	bool chocar(Bola &);
	float calcDistancia(Bola );
	static const int vidaInicial = 100;

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

private:

>>>>>>> master:Interfaces/bolas/bolas/bola.h
};

#endif
