#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QPaintEvent>
class MainWindow : public QMainWindow{
Q_OBJECT
public:
        MainWindow(QWidget * parent = 0, Qt::WindowFlags flags = 0);
	
	void paintEvent(QPaintEvent *);

private:
	


public slots:
	
	void slotRepintar();
};

#endif
