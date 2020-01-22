#ifndef _INFODIALOG_H
#define _INFODIALOG_H
#include "ui_InfoDialog.h"
#include <QDialog>

class InfoDialog : public QDialog, public Ui::InfoDialog {

	Q_OBJECT
	
public:

	InfoDialog(int count, int hg, int wdt,QWidget * parent = 0);
	
private: 

	
	
};


#endif
