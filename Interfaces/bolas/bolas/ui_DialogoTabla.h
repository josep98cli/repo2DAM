/********************************************************************************
** Form generated from reading UI file 'DialogoTabla.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DIALOGOTABLA_H
#define UI_DIALOGOTABLA_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QTableView>
#include <QtWidgets/QVBoxLayout>

QT_BEGIN_NAMESPACE

class Ui_DialogoTabla
{
public:
    QVBoxLayout *verticalLayout;
    QTableView *tableView;
    QDialogButtonBox *buttonBox;

    void setupUi(QDialog *DialogoTabla)
    {
        if (DialogoTabla->objectName().isEmpty())
            DialogoTabla->setObjectName(QString::fromUtf8("DialogoTabla"));
        DialogoTabla->resize(513, 287);
        QSizePolicy sizePolicy(QSizePolicy::Fixed, QSizePolicy::Fixed);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(DialogoTabla->sizePolicy().hasHeightForWidth());
        DialogoTabla->setSizePolicy(sizePolicy);
        DialogoTabla->setBaseSize(QSize(513, 287));
        verticalLayout = new QVBoxLayout(DialogoTabla);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        tableView = new QTableView(DialogoTabla);
        tableView->setObjectName(QString::fromUtf8("tableView"));
        QSizePolicy sizePolicy1(QSizePolicy::Expanding, QSizePolicy::Expanding);
        sizePolicy1.setHorizontalStretch(0);
        sizePolicy1.setVerticalStretch(0);
        sizePolicy1.setHeightForWidth(tableView->sizePolicy().hasHeightForWidth());
        tableView->setSizePolicy(sizePolicy1);
        tableView->viewport()->setProperty("cursor", QVariant(QCursor(Qt::ArrowCursor)));

        verticalLayout->addWidget(tableView);

        buttonBox = new QDialogButtonBox(DialogoTabla);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);

        verticalLayout->addWidget(buttonBox);


        retranslateUi(DialogoTabla);
        QObject::connect(buttonBox, SIGNAL(accepted()), DialogoTabla, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DialogoTabla, SLOT(reject()));

        QMetaObject::connectSlotsByName(DialogoTabla);
    } // setupUi

    void retranslateUi(QDialog *DialogoTabla)
    {
        DialogoTabla->setWindowTitle(QApplication::translate("DialogoTabla", "Dialog", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DialogoTabla: public Ui_DialogoTabla {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DIALOGOTABLA_H
