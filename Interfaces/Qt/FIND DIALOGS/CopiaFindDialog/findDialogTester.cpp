
#include <QtGui>
#include <QDialog>
#include <QHBoxLayout>
#include <QListWidget>
 #include "findDialogTester.h"

findDialogTester::findDialogTester(QWidget *parent)
      : QDialog(parent)
  {
      QVBoxLayout *backwardLayoutVertical = new QVBoxLayout;
      QVBoxLayout *forwardLayoutVertical = new QVBoxLayout;
	
      QHBoxLayout *mainHorizontal = new QHBoxLayout;

	
        listaForward = new QListWidget();
	listaBackward = new QListWidget();
	
	backwardLayoutVertical->addWidget(listaBackward);
	forwardLayoutVertical->addWidget(listaForward);

	mainHorizontal->addLayout(backwardLayoutVertical);
	mainHorizontal->addLayout(forwardLayoutVertical);
	setLayout(mainHorizontal);
 }

findDialogTester::slotForward(const QString &str, Qt::CaseSensitivity cs){
	listaForward->addItem(str);
}

findDialogTester::slotBackward(const QString &str, Qt::CaseSensitivity cs){
	listaBackward->addItem(str);
}
