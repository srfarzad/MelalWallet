package com.navin.melalwallet.webservice;

import com.navin.melalwallet.models.Category;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IService {


    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> register(@Field("username") String user, @Field("password") String pass);



    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> login(@Field("username") String user, @Field("password") String pass);


    @GET("getCategories.php")
    Call<List<Category>> getCategories();



    //RX Method


    @FormUrlEncoded
    @POST("login.php")
    Single<ResponseBody> loginUser(@Field("username") String user, @Field("password") String pass);


 //   CompletableFuture


}
