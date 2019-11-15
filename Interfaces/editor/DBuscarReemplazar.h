#ifndef _DBUSCARREEMPLAZAR_H
#define _DBUSCARREEMPLAZAR_H

#include "ui_DBuscarReemplazar.h"
#include <QDialog>

class DBuscarReemplazar:public QDialog, public Ui::DBuscarReemplazar{
	
Q_OBJECT
	public:
		DBuscarReemplazar(QString cadena, QWidget * parent = 0);


};

#endif
