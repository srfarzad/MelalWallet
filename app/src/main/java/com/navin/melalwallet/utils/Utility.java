package com.navin.melalwallet.utils;

public class Utility {

    public int getMin(int a, int b) {

        if (a > b) {
            return b;
        } else {
            return a;
        }
    }




    public boolean getZoj (int i){
        if (i%2 == 0){
            return true;
        } else {
            return false;
        }
    }
}
