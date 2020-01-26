package com.example.practica8_josep_climent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.ByteArrayOutputStream;

public class PerfilFragment extends Fragment {

    private TextView nomUsuario;
    private TextView ciudad;
    private ImageView imgUsuario;
    private static Drawable img_d;

    @SuppressLint("ResourceType")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.perfil_fragment,container, false);

        nomUsuario = (TextView) vista.findViewById(R.id.nombrePerfil);
        ciudad = (TextView) vista.findViewById(R.id.ciudadPerfil);
        imgUsuario = (ImageView) vista.findViewById(R.id.imgPerfil);
        Bundle arg = getArguments();

        if (arg != null){
            nomUsuario.setText(arg.getString("nombrePerfil"));
            ciudad.setText(arg.getString("nombreCiudad"));
            imgUsuario.setImageDrawable(img_d);
        }
        return vista;
    }


    public static PerfilFragment newInstance(String nombre, String ciudad, Drawable d){

        PerfilFragment perfilFragment = new PerfilFragment();
        Bundle caja = new Bundle();
        caja.putString("nombrePerfil",nombre);
        caja.putString("nombreCiudad",ciudad);
        img_d = d;
        perfilFragment.setArguments(caja);
        return perfilFragment;
    }


}
