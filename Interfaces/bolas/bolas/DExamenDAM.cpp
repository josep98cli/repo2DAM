#include "DExamenDAM.h"
#include <QMessageBox>
#include <QTimer>
#include <QColorDialog>
#include "bola.h";

DExamenDAM::DExamenDAM(QVector<Bola*> bolas,QWidget * parent) : QDialog(parent){

	setupUi(this);
	
	bolasMain = bolas;
	QTimer *timer = new QTimer(this);
      	connect(timer, SIGNAL(timeout()), this, SLOT(slotUpdate()));
      	timer->start(1000);
	
	connect(botonRealizar, SIGNAL(clicked()),this, SLOT(slotRealizar()));
	connect(spinBolas, SIGNAL(valueChanged(int)),this,SLOT(slotSpinBox(int)));
	connect(timer,SIGNAL(timeout()),this, SLOT(slotUpdate()));
	connect(rbYa, SIGNAL(clicked(bool)),this,SLOT(slotRadioButtons(bool)));
	connect(rbRato, SIGNAL(clicked(bool)),this,SLOT(slotRadioButtons(bool)));
	connect(comboAccion, SIGNAL(currentTextChanged(const QString)),this,
	SLOT(slotCambiarCombo(QString)));
	
	spinBolas->setRange(0,bolasMain.size());
	
}

void DExamenDAM::slotRadioButtons(bool checked){

	
	accionARealizar = comboAccion->currentText();
	QString cadena;

	if(rbYa->isChecked()){
	
		cadena = "Ya";
		map[accionARealizar]= 1 ;
		
	
	}else{
		cadena = "Para mas tarde";
		map[accionARealizar]= 2 ;
	}
	
	int r = QMessageBox::warning(this, tr("Vas a cambiar a ")+accionARealizar,
			cadena,
			QMessageBox::Yes | QMessageBox::No);

	
}

void DExamenDAM::slotCambiarCombo(QString cadena){

	int valorRadio = 1;

	if(cadena == comboAccion->itemText(0)){
	
		valorRadio = map.value(comboAccion->itemText(0));
		
	}else if(cadena == comboAccion->itemText(1)){
	
		valorRadio = map.value(comboAccion->itemText(1));
		
	}else if(cadena == comboAccion->itemText(2)){
	
		valorRadio = map.value(comboAccion->itemText(2));
		
	}
	
	if(valorRadio == 1){
		rbYa->setChecked(true);
		rbRato->setChecked(false);
	}else{
		rbRato->setChecked(true);
		rbYa->setChecked(false);
	}
	
		
}

void DExamenDAM::slotUpdate(){

	

}

void DExamenDAM::slotSpinBox(int valor){

	
	lcdBolas->display(valor);

}


void DExamenDAM::slotRealizar(){

	Bola * bolaSeleccionada;
	QString opcion = comboAccion->currentText();

	if(opcion == "Parar"){
	
		bolaSeleccionada = bolasMain.at(spinBolas->value());
		bolaSeleccionada->vX = 0;
		bolaSeleccionada->vY = 0;
		
	}else if(opcion == "ASignar color"){
	
		//QColorDialog::ShowAlphaChannel();
	}

}



















