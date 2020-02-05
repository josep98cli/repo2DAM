#ifndef QDIALOGTREE_H
#define QDIALOGTREE_H

#include "ui_QDialogTree.h"
#include <QDialog>
#include "bola.h"
#include <QAbstractItemModel>
#include <QModelIndex>
class ModelTree;
class QDialogTree : public QDialog, public Ui::QDialogTree{
	Q_OBJECT

public:
	QDialogTree(QVector<Bola*>*,QWidget * parent = 0);
	ModelTree * model;
};


class ModelTree : public QAbstractItemModel{

	Q_OBJECT
public:

	QVector<Bola*> *bolas;
	ModelTree(QVector<Bola*>*, QObject * parent = nullptr);

	QModelIndex index ( int row, int column, const QModelIndex & parent = 		QModelIndex())const;
	QModelIndex parent ( const QModelIndex & index ) const;

	int rowCount ( const QModelIndex & parent = QModelIndex() ) const ;
	int columnCount ( const QModelIndex & parent = QModelIndex() ) const;
	QVariant data ( const QModelIndex & index, int role = Qt::DisplayRole ) const;

	int bolasCount()const;
	Bola * topBola(int)const;

	
};

#endif 
