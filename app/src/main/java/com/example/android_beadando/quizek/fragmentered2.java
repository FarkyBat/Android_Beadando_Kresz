package com.example.android_beadando.quizek;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android_beadando.R;
import com.example.android_beadando.hibakhoz.hibasvalasz2;
import com.example.android_beadando.start;

public class fragmentered2 extends Fragment {

    Button osszeredmeny;
    Button ujra;
    Button kezdo;
    TextView siker;
    TextView nemsiker;
    TextView eredmeny;
    Activity context;
    Button hibak;

    int pont = quizfragment2.pont;
    int kerdesek = kerdesvalasz2.kérdés.length;

    public static int besteredmeny1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmentered, container, false);

        osszeredmeny=view.findViewById(R.id.osszeredmenyek);
        hibak= view.findViewById(R.id.hibak);
        siker = view.findViewById(R.id.siker1);
        nemsiker = view.findViewById(R.id.nemsiker1);
        eredmeny = view.findViewById(R.id.eredm1);
        ujra = view.findViewById(R.id.retry1);
        kezdo = view.findViewById(R.id.kezdo1);
        context=getActivity();

        besteredmeny1=((start)getActivity()).getBesteredmeny1();

        if(quizfragment2.pont>besteredmeny1){
            int elertpont=quizfragment2.pont;
            start.setBesteredmeny1(elertpont);
        }


        if (quizfragment2.pont > quizfragment2.kerdesek * 0.60) {
            siker.setVisibility(View.VISIBLE);
            eredmeny.setText("Elért pontszámod: " + pont + "a " + kerdesek + "-ból");

        } else {
            nemsiker.setVisibility(View.VISIBLE);
            eredmeny.setText("Elért pontszámod: " + pont + "a " + kerdesek + "-ból");
        }
        kezdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button gombnyomas = (Button) view;
                if (gombnyomas.getId() == R.id.kezdo1) {
                    Intent intent = new Intent(context, start.class);
                    startActivity(intent);

                }
            }
        });
        hibak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button gombnyomas = (Button) view;
                if (gombnyomas.getId() == R.id.hibak) {
                    ujraFragment(new hibasvalasz2());
                }
            }
        });
        ujra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button gombnyomas = (Button) view;
                if (gombnyomas.getId() == R.id.retry1) {
                    ujraFragment(new quizfragment2());
                }
            }
        });



        return view;
    }
    public void ujraFragment(Fragment fragment) {

        FragmentTransaction fragmentManager = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentManager.replace(R.id.start1, fragment).commit();

    }
}
