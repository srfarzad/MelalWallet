package com.navin.melalwallet.confiig;

import android.app.Application;

import androidx.multidex.MultiDexApplication;

import com.google.android.gms.ads.MobileAds;

public class AppConfiguration extends MultiDexApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
    }
}
