package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRobots extends RecyclerView.Adapter<RobotViewHolder> implements View.OnClickListener {

    private ArrayList<Robot> robots;
    private Context contexto;
    private View.OnClickListener mListener;

    public AdaptadorRobots(ArrayList<Robot> robots, Context contexto) {
        this.robots = robots;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public RobotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elemento_lista, parent, false);
        RobotViewHolder viewHolder = new RobotViewHolder(itemview, contexto);
        itemview.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RobotViewHolder holder, int position) {
        Robot robot = robots.get(position);
        holder.bindAlumno(robot);
    }

    @Override
    public int getItemCount() {
        return robots.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        mListener = listener;
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            mListener.onClick(view);
        }
    }

}
