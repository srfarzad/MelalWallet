package com.navin.melalwallet.utils;

import com.navin.melalwallet.models.Metro;

public class ColorUtils {


    public static String getColor(int line) {

        String color = "";

        Metro metro = Metro.valueOf("str");


        switch (metro) {
            case TAJRISH_KAHRIZAK:

                color = "#D32F2F";

                break;
            case FARHANGSARA_SADEGHIYE:

                color = "#1E88E5";
                break;

            case GHAEM_AZADEGAN:

                color = "#4CAF50";


                break;

            case EKBATAN_KOLAHDOZ:

                color = "#FDD835";

                break;
            case SADEGHIYE_GOLSHAHR:

                color = "#64B5F6";

                break;

        }


        return color;

    }


}
