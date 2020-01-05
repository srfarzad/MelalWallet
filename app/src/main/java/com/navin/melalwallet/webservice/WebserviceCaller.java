package com.navin.melalwallet.webservice;

import android.util.Log;

import com.navin.melalwallet.models.Category;
import com.navin.melalwallet.models.IMessageListener;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {

    IService iService;

    public WebserviceCaller() {
        iService = ApiClient.getRetrofit().create(IService.class);

    }

    public void a () throws Exception {

    }

    public void loginUser (String username , String password, IMessageListener listener) {

        try {
            a();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Call<ResponseBody> login = iService.login(username , password);

        login.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                Log.e("","");
                try {
                    listener.onResponse(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                listener.onFailure(t.getMessage().toString());

            }
        });




    }



    public void getCategories(IMessageListener listener) {


       Call<List<Category>> call= iService.getCategories();

       call.enqueue(new Callback<List<Category>>() {
           @Override
           public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {


               listener.onResponse(response.body());

           }

           @Override
           public void onFailure(Call<List<Category>> call, Throwable t) {

               listener.onFailure(t.getMessage().toString());

           }
       });


    }










}
