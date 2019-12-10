package com.example.projectejosepcliment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button login;
    TextView contOlvidada;
    Switch mostrarPass;
    EditText usuario;
    EditText pass;
    TextInputLayout inputEmail, inputPass;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.botonLog);
        contOlvidada = (TextView) findViewById(R.id.contOlvidad);
        mostrarPass = (Switch) findViewById(R.id.swiPass);
        usuario = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText2);
        inputEmail = (TextInputLayout) findViewById(R.id.inputUser);
        inputPass =(TextInputLayout) findViewById(R.id.inputPass);

        login.setOnClickListener(this);
        mostrarPass.setOnClickListener(this);
        contOlvidada.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.botonLog:
                if (!Patterns.EMAIL_ADDRESS.matcher(usuario.getText().toString()).matches()){
                    inputEmail.setError("Error en el formato del correo");

                }else{
                    inputEmail.setError(null);
                    Intent intent = new Intent(MainActivity.this, Menu_inicial.class);
                    intent.putExtra("variable_usuario",usuario.getText().toString());
                    startActivity(intent);
                }
                break;
            case R.id.contOlvidad:
                inputPass.setHelperText("Indicio: 1234");
                break;
            case R.id.swiPass:
                if (mostrarPass.isChecked()){
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
        }
    }
}
