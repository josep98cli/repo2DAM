#ifndef DCONTROLBOLAS_H
#define DCONTROLBOLAS_H

#include "ui_DControlBolas.h"
#include <QDialog>
#include <QVector>
#include "BolaYWidget.h"

class DControlBolas : public QDialog, public Ui::DControlBolas {

	Q_OBJECT
	
public:

	DControlBolas(QVector<Bola*> * bolas, QWidget * parent = 0);
	QVector <Bola*> *bolas;
	bool bolasMov;

public slots:
	void pararTodasBolas();
	void slotBolaSeleccionada(int);

};


#endif
