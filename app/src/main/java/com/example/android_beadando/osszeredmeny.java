package com.example.android_beadando;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class osszeredmeny extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        TextView eredmeny;


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_osszeredmeny, container, false);

        eredmeny=view.findViewById(R.id.elért);

        return view;
    }
}