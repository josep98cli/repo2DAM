#ifndef DIALOGOTABLA_H
#define DIALOGOTABLA_H
#include "ui_DialogoTabla.h"
#include <QDialog>
#include <QVariant>
#include "bola.h"
#include <QVector>


class MiModelo;

class DialogoTabla : public QDialog, public Ui::DialogoTabla {

	Q_OBJECT
	
public:

	
	DialogoTabla(QVector<Bola*> *,QWidget * parent = 0);
	QVector<Bola*> * bolas;
	MiModelo * modelo;
	
private: 

	
	
};

class MiModelo : public QAbstractTableModel{
	
	Q_OBJECT

public:
	
	QVector<Bola*> * bolas;
	
	MiModelo(QVector<Bola*> *,QObject *parent = nullptr);
	int rowCount(const QModelIndex &)const;
	int columnCount(const QModelIndex &)const;
	QVariant data(const QModelIndex &, int) const;
	QVariant headerData(int , Qt::Orientation , int ) const;
	
	
};


#endif
