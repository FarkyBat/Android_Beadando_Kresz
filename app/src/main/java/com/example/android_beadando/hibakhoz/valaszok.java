package com.example.android_beadando.hibakhoz;

import java.util.ArrayList;
import java.util.List;

public class valaszok {
public String valasz;

    public valaszok(String valasz) {
        this.valasz = valasz;
    }

    public String getValasz() {
        return valasz;
    }

    List<String> valaszok = new ArrayList<>();

    public List<String> getValaszok() {
        return valaszok;
    }
}
