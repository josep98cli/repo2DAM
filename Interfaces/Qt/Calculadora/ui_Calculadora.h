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
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_Calculadora
{
public:
    QWidget *widget;
    QHBoxLayout *horizontalLayout_2;
    QVBoxLayout *verticalLayout_2;
    QLineEdit *lineEdit;
    QGridLayout *gridLayout;
    QPushButton *b7;
    QPushButton *b9;
    QPushButton *b6;
    QPushButton *b2;
    QPushButton *b4;
    QPushButton *b1;
    QPushButton *b8;
    QPushButton *b3;
    QPushButton *b5;
    QHBoxLayout *horizontalLayout;
    QPushButton *pushButton_3;
    QPushButton *pushButton_4;
    QVBoxLayout *verticalLayout;
    QPushButton *mas;
    QPushButton *pushButton;
    QPushButton *pushButton_2;

    void setupUi(QWidget *Calculadora)
    {
        if (Calculadora->objectName().isEmpty())
            Calculadora->setObjectName(QString::fromUtf8("Calculadora"));
        Calculadora->resize(621, 431);
        widget = new QWidget(Calculadora);
        widget->setObjectName(QString::fromUtf8("widget"));
        widget->setGeometry(QRect(20, 30, 511, 361));
        horizontalLayout_2 = new QHBoxLayout(widget);
        horizontalLayout_2->setObjectName(QString::fromUtf8("horizontalLayout_2"));
        horizontalLayout_2->setContentsMargins(0, 0, 0, 0);
        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2->setObjectName(QString::fromUtf8("verticalLayout_2"));
        lineEdit = new QLineEdit(widget);
        lineEdit->setObjectName(QString::fromUtf8("lineEdit"));

        verticalLayout_2->addWidget(lineEdit);

        gridLayout = new QGridLayout();
        gridLayout->setObjectName(QString::fromUtf8("gridLayout"));
        b7 = new QPushButton(widget);
        b7->setObjectName(QString::fromUtf8("b7"));

        gridLayout->addWidget(b7, 0, 0, 1, 1);

        b9 = new QPushButton(widget);
        b9->setObjectName(QString::fromUtf8("b9"));

        gridLayout->addWidget(b9, 0, 2, 1, 1);

        b6 = new QPushButton(widget);
        b6->setObjectName(QString::fromUtf8("b6"));

        gridLayout->addWidget(b6, 1, 2, 1, 1);

        b2 = new QPushButton(widget);
        b2->setObjectName(QString::fromUtf8("b2"));

        gridLayout->addWidget(b2, 2, 1, 1, 1);

        b4 = new QPushButton(widget);
        b4->setObjectName(QString::fromUtf8("b4"));

        gridLayout->addWidget(b4, 1, 0, 1, 1);

        b1 = new QPushButton(widget);
        b1->setObjectName(QString::fromUtf8("b1"));

        gridLayout->addWidget(b1, 2, 0, 1, 1);

        b8 = new QPushButton(widget);
        b8->setObjectName(QString::fromUtf8("b8"));

        gridLayout->addWidget(b8, 0, 1, 1, 1);

        b3 = new QPushButton(widget);
        b3->setObjectName(QString::fromUtf8("b3"));

        gridLayout->addWidget(b3, 2, 2, 1, 1);

        b5 = new QPushButton(widget);
        b5->setObjectName(QString::fromUtf8("b5"));

        gridLayout->addWidget(b5, 1, 1, 1, 1);


        verticalLayout_2->addLayout(gridLayout);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        pushButton_3 = new QPushButton(widget);
        pushButton_3->setObjectName(QString::fromUtf8("pushButton_3"));

        horizontalLayout->addWidget(pushButton_3);

        pushButton_4 = new QPushButton(widget);
        pushButton_4->setObjectName(QString::fromUtf8("pushButton_4"));

        horizontalLayout->addWidget(pushButton_4);


        verticalLayout_2->addLayout(horizontalLayout);


        horizontalLayout_2->addLayout(verticalLayout_2);

        verticalLayout = new QVBoxLayout();
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        mas = new QPushButton(widget);
        mas->setObjectName(QString::fromUtf8("mas"));

        verticalLayout->addWidget(mas);

        pushButton = new QPushButton(widget);
        pushButton->setObjectName(QString::fromUtf8("pushButton"));

        verticalLayout->addWidget(pushButton);

        pushButton_2 = new QPushButton(widget);
        pushButton_2->setObjectName(QString::fromUtf8("pushButton_2"));
        pushButton_2->setEnabled(true);

        verticalLayout->addWidget(pushButton_2);


        horizontalLayout_2->addLayout(verticalLayout);


        retranslateUi(Calculadora);

        QMetaObject::connectSlotsByName(Calculadora);
    } // setupUi

    void retranslateUi(QWidget *Calculadora)
    {
        Calculadora->setWindowTitle(QApplication::translate("Calculadora", "Form", nullptr));
        b7->setText(QApplication::translate("Calculadora", "7", nullptr));
        b9->setText(QApplication::translate("Calculadora", "9", nullptr));
        b6->setText(QApplication::translate("Calculadora", "6", nullptr));
        b2->setText(QApplication::translate("Calculadora", "2", nullptr));
        b4->setText(QApplication::translate("Calculadora", "4", nullptr));
        b1->setText(QApplication::translate("Calculadora", "1", nullptr));
        b8->setText(QApplication::translate("Calculadora", "8", nullptr));
        b3->setText(QApplication::translate("Calculadora", "3", nullptr));
        b5->setText(QApplication::translate("Calculadora", "5", nullptr));
        pushButton_3->setText(QApplication::translate("Calculadora", "0", nullptr));
        pushButton_4->setText(QApplication::translate("Calculadora", ".", nullptr));
        mas->setText(QApplication::translate("Calculadora", "+", nullptr));
        pushButton->setText(QApplication::translate("Calculadora", "-", nullptr));
        pushButton_2->setText(QApplication::translate("Calculadora", "=", nullptr));
    } // retranslateUi

};

namespace Ui {
    class Calculadora: public Ui_Calculadora {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CALCULADORA_H
