package com.example.activitat3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b1;
    Button b2;
    Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button) findViewById(R.id.buttonEj1);
        b2=(Button) findViewById(R.id.buttonEj2);
        b3=(Button) findViewById(R.id.calculadora);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonEj2){
            Intent intent = new Intent(view.getContext(), Ejercicio3Layout.class);
            startActivity(intent);
        }else if(view.getId() == R.id.buttonEj1){
            Intent intent = new Intent(view.getContext(), Ejercicio1.class);
            startActivity(intent);
        }else if(view.getId() == R.id.calculadora){
            Intent intent = new Intent(view.getContext(), Calculadora.class);
            startActivity(intent);
        }
    }

}
