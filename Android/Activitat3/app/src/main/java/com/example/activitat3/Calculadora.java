package com.example.activitat3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculadora extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    private Button boton1;
    private Button boton2;
    private Button boton3;
    private Button boton4;
    private Button boton5;
    private Button boton6;
    private Button boton7;
    private Button boton8;
    private Button boton9;
    private Button botonSuma;
    private Button botonResta;
    private Button botonMulti;
    private Button botonDivi;
    private Button botonIgual;
    private Button botonBorrar;

    private String num1;
    private String num2;
    private String result= "0";
    private boolean marcado;


    private Operaciones operacion;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        textView = (TextView) findViewById(R.id.textCalc);
        boton1 = (Button) findViewById(R.id.num_1);
        boton2 = (Button) findViewById(R.id.num_2);
        boton3 = (Button) findViewById(R.id.num_3);
        boton4 = (Button) findViewById(R.id.num_4);
        boton5 = (Button) findViewById(R.id.num_5);
        boton6 = (Button) findViewById(R.id.num_6);
        boton7 = (Button) findViewById(R.id.num_7);
        boton8 = (Button) findViewById(R.id.num_8);
        boton9 = (Button) findViewById(R.id.num_9);
        botonSuma = (Button) findViewById(R.id.suma);
        botonResta = (Button) findViewById(R.id.resta);
        botonMulti = (Button) findViewById(R.id.multiplicacion);
        botonDivi = (Button) findViewById(R.id.barra_division);
        botonIgual = (Button) findViewById(R.id.igual);
        botonBorrar = (Button) findViewById(R.id.borrar);

        textView.setOnClickListener(this);
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
        boton4.setOnClickListener(this);
        boton5.setOnClickListener(this);
        boton6.setOnClickListener(this);
        boton7.setOnClickListener(this);
        boton8.setOnClickListener(this);
        boton9.setOnClickListener(this);
        botonSuma.setOnClickListener(this);
        botonResta.setOnClickListener(this);
        botonMulti.setOnClickListener(this);
        botonDivi.setOnClickListener(this);
        botonIgual.setOnClickListener(this);
        botonBorrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        operacion = new Operaciones(0,0,null);
        switch(view.getId()){
            case R.id.borrar:
                borrarTodo();
                break;
            case R.id.suma:
                textView.append(" + ");
                break;
            case R.id.resta:
                textView.append(" - ");
                break;
            case R.id.multiplicacion:
                textView.append(" * ");
                break;
            case R.id.barra_division:
                textView.append(" / ");
                break;
            case R.id.num_0:
                textView.append("0");
                break;
            case R.id.num_1:
                textView.append("0");
                break;
            case R.id.num_2:
                textView.append("2");
                break;
            case R.id.num_3:
                textView.append("3");
                break;
            case R.id.num_4:
                textView.append("4");
                break;
            case R.id.num_5:
                textView.append("5");
                break;
            case R.id.num_6:
                textView.append("6");
                break;
            case R.id.num_7:
                textView.append("7");
                break;
            case R.id.num_8:
                textView.append("8");
                break;
            case R.id.num_9:
                textView.append("9");
                break;
            case R.id.igual:
                resolverOperacion();
                break;
        }

    }

    public void resolverOperacion(){
        String operacionInicial = textView.getText().toString();
        String[] operacionSplit = operacionInicial.split(" ");
        int num1 = Integer.parseInt(operacionSplit[0]);
        int num2 = Integer.parseInt(operacionSplit[2]);
        String signo = operacionSplit[1];

        switch (signo){
            case "+":
                textView.setText(Double.toString(operacion.operacionSuma(num1,num2)));
                break;
            case "-":
                textView.setText(Double.toString(operacion.operacionResta(num1,num2)));
                break;
            case "*":
                textView.setText(Double.toString(operacion.operacionMulti(num1,num2)));
                break;
            case "/":
                textView.setText(Double.toString(operacion.operacionDivision(num1,num2)));
                break;
        }

    }

    public void borrarTodo(){
        textView.setHint("0");
        textView.setText("");
    }

}
