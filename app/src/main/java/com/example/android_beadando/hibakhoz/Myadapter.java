package com.example.android_beadando.hibakhoz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_beadando.R;
import com.example.android_beadando.start;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {

    private hibasvalasz fragment;
    private List<hibak> hibaklist;

    public Myadapter(List<hibak> hibaklist, hibasvalasz fragment) { //Beletesszük a paraméterbe a listát és a fragmentet hogy meglegyen a kommunik
        this.hibaklist = hibaklist;
        this.fragment = fragment;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista, parent,false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        hibak hibak = hibaklist.get(position);
        holder.kerdes.setText(hibak.getKerdes());
        holder.valasz.setText(hibak.getValasz());
        holder.helyesvalasz.setText(hibak.getHelyesvalasz());

    }
    @Override
    public int getItemCount() {
        return hibaklist.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView kerdes;
        TextView valasz;
        TextView helyesvalasz;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            kerdes=itemView.findViewById(R.id.kerdes);
            valasz=itemView.findViewById(R.id.valasz);
            helyesvalasz=itemView.findViewById(R.id.helyesvalasz);
        }
    }
}
