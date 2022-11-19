package com.example.android_beadando.hibakhoz;

import com.example.android_beadando.hibakhoz.hibak;
import com.example.android_beadando.start;

import java.util.ArrayList;
import java.util.List;

public class Manager {


    public static List<hibak> adatbetolt() {


            List<hibak> hibakList=new ArrayList<>();


        hibak hibak=new hibak("Nevezd meg a fent látható táblát.","" ,"Előzni tilos");
        hibakList.add(hibak);

        hibak = new hibak("Nevezd meg a fent látható táblát.", "", "Sebességkorlátozás");
        hibakList.add(hibak);

        hibak = new hibak("Nevezd meg a fent látható táblát.", "", "Főútvonal vége");
        hibakList.add(hibak);

        hibak = new hibak("Nevezd meg a fent látható táblát.", "", "kanyarodó főútvonal");
        hibakList.add(hibak);

        return hibakList;
    }


}
