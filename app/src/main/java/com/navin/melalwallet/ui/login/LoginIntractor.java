package com.navin.melalwallet.ui.login;

import android.content.Intent;
import android.widget.Toast;

import com.navin.melalwallet.MainActivity;
import com.navin.melalwallet.models.IMessageListener;
import com.navin.melalwallet.webservice.WebserviceCaller;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginIntractor {


    interface onLoginListener<T> {

        void onError(String reason);
        void onSuccess(T response);
        void onLoginError(String response);
        public void onUsernameError();
        public void onPasswordError();


    }





    public void login (String username , String password ,onLoginListener loginListener ) {


        if(username.isEmpty()){
            loginListener.onUsernameError();
            return;

        }

        if(password.isEmpty()){
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

                    if(res>0) {

                        loginListener.onSuccess(response);

                    }
                    else {
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
