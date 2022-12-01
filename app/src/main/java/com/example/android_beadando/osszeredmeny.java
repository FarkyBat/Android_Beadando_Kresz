package com.example.android_beadando;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class osszeredmeny extends Fragment {

    TextView kiszamolt;

    int szam;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_osszeredmeny, container, false);

        kiszamolt=view.findViewById(R.id.kiszamolt);
        szam+=((start)getActivity()).getBesteredmeny1();

        if (szam==0){
            kiszamolt.setText("0");
        }else if(szam>0){kiszamolt.setText(szam);}








        return view;
    }
}