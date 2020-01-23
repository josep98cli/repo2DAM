package com.example.practica_7_josepcliment;

import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetalleRobotFragment extends Fragment {

    ImageView imagen;
    ArrayList<Robot> robots;
    AdaptadorRobots robotsAdapter;
    RecyclerView recyclerView;

    public static DetalleRobotFragment newInstance(Robot robotSeleccionado) {
        DetalleRobotFragment mFragment = new DetalleRobotFragment();

        return mFragment;
    }

    public void actualizarDatos(Robot robotSeleccionado) {
        switch (robotSeleccionado.getTipo()){
            case R2D2:
                imagen.setImageDrawable(getActivity().getDrawable(R.drawable.rdosddos));
                break;
            case WALLE:
                imagen.setImageDrawable(getActivity().getDrawable(R.drawable.walle));
                break;
            case BENDER:
                imagen.setImageDrawable(getActivity().getDrawable(R.drawable.bender));
                break;
        }

    }
}
