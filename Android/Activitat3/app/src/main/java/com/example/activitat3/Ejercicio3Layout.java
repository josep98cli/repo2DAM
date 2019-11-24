package com.example.activitat3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ejercicio3Layout extends AppCompatActivity implements View.OnClickListener {

    Button b3_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);
        b3_1 =(Button) findViewById(R.id.botonEj3_1);
        b3_1.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), Ejercicio1.class);
        startActivity(intent);
    }
}
