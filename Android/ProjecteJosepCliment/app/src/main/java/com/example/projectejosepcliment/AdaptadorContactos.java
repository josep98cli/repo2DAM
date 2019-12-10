package com.example.projectejosepcliment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorContactos extends RecyclerView.Adapter<ContactosViewHolder> implements View.OnClickListener {

    private ArrayList<Contacto> contactos;
    private Context contexto;
    private View.OnClickListener mListener;

    public AdaptadorContactos(ArrayList<Contacto> contactos, Context contexto) {
        this.contactos = contactos;
        this.contexto = contexto;
    }


    @Override
    public void onClick(View view) {
        if (mListener != null){
            mListener.onClick(view);
        }
    }

    @NonNull
    @Override
    public ContactosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_elemento_lista,parent, false);
        ContactosViewHolder viewHolder = new ContactosViewHolder(itemview, contexto);
        itemview.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactosViewHolder holder, int position) {
            Contacto c = contactos.get(position);
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        mListener = listener;
    }
}
