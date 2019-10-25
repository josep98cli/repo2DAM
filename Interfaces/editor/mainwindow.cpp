#include "mainwindow.h"
#include <QStatusBar>
#include <QMenuBar>
#include <QMessageBox>

VentanaPrincipal::VentanaPrincipal(
        QWidget * parent ,
        Qt::WindowFlags flags ) : QMainWindow(parent,flags) {

        editorCentral = new QTextEdit(this);
        setCentralWidget(editorCentral);

    setWindowIcon(QIcon(":/images/icon.png"));
}


