package com.example.android_beadando.hibakhoz;

public class hibak {
private String kerdes;
private String valasz;
private String helyesvalasz;

    public hibak(String kerdes, String valasz, String helyesvalasz) {
        this.kerdes = kerdes;
        this.valasz = valasz;
        this.helyesvalasz = helyesvalasz;
    }

    public void setKerdes(String kerdes) {
        this.kerdes = kerdes;
    }

    public void setValasz(String valasz) {
        this.valasz = valasz;
    }

    public void setHelyesvalasz(String helyesvalasz) {
        this.helyesvalasz = helyesvalasz;
    }

    public String getKerdes() {
        return kerdes;
    }

    public String getValasz() {
        return valasz;
    }

    public String getHelyesvalasz() {
        return helyesvalasz;
    }
}
