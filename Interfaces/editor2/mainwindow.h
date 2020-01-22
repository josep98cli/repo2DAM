#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QTextEdit>
#include <QAction>
#include <QMenu>
#include <QLabel>
#include <QChartView>
#include <QLineSeries>
#include <QValueAxis>


QT_CHARTS_USE_NAMESPACE

class VentanaPrincipal : public QMainWindow {
Q_OBJECT
public:
        VentanaPrincipal(QWidget * parent = 0, Qt::WindowFlags flags = 0);
	QChart * chart;
	QChartView * chartView;
	QLineSeries *serie;
	
private:
	
        QTextEdit *editorCentral;

        
public slots:
	void slotResaltar(const QPointF &, bool);
	void slotTemporizador();
};

#endif 
