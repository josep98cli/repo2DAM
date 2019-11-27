
#include <QTimer>
#include <QPainter>
#include <math.h>
#include "mainwindow.h"


MainWindow::MainWindow(QWidget * parent ,Qt::WindowFlags flags ) : QMainWindow(parent,flags){
	
	QTimer *temporizador = new QTimer();

	/*programar el temporizador*/
	temporizador->setInterval(100);
	temporizador->setSingleShot(false);
	temporizador->start();

	/*arrancar el temporizador*/
	connect(temporizador,SIGNAL(timeout()), this, SLOT(slotRepintar()));


	resize(800,600);
	posX = posY = (rand()%500)+1;
	 
}


void MainWindow::paintEvent(QPaintEvent *e){
	
	QPainter pintor(this);
	/*Rebotes izquierda y derecha*/
	if(posX>=780)
		velX = -fabs(velX);
		
	
	if(posX<=10)
		velX= fabs(velX);

	
	posX =posX+velX;

	/*Rebotes arriba y abajo*/
	if(posY>=580)
		velY = -fabs(velY);
		
	if(posY<=20)
		velY = fabs(velY);
		
	posY = posY + velY;

	pintor.drawEllipse(posX,posY,20,20);	
}


void MainWindow::slotRepintar(){
	update();

}
