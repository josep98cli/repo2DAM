#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QPaintEvent>
#include <bola.h>
#include <iostream>
#include <stdio.h>
#include <QVector>
#include <QRandomGenerator>
#include <QMenu>
#include <QAction>
#include "DInformacion.h"


class MainWindow : public QMainWindow {
Q_OBJECT
public:
        MainWindow(QWidget * parent = 0, Qt::WindowFlags flags = 0);
	void paintEvent(QPaintEvent * );
	

private:
        float posX;
	float posY;
	float velX;
	float velY;

	DInformacion *dialogo;
	Bola * b;
	QRandomGenerator generador;
	QVector<Bola*> bolas;
	QMenu * menuArchivo;
	QAction * accionInformacion;
        
public slots:

	void slotRepintar();
	void slotMostrarDialogoInfo();
	
};

#endif 
