package com.example.android_beadando.hibakhoz;

import java.util.ArrayList;
import java.util.List;

public class Manager {


    public static List<hibak> adatbetolt() {


        List<hibak> hibakList=new ArrayList<>();


        hibak hibak=new hibak("Nevezd meg a fent látható táblát.","Előzni tilos");
        hibakList.add(hibak);

        hibak = new hibak("Nevezd meg a fent látható táblát.", "Sebességkorlátozás");
        hibakList.add(hibak);

        hibak = new hibak("Nevezd meg a fent látható táblát.",  "Főútvonal vége");
        hibakList.add(hibak);

        hibak = new hibak("Nevezd meg a fent látható táblát.",  "kanyarodó főútvonal");
        hibakList.add(hibak);

        return hibakList;
    }
    public static List<hibak> adatbetolt2() {


        List<hibak> hibakList=new ArrayList<>();


        hibak hibak=new hibak("Mi a helyes haladási sorrend?","A B C D");
        hibakList.add(hibak);

        hibak = new hibak("Mi a helyes haladási sorrend?", "B A C");
        hibakList.add(hibak);

        hibak = new hibak("Mi a helyes haladási sorrend?",  "A C B");
        hibakList.add(hibak);

        hibak = new hibak("Mi a helyes haladási sorrend?",   "B C A");
        hibakList.add(hibak);

        hibak = new hibak("Mi a helyes haladási sorrend?",  "A C B");
        hibakList.add(hibak);

        hibak = new hibak("Mi a helyes haladási sorrend?",  "B A C");
        hibakList.add(hibak);

        hibak = new hibak("Mi a helyes haladási sorrend?",  "D B C A");
        hibakList.add(hibak);

        hibak = new hibak("Mi a helyes haladási sorrend?",  "B C A");
        hibakList.add(hibak);

        hibak = new hibak("Mi a helyes haladási sorrend?",  "A C B D");
        hibakList.add(hibak);

        hibak = new hibak("Mi a helyes haladási sorrend?",  "A C D");
        hibakList.add(hibak);

        hibak = new hibak("Mi a helyes haladási sorrend?",  "A B C");
        hibakList.add(hibak);

        hibak = new hibak("Mi a helyes haladási sorrend?",  "C D B A");
        hibakList.add(hibak);

        hibak = new hibak("Mi a helyes haladási sorrend?",  "A C B D");
        hibakList.add(hibak);

        hibak = new hibak("Mi a helyes haladási sorrend?",  "A C B");
        hibakList.add(hibak);

        hibak = new hibak("Mi a helyes haladási sorrend?",  "A D C B");
        hibakList.add(hibak);






        return hibakList;
    }

}
