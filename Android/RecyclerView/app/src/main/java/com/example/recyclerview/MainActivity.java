package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recycler;
    public AdaptadorRobots adaptador;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Robot> robots;
    private EditText dni;
    private EditText nombre;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dni = findViewById(R.id.etdni);
        nombre = findViewById(R.id.etnombre);
        rg = findViewById(R.id.rg_sexo);
        getSupportActionBar().setTitle("Listado de robots");
        robots = new ArrayList<>();


        for (int i = 1; i < 10; i++) {
            robots.add(new Robot("1234567" + i, "Nombre " + i, (i % 2 == 0) ? 'H' : 'M'));
        }


        recycler = findViewById(R.id.rv_alumnos);
        adaptador = new AdaptadorRobots(robots, this);
        adaptador.setOnClickListener(this);
        recycler.setAdapter(adaptador);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recycler.setLayoutManager(layoutManager);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_insertar) {
            char sexo = (rg.getCheckedRadioButtonId() == R.id.rbh) ? 'H' : 'M';
            robots.add(new Robot(dni.getText().toString(), nombre.getText().toString(), sexo));
            adaptador.notifyDataSetChanged();
        } else {
            int pos = recycler.getChildAdapterPosition(view);
            Robot asel = robots.get(pos);
            Toast.makeText(this, "Robot " + asel.getNombre(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_resource, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_new:
                setContentView(R.layout.activity_crear_robot);
                return true;
            case R.id.action_setting:
                robots.clear();
                adaptador.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
