
#include <QApplication>

#include "findDialog.h"
#include "findDialogTester.h"

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);
    FindDialog *dialog = new FindDialog;
	dialog->show();

    findDialogTester  *probador = new findDialogTester;
	probador->show();

	QObject::connect(dialog, SIGNAL(findNext(const QString &, Qt::CaseSensitivity)),probador, SLOT(slotFordward(const QString &, QT::CaseSensivity)));
	QObject::connect(dialog, SIGNAL(findPrevious(const QString &, Qt::CaseSensitivity)),probador, SLOT(slotBackward(const QString &, QT::CaseSensivity)));

    return app.exec();

	 QObject::connect(dialog, SIGNAL(findNext(const QString &, Qt::CaseSensitivity)),
                   probador, SLOT(slotFordward(const QString &str, Qt::CaseSensitivity cs)));

	QObject::connect(dialog, SIGNAL(findPrevious(const QString &, Qt::CaseSensitivity)),
                   probador, SLOT(slotBackground(const QString &str, Qt::CaseSensitivity cs)));
}

