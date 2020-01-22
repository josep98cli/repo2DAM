package com.example.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RobotViewHolder extends RecyclerView.ViewHolder {

    private ImageView imgSexo;
    private TextView tvNombre;
    private TextView tvDni;
    private Context contexto;

    public RobotViewHolder(@NonNull View itemView, Context contexto) {
        super(itemView);

        imgSexo=itemView.findViewById(R.id.img_sexo);
        tvNombre=itemView.findViewById(R.id.tv_nombre);
        tvDni=itemView.findViewById(R.id.tv_dni);
        this.contexto = contexto;
    }

    public void bindAlumno(Robot a){
        if (a.getSexo()=='H'){
            imgSexo.setImageDrawable(contexto.getDrawable(R.mipmap.male_foreground));
        }else {
            imgSexo.setImageDrawable(contexto.getDrawable(R.mipmap.female_foreground));
        }
        tvNombre.setText(a.getNombre());
        tvDni.setText(a.getDni());
    }
}
