package com.example.android_beadando.quizek;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android_beadando.R;
import com.example.android_beadando.start;

import java.util.List;


public class quizfragment2 extends Fragment implements View.OnClickListener{
    ImageView kep;
    TextView Kerdesszam;    //kerdesszamlalo
    TextView kerdes;    //maga a kerdes
    Button a, b, c, d;  //válaszlehetőségek
    Button next;
    Button next2;//tovább gomb
    Button segitseg;

    public static String[] valaszok;

    int i = 0;
    public static int pont = 0;   //pontszámláló helyes válaszonként hozzá lesz adva egy pont.
    public static int kerdesek = kerdesvalasz2.kérdés.length;  //kérdések száma a másik osztály tömbjének darabszáma vagyis kérdésszáma..
    int kerdesI = 0;    //kérdésszámláló. amikor a nextre nyomunk hozzáad egyet.
    String valasz = ""; //a bejelölt válasz

    public static képek p1 = new képek(R.drawable.kep1);
    public static képek p2 = new képek(R.drawable.kep2);
    public static képek p3 = new képek(R.drawable.kep3);
    public static képek p4 = new képek(R.drawable.kep4);
    public static képek p5 = new képek(R.drawable.kep5);
    public static képek p6 = new képek(R.drawable.kep6);
    public static képek p7 = new képek(R.drawable.kep7);
    public static képek p8 = new képek(R.drawable.kep8);
    public static képek p9 = new képek(R.drawable.kep9);
    public static képek p10 = new képek(R.drawable.kep10);
    public static képek p11 = new képek(R.drawable.kep11);
    public static képek p12 = new képek(R.drawable.kep12);
    public static képek p13 = new képek(R.drawable.kep13);
    public static képek p14 = new képek(R.drawable.kep14);
    public static képek p15 = new képek(R.drawable.kep15);


    public static képek [] kepektomb = new képek[]{
            p1, p2, p3, p4, p5, p6, p7, p8,p9,p10,p11,p12,p13,p14,p15
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_quizfragment1, container, false);
        List<Integer> kreszkepek=((start)getActivity()).getKreszkepek();
        kreszkepek.add(R.drawable.kep1);
        kreszkepek.add(R.drawable.kep2);
        kreszkepek.add(R.drawable.kep3);
        kreszkepek.add(R.drawable.kep4);
        kreszkepek.add(R.drawable.kep5);
        kreszkepek.add(R.drawable.kep6);
        kreszkepek.add(R.drawable.kep7);
        kreszkepek.add(R.drawable.kep8);
        kreszkepek.add(R.drawable.kep9);
        kreszkepek.add(R.drawable.kep10);
        kreszkepek.add(R.drawable.kep11);
        kreszkepek.add(R.drawable.kep12);
        kreszkepek.add(R.drawable.kep13);
        kreszkepek.add(R.drawable.kep14);
        kreszkepek.add(R.drawable.kep15);


        kep = view.findViewById(R.id.imageView);
        Kerdesszam = view.findViewById(R.id.kerdesszam);
        kerdes = view.findViewById(R.id.kerdes);
        a = view.findViewById(R.id.a);
        b = view.findViewById(R.id.b);
        c = view.findViewById(R.id.c);
        d = view.findViewById(R.id.d);
        next = view.findViewById(R.id.next);
        next2 = view.findViewById(R.id.next2);
        segitseg = view.findViewById(R.id.segitseg);

        //összekötjük öket id alapján, és így adjuk nekik a funkciókat.

        //létrehozzuk a gombok működését.

        kep.setImageResource(kepektomb[0].getImage());
        kerdes.setText(kerdesvalasz2.kérdés[0]);
        a.setText(kerdesvalasz2.valaszlehetoseg[kerdesI][0]); //egyesével tovább hozzá ad egyet a tömb 0. 1. 2. 3. eleméhez
        b.setText(kerdesvalasz2.valaszlehetoseg[kerdesI][1]);
        c.setText(kerdesvalasz2.valaszlehetoseg[kerdesI][2]);
        d.setText(kerdesvalasz2.valaszlehetoseg[kerdesI][3]);



        a.setOnClickListener(this); //megnyomásra történik valami...
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        segitseg.setOnClickListener(this);
        next.setOnClickListener(this);
        next2.setOnClickListener(this);

        Kerdesszam.setText((kerdesI+1)+"/50");
        next.setEnabled(false);
        return view;
    }

    @Override
    public void onClick(View view) {
        a.setBackgroundColor(Color.rgb(62,133,191));
        b.setBackgroundColor(Color.rgb(62,133,191));
        c.setBackgroundColor(Color.rgb(62,133,191));
        d.setBackgroundColor(Color.rgb(62,133,191));

        Button gombnyomas = (Button) view;

        if (gombnyomas.getId()==R.id.segitseg){//ha megnyomtuk a gombot, akkor:


            a.setEnabled(false);
            b.setEnabled(false);
            c.setEnabled(false);
            d.setEnabled(false);


            next2.setVisibility(View.VISIBLE);
            next.setVisibility(View.INVISIBLE);


            if (kerdesvalasz2.valaszlehetoseg[kerdesI][0] == kerdesvalasz2.helyesvalasz[kerdesI]) {
                a.setBackgroundColor(Color.rgb(55, 255, 0));

            } else {
                a.setBackgroundColor(Color.rgb(160, 0, 0));
            }
            if (kerdesvalasz2.valaszlehetoseg[kerdesI][1] == kerdesvalasz2.helyesvalasz[kerdesI]) {
                b.setBackgroundColor(Color.rgb(55, 255, 0));

            } else {
                b.setBackgroundColor(Color.rgb(160, 0, 0));
            }
            if (kerdesvalasz2.valaszlehetoseg[kerdesI][2] == kerdesvalasz2.helyesvalasz[kerdesI]) {
                c.setBackgroundColor(Color.rgb(55, 255, 0));

            } else {
                c.setBackgroundColor(Color.rgb(160, 0, 0));
            }
            if (kerdesvalasz2.valaszlehetoseg[kerdesI][3] == kerdesvalasz2.helyesvalasz[kerdesI]) {
                d.setBackgroundColor(Color.rgb(55, 255, 0));

            } else {
                d.setBackgroundColor(Color.rgb(160, 0, 0));
            }


        }

        if(gombnyomas.getId()==R.id.next2){
            a.setEnabled(true);
            b.setEnabled(true);
            c.setEnabled(true);
            d.setEnabled(true);
            valasz = "Segítséggel: "+kerdesvalasz2.helyesvalasz[kerdesI];
            List<String> valaszok = ((start)getActivity()).getValaszok();
            valaszok.add(valasz);
            List<Integer> correctfalse =((start)getActivity()).getCorrectfalse();
            correctfalse.add(R.drawable.cross);

            kerdesI++;
            Kerdesszam.setText((kerdesI+1)+"/50");
            koviKerdes();
            next.setVisibility(View.VISIBLE);
            next2.setVisibility(View.INVISIBLE);


        }

        if (gombnyomas.getId()==R.id.next){ //ha megnyomjuk a next gombot,////////////////////
            next.setEnabled(false);
            if(valasz.equals(kerdesvalasz2.helyesvalasz[kerdesI])){
                pont++;
                //  valasz=kérdésválasz.helyesvalasz[kerdesI];
                List<Integer> correctfalse =((start)getActivity()).getCorrectfalse();
                correctfalse.add(R.drawable.correct);
            }else if(valasz!=kerdesvalasz2.helyesvalasz[kerdesI]){
                List<Integer> correctfalse =((start)getActivity()).getCorrectfalse();
                correctfalse.add(R.drawable.cross);
            }


            kerdesI++;//számlálóhoz hozzáad egyet
            Kerdesszam.setText((kerdesI+1)+"/50");
            koviKerdes();//betölti a következő kérdést


        }else if(gombnyomas.getId()==R.id.a || gombnyomas.getId()==R.id.b || gombnyomas.getId()==R.id.c || gombnyomas.getId()==R.id.d){
            next.setEnabled(true);
            valasz = gombnyomas.getText().toString();
            List<String> valaszok = ((start)getActivity()).getValaszok();
            valaszok.add(valasz);
            gombnyomas.setBackgroundColor(Color.BLUE);
            //valaszok[kerdesI]=valasz;
        }


    }
    void koviKerdes(){

        if (kerdesI == kerdesek){//ha a kérdések végére ér(ugye a kerdesek egyenlő a kérdések.length-el.)
            loadFragment(new fragmentered2());//akkor meghívja a vége() függvényt
            return;//és visszaadja az elért ponszámokat.

        }
        kep.setImageResource(kepektomb[kerdesI].getImage());
        kerdes.setText(kerdesvalasz2.kérdés[kerdesI]);//menjen a következő kérdésre
        a.setText(kerdesvalasz2.valaszlehetoseg[kerdesI][0]); //egyesével tovább hozzá ad egyet a tömb 0. 1. 2. 3. eleméhez
        b.setText(kerdesvalasz2.valaszlehetoseg[kerdesI][1]);
        c.setText(kerdesvalasz2.valaszlehetoseg[kerdesI][2]);
        d.setText(kerdesvalasz2.valaszlehetoseg[kerdesI][3]);
    }

    /* public void setFragment(FragmentManager fragmentManager, Fragment fragment){
         FragmentTransaction transaction = fragmentManager.beginTransaction();
         transaction.setReorderingAllowed(true);
         transaction.replace(R.id.eredmeny, fragment, null);
         transaction.addToBackStack(null).commit();
     }*/
    public void loadFragment(Fragment eredmeny) {

        FragmentTransaction fragmentManager = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentManager.replace(R.id.start1, eredmeny).commit();

    }

}