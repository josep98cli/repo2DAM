#include <QApplication>
#include <QHBoxLayout>
#include <QSlider>
#include <QSpinBox>
#include <QPushButton>

int main(int argc, char *argv[])
{
      QApplication app(argc, argv);
      QPushButton *buttonIncre = new QPushButton("Incrementar");
      QPushButton *buttonDecre = new QPushButton("Decrementar");

      QWidget *window = new QWidget;
      window->setWindowTitle("Enter Your Age");

     QSpinBox *spinBox = new QSpinBox;
     QSlider *slider = new QSlider(Qt::Horizontal);
     spinBox->setRange(0, 130);
     slider->setRange(0, 130);

     QObject::connect(spinBox, SIGNAL(valueChanged(int)),
                      slider, SLOT(setValue(int)));
     QObject::connect(slider, SIGNAL(valueChanged(int)),
                      spinBox, SLOT(setValue(int)));

     
     QObject::connect(buttonIncre, SIGNAL(clicked()),
                      spinBox, SLOT(stepUp()));
	
	QObject::connect(buttonDecre, SIGNAL(clicked()),
                      spinBox, SLOT(stepDown()));
//Valor por defecto 35
     spinBox->setValue(35);

     QHBoxLayout *layout = new QHBoxLayout;
    	
     layout->addWidget(spinBox);
     layout->addWidget(slider);
     layout->addWidget(buttonIncre);
     layout->addWidget(buttonDecre);
     window->setLayout(layout);


     window->show();

     return app.exec();
}

