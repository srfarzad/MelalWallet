package com.navin.melalwallet.ui.login;

import android.app.Activity;
import android.content.Context;

public class LoginPresentor implements LoginIntractor.onLoginListener {


    LoginIntractor loginIntractor;
    ILoginView loginView;
    Activity context;

    public LoginPresentor (Activity context , ILoginView loginView, LoginIntractor loginIntractor) {
        this.context = context;
        this.loginView = loginView;
        this.loginIntractor = loginIntractor;
    }


    public void loginUser (String username , String password){

        loginView.showProgressBar();
        loginIntractor.login(context,username,password,this);


    }

    @Override
    public void onError(String reason) {
        loginView.hidesProgressBar();
        loginView.onError("");

    }

    @Override
    public void onSuccess(Object response) {
        loginView.hidesProgressBar();
        loginView.onSuccess(response);

    }

    @Override
    public void onLoginError(String response) {
        loginView.hidesProgressBar();
        loginView.onFailureError("");
    }

    @Override
    public void onUsernameError() {
        loginView.hidesProgressBar();
        loginView.onUsernameError();

    }

    @Override
    public void onPasswordError() {

        loginView.hidesProgressBar();
        loginView.onPasswordError();
    }
}
