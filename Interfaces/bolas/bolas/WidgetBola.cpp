#include "WidgetBola.h"
#include <QColorDialog>


WidgetBola::WidgetBola(Bola * b, QWidget * parent):QDialog(parent){
	setupUi(this);
	
	bola =b;
	connect(botonParar, SIGNAL(clicked()),this, SLOT(slotPararBola()));
	connect(botonColor, SIGNAL(clicked()), this, SLOT(slotElegirColor()));

}

void WidgetBola::slotPararBola(){
	
	QString mov = botonParar->text();
	
	if (mov == "Parar Bola"){
		bola->vX=0;
		bola->vY=0;
		botonParar->setText("Mover Bola");
	}else{
		bola->vX=10;
		bola->vY=10;
		botonParar->setText("Parar Bola");
	}
	
}

void WidgetBola::slotElegirColor(){
	
	QColorDialog *dialogColor = new QColorDialog();
		dialogColor->open();
	QColor colorSelec =  dialogColor->getColor();
	bola->color=colorSelec;
		
}



