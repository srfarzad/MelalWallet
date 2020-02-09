package com.navin.melalwallet.webservice;

import android.util.Log;

import com.navin.melalwallet.models.Category;
import com.navin.melalwallet.models.IMessageListener;
import com.navin.melalwallet.models.Product;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {

    IService iService;

    @Inject
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




    public void loginUser2 (String username , String password, IMessageListener listener) {


        Single<ResponseBody> login2 = iService.loginUser(username, password);

        login2.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(ResponseBody responseBody) {

                        Log.e("","");
                        try {
                            listener.onResponse(responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailure(e.getMessage().toString());
                    }
                });







    }



    public void getAnnouncements(IMessageListener listener) {


        Call<List<Product>> call = iService.getAnnouncements();

         call.enqueue(new Callback<List<Product>>() {
             @Override
             public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                 listener.onResponse(response.body());
             }

             @Override
             public void onFailure(Call<List<Product>> call, Throwable t) {
                listener.onFailure(t.getMessage().toString());
             }
         });





    }


    public void getBestProducts(IMessageListener listener) {


        Call<List<Product>> call = iService.getBestProducts();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                listener.onFailure(t.getMessage().toString());
            }
        });





    }



    public void getNewProducts(IMessageListener listener) {


        Call<List<Product>> call = iService.getNewApplications();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                listener.onFailure(t.getMessage().toString());
            }
        });





    }







}
