#include "mainwindow.h"
#include <QStatusBar>
#include <QMenuBar>
#include <QMessageBox>
#include <QMenu>
#include <QAction>
#include <QToolBar>

VentanaPrincipal::VentanaPrincipal(QWidget * parent ,Qt::WindowFlags flags ) : QMainWindow(parent,flags) {

	guardar = false;
        editorCentral = new QTextEdit(this);
        setCentralWidget(editorCentral);
        crearQActions();
        
        crearMenus();
        
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
      
        
	accion1TB = new QAction("1", this);
	accion1TB-> setIcon(QIcon(":/images/icon.png"));

        connect(accionSalir, SIGNAL(triggered()),this, SLOT(slotCerrar()));
        connect(accionCopiar, SIGNAL(triggered()),this, SLOT(slotCopiar()));
        connect(accionCortar, SIGNAL(triggered()),this, SLOT(slotCortar()));
        connect(accionPegar, SIGNAL(triggered()),this, SLOT(slotPegar()));
        connect(accionNuevo, SIGNAL(triggered()),this,SLOT(slotNuevo()));
        connect(editorCentral, SIGNAL(textChanged()),this,SLOT(slotComprobar()));
        connect(accionGuardar, SIGNAL(triggered()),this, SLOT(slotGuardar()));
        
        
        
}

void VentanaPrincipal::crearMenus(){

	menuArchivo = menuBar()->addMenu("Archivo");
        menuArchivo ->addAction(accionSalir);
        menuArchivo ->addAction(accionNuevo);
        menuArchivo -> addAction(accionGuardar);
        
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

}

void VentanaPrincipal::slotCerrar(void){
	this -> close();
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
	guardar = true;
	
	
}

void VentanaPrincipal::slotComprobar(void){
	
	guardar = false;
}






