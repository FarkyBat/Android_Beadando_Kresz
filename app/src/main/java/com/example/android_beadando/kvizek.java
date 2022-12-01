package com.example.android_beadando;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android_beadando.quizek.quizfragment1;
import com.example.android_beadando.quizek.quizfragment2;


public class kvizek extends Fragment {
    Button button1;
    Button button2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_kvizek, container, false);
        button1=view.findViewById(R.id.button1);
        button2=view.findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button gombnyomas = (Button) view;
                if (gombnyomas.getId() == R.id.button1) {
                    betoltFragment(new quizfragment1());
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button gombnyomas = (Button) view;
                if (gombnyomas.getId() == R.id.button2) {
                    betoltFragment(new quizfragment2());
                }
            }
        });


        return view;
    }
    public void betoltFragment(Fragment fragment) {

        FragmentTransaction fragmentManager = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentManager.replace(R.id.start1, fragment).commit();

    }

}