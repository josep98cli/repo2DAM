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

    private double num1=0;
    private double num2=0;
    private String result= "0";
    private boolean nextMarca =true;
    private boolean marcadoNum2 = false;
    private String ultTeclaPulsada =null;

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
                operacion.operacionSuma(num1, num2);
                break;
            case R.id.resta:
                operacion.operacionResta(num1, num2);
                break;
            case R.id.multiplicacion:
                operacion.operacionMulti(num1, num2);
                break;
            case R.id.barra_division:
                operacion.operacionDivision(num1,num2);
                break;
            case R.id.num_0:
                checkNumero( view.getId());
                break;
            case R.id.num_1:
                checkNumero( view.getId());
                break;
            case R.id.num_2:
                checkNumero( view.getId());
                break;
            case R.id.num_3:
                checkNumero( view.getId());
                break;
            case R.id.num_4:
                checkNumero( view.getId());
                break;
            case R.id.num_5:
                checkNumero( view.getId());
                break;
            case R.id.num_6:
                checkNumero( view.getId());
                break;
            case R.id.num_7:
                checkNumero( view.getId());
                break;
            case R.id.num_8:
                checkNumero( view.getId());
                break;
            case R.id.num_9:
                checkNumero( view.getId());
                break;
            case R.id.igual:
                marcadoNum2=false;
                ultTeclaPulsada="=";
                break;

        }

    }
    public void checkNumero(int numero){
        if (operacion.getNumero1()==0){
            operacion.setNumero1(numero);
        }else{
            operacion.setNumero2(numero);
        }
    }
    public void comprobarOperacion(String operar, Button boton){
        if (ultTeclaPulsada!=operar){
            nextMarca= false;
            marcadoNum2= false;
            operacion.setOperacion1(operar);
        }else{
            checkNumero(0);
        }
    }

    public void borrarTodo(){
        num1= 0;
        num2 = 0;
        result = "0";
        nextMarca= true;
        marcadoNum2= false;
        ultTeclaPulsada=null;
    }

}
