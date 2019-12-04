/********************************************************************************
** Form generated from reading UI file 'DInformacion.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DINFORMACION_H
#define UI_DINFORMACION_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QLabel>

QT_BEGIN_NAMESPACE

class Ui_DInformacion
{
public:
    QLabel *label;
    QLabel *label_2;
    QLabel *labelBolas;
    QLabel *labelPantalla;

    void setupUi(QDialog *DInformacion)
    {
        if (DInformacion->objectName().isEmpty())
            DInformacion->setObjectName(QString::fromUtf8("DInformacion"));
        DInformacion->resize(400, 281);
        label = new QLabel(DInformacion);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(10, 30, 121, 17));
        label_2 = new QLabel(DInformacion);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setGeometry(QRect(0, 150, 141, 20));
        labelBolas = new QLabel(DInformacion);
        labelBolas->setObjectName(QString::fromUtf8("labelBolas"));
        labelBolas->setGeometry(QRect(170, 30, 67, 17));
        labelPantalla = new QLabel(DInformacion);
        labelPantalla->setObjectName(QString::fromUtf8("labelPantalla"));
        labelPantalla->setGeometry(QRect(170, 110, 67, 17));

        retranslateUi(DInformacion);

        QMetaObject::connectSlotsByName(DInformacion);
    } // setupUi

    void retranslateUi(QDialog *DInformacion)
    {
        DInformacion->setWindowTitle(QApplication::translate("DInformacion", "Dialog", nullptr));
        label->setText(QApplication::translate("DInformacion", "Numero de bolas", nullptr));
        label_2->setText(QApplication::translate("DInformacion", "Resolucion pantalla:", nullptr));
        labelBolas->setText(QApplication::translate("DInformacion", "0", nullptr));
        labelPantalla->setText(QApplication::translate("DInformacion", "0 x 0", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DInformacion: public Ui_DInformacion {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DINFORMACION_H
