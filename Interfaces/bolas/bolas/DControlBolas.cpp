#include "DControlBolas.h"
#include "WidgetBola.h"

DControlBolas::DControlBolas(QVector<Bola*> * bolas, QWidget * parent):QDialog(parent){
	
	setupUi(this);
	tabBolas->clear();
	
	for (int i=0; i < bolas->size(); i++){
		tabBolas->insertTab(i, new WidgetBola(bolas->at(i)), QString("Bola") + QString::number(i));
	}

	connect(botonPararTodas, SIGNAL(clicked()),this, SLOT(pararTodasBolas()));
	connect(tabBolas, SIGNAL(currentChanged(int)), this, SLOT(slotBolaSeleccionada(int)));
}

void DControlBolas::pararTodasBolas(void){

	for (int i=0; i < tabBolas->count();i++){
		WidgetBola *wb = qobject_cast <WidgetBola * >(tabBolas->widget(i));
		wb->slotPararBola();
	}
	
}

void DControlBolas::slotBolaSeleccionada(int num){

	for (int i=0; i < tabBolas->count();i++){
		WidgetBola *wb = qobject_cast <WidgetBola * >(tabBolas->widget(i));
		wb -> bola -> resaltada = false;
	}

	
	Bola * aResaltar = (qobject_cast<WidgetBola*>(tabBolas->currentWidget()))->bola;
	aResaltar->resaltada = true;

	
}
