#include "calculadora.h"

Calculadora::Calculadora(QWidget * parent) : QWidget(parent){

	setupUi(this);
	
	
	connect(b1, SIGNAL(clicked()),
          this, SLOT(slotEscribirN(void)));
          
        connect(b2, SIGNAL(clicked()),
          this, SLOT(slotEscribirN(void)));
          
          connect(b3, SIGNAL(clicked()),
          this, SLOT(slotEscribirN(void)));
          
          connect(b4, SIGNAL(clicked()),
          this, SLOT(slotEscribirN(void)));
          
          connect(b5, SIGNAL(clicked()),
          this, SLOT(slotEscribirN(void)));
          
          connect(b6, SIGNAL(clicked()),
          this, SLOT(slotEscribirN(void)));
          
          connect(b7, SIGNAL(clicked()),
          this, SLOT(slotEscribirN(void)));
          
          connect(b8, SIGNAL(clicked()),
          this, SLOT(slotEscribirN(void)));
          
          connect(b9, SIGNAL(clicked()),
          this, SLOT(slotEscribirN(void)));
	
}

void Calculadora::slotEscribirN(void ){

	QPushButton * b = qobject_cast<QPushButton *>(sender());
	lineEdit->setText(lineEdit->text()+b->text());
}	

