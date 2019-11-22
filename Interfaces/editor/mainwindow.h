#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QStringList>
#include <QMainWindow>
#include <QTextEdit>
#include <QAction>
#include <QMenu>
#include <QLabel>
#include "DBuscarReemplazar.h"

class VentanaPrincipal : public QMainWindow {
Q_OBJECT
public:
        VentanaPrincipal(QWidget * parent = 0, Qt::WindowFlags flags = 0);


private:
	
        QTextEdit *editorCentral;
        QAction * accionSalir;
        QAction * accionCopiar;
        QAction * accionCortar;
        QAction * accionPegar;
        QAction * accionNuevo;
        QAction * accionGuardar;
	QAction * accion1TB;
	QAction * accion2TB;
	QAction * accion3TB;
	QAction *accionAbrir;
	QAction * accionDialogo;
	QLabel *fila;
	QLabel *columna;
        QMenu * menuArchivo;
        QMenu * menuEditar;
	QStringList listaArchivos;
	QVector<QAction *> actRecientes;
	DBuscarReemplazar * dialogoBuscar;
	


	static const int MAXARCHIVOS= 5;	
	
	
	void crearBarraEstado();
	void crearBarrasHerramientas();
        void crearQActions();
        void crearMenus();
	void mostrarBotonPalabra();
        bool guardar;
	void closeEvent(QCloseEvent *event);
        void actualizarMenus(QString ruta);
	void abrirArchivo(QString ruta);
        
public slots:
	void slotCerrar();
	void slotCopiar();
	void slotCortar();
	void slotPegar();
	void slotNuevo();
	void slotComprobar();
	void slotGuardar();
	void slotmostrarTB();
	void slotCambioEstado();
	void slotAbrir();
	void slotBuscarReemplazar();
	void slotAbrirRecientes();
	void slotAnyadirPalabra(QString);

};

#endif 
