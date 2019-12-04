#ifndef _DINFORMACION_H
#define _DINFORMACION_H

#include "ui_DInformacion.h"
#include <QDialog>

class DInformacion:public QDialog, public Ui::DInformacion{
	Q_OBJECT
	public:
		DInformacion(int numBolas, int alt, int anch, QWidget * parent = 0);
};

#endif


