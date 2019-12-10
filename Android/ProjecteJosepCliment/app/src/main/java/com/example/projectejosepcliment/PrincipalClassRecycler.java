package com.example.projectejosepcliment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PrincipalClassRecycler extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView recycler;
    public AdaptadorContactos adaptador;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Contacto> contactos;
    private EditText telefono;
    private EditText nombre;
    private RadioGroup rg;
    private Button b;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_recycler);
        telefono = findViewById(R.id.etTelefono);
        nombre = findViewById(R.id.etnombre);
        rg = findViewById(R.id.rg_grupo);

        contactos = new ArrayList<>();

        for (int i=1; i<contactos.size(); i++){
            contactos.add(new Contacto( contactos.get(i).getNombre() , contactos.get(i).getTelefono(),contactos.get(i).getGrupo()));
        }
        recycler = findViewById(R.id.rv_contactos);
        adaptador = new AdaptadorContactos(contactos, this);
        adaptador.setOnClickListener(this);
        recycler.setAdapter(adaptador);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recycler.setLayoutManager(layoutManager);
        b = (Button) findViewById(R.id.button_insertar);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String grupo="";
        if(view.getId() == R.id.button_insertar){
            switch (rg.getCheckedRadioButtonId()){
                case R.id.rbt:
                    grupo="Trabajo";
                    break;
                case R.id.rba:
                    grupo="Amigos";
                    break;
                case R.id.rbf:
                    grupo="Familiar";
            }
            int tel = Integer.parseInt(telefono.getText().toString());
            contactos.add(new Contacto(nombre.getText().toString(), tel , grupo));
            adaptador.notifyDataSetChanged();
        }else{
            int pos = recycler.getChildAdapterPosition(view);
            Contacto asel = contactos.get(pos);
            Toast.makeText(this,"Contacto "+asel.getNombre(), Toast.LENGTH_LONG).show();
        }
    }
}
