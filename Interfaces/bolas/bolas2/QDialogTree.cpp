
#include "QDialogTree.h"
#include "bola.h"
#include "QDebug"

QDialogTree::QDialogTree(QVector<Bola*>*bolas,QWidget * parent):QDialog(parent){

	setupUi(this);
	model = new ModelTree(bolas);
	treeView->setModel(model);
	this->adjustSize();
}

ModelTree::ModelTree(QVector<Bola*> *lasBolas, QObject * parent):QAbstractItemModel(parent){

	this->bolas=lasBolas;

}


int ModelTree::rowCount(const QModelIndex & parent)const{
	if(!parent.isValid())
		return bolasCount();
	else{
		Bola * padre = static_cast<Bola*>(parent.internalPointer());
		return padre->bolasHijas.size();
	
	}
	
}

int ModelTree::columnCount(const QModelIndex & parent)const{
	
	return 3;

}

QVariant ModelTree::data(const QModelIndex & index, int role)const{

	Bola *b = bolas->at(index.row());

    	if (index.column()==1) return QVariant(QString::number(b->x));
    	if (index.column()==2) return QVariant(QString::number(b->y));
    	if (!index.isValid())
        return QVariant(QString("raiz"));

	if (b == NULL || index.internalPointer() == bolas) {
        	qDebug() << QString("error"); return QVariant();
        }
    	if (role == Qt::DisplayRole ) {
        	if (index.column() == 0)
            	return QVariant(QString::number(b->numBola));
        	if (index.column() == 1)
            	return QVariant(QString::number(b->x));
        	if (index.column() == 2)
            	return QVariant(QString::number(b->y));
       }

    if (role ==Qt::DecorationRole && b != NULL)
        return QVariant((b->color));
    return QVariant();

}

//Metodo que da un indice de una hija la qual quiero la información
QModelIndex ModelTree::index( int row, int column, const QModelIndex & parent )const{
 
	
	//qDebug()<<parent.isValid();
	if(!parent.isValid() && (row<bolasCount())){
		return createIndex(row, column, topBola(row));
	}

	Bola * padre = static_cast<Bola*>(parent.internalPointer());
	if(row < padre->bolasHijas.size()){
		
		return createIndex(row,column, padre->bolasHijas.at(row));
	}
	return QModelIndex();

}

QModelIndex ModelTree::parent(const QModelIndex & index )const{
	
	

	if(!index.isValid()) return QModelIndex();
	//if(index.internalPointer() == bolas) return QModelIndex();
	
	Bola * bola = static_cast<Bola*>(index.internalPointer());
	if(bola->padre == NULL) return QModelIndex();
	
	return createIndex(0,0,bola->padre);

}

int ModelTree::bolasCount()const{


	int num=0;

	for (int i =0; i < bolas->size();i++){
		if(bolas->at(i)->padre == NULL){
			num++;
		}	
	}
	qDebug() << "bolascount " << num ;
	return num;

}



Bola* ModelTree::topBola(int pos)const{

	int cont = 0;
	for(int i=0; i <bolas->size(); i++){
		
		if(bolas->at(i)->padre == NULL){
			
	
			if (cont == pos)
				return bolas->at(i);		
			cont++;
		}
		
	}
	return NULL;

}







