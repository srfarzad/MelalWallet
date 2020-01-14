package com.navin.melalwallet.confiig;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDexApplication;
import androidx.room.Room;

import com.google.android.gms.ads.MobileAds;
import com.navin.melalwallet.database.AppDatabase;

public class AppConfiguration extends MultiDexApplication {


    private static AppDatabase instance=null;


    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");


       /* AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"app").build();*/


    }


    public static synchronized AppDatabase getInstance(Context context) {

        if(instance==null){


            instance = Room.databaseBuilder(context,
                    AppDatabase.class,"app").build();


        }


        return  instance;

    }





}
