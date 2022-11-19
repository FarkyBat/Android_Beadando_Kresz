package com.example.android_beadando.quizek;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android_beadando.R;
import com.example.android_beadando.hibakhoz.hibasvalasz;
import com.example.android_beadando.quizek.kérdésválasz;
import com.example.android_beadando.quizek.quizfragment1;
import com.example.android_beadando.start;


public class fragmentered extends Fragment {
    Button ujra;
    Button kezdo;
    TextView siker;
    TextView nemsiker;
    TextView eredmeny;
    Activity context;
    Button hibak;

    int pont = quizfragment1.pont;
    int kerdesek = kérdésválasz.kérdés.length;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmentered, container, false);

        hibak= view.findViewById(R.id.hibak);
        siker = view.findViewById(R.id.siker1);
        nemsiker = view.findViewById(R.id.nemsiker1);
        eredmeny = view.findViewById(R.id.eredm1);
        ujra = view.findViewById(R.id.retry1);
        kezdo = view.findViewById(R.id.kezdo1);
        context=getActivity();

        if (quizfragment1.pont > quizfragment1.kerdesek * 0.60) {
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
                    ujraFragment(new hibasvalasz());
                }
            }
        });
        ujra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button gombnyomas = (Button) view;
                if (gombnyomas.getId() == R.id.retry1) {
                    ujraFragment(new quizfragment1());
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
