package com.example.projectejosepcliment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu_inicial extends AppCompatActivity implements View.OnClickListener {

    Button botonInf;
    Button botonCalculadora;
    Button botonContactos;
    TextView textoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        botonInf = (Button) findViewById(R.id.buttonInf);
        botonCalculadora = (Button) findViewById(R.id.buttonCalculadora);
        botonContactos = (Button) findViewById(R.id.buttonContactos);
        textoUsuario = (TextView) findViewById(R.id.editTextUsuario);


        botonInf.setOnClickListener(this);
        botonCalculadora.setOnClickListener(this);
        botonContactos.setOnClickListener(this);

        //recupero activity
        String var_usuario = getIntent().getStringExtra("variable_usuario");
        String nombreUsuario="";
        for (int i=0; i<var_usuario.length();i++){
            if (var_usuario.charAt(i)!= '@'){
                nombreUsuario+=var_usuario.charAt(i);
            }else{
                break;
            }
        }
        textoUsuario.setText("Bienvenido " + var_usuario);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.buttonCalculadora:
                Intent intent2 = new Intent(Menu_inicial.this, Calculadora.class);
                startActivity(intent2);
                break;
            case R.id.buttonInf:
                Intent intent = new Intent(Menu_inicial.this, Informacion.class);
                startActivity(intent);
        }
    }
}
