package com.example.pruebafragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MiPrimerFragment.OnMiPrimerFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MiPrimerFragment mFragment = MiPrimerFragment.newInstance("Pepe");
        MiPrimerFragment mFragment2  = MiPrimerFragment.newInstance("Juan");

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        transaction.replace(R.id.layout_contenedor, mFragment);
        transaction.add(R.id.layout_contenedor, mFragment2);



        transaction.commit();
    }

    @Override
    public void onMiPrimerFragmentClick() {
        FragmentManager sFragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        SegundoFragment segFragment = SegundoFragment.newInstance();

        transaction.add(R.id.layout_contenedor, segFragment);

        transaction.addToBackStack(null);

        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount()>0){
            getSupportFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }
}
