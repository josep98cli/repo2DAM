/********************************************************************************
** Form generated from reading UI file 'DExamenDAM.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DEXAMENDAM_H
#define UI_DEXAMENDAM_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QComboBox>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QGroupBox>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLCDNumber>
#include <QtWidgets/QLabel>
#include <QtWidgets/QProgressBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QRadioButton>
#include <QtWidgets/QSpinBox>
#include <QtWidgets/QVBoxLayout>

QT_BEGIN_NAMESPACE

class Ui_DExamenDAM
{
public:
    QDialogButtonBox *buttonBox;
    QLCDNumber *lcdBolas;
    QSpinBox *spinBolas;
    QLabel *label;
    QComboBox *comboAccion;
    QLabel *label_2;
    QPushButton *botonRealizar;
    QGroupBox *groupBox;
    QHBoxLayout *horizontalLayout;
    QVBoxLayout *verticalLayout;
    QRadioButton *rbYa;
    QRadioButton *rbRato;
    QLabel *label_3;
    QProgressBar *progressBar;
    QLabel *label_4;
    QPushButton *BotonFinalizar;

    void setupUi(QDialog *DExamenDAM)
    {
        if (DExamenDAM->objectName().isEmpty())
            DExamenDAM->setObjectName(QString::fromUtf8("DExamenDAM"));
        DExamenDAM->resize(584, 424);
        buttonBox = new QDialogButtonBox(DExamenDAM);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(210, 370, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        lcdBolas = new QLCDNumber(DExamenDAM);
        lcdBolas->setObjectName(QString::fromUtf8("lcdBolas"));
        lcdBolas->setGeometry(QRect(160, 70, 64, 23));
        QPalette palette;
        QBrush brush(QColor(0, 0, 0, 255));
        brush.setStyle(Qt::SolidPattern);
        palette.setBrush(QPalette::Active, QPalette::WindowText, brush);
        QBrush brush1(QColor(0, 255, 0, 255));
        brush1.setStyle(Qt::SolidPattern);
        palette.setBrush(QPalette::Active, QPalette::Button, brush1);
        QBrush brush2(QColor(127, 255, 127, 255));
        brush2.setStyle(Qt::SolidPattern);
        palette.setBrush(QPalette::Active, QPalette::Light, brush2);
        QBrush brush3(QColor(63, 255, 63, 255));
        brush3.setStyle(Qt::SolidPattern);
        palette.setBrush(QPalette::Active, QPalette::Midlight, brush3);
        QBrush brush4(QColor(0, 127, 0, 255));
        brush4.setStyle(Qt::SolidPattern);
        palette.setBrush(QPalette::Active, QPalette::Dark, brush4);
        QBrush brush5(QColor(0, 170, 0, 255));
        brush5.setStyle(Qt::SolidPattern);
        palette.setBrush(QPalette::Active, QPalette::Mid, brush5);
        palette.setBrush(QPalette::Active, QPalette::Text, brush);
        QBrush brush6(QColor(255, 255, 255, 255));
        brush6.setStyle(Qt::SolidPattern);
        palette.setBrush(QPalette::Active, QPalette::BrightText, brush6);
        palette.setBrush(QPalette::Active, QPalette::ButtonText, brush);
        palette.setBrush(QPalette::Active, QPalette::Base, brush6);
        palette.setBrush(QPalette::Active, QPalette::Window, brush1);
        palette.setBrush(QPalette::Active, QPalette::Shadow, brush);
        palette.setBrush(QPalette::Active, QPalette::AlternateBase, brush2);
        QBrush brush7(QColor(255, 255, 220, 255));
        brush7.setStyle(Qt::SolidPattern);
        palette.setBrush(QPalette::Active, QPalette::ToolTipBase, brush7);
        palette.setBrush(QPalette::Active, QPalette::ToolTipText, brush);
        palette.setBrush(QPalette::Inactive, QPalette::WindowText, brush);
        palette.setBrush(QPalette::Inactive, QPalette::Button, brush1);
        palette.setBrush(QPalette::Inactive, QPalette::Light, brush2);
        palette.setBrush(QPalette::Inactive, QPalette::Midlight, brush3);
        palette.setBrush(QPalette::Inactive, QPalette::Dark, brush4);
        palette.setBrush(QPalette::Inactive, QPalette::Mid, brush5);
        palette.setBrush(QPalette::Inactive, QPalette::Text, brush);
        palette.setBrush(QPalette::Inactive, QPalette::BrightText, brush6);
        palette.setBrush(QPalette::Inactive, QPalette::ButtonText, brush);
        palette.setBrush(QPalette::Inactive, QPalette::Base, brush6);
        palette.setBrush(QPalette::Inactive, QPalette::Window, brush1);
        palette.setBrush(QPalette::Inactive, QPalette::Shadow, brush);
        palette.setBrush(QPalette::Inactive, QPalette::AlternateBase, brush2);
        palette.setBrush(QPalette::Inactive, QPalette::ToolTipBase, brush7);
        palette.setBrush(QPalette::Inactive, QPalette::ToolTipText, brush);
        palette.setBrush(QPalette::Disabled, QPalette::WindowText, brush4);
        palette.setBrush(QPalette::Disabled, QPalette::Button, brush1);
        palette.setBrush(QPalette::Disabled, QPalette::Light, brush2);
        palette.setBrush(QPalette::Disabled, QPalette::Midlight, brush3);
        palette.setBrush(QPalette::Disabled, QPalette::Dark, brush4);
        palette.setBrush(QPalette::Disabled, QPalette::Mid, brush5);
        palette.setBrush(QPalette::Disabled, QPalette::Text, brush4);
        palette.setBrush(QPalette::Disabled, QPalette::BrightText, brush6);
        palette.setBrush(QPalette::Disabled, QPalette::ButtonText, brush4);
        palette.setBrush(QPalette::Disabled, QPalette::Base, brush1);
        palette.setBrush(QPalette::Disabled, QPalette::Window, brush1);
        palette.setBrush(QPalette::Disabled, QPalette::Shadow, brush);
        palette.setBrush(QPalette::Disabled, QPalette::AlternateBase, brush1);
        palette.setBrush(QPalette::Disabled, QPalette::ToolTipBase, brush7);
        palette.setBrush(QPalette::Disabled, QPalette::ToolTipText, brush);
        lcdBolas->setPalette(palette);
        spinBolas = new QSpinBox(DExamenDAM);
        spinBolas->setObjectName(QString::fromUtf8("spinBolas"));
        spinBolas->setGeometry(QRect(120, 30, 111, 26));
        label = new QLabel(DExamenDAM);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(10, 40, 101, 16));
        comboAccion = new QComboBox(DExamenDAM);
        comboAccion->addItem(QString());
        comboAccion->addItem(QString());
        comboAccion->addItem(QString());
        comboAccion->setObjectName(QString::fromUtf8("comboAccion"));
        comboAccion->setGeometry(QRect(370, 70, 171, 26));
        label_2 = new QLabel(DExamenDAM);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setGeometry(QRect(260, 80, 57, 16));
        botonRealizar = new QPushButton(DExamenDAM);
        botonRealizar->setObjectName(QString::fromUtf8("botonRealizar"));
        botonRealizar->setGeometry(QRect(410, 110, 87, 27));
        groupBox = new QGroupBox(DExamenDAM);
        groupBox->setObjectName(QString::fromUtf8("groupBox"));
        groupBox->setGeometry(QRect(280, 160, 211, 113));
        QPalette palette1;
        palette1.setBrush(QPalette::Active, QPalette::WindowText, brush);
        QBrush brush8(QColor(142, 32, 237, 255));
        brush8.setStyle(Qt::SolidPattern);
        palette1.setBrush(QPalette::Active, QPalette::Button, brush8);
        QBrush brush9(QColor(200, 135, 255, 255));
        brush9.setStyle(Qt::SolidPattern);
        palette1.setBrush(QPalette::Active, QPalette::Light, brush9);
        QBrush brush10(QColor(171, 83, 246, 255));
        brush10.setStyle(Qt::SolidPattern);
        palette1.setBrush(QPalette::Active, QPalette::Midlight, brush10);
        QBrush brush11(QColor(71, 16, 118, 255));
        brush11.setStyle(Qt::SolidPattern);
        palette1.setBrush(QPalette::Active, QPalette::Dark, brush11);
        QBrush brush12(QColor(95, 21, 158, 255));
        brush12.setStyle(Qt::SolidPattern);
        palette1.setBrush(QPalette::Active, QPalette::Mid, brush12);
        palette1.setBrush(QPalette::Active, QPalette::Text, brush);
        palette1.setBrush(QPalette::Active, QPalette::BrightText, brush6);
        palette1.setBrush(QPalette::Active, QPalette::ButtonText, brush);
        QBrush brush13(QColor(255, 41, 98, 255));
        brush13.setStyle(Qt::SolidPattern);
        palette1.setBrush(QPalette::Active, QPalette::Base, brush13);
        palette1.setBrush(QPalette::Active, QPalette::Window, brush8);
        palette1.setBrush(QPalette::Active, QPalette::Shadow, brush);
        QBrush brush14(QColor(90, 129, 255, 255));
        brush14.setStyle(Qt::SolidPattern);
        palette1.setBrush(QPalette::Active, QPalette::HighlightedText, brush14);
        QBrush brush15(QColor(198, 143, 246, 255));
        brush15.setStyle(Qt::SolidPattern);
        palette1.setBrush(QPalette::Active, QPalette::AlternateBase, brush15);
        palette1.setBrush(QPalette::Active, QPalette::ToolTipBase, brush7);
        palette1.setBrush(QPalette::Active, QPalette::ToolTipText, brush);
        palette1.setBrush(QPalette::Inactive, QPalette::WindowText, brush);
        palette1.setBrush(QPalette::Inactive, QPalette::Button, brush8);
        palette1.setBrush(QPalette::Inactive, QPalette::Light, brush9);
        palette1.setBrush(QPalette::Inactive, QPalette::Midlight, brush10);
        palette1.setBrush(QPalette::Inactive, QPalette::Dark, brush11);
        palette1.setBrush(QPalette::Inactive, QPalette::Mid, brush12);
        palette1.setBrush(QPalette::Inactive, QPalette::Text, brush);
        palette1.setBrush(QPalette::Inactive, QPalette::BrightText, brush6);
        palette1.setBrush(QPalette::Inactive, QPalette::ButtonText, brush);
        QBrush brush16(QColor(255, 96, 146, 255));
        brush16.setStyle(Qt::SolidPattern);
        palette1.setBrush(QPalette::Inactive, QPalette::Base, brush16);
        palette1.setBrush(QPalette::Inactive, QPalette::Window, brush8);
        palette1.setBrush(QPalette::Inactive, QPalette::Shadow, brush);
        palette1.setBrush(QPalette::Inactive, QPalette::HighlightedText, brush14);
        palette1.setBrush(QPalette::Inactive, QPalette::AlternateBase, brush15);
        palette1.setBrush(QPalette::Inactive, QPalette::ToolTipBase, brush7);
        palette1.setBrush(QPalette::Inactive, QPalette::ToolTipText, brush);
        palette1.setBrush(QPalette::Disabled, QPalette::WindowText, brush11);
        palette1.setBrush(QPalette::Disabled, QPalette::Button, brush8);
        palette1.setBrush(QPalette::Disabled, QPalette::Light, brush9);
        palette1.setBrush(QPalette::Disabled, QPalette::Midlight, brush10);
        palette1.setBrush(QPalette::Disabled, QPalette::Dark, brush11);
        palette1.setBrush(QPalette::Disabled, QPalette::Mid, brush12);
        palette1.setBrush(QPalette::Disabled, QPalette::Text, brush11);
        palette1.setBrush(QPalette::Disabled, QPalette::BrightText, brush6);
        palette1.setBrush(QPalette::Disabled, QPalette::ButtonText, brush11);
        palette1.setBrush(QPalette::Disabled, QPalette::Base, brush8);
        palette1.setBrush(QPalette::Disabled, QPalette::Window, brush8);
        palette1.setBrush(QPalette::Disabled, QPalette::Shadow, brush);
        palette1.setBrush(QPalette::Disabled, QPalette::HighlightedText, brush14);
        palette1.setBrush(QPalette::Disabled, QPalette::AlternateBase, brush8);
        palette1.setBrush(QPalette::Disabled, QPalette::ToolTipBase, brush7);
        palette1.setBrush(QPalette::Disabled, QPalette::ToolTipText, brush);
        groupBox->setPalette(palette1);
        horizontalLayout = new QHBoxLayout(groupBox);
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        verticalLayout = new QVBoxLayout();
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        rbYa = new QRadioButton(groupBox);
        rbYa->setObjectName(QString::fromUtf8("rbYa"));
        QPalette palette2;
        QBrush brush17(QColor(239, 41, 41, 255));
        brush17.setStyle(Qt::SolidPattern);
        palette2.setBrush(QPalette::Active, QPalette::Base, brush17);
        palette2.setBrush(QPalette::Inactive, QPalette::Base, brush17);
        palette2.setBrush(QPalette::Disabled, QPalette::Base, brush8);
        rbYa->setPalette(palette2);

        verticalLayout->addWidget(rbYa);

        rbRato = new QRadioButton(groupBox);
        rbRato->setObjectName(QString::fromUtf8("rbRato"));

        verticalLayout->addWidget(rbRato);


        horizontalLayout->addLayout(verticalLayout);

        label_3 = new QLabel(DExamenDAM);
        label_3->setObjectName(QString::fromUtf8("label_3"));
        label_3->setGeometry(QRect(10, 80, 111, 16));
        progressBar = new QProgressBar(DExamenDAM);
        progressBar->setObjectName(QString::fromUtf8("progressBar"));
        progressBar->setGeometry(QRect(140, 320, 118, 23));
        progressBar->setValue(24);
        label_4 = new QLabel(DExamenDAM);
        label_4->setObjectName(QString::fromUtf8("label_4"));
        label_4->setGeometry(QRect(20, 320, 121, 16));
        BotonFinalizar = new QPushButton(DExamenDAM);
        BotonFinalizar->setObjectName(QString::fromUtf8("BotonFinalizar"));
        BotonFinalizar->setGeometry(QRect(20, 370, 311, 27));

        retranslateUi(DExamenDAM);
        QObject::connect(buttonBox, SIGNAL(accepted()), DExamenDAM, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DExamenDAM, SLOT(reject()));

        QMetaObject::connectSlotsByName(DExamenDAM);
    } // setupUi

    void retranslateUi(QDialog *DExamenDAM)
    {
        DExamenDAM->setWindowTitle(QApplication::translate("DExamenDAM", "Dialog", nullptr));
        label->setText(QApplication::translate("DExamenDAM", "Numero de Bola", nullptr));
        comboAccion->setItemText(0, QApplication::translate("DExamenDAM", "Parar", nullptr));
        comboAccion->setItemText(1, QApplication::translate("DExamenDAM", "Inicializar Aleatoriamente", nullptr));
        comboAccion->setItemText(2, QApplication::translate("DExamenDAM", "ASignar color", nullptr));

        label_2->setText(QApplication::translate("DExamenDAM", "Accion:", nullptr));
        botonRealizar->setText(QApplication::translate("DExamenDAM", "Realizar", nullptr));
        groupBox->setTitle(QApplication::translate("DExamenDAM", "Hora ejecuci\303\263n acci\303\263n", nullptr));
        rbYa->setText(QApplication::translate("DExamenDAM", "Ya", nullptr));
        rbRato->setText(QApplication::translate("DExamenDAM", "Dentro de un rato", nullptr));
        label_3->setText(QApplication::translate("DExamenDAM", "Elegida Bola", nullptr));
        label_4->setText(QApplication::translate("DExamenDAM", "Tiempo Restante", nullptr));
        BotonFinalizar->setText(QApplication::translate("DExamenDAM", "Finalizar Aplicaci\303\263n", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DExamenDAM: public Ui_DExamenDAM {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DEXAMENDAM_H
