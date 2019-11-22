/********************************************************************************
** Form generated from reading UI file 'bucarReemplazar.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_BUCARREEMPLAZAR_H
#define UI_BUCARREEMPLAZAR_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>

QT_BEGIN_NAMESPACE

class Ui_DBuscarReemplazar
{
public:
    QDialogButtonBox *buttonBox;
    QLabel *label;
    QLabel *label_2;
    QLineEdit *leBuscar;
    QLineEdit *leReemplazar;
    QPushButton *botonBuscar;

    void setupUi(QDialog *DBuscarReemplazar)
    {
        if (DBuscarReemplazar->objectName().isEmpty())
            DBuscarReemplazar->setObjectName(QString::fromUtf8("DBuscarReemplazar"));
        DBuscarReemplazar->resize(400, 300);
        buttonBox = new QDialogButtonBox(DBuscarReemplazar);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(30, 240, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        label = new QLabel(DBuscarReemplazar);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(50, 60, 67, 17));
        label_2 = new QLabel(DBuscarReemplazar);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setGeometry(QRect(50, 100, 101, 17));
        leBuscar = new QLineEdit(DBuscarReemplazar);
        leBuscar->setObjectName(QString::fromUtf8("leBuscar"));
        leBuscar->setGeometry(QRect(190, 60, 113, 25));
        leReemplazar = new QLineEdit(DBuscarReemplazar);
        leReemplazar->setObjectName(QString::fromUtf8("leReemplazar"));
        leReemplazar->setGeometry(QRect(190, 100, 113, 25));
        botonBuscar = new QPushButton(DBuscarReemplazar);
        botonBuscar->setObjectName(QString::fromUtf8("botonBuscar"));
        botonBuscar->setGeometry(QRect(310, 60, 89, 25));

        retranslateUi(DBuscarReemplazar);
        QObject::connect(buttonBox, SIGNAL(accepted()), DBuscarReemplazar, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DBuscarReemplazar, SLOT(reject()));

        QMetaObject::connectSlotsByName(DBuscarReemplazar);
    } // setupUi

    void retranslateUi(QDialog *DBuscarReemplazar)
    {
        DBuscarReemplazar->setWindowTitle(QApplication::translate("DBuscarReemplazar", "Dialog", nullptr));
        label->setText(QApplication::translate("DBuscarReemplazar", "Buscar", nullptr));
        label_2->setText(QApplication::translate("DBuscarReemplazar", "Reemplazar", nullptr));
        botonBuscar->setText(QApplication::translate("DBuscarReemplazar", "Buscar", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DBuscarReemplazar: public Ui_DBuscarReemplazar {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_BUCARREEMPLAZAR_H
