package com.example.android_beadando;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class osszeredmeny extends Fragment {
    TextView ossz;
    TextView szoveg;
    TextView osszeredmeny1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_osszeredmeny, container, false);
        ossz=view.findViewById(R.id.ossz);
        szoveg=view.findViewById(R.id.szoveg);
        osszeredmeny1=view.findViewById(R.id.osszeredmeny1);
        osszeredmeny1.setText(((start)getActivity()).getBesteredmeny1());


        return view;
    }
}