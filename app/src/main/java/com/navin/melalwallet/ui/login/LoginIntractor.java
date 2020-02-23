package com.navin.melalwallet.ui.login;

import android.app.Activity;

import com.navin.melalwallet.confiig.PrefManager;
import com.navin.melalwallet.models.IMessageListener;
import com.navin.melalwallet.webservice.WebserviceCaller;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginIntractor {

    PrefManager prefManager;

    interface onLoginListener<T> {

        void onError(String reason);

        void onSuccess(T response);

        void onLoginError(String response);

        public void onUsernameError();

        public void onPasswordError();


    }


    public void login(Activity context, String username, String password, onLoginListener loginListener) {

        prefManager = new PrefManager(context);


        if (username.isEmpty()) {
            loginListener.onUsernameError();
            return;

        }

        if (password.isEmpty()) {
            loginListener.onPasswordError();
            return;
        }


        WebserviceCaller webserviceCaller = new WebserviceCaller();

        webserviceCaller.loginUser(username, password, new IMessageListener() {
            @Override
            public void onResponse(Object response) {


                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    int res = jsonObject.getInt("code");

                    if (res > 0) {

                        loginListener.onSuccess(response);
                        prefManager.setLogin(true);

                    } else {
                        loginListener.onError("");

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(String errorResponse) {

                loginListener.onLoginError("");

            }
        });


    }


}
