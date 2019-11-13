#include "mainwindow.h"
#include <QStatusBar>
#include <QMenuBar>
#include <QMessageBox>
#include <QMenu>
#include <QAction>
#include <QToolBar>
#include <QLabel>
#include <QDebug>
#include <QString>
#include <QTextCursor>
#include <QFileDialog>
#include <QFile>
#include <QTextStream>
#include <QTextBlock>
#include <QApplication>

VentanaPrincipal::VentanaPrincipal(QWidget * parent ,Qt::WindowFlags flags ) : QMainWindow(parent,flags) {

	guardar = false;
        editorCentral = new QTextEdit(this);
        setCentralWidget(editorCentral);
        crearQActions();
	columna = new QLabel("Columna: 1");
	fila = new QLabel("Fila: 1");

        crearBarraEstado();
        crearMenus();
        crearBarrasHerramientas();
    	setWindowIcon(QIcon(":/images/icon.png"));
	
}

void VentanaPrincipal::crearQActions(){
	
        accionSalir = new QAction("Cerrar",this);
        accionSalir -> setShortcut(QKeySequence::Close);
        
        
        accionCopiar = new QAction("Copiar",this);
        accionCopiar -> setShortcut(QKeySequence::Copy);
        
       	
        accionCortar = new QAction("Cortar",this);
        accionCopiar -> setShortcut(QKeySequence::Cut);
        
        
        accionPegar = new QAction("Pegar",this);
        accionPegar -> setShortcut(QKeySequence::Paste);
        
        accionNuevo = new QAction("Nuevo",this);
        accionNuevo -> setShortcut(QKeySequence::New);
        
        accionGuardar = new QAction("Guardar",this);
        accionGuardar -> setShortcut(QKeySequence::Save);
      
        
	accion1TB = new QAction("Boton 1", this);
	accion1TB-> setIcon(QIcon(":/images/icon.png"));

	accion2TB = new QAction("Boton 2", this);
	accion2TB-> setIcon(QIcon(":/images/icon.png"));

	accion3TB = new QAction("Boton 3", this);
	accion3TB-> setIcon(QIcon(":/images/icon.png"));

	accionAbrir = new QAction("Abrir archivo", this);
	accionAbrir->setShortcut(QKeySequence::Open);

	
	connect(accionAbrir, SIGNAL(triggered()), this, SLOT(slotAbrir()));
        connect(accionSalir, SIGNAL(triggered()),this, SLOT(slotCerrar()));
        connect(accionCopiar, SIGNAL(triggered()),this, SLOT(slotCopiar()));
        connect(accionCortar, SIGNAL(triggered()),this, SLOT(slotCortar()));
        connect(accionPegar, SIGNAL(triggered()),this, SLOT(slotPegar()));
        connect(accionNuevo, SIGNAL(triggered()),this,SLOT(slotNuevo()));
        connect(editorCentral, SIGNAL(textChanged()),this,SLOT(slotComprobar()));
        connect(accionGuardar, SIGNAL(triggered()),this, SLOT(slotGuardar()));
	
	connect(accion1TB, SIGNAL(triggered()),this, SLOT(slotmostrarTB()));
	connect(accion2TB, SIGNAL(triggered()),this, SLOT(slotmostrarTB()));
	connect(accion3TB, SIGNAL(triggered()),this, SLOT(slotmostrarTB()));
	
	connect(editorCentral, SIGNAL(cursorPositionChanged()),this, SLOT(slotCambioEstado()));
        
        
}

void VentanaPrincipal::crearMenus(){

	menuArchivo = menuBar()->addMenu("Archivo");
	menuArchivo ->addAction(accionNuevo);
	menuArchivo ->addAction(accionAbrir);
	menuArchivo ->addAction(accionGuardar);
        menuArchivo ->addAction(accionSalir);
        
        menuEditar = menuBar()->addMenu("Editar");
	menuEditar->addAction(accionCopiar);
	menuEditar->addAction(accionCortar);
	menuEditar->addAction(accionPegar);
	
	editorCentral->addAction(accionNuevo);
	editorCentral->setContextMenuPolicy(Qt::ActionsContextMenu);
}

void VentanaPrincipal::crearBarrasHerramientas(){
	
	QToolBar * barraPrincipal;
	
	barraPrincipal = this->addToolBar("Barra Herramientas");

	barraPrincipal->addAction(accion1TB);
	barraPrincipal->addAction(accion2TB);
	barraPrincipal->addAction(accion3TB);

}

void VentanaPrincipal::crearBarraEstado(){
	statusBar()->addWidget(columna);
	statusBar()->addWidget(fila);
}

void VentanaPrincipal::slotCerrar(void){

	if(guardar){ 

		slotGuardar();

	}else{
		int r = QMessageBox::warning(this,
		"EditorClase",
		"El document ha sigut modificat.\nVols guardar els canvis?",
		QMessageBox::Yes | QMessageBox::No | QMessageBox::Cancel);
		if (r == QMessageBox::Yes ){
			slotGuardar();
		}
		if( r == QMessageBox::No){
			guardar = false;
			return;
		}
		if ( r == QMessageBox::Cancel ){
			return;
		}
	}
	QApplication::exit();

}

void VentanaPrincipal::slotCopiar(void){
	editorCentral -> copy();
}

void VentanaPrincipal::slotCortar(void){
	editorCentral -> cut();
}

void VentanaPrincipal::slotPegar(void){
	editorCentral -> paste();
}


void VentanaPrincipal::slotNuevo(void){

	if(guardar){
	
		editorCentral -> clear();
		
	}else{
		int r = QMessageBox::warning(this,
		"EditorClase",
		"El document ha sigut modificat.\nVols guardar els canvis?",
		QMessageBox::Yes | QMessageBox::No | QMessageBox::Cancel);
		
		if (r == QMessageBox::Yes ){
			guardar = true;
		}
		if( r == QMessageBox::No){
			guardar = false;
			editorCentral -> clear();
		}
		if ( r == QMessageBox::Cancel ){
			return;
		}
	}
}

void VentanaPrincipal::slotGuardar(void){

	QString rutaFichero;
	rutaFichero=QFileDialog::getSaveFileName(this, QString("abrir documentillo"));
	
	QFile fichero(rutaFichero);
	
	if(! fichero.open(QIODevice::WriteOnly)){
		qDebug()<<"Algo va mal en el fichero";	
		return;	
	}
	
	QTextStream stream(&fichero);

	for (int i=0; i<editorCentral->document()->blockCount();i++){

		stream << editorCentral->document()->findBlockByNumber(i).text() << endl;
	}

	fichero.close();
	
	guardar =true;
}

void VentanaPrincipal::slotComprobar(void){
	
	guardar = false;
}


void VentanaPrincipal::slotmostrarTB(void){
	
	QAction * accionCogerAction = qobject_cast<QAction *>(sender());
	editorCentral->append(accionCogerAction->text());
}

void VentanaPrincipal::slotCambioEstado(void){

	QTextCursor cursor = editorCentral->textCursor();
	
	fila->setText("Fila: "+QString::number(cursor.blockNumber()));
	columna->setText("Columna: "+QString::number(cursor.columnNumber()));
}

void VentanaPrincipal::slotAbrir(void){

	//qDebug sirve para debuggear por consola
	qDebug()<<"Antes de abrir diálogo";
	//creo un QString 
	QString rutaArchivo;
	//le asigno al QString la ruta del documento seleccionado 
	rutaArchivo=QFileDialog::getOpenFileName(this, QString("abrir documentillo"));
	//debuggeo la ruta del archivo	
	qDebug()<<rutaArchivo;
	
	//limpio el editor
	editorCentral->clear();
	
	//creo un objeto de clase FILE con la ruta del dialogo del fichero	
	QFile fichero(rutaArchivo);
	
	//compruebo las excepciones y le digo que abra el fichero en solo lectura
	if(! fichero.open(QIODevice::ReadOnly)){
		qDebug()<<"Algo va mal en el fichero";	
		return;	
	}
	//creo un objeto de tipo QTextStream y le paso por referencia el fichero 
	QTextStream stream(&fichero);
	//uso la funcion readAll() que lee todo el fichero
	QString texto =stream.readAll();
	//pongo el texto en el editor
	editorCentral->append(texto);
	//cierro el fichero
	fichero.close();

		
}

void VentanaPrincipal::closeEvent(QCloseEvent *event)
  {
      if (!guardar) {
          slotGuardar();
	  event->ignore();
      } else {
          event->ignore();
      }
  }












