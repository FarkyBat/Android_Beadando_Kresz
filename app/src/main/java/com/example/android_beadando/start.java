package com.example.android_beadando;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class start extends AppCompatActivity implements View.OnClickListener{
    Button eredmenyeid;
    Button start;
    ImageView Hatter;
    List<String> valaszok = new ArrayList<>();
    public List<String> getValaszok() {
        return valaszok;
    }
    public List<Integer> correctfalse = new ArrayList<>();
    public  List<Integer> getCorrectfalse() {
        return correctfalse;
    }
    public List<Integer> kreszkepek = new ArrayList<>();
    public List<Integer> getKreszkepek() {
        return kreszkepek;
    }

    public static int besteredmeny1=0;
    public int getBesteredmeny1() {
        return besteredmeny1;
    }
    public static void setBesteredmeny1(int besteredmeny) {
        besteredmeny1 = besteredmeny;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Hatter=findViewById(R.id.imageView2);
        eredmenyeid=findViewById(R.id.eredmenyeid);
        start=findViewById(R.id.start);
        eredmenyeid.setOnClickListener(this);
        start.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        Button gombnyomas = (Button) view;
        if (gombnyomas.getId()==R.id.start){
            start.setVisibility(View.INVISIBLE);
            eredmenyeid.setVisibility(View.INVISIBLE);
            loadFragment(new kvizek());
            Hatter.setVisibility(View.INVISIBLE);
        }

        if (gombnyomas.getId()==R.id.eredmenyeid){
            start.setVisibility(View.INVISIBLE);
            eredmenyeid.setVisibility(View.INVISIBLE);
            loadFragment(new osszeredmeny());
        }

    }
    public void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.start1, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }


}