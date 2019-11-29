#include "mainwindow.h"
#include <QPainter>
#include <QTimer>
#include <math.h>
#include <iostream>
#include <stdio.h>
#include <QVector>
#include "bola.h"
#include <QDebug>
MainWindow::MainWindow(QWidget * parent ,Qt::WindowFlags flags ) : QMainWindow(parent,flags) {

	QTimer * temporizador = new QTimer();
	/*programar el temporizador*/
	temporizador->setInterval(10);
	temporizador->setSingleShot(false);
	temporizador->start();
	/*arrancar el temporizador*/
	
	
	connect(temporizador,SIGNAL(timeout()),this, SLOT(slotRepintar()));
	
	resize(800,600);
	
	for(int i = 0; i<5; i++){
		velX = generador.bounded(-2,10);
		velY = generador.bounded(-2,10);
		posX = generador.bounded(0,800);
		posY = generador.bounded(0,600);
		bolas.append(new Bola(posX,posY,velX,velY));
	}
    
}



void MainWindow::paintEvent(QPaintEvent *e){
	
	
	QPainter pintor(this);
	
	for(int i = 0; i<bolas.size(); i++){
		bolas[i]->pintarBola(pintor, 40,40);
		bolas[i]->mover(height(),width());
		
		for(int j = 0; j<bolas.size(); j++){
			bolas[i]->chocar(*bolas[j]);
		}
	}
	
	
	
	
    		

}





void MainWindow::slotRepintar(void){
	
	update();	
	
}



