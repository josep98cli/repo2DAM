#include "InfoDialog.h"

InfoDialog::InfoDialog(int count, int hg, int wdt,QWidget * parent) : QDialog(parent){

	setupUi(this);
	
	lbNum->setText(QString::number(count));
	
	lbSize->setText(QString(QString::number(wdt)+" x "+QString::number(hg)));
	
}
