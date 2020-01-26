package com.example.practica8_josep_climent;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment implements View.OnClickListener{

    Button bPerfil;
    Button bPreferencias;
    public interfaceFragment mListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.menu_fragment,container, false);
        bPerfil = (Button) vista.findViewById(R.id.bPerfil);
        bPreferencias = (Button) vista.findViewById(R.id.bPreferencias);

        bPerfil.setOnClickListener(this);
        bPreferencias.setOnClickListener(this);
        return vista;
    }

    public static MenuFragment newInstance(){

        MenuFragment listadoFragment = new MenuFragment();

        return listadoFragment;
    }


    @Override
    public void onClick(View view) {

       if (view.getId() == bPerfil.getId()){
           mListener.viewProfile();

       }else{
           mListener.preferencies();
       }

    }

    public interface interfaceFragment{
        public void viewProfile();
        public void preferencies();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof interfaceFragment) {
            mListener = (interfaceFragment) context;
        } else {
            throw new RuntimeException(context.toString() + "error");
        }
    }
}


