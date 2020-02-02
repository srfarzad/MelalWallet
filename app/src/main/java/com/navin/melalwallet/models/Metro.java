package com.navin.melalwallet.models;

public enum Metro {


    TAJRISH_KAHRIZAK(1), FARHANGSARA_SADEGHIYE(2), GHAEM_AZADEGAN(3), EKBATAN_KOLAHDOZ(4),

    SADEGHIYE_GOLSHAHR(5);


    int line;


    private Metro(int line) {
        this.line = line;
    }



    public int getLine() {
        return line;
    }


}
