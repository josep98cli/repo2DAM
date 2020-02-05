#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QPaintEvent>
#include <QKeyEvent>
#include <QMouseEvent>
#include <QAction>
#include <BolaYWidget.h>
#include <iostream>
#include <stdio.h>
#include <QVector>


class MainWindow : public QMainWindow {
Q_OBJECT
	
public:
        MainWindow(QWidget * parent = 0, Qt::WindowFlags flags = 0);
	void paintEvent(QPaintEvent * );
	void keyPressEvent(QKeyEvent * e);
	void mouseDoubleClickEvent(QMouseEvent * e);
	void mouseReleaseEvent(QMouseEvent *e);
	void moverJugadorRaton(void);
	void dragEnterEvent(QDragEnterEvent * event);
	void dropEvent(QDropEvent *event);
	void mousePressEvent(QMouseEvent *event);
	void mouseMoveEvent(QMouseEvent *event);

	

private:
        float posX;
	float posY;
	float velX;
	float velY;
	float radio;
	float posRatonX;
	float posRatonY;
	void crearQActions();
	void crearMenus();
	int vidasJugador;	
	void performDrag();	

	QMouseEvent * eventoInicial;
	QAction * accionDialogo;
	QAction * accionExamen;
	QAction * accionTabla;
	QAction * accionControlBolas;
	QMenu * menuArchivo;
	QMenu * menuDialogos;
	Bola * jugador;
	QVector<Bola*> bolas;
	QPoint posSalida;
	QPoint startPos;
	QAction * accionGraficos;
	QAction * accionTreeView;
	
	
        
public slots:

	void slotRepintar();
	void slotDialogo();
	void slotExamen();
	void slotInfoTabla();
	void slotControlBolas();
	void slotGraficos();
	void slotTreeView();
};

#endif 
