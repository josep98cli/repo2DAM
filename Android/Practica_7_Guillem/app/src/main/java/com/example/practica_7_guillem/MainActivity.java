package com.example.practica_7_guillem;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean pantallaMovil;
    ArrayList<Robot> listaRobots = new ArrayList<>();
    private AdaptadorRobots adaptador;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantallaMovil = getSupportFragmentManager().findFragmentById(R.id.fgrag_lista)==null;

        if (pantallaMovil){
            FragmentManager fragmentManager1 = getSupportFragmentManager();
            FragmentTransaction transaction1 =fragmentManager1.beginTransaction();

            ListadoRobotsFragment listadoRobotsFragment = ListadoRobotsFragment.newInstance();
            transaction1.add(R.id.layout_contenedor,listadoRobotsFragment);
            transaction1.addToBackStack(null);
            transaction1.commit();
        }else{

        }

        getSupportActionBar().setTitle("Listado de robots");

        adaptador = new AdaptadorRobots(listaRobots, this);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

    }


    @Override
    protected void onResume() {
        super.onResume();
        this.adaptador.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_robots, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.addRobot:
                Intent i = new Intent(this, FormularioRobot.class);
                startActivityForResult(i, 1);
                break;

            case R.id.reiniciar:
                listaRobots.clear();

                adaptador.notifyDataSetChanged();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void onRobotSelected(Robot robotSeleccionado){
        if (pantallaMovil){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            DetalleRobotFragment detalleRobotFragment = DetalleRobotFragment.newInstance(robotSeleccionado);
            transaction.replace(R.id.layout_contenedor,detalleRobotFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }else{
            DetalleRobotFragment fragmentDetalle = (DetalleRobotFragment) getSupportFragmentManager().findFragmentById(R.id.fgrag_detalle);
            fragmentDetalle.actualizarDatos(robotSeleccionado);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addRobot) {
            abrirFormNuevoRobot();
        }
    }

    private void abrirFormNuevoRobot() {
        Intent i = new Intent(this, FormularioRobot.class);
        startActivityForResult(i, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 0 && resultCode == 0) {
            Robot r;
            try {
                r = (Robot) data.getSerializableExtra("Robot");
                anyadirNuevoRobot(r);
            } catch (NullPointerException e) {
                return;
            }
        } else if (requestCode == 1 && resultCode == 0) {
            try {
                Robot r = (Robot) data.getSerializableExtra("Robot");
                int i = data.getIntExtra("pos", 0);
                this.listaRobots.set(i, r);
                adaptador.notifyItemChanged(i);
            } catch (NullPointerException e) {
                return;
            }
        }
    }

    private void anyadirNuevoRobot(final Robot r) {
        // añadir robot
        this.listaRobots.add(0, r);
        this.adaptador.notifyItemInserted(0);


    }
}
