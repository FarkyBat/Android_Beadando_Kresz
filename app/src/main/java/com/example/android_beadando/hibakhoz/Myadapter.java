package com.example.android_beadando.hibakhoz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_beadando.R;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {

    private hibasvalasz fragment;
    private List<hibak> hibaklist;
    private List<Integer> correctfalse;
    private List<String> valaszlista;// a startból
    private List<Integer> kreszkeplista;


    public Myadapter(List<hibak> hibaklist, List<String> valaszlista, List<Integer> correctfalse, List<Integer> kreszkeplista, hibasvalasz fragment) { //Beletesszük a paraméterbe a listát és a fragmentet hogy meglegyen a kommunik
        this.hibaklist = hibaklist;
        this.valaszlista=valaszlista;
        this.correctfalse=correctfalse;
        this.kreszkeplista =kreszkeplista;
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
        Integer kreszkep=kreszkeplista.get(position);
        Integer kep= correctfalse.get(position);
        String valasz= valaszlista.get(position);
        hibak hibak = hibaklist.get(position);
        holder.kerdes.setText(hibak.getKerdes());
        holder.valasz.setText(valasz);
        holder.helyesvalasz.setText(hibak.getHelyesvalasz());
        holder.correctfalse.setImageResource(kep);
        holder.kreszkep.setImageResource(kreszkep);
    }
    @Override
    public int getItemCount() {
        return hibaklist.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView kerdes;
        TextView valasz;
        TextView helyesvalasz;
        ImageView kreszkep;
        ImageView correctfalse;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            kerdes=itemView.findViewById(R.id.kerdes);
            valasz=itemView.findViewById(R.id.valasz);
            helyesvalasz=itemView.findViewById(R.id.helyesvalasz);
            correctfalse=itemView.findViewById(R.id.correctfalse);
            kreszkep=itemView.findViewById(R.id.kreszkep);
        }
    }
}
