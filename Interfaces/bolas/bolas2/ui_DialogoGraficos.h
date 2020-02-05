/********************************************************************************
** Form generated from reading UI file 'DialogoGraficos.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DIALOGOGRAFICOS_H
#define UI_DIALOGOGRAFICOS_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>

QT_BEGIN_NAMESPACE

class Ui_DialogoGraficos
{
public:
    QDialogButtonBox *buttonBox;

    void setupUi(QDialog *DialogoGraficos)
    {
        if (DialogoGraficos->objectName().isEmpty())
            DialogoGraficos->setObjectName(QString::fromUtf8("DialogoGraficos"));
        DialogoGraficos->resize(400, 300);
        buttonBox = new QDialogButtonBox(DialogoGraficos);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(210, 250, 171, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);

        retranslateUi(DialogoGraficos);
        QObject::connect(buttonBox, SIGNAL(accepted()), DialogoGraficos, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DialogoGraficos, SLOT(reject()));

        QMetaObject::connectSlotsByName(DialogoGraficos);
    } // setupUi

    void retranslateUi(QDialog *DialogoGraficos)
    {
        DialogoGraficos->setWindowTitle(QApplication::translate("DialogoGraficos", "Dialog", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DialogoGraficos: public Ui_DialogoGraficos {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DIALOGOGRAFICOS_H
