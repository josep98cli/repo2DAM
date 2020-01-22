package com.example.pruebafragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MiPrimerFragment extends Fragment implements View.OnClickListener {

private final static String ARG_NOMBRE = "ARG_NOMBRE";

private String nombre;
private TextView tvNombre;
private Button btnPulsar;
private OnMiPrimerFragmentListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle informacionRecibida = getArguments();

        if (informacionRecibida!=null){
            nombre = informacionRecibida.getString(ARG_NOMBRE);
        }

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vistaLayout = inflater.inflate(R.layout.mi_primer_layout, container, false);
            tvNombre = vistaLayout.findViewById(R.id.tvNombre);
            btnPulsar = vistaLayout.findViewById(R.id.button1);
            btnPulsar.setOnClickListener(this);

            if(nombre != null){
                tvNombre.setText(nombre);
            }



        return vistaLayout;
    }

    public static MiPrimerFragment newInstance(String nombre){
        Bundle informacionParaFragment = new Bundle();
        informacionParaFragment.putString(ARG_NOMBRE, nombre);

        MiPrimerFragment mFragment = new MiPrimerFragment();
        mFragment.setArguments(informacionParaFragment);
        return mFragment;
    }


    @Override
    public void onClick(View view) {
        mListener.onMiPrimerFragmentClick();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof  OnMiPrimerFragmentListener){
            mListener = (OnMiPrimerFragmentListener) context;
        }else{
            throw new RuntimeException(context.toString()+ " debe implementar OnMiPrimerListener");
        }
    }



    public  interface  OnMiPrimerFragmentListener{
        public void onMiPrimerFragmentClick();
    }




}

