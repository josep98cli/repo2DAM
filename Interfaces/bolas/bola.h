#ifndef BOLA_H
#define BOLA_H


class Bola{

public:
	
	float posX, posY;
	float velX, velY;
	
	Bola(float pX, float pY, float vX, float vY);
	void mover(int altura, int anchura);
	void chocar(Bola &otra);
	int distancia(Bola otra);
};

#endif
