package com.navin.melalwallet.webservice;

import io.reactivex.android.plugins.RxAndroidPlugins;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    static Retrofit retrofit = null;

    public static final String BASE_URL="http://androidsupport.ir/market/";
    public static final String IMAGE_URL=BASE_URL+"images/";


    public static Retrofit getRetrofit() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }


        return retrofit;
    }


}
