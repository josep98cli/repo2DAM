package com.example.linearlayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Colores extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = "hola";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);


        CheckBox checkbox = findViewById(R.id.checkTxt);



        checkbox.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        CheckBox check1 = findViewById(R.id.checkTxt);
        RadioGroup radioTexto = findViewById(R.id.colorTexto);
        RadioGroup radioFondo = findViewById(R.id.radioFondo);



        RadioButton fondoNegro = findViewById(R.id.colorNegro);
        int fondoNegroId = radioFondo.getId();
        RadioButton fondoVerde = findViewById(R.id.colorVerde);
        RadioButton fondoRojo = findViewById(R.id.colorRojo);

        RadioButton textoNegro = findViewById(R.id.textoNegro);
        RadioButton textoRojo = findViewById(R.id.textoRojo);
        RadioButton textoVerde = findViewById(R.id.textoVerde);

        TextView txtView = findViewById(R.id.txtView);


        if (check1.isChecked()){

        }
    }
}
