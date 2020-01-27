#include "DialogoGraficos.h"


DialogoGraficos::DialogoGraficos(QVector<Bola*> *bolasPasadas, QWidget * parent):QDialog(parent){
	setupUi(this);
	bolas = bolasPasadas;

	QTimer * temporizador = new QTimer();
	temporizador->setSingleShot(false);
	temporizador->setInterval(1000);
	
	connect(temporizador,SIGNAL(timeout()), this, SLOT(slotTemporizador()));
	temporizador->start();

	bs1 = new QBarSet("Bola");
	bs1->setLabel("1");

	series = new QBarSeries();
	series->append(bs1);


	chart = new QChart();
	chart->addSeries(series);
	chart->setTitle("Boles");
	chart->setAnimationOptions(QChart::SeriesAnimations);
	
	
	
	for (int i= 0; i < bolas->size(); i++){
		categories.append(QString("Bola: ")+QString::number(i));
		bs1->append(bolas->at(i)->numColisiones);
	}
	
	QBarCategoryAxis * axisX = new QBarCategoryAxis();
	axisX->append(categories);
	chart->addAxis(axisX, Qt::AlignBottom);
	series->attachAxis(axisX);	
	
	QValueAxis * axisY = new QValueAxis();
	axisY->setRange(0,15);
	chart->addAxis(axisY, Qt::AlignLeft);
	series->attachAxis(axisY);
	
	chartView = new QChartView(chart);
	
	series->setName(QString("Bolas"));
	
	chartView->setRenderHint(QPainter::Antialiasing);

	gridLayout = new QGridLayout();
	gridLayout->addWidget(chartView,0,0);
	setLayout(gridLayout);
	
}

void DialogoGraficos::slotTemporizador(){

	for (int i= 0; i < bolas->size(); i++){
		categories.append(QString("Bola: ")+QString::number(i));
		bs1->replace(i,bolas->at(i)->numColisiones);
	}
	
}

