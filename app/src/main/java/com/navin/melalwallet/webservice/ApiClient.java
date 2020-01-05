package com.navin.melalwallet.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    static Retrofit retrofit = null;

    public static final String BASE_URL="http://androidsupport.ir/market/";
    public static final String IMAGE_URL=BASE_URL+"images/";


    public static Retrofit getRetrofit() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }


        return retrofit;
    }


}
