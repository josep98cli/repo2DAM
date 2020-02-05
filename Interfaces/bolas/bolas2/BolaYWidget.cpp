
#include "BolaYWidget.h"

BolaYWidget::BolaYWidget(bool esJugador, float px, float py, float velX, float velY, float r, QColor col, QWidget * parent): 
Bola(esJugador, px, py, velX, velY, r, col), WidgetBola(this, parent){
	
}

BolaYWidget::BolaYWidget(bool esJugador, float px, float py, float velX, float velY, float r,  QWidget * parent): 
Bola(esJugador, px, py, velX, velY, r), WidgetBola(this, parent){
	
}

