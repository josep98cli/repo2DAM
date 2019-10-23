#ifndef FINDDIALOGTESTER_H
#define FINDDIALOGTESTER_H

 #include <QtGui>
 #include <QDialog>
 #include <QLabel>
 #include <QListWidget>


class QLabel;


class findDialogTester : public QDialog{
	Q_OBJECT

public:

	findDialogTester(QWidget *parent = NULL);
private:
	
	 QListWidget * listaBackward;
	QListWidget *listaForward;

public slots:

	void slotFordward(const QString &str, Qt::CaseSensitivity cs);
	void slotBackward(const QString &str, Qt::CaseSensitivity cs);
};

#endif
