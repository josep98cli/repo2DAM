package com.example.projectejosepcliment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactosViewHolder extends RecyclerView.ViewHolder {

    private Context contexto;
    private TextView tvNombre;
    private TextView tvTelefono;

    public ContactosViewHolder(@NonNull View itemView, Context contexto) {
        super(itemView);
        this.contexto =contexto;
        tvNombre=itemView.findViewById(R.id.tv_nombre);
        tvTelefono=itemView.findViewById(R.id.tvTelefono);
    }

    public void bindContacto(Contacto c){

        if (c.getGrupo().equals("Familiar")){

        }else if(c.getGrupo().equals("Trabajo")){

        }else if(c.getGrupo().equals("Amigos")){

        }
    }
}
