package com.example.linearlayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Colores extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        CheckBox checkbox = findViewById(R.id.checkTxt);
        checkbox.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        RadioGroup radioTexto = findViewById(R.id.colorTexto);
        RadioGroup radioFondo = findViewById(R.id.radioFondo);

        radioFondo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                CheckBox checkbox = findViewById(R.id.checkTxt);
                TextView txtView= findViewById(R.id.txtViewColors);

                if (checkbox.isChecked()){
                    if (i == R.id.colorNegro){
                        txtView.setBackgroundColor(Color.BLACK);
                    }else if(i == R.id.colorRojo){
                        txtView.setBackgroundColor(Color.RED);
                    }else if(i == R.id.colorVerde){
                        txtView.setBackgroundColor(Color.GREEN);
                    }
                }

            }
        });

        radioTexto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                TextView txtView= findViewById(R.id.txtViewColors);
                CheckBox checkbox = findViewById(R.id.checkTxt);

                if (checkbox.isChecked()){
                    if (i == R.id.textoNegro){
                        txtView.setTextColor(Color.BLACK);
                    }else if(i == R.id.textoRojo){
                        txtView.setTextColor(Color.RED);
                    }else if(i == R.id.textoVerde){
                        txtView.setTextColor(Color.GREEN);
                    }
                }

            }
        });
    }
}
