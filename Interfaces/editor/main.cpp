#include <QApplication>

#include "mainwindow.h"

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);
    VentanaPrincipal *finestra = new VentanaPrincipal;
    finestra->show();
    return app.exec();
}

