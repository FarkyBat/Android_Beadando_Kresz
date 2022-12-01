package com.example.android_beadando.hibakhoz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_beadando.R;
import com.example.android_beadando.quizek.fragmentered;
import com.example.android_beadando.start;

import java.util.List;


public class hibasvalasz2 extends Fragment {
    Button vissza;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_hibasvalasz, container, false);

        vissza=view.findViewById(R.id.vissza);



        List<String> valaszlista=((start)getActivity()).getValaszok();//feltöltjük a listát
        List<Integer> kreszkeplista=((start)getActivity()).getKreszkepek();
        List<Integer> correctfalse=((start)getActivity()).getCorrectfalse();
        RecyclerView recyclerView1 = view.findViewById(R.id.RecyclerView);
        List<hibak> hibakList = Manager.adatbetolt2(); //feltöltjük a listát. létrehoztunk egy listát és meghítunk rá egy függvényt amely feltöltötte adattal ezt a "hibakList"-et
        Myadapter2 adapter1= new Myadapter2(hibakList, valaszlista, correctfalse, kreszkeplista, this);  //beletettük az adapterbe amely elrendezi a listák elemeit a megfelelő helyekre.

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getContext());
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setAdapter(adapter1); //beletöltjük az adapter adatokat.


        vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button gombnyomas = (Button) view;
                if (gombnyomas.getId() == R.id.vissza) {
                    ujraFragment(new fragmentered());
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