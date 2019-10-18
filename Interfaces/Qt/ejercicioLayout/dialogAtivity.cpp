
#include <QCheckBox>
#include <QSlider>
#include <QLCDNumber>
#include <QPushButton>
#include <QHBoxLayout>
#include <QVBoxLayout>

#include "dialogAtivity.h"

DialogAtivity::DialogAtivity(QWidget * parent)
	:QDialog(parent)
{

	lcd = new QLCDNumber();

	actTop = new QCheckBox("Activo");
	actMid = new QCheckBox("Activo");	
	actBot = new QCheckBox("Activo");
	
	sTop = new QSlider();
	sMid = new QSlider();
	sBot = new QSlider();
	
	bOK = new QPushButton("OK");
	bCancel = new QPushButton("Cancel");
	b1 = new QPushButton("1");
	b2 = new QPushButton("2");
	
	QVBoxLayout *mainLayout = new QVBoxLayout;
	QHBoxLayout *topMain = new QHBoxLayout;
	QVBoxLayout *botMain = new QVBoxLayout;
	QVBoxLayout *topLeftLayout = new QVBoxLayout;
	QVBoxLayout *topMidLayout = new QVBoxLayout;
	QVBoxLayout *topRightLayout = new QVBoxLayout;
	QHBoxLayout *topRightTopLayout = new QHBoxLayout;

	topRightTopLayout->addWidget(b1);
	topRightTopLayout->addWidget(b2);
	
	topLeftLayout->addLayout(topRightTopLayout);
	topLeftLayout->addWidget(sTop);
	topLeftLayout->addWidget(sMid);
	topLeftLayout->addWidget(sBot);	
	

	topMidLayout->addWidget(actTop);
	topMidLayout->addWidget(actMid);
	topMidLayout->addWidget(actBot);
	
	topRightLayout->addWidget(lcd);
	
	topMain->addLayout(topLeftLayout);
	topMain->addLayout(topMidLayout);
	topMain->addLayout(topRightLayout);

	botMain->addWidget(bOK);
	botMain->addWidget(bCancel);
	
	mainLayout->addLayout(topMain);
	mainLayout->addLayout(botMain);
	
	setLayout(mainLayout);

	sTop->setOrientation(Qt::Horizontal);
	sMid->setOrientation(Qt::Horizontal);
	sBot->setOrientation(Qt::Horizontal);
		
	connect(sTop, SIGNAL(valueChanged(int)),
	this, SLOT(establecerLCD(int)));

	connect(sMid, SIGNAL(valueChanged(int)),
	this, SLOT(establecerLCD(int)));

	connect(sBot, SIGNAL(valueChanged(int)),
	this, SLOT(establecerLCD(int)));
}

void dialogAtivity::establecerLCD(int num){
	int suma = sTop->value() + sMid->value() + sBot->value();
	lcd->display(suma)
}







