/********************************************************************************
** Form generated from reading UI file 'Calculadora.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_CALCULADORA_H
#define UI_CALCULADORA_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_Calculadora
{
public:
    QPushButton *b1;
    QPushButton *b2;
    QPushButton *pushButton;
    QPushButton *pushButton_2;
    QPushButton *pushButton_3;
    QPushButton *pushButton_4;
    QPushButton *pushButton_5;
    QPushButton *pushButton_6;
    QPushButton *pushButton_7;

    void setupUi(QWidget *Calculadora)
    {
        if (Calculadora->objectName().isEmpty())
            Calculadora->setObjectName(QString::fromUtf8("Calculadora"));
        Calculadora->resize(400, 300);
        b1 = new QPushButton(Calculadora);
        b1->setObjectName(QString::fromUtf8("b1"));
        b1->setGeometry(QRect(20, 230, 89, 25));
        b2 = new QPushButton(Calculadora);
        b2->setObjectName(QString::fromUtf8("b2"));
        b2->setGeometry(QRect(120, 230, 89, 25));
        pushButton = new QPushButton(Calculadora);
        pushButton->setObjectName(QString::fromUtf8("pushButton"));
        pushButton->setGeometry(QRect(220, 230, 89, 25));
        pushButton_2 = new QPushButton(Calculadora);
        pushButton_2->setObjectName(QString::fromUtf8("pushButton_2"));
        pushButton_2->setGeometry(QRect(20, 190, 89, 25));
        pushButton_3 = new QPushButton(Calculadora);
        pushButton_3->setObjectName(QString::fromUtf8("pushButton_3"));
        pushButton_3->setGeometry(QRect(120, 190, 89, 25));
        pushButton_4 = new QPushButton(Calculadora);
        pushButton_4->setObjectName(QString::fromUtf8("pushButton_4"));
        pushButton_4->setGeometry(QRect(220, 190, 89, 25));
        pushButton_5 = new QPushButton(Calculadora);
        pushButton_5->setObjectName(QString::fromUtf8("pushButton_5"));
        pushButton_5->setGeometry(QRect(20, 150, 89, 25));
        pushButton_6 = new QPushButton(Calculadora);
        pushButton_6->setObjectName(QString::fromUtf8("pushButton_6"));
        pushButton_6->setGeometry(QRect(120, 150, 89, 25));
        pushButton_7 = new QPushButton(Calculadora);
        pushButton_7->setObjectName(QString::fromUtf8("pushButton_7"));
        pushButton_7->setGeometry(QRect(220, 150, 89, 25));

        retranslateUi(Calculadora);

        QMetaObject::connectSlotsByName(Calculadora);
    } // setupUi

    void retranslateUi(QWidget *Calculadora)
    {
        Calculadora->setWindowTitle(QApplication::translate("Calculadora", "Form", nullptr));
        b1->setText(QApplication::translate("Calculadora", "1", nullptr));
        b2->setText(QApplication::translate("Calculadora", "2", nullptr));
        pushButton->setText(QApplication::translate("Calculadora", "3", nullptr));
        pushButton_2->setText(QApplication::translate("Calculadora", "4", nullptr));
        pushButton_3->setText(QApplication::translate("Calculadora", "5", nullptr));
        pushButton_4->setText(QApplication::translate("Calculadora", "6", nullptr));
        pushButton_5->setText(QApplication::translate("Calculadora", "7", nullptr));
        pushButton_6->setText(QApplication::translate("Calculadora", "8", nullptr));
        pushButton_7->setText(QApplication::translate("Calculadora", "9", nullptr));
    } // retranslateUi

};

namespace Ui {
    class Calculadora: public Ui_Calculadora {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CALCULADORA_H
