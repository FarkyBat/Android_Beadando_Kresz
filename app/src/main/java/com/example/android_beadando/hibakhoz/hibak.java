package com.example.android_beadando.hibakhoz;

public class hibak {
    private String kerdes;

    private String helyesvalasz;


    public hibak(String kerdes, String helyesvalasz) {
        this.kerdes = kerdes;

        this.helyesvalasz = helyesvalasz;

    }

    public void setKerdes(String kerdes) {
        this.kerdes = kerdes;
    }



    public void setHelyesvalasz(String helyesvalasz) {
        this.helyesvalasz = helyesvalasz;
    }



    public String getKerdes() {
        return kerdes;
    }



    public String getHelyesvalasz() {
        return helyesvalasz;
    }

}
