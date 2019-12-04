#include "DInformacion.h"

DInformacion::DInformacion(int numBolas, int alt, int anch, QWidget * parent) : QDialog(parent){
	
	
	labelBolas->setText(QString::number(numBolas));

	QString textoTamanyo = QString::number(alt) + QString(" x ")+QString::number(anch);

	labelPantalla->setText(textoTamanyo);
	
	setupUi(this);
}
