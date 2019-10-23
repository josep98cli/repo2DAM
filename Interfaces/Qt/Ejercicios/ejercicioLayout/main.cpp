
#include <QApplication>

#include "dialogAtivity.h"

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);
    DialogAtivity *dialog = new DialogAtivity;
    dialog->show();
    return app.exec();
}

