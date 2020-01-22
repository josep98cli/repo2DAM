#ifndef BOLAYWIDGET_H
#define BOLAYWIDGET_H

#include "WidgetBola.h"
#include "bola.h"

class BolaYWidget : public WidgetBola, public Bola {

public:
	BolaYWidget(bool esJugador, float x, float y, float vX, float vY,float rad, QColor col, QWidget * parent = 0);
	
	BolaYWidget(bool esJugador, float x, float y, float vX, float vY,float rad, QWidget * parent = 0);
};

#endif
