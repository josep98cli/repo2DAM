package com.example.activitat3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ejercicio1 extends AppCompatActivity implements View.OnClickListener{
    TextView txt1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame);
        b1= (Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
        txt1 = (TextView) findViewById(R.id.textView1);
    }


    @Override
    public void onClick(View view) {
        txt1.setVisibility(View.VISIBLE);
        b1.setVisibility(View.INVISIBLE);

    }
}
