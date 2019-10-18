#ifndef DIALOGATIVITY_H
#define DIALOGATIVITY_H

 #include <QDialog>
class QCheckBox;
class QPushButton;
class QSlider;
class QLCDNumber;

class DialogAtivity : public QDialog{
	Q_OBJECT

public:

	DialogAtivity(QWidget *parent = NULL);
private:
	QPushButton *bOK, *bCancel, *b1, *b2;
	QSlider *sTop, *sMid, *sBot;
	QCheckBox *actTop, *actMid, *actBot;
	QLCDNumber *lcd; 

public slots:

	void establecerLCD(int num);
	
};

#endif
