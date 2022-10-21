package com.example.android_beadando;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{ //gombkattintásra implementál

    TextView Kerdesszam;    //kerdesszamlalo
    TextView kerdes;    //maga a kerdes
    Button a, b, c, d;  //válaszlehetőségek
    Button next;    //tovább gomb

    int pont = 0;   //pontszámláló helyes válaszonként hozzá lesz adva egy pont.
    int kerdesek = kérdésválasz.kérdés.length;  //kérdések száma a másik osztály tömbjének darabszáma vagyis kérdésszáma..
    int kerdesI = 0;    //kérdésszámláló. amikor a nextre nyomunk hozzáad egyet.
    String valasz = ""; //a bejelölt válasz


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Kerdesszam = findViewById(R.id.kerdesszam);
        kerdes = findViewById(R.id.kerdes);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        next = findViewById(R.id.next);
        //összekötjük öket id alapján, és így adjuk nekik a funkciókat.

        //létrehozzuk a gombok működését.

        a.setOnClickListener(this::onClick); //megnyomásra történik valami...
        b.setOnClickListener(this::onClick);
        c.setOnClickListener(this::onClick);
        d.setOnClickListener(this::onClick);
        next.setOnClickListener(this);


        Kerdesszam.setText((kerdesI+1)+"/50");


    }

    @Override
    public void onClick(View view) {//itt lesznek az utasítások gombnyomásra

        a.setBackgroundColor(Color.rgb(62,133,191));
        b.setBackgroundColor(Color.rgb(62,133,191));
        c.setBackgroundColor(Color.rgb(62,133,191));
        d.setBackgroundColor(Color.rgb(62,133,191));

        Button gombnyomas = (Button) view;


        if (gombnyomas.getId()==R.id.next){ //ha megnyomjuk a next gombot,
            kerdesI++;//számlálóhoz hozzáad egyet
            Kerdesszam.setText((kerdesI+1)+"/50");
            koviKerdes();//betölti a következő kérdést
            if(valasz.equals(kérdésválasz.helyesvalasz[kerdesI])){
                pont++;
            }

        }else{
            valasz = gombnyomas.getText().toString();
            gombnyomas.setBackgroundColor(Color.BLUE);

        }



    }
    void koviKerdes(){

        if (kerdesI == kerdesek){//ha a kérdések végére ér(ugye a kerdesek egyenlő a kérdések.length-el.)
            vege(); //akkor meghívja a vége() függvényt
            return;//és visszaadja az elért ponszámokat.
        }else

            kerdes.setText(kérdésválasz.kérdés[kerdesI]);//menjen a következő kérdésre
        a.setText(kérdésválasz.valaszlehetoseg[kerdesI][0]); //egyesével tovább hozzá ad egyet a tömb 0. 1. 2. 3. eleméhez
        b.setText(kérdésválasz.valaszlehetoseg[kerdesI][1]);
        c.setText(kérdésválasz.valaszlehetoseg[kerdesI][2]);
        d.setText(kérdésválasz.valaszlehetoseg[kerdesI][3]);
    }
    void vege(){

    }

}