#ifndef DEXAMENDAM_H
#define DEXAMENDAM_H
#include "ui_DExamenDAM.h"
#include <QDialog>
#include "bola.h";
#include <QMap>
#include "BolaYWidget.h"


class DExamenDAM : public QDialog, public Ui::DExamenDAM {

	Q_OBJECT
	
public:

	DExamenDAM(QVector<Bola*> bolas,QWidget * parent = 0);
	QString accionARealizar;
	QMap<QString, int>  map;
	QVector<Bola*> bolasMain;
	
private: 

	
public slots:
	void slotRadioButtons(bool);
	void slotCambiarCombo(QString);
	void slotUpdate(void);
	void slotSpinBox(int);
	void slotRealizar(void);
};

//el apartat del combobox en els radio buttons amb el messageBox funciona
//el apartat del spin box y el lcd tambe funciona
//també funciona el boto realizar pero sols per a parar la bola


#endif
