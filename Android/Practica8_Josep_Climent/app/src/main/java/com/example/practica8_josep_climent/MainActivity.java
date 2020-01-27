package com.example.practica8_josep_climent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.Toast;

import java.nio.BufferUnderflowException;

public class MainActivity extends AppCompatActivity implements MenuFragment.interfaceFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager1 = getSupportFragmentManager();
        FragmentTransaction transaction1 = fragmentManager1.beginTransaction();

        MenuFragment menuFragment = MenuFragment.newInstance();
        transaction1.add(R.id.contenedor, menuFragment);
        transaction1.addToBackStack(null);
        transaction1.commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void viewProfile() {

        FragmentManager fragmentManager1 = getSupportFragmentManager();
        FragmentTransaction transaction1 = fragmentManager1.beginTransaction();

        PerfilFragment pf = PerfilFragment.newInstance("Pepe", "Jativa", this.getDrawable(R.drawable.user));
        transaction1.replace(R.id.contenedor, pf);
        transaction1.addToBackStack(null);
        transaction1.commit();
    }

    @Override
    public void preferencies() {

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new Preferences())
                .commit();

    }
}
