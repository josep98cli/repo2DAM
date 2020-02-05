#include <QApplication>

#include "mainwindow.h"

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);
    MainWindow *finestra = new MainWindow;
    finestra->show();
    return app.exec();
}


