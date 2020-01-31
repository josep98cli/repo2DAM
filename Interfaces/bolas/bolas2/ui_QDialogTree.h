/********************************************************************************
** Form generated from reading UI file 'QDialogTree.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_QDIALOGTREE_H
#define UI_QDIALOGTREE_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QTreeView>

QT_BEGIN_NAMESPACE

class Ui_QDialogTree
{
public:
    QDialogButtonBox *buttonBox;
    QTreeView *treeView;
    QPushButton *butRecargarBolas;

    void setupUi(QDialog *QDialogTree)
    {
        if (QDialogTree->objectName().isEmpty())
            QDialogTree->setObjectName(QString::fromUtf8("QDialogTree"));
        QDialogTree->resize(818, 564);
        buttonBox = new QDialogButtonBox(QDialogTree);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(460, 520, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        treeView = new QTreeView(QDialogTree);
        treeView->setObjectName(QString::fromUtf8("treeView"));
        treeView->setGeometry(QRect(10, 20, 781, 431));
        butRecargarBolas = new QPushButton(QDialogTree);
        butRecargarBolas->setObjectName(QString::fromUtf8("butRecargarBolas"));
        butRecargarBolas->setGeometry(QRect(50, 480, 701, 25));

        retranslateUi(QDialogTree);
        QObject::connect(buttonBox, SIGNAL(accepted()), QDialogTree, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), QDialogTree, SLOT(reject()));

        QMetaObject::connectSlotsByName(QDialogTree);
    } // setupUi

    void retranslateUi(QDialog *QDialogTree)
    {
        QDialogTree->setWindowTitle(QApplication::translate("QDialogTree", "Dialog", nullptr));
        butRecargarBolas->setText(QApplication::translate("QDialogTree", "Recargar Bolas", nullptr));
    } // retranslateUi

};

namespace Ui {
    class QDialogTree: public Ui_QDialogTree {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_QDIALOGTREE_H
