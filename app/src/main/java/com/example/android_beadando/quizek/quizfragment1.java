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


public class quizfragment1 extends Fragment implements View.OnClickListener{
    ImageView kep;
    TextView Kerdesszam;    //kerdesszamlalo
    TextView kerdes;    //maga a kerdes
    Button a, b, c, d;  //válaszlehetőségek
    Button next;
    Button next2;//tovább gomb
    Button segitseg;

    public static String[] valaszok;
    int i1=0;
    int i = 0;
    public static int pont = 0;   //pontszámláló helyes válaszonként hozzá lesz adva egy pont.
    public static int kerdesek = kérdésválasz.kérdés.length;  //kérdések száma a másik osztály tömbjének darabszáma vagyis kérdésszáma..
    int kerdesI = 0;    //kérdésszámláló. amikor a nextre nyomunk hozzáad egyet.
    String valasz = ""; //a bejelölt válasz

    public static képek p1 = new képek(R.drawable.eloznitilos);
    public static képek p2 = new képek(R.drawable.sebkorlatoz);
    public static képek p3 = new képek(R.drawable.foutvonalvege);
    public static képek p4 = new képek(R.drawable.kanyarodofoutvonal);

    public static képek [] kepektomb = new képek[]{
            p1, p2, p3, p4
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_quizfragment1, container, false);
        List<Integer> kreszkepek=((start)getActivity()).getKreszkepek();
        kreszkepek.add(R.drawable.eloznitilos);
        kreszkepek.add(R.drawable.sebkorlatoz);
        kreszkepek.add(R.drawable.foutvonalvege);
        kreszkepek.add(R.drawable.kanyarodofoutvonal);
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
        kerdes.setText(kérdésválasz.kérdés[0]);
        a.setText(kérdésválasz.valaszlehetoseg[kerdesI][0]); //egyesével tovább hozzá ad egyet a tömb 0. 1. 2. 3. eleméhez
        b.setText(kérdésválasz.valaszlehetoseg[kerdesI][1]);
        c.setText(kérdésválasz.valaszlehetoseg[kerdesI][2]);
        d.setText(kérdésválasz.valaszlehetoseg[kerdesI][3]);



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


            if (kérdésválasz.valaszlehetoseg[kerdesI][0] == kérdésválasz.helyesvalasz[kerdesI]) {
                a.setBackgroundColor(Color.rgb(55, 255, 0));

            } else {
                a.setBackgroundColor(Color.rgb(160, 0, 0));
            }
            if (kérdésválasz.valaszlehetoseg[kerdesI][1] == kérdésválasz.helyesvalasz[kerdesI]) {
                b.setBackgroundColor(Color.rgb(55, 255, 0));

            } else {
                b.setBackgroundColor(Color.rgb(160, 0, 0));
            }
            if (kérdésválasz.valaszlehetoseg[kerdesI][2] == kérdésválasz.helyesvalasz[kerdesI]) {
                c.setBackgroundColor(Color.rgb(55, 255, 0));

            } else {
                c.setBackgroundColor(Color.rgb(160, 0, 0));
            }
            if (kérdésválasz.valaszlehetoseg[kerdesI][3] == kérdésválasz.helyesvalasz[kerdesI]) {
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
            valasz = "Segítséggel: "+kérdésválasz.helyesvalasz[kerdesI];
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
            if(valasz.equals(kérdésválasz.helyesvalasz[kerdesI])){
                pont++;
                //  valasz=kérdésválasz.helyesvalasz[kerdesI];
                List<Integer> correctfalse =((start)getActivity()).getCorrectfalse();
                correctfalse.add(R.drawable.correct);
            }else if(valasz!=kérdésválasz.helyesvalasz[kerdesI]){
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
            loadFragment(new fragmentered());//akkor meghívja a vége() függvényt
            return;//és visszaadja az elért ponszámokat.

        }
        kep.setImageResource(kepektomb[kerdesI].getImage());
        kerdes.setText(kérdésválasz.kérdés[kerdesI]);//menjen a következő kérdésre
        a.setText(kérdésválasz.valaszlehetoseg[kerdesI][0]); //egyesével tovább hozzá ad egyet a tömb 0. 1. 2. 3. eleméhez
        b.setText(kérdésválasz.valaszlehetoseg[kerdesI][1]);
        c.setText(kérdésválasz.valaszlehetoseg[kerdesI][2]);
        d.setText(kérdésválasz.valaszlehetoseg[kerdesI][3]);
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
