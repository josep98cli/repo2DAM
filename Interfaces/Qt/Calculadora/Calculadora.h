#ifndef CALCULADORA_H
#define CALCULADORA_H

#include <QWidget>
#include "ui_Calculadora.h"

class Calculadora : public QWidget, public Ui::Calculadora {

public:
	Calculadora(QWidget * parent = NULL);

 };

#endif
