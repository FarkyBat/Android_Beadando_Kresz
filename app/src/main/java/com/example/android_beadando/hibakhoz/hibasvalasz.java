package com.example.android_beadando.hibakhoz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_beadando.R;

import java.util.List;


public class hibasvalasz extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_hibasvalasz, container, false);

       RecyclerView recyclerView = view.findViewById(R.id.RecyclerView);
       List<hibak> hibakList = Manager.adatbetolt(); //létrehoztunk egy listát és meghítunk rá egy függvényt amely feltöltötte adattal ezt a "hibakList"-et
       Myadapter adapter= new Myadapter(hibakList, this);  //beletettük az adapterbe amely elrendezi a listák elemeit a megfelelő helyekre.

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter); //beletöltjük az adapter adatokat.

        return view;

    }
}