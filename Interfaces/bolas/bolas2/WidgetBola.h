#ifndef WIDGETBOLA_H
#define WIDGETBOLA_H

#include "ui_WidgetBola.h"
#include <QDialog>
#include "bola.h"

class WidgetBola : public QDialog, public Ui::WidgetBola {

	Q_OBJECT
	
public:

	WidgetBola(Bola * b,QWidget * parent = 0);
	Bola * bola;
	
public slots:

	void slotPararBola(void);	
	void slotElegirColor(void);

};

#endif
