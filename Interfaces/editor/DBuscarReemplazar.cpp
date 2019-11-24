#include "DBuscarReemplazar.h"

DBuscarReemplazar::DBuscarReemplazar(QString cadena, QWidget * parent) : QDialog(parent){
	
	setupUi(this);
	leBuscar->setText(cadena);
	
}
