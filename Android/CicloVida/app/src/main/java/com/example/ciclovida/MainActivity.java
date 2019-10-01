package com.example.ciclovida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CicloVida";
    StringBuilder mensajes = new StringBuilder();
    TextView visor;

    private void escribir(String text){
        Log.d(TAG, text);
        mensajes.append(text);
        mensajes.append("\n");
        visor.setText(mensajes.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        escribir("Entra en onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        escribir("Entra en onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        escribir("Entra en onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        escribir("Entra en onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        escribir("Entra en onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        escribir("Entra en onDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visor = (TextView) findViewById(R.id.tv);
        mensajes = new StringBuilder();
        escribir("Entra en onCreate");

    }




}
