package com.navin.melalwallet.models;

public enum Days {


    SAT(1), SUN(2), MON(3), TUE(4),
    WED(5), THU(6), FRI(7);


    int value;

    private Days(int value) {

        this.value = value;


    }


    public int getDay() {
        return value;
    }


    }
