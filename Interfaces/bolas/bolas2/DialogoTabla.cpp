#include "DialogoTabla.h"


DialogoTabla::DialogoTabla(QVector<Bola*> * bolas,QWidget * parent) : QDialog(parent){

	setupUi(this);
	

	this->bolas = bolas;
	modelo = new MiModelo(bolas);
	tableView->setModel(modelo);
	this->adjustSize();
	
	
}

MiModelo::MiModelo(QVector<Bola*> * bolas,QObject *parent) : QAbstractTableModel(parent){

	this->bolas = bolas;

		
}

int MiModelo::rowCount(const QModelIndex &parent)const{
	
		
	return bolas->size();
	
}

int MiModelo::columnCount(const QModelIndex &parent)const{
	
		
	return 4;
	
}

QVariant MiModelo::data(const QModelIndex &index, int role) const{
	
	if( role != Qt::DisplayRole ) return QVariant();
	
		if(index.column() == 0){
			
			return QString::number(bolas->at(index.row())->Bola::x);
			
		}else if(index.column() == 1){
			
			return QString::number(bolas->at(index.row())->Bola::y);
		}else if(index.column() == 2){
			
			return QString::number(bolas->at(index.row())->vX);
		}else if(index.column() == 3){
			
			return QString::number(bolas->at(index.row())->vY);
		}
		
	
	
	
	
	
}

QVariant MiModelo::headerData(int section, Qt::Orientation orientation, int role = Qt::DisplayRole) const{

	if(role != Qt::DisplayRole ) return QVariant();

	if(orientation == Qt::Horizontal){
		if(section == 0) return QString("PosX");
		if(section == 1) return QString("PosY");
		if(section == 2) return QString("VelX");
		if(section == 3) return QString("VelY");
	}else if(orientation == Qt::Vertical){
		if(section == 0) return QString("Bola 1");
		if(section == 1) return QString("Bola 2");
		if(section == 2) return QString("Bola 3");
		if(section == 3) return QString("Bola 4");
		if(section == 4) return QString("Bola 5");
	}

}

















