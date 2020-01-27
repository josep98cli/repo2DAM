#ifndef DIALOGOGRAFICOS_H
#define DIALOGOGRAFICOS_H

#include "ui_DialogoGraficos.h"
#include <QBarCategoryAxis>
#include <QBarSet>
#include <QBarSeries>
#include <QChart>
#include <QChartView>
#include <QTextEdit>
#include <QGridLayout>
#include <QValueAxis>
#include "bola.h"
#include <QTimer>

QT_CHARTS_USE_NAMESPACE
class DialogoGraficos : public QDialog, public Ui::DialogoGraficos {

Q_OBJECT

public:
	QVector <Bola*> *bolas;
	DialogoGraficos(QVector <Bola*> *bolasPasadas, QWidget * parent = 0);
	QChartView *chartView;
   	QGridLayout *gridLayout;
	QChart * chart;
	QBarSeries *series;
	QBarSet *bs1; 
	QStringList categories;

public slots:
	void slotTemporizador();
	
};

#endif
