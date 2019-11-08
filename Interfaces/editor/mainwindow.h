#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QTextEdit>
#include <QAction>
#include <QMenu>


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
        QMenu * menuArchivo;
        QMenu * menuEditar;
	void crearBarrasHerramientas();
        void crearQActions();
        void crearMenus();
        bool guardar;
        
        
public slots:
	void slotCerrar();
	void slotCopiar();
	void slotCortar();
	void slotPegar();
	void slotNuevo();
	void slotComprobar();
	void slotGuardar();
	

};

#endif 
