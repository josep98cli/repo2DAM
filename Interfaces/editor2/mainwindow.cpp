#include "mainwindow.h"
#include <QStatusBar>
#include <QMenuBar>
#include <QMessageBox>
#include <QMenu>
#include <QAction>
#include <QToolBar>
#include <QLabel>
#include <QDebug>
#include <QString>
#include <QTextCursor>
#include <QFileDialog>
#include <QFile>
#include <QTextStream>
#include <QTextBlock>
#include <QApplication>
#include <QTimer>



VentanaPrincipal::VentanaPrincipal(QWidget * parent ,Qt::WindowFlags flags ) : QMainWindow(parent,flags) {

        editorCentral = new QTextEdit(this);
        setCentralWidget(editorCentral);
     
	QTimer * temporizador = new QTimer();
	temporizador->setSingleShot(false);
	temporizador->setInterval(1000);

	connect(temporizador,SIGNAL(timeout()), this, SLOT(slotTemporizador()));
	temporizador->start();
	
	chart = new QChart();
	chartView = new QChartView(chart);

	setCentralWidget(chartView);
	
	serie = new QLineSeries();

	serie->append(1,1);
	serie->append(2,0);
	serie->append(4,2);
	chart->addSeries(serie);

	QValueAxis * axisY = new QValueAxis;
	axisY->setRange(0,7);
	axisY->setTitleText("Goles");	
	

	QValueAxis * axisX = new QValueAxis;
	axisX->setRange(0,5);
	axisX->setTitleText("Dias");

	chart->addAxis(axisY, Qt::AlignLeft);
	chart->addAxis(axisX, Qt::AlignBottom);
	
	serie->attachAxis(axisY);
	serie->attachAxis(axisX);
	
	chart->legend()->hide();
	serie->setName(QString("Maradona"));
	
	
	
	connect(serie, SIGNAL(hovered(const QPointF &,bool)),this,SLOT(slotResaltar(const QPointF &,bool)));

	chartView->setRenderHint(QPainter::Antialiasing);	

	resize(400,300);
}

void VentanaPrincipal::slotTemporizador(){

	int tamanyoSerie = serie->count();
	double coordX = serie->at(tamanyoSerie - 1).x();
	double coordY = serie->at(tamanyoSerie - 1).y();
	
	serie->replace(tamanyoSerie - 1, coordX, coordY + 0.5);
	
	QList<QAbstractAxis *> listaEjes = chart->axes(Qt::Vertical); 
	
	foreach (QAbstractAxis * eje, listaEjes){
		serie->detachAxis(eje);	
		chart->removeAxis(eje);
		
		delete eje;

		
	}
	
	QValueAxis * axisY = new QValueAxis;
	axisY->setRange(0,coordY+ 1.5 );
	axisY->setTitleText("Goles");
	chart->addAxis(axisY, Qt::AlignLeft);
	serie->attachAxis(axisY);


	QList<QAbstractAxis *> listaEjesX = chart->axes(Qt::Horizontal); 
	
	foreach (QAbstractAxis * eje, listaEjesX){
		serie->detachAxis(eje);	
		chart->removeAxis(eje);
		
		delete eje;

		
	}
	
	QValueAxis * axisX = new QValueAxis;
	axisX->setRange(0,coordX );
	axisX->setTitleText("Dias");
	chart->addAxis(axisX, Qt::AlignBottom);
	serie->attachAxis(axisX);

}

void VentanaPrincipal::slotResaltar(const QPointF &p, bool resaltado){
	QPen pen;

		if(resaltado){
			pen.setColor(Qt::red);
			pen.setWidth(4);			
		}else{
			pen.setColor(Qt::blue);
			pen.setWidth(3);		
		}

	serie->setPen(pen);
}



















