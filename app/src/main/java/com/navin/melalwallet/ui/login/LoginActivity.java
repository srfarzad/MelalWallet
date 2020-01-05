package com.navin.melalwallet.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.navin.melalwallet.MainActivity;
import com.navin.melalwallet.R;
import com.navin.melalwallet.models.IMessageListener;
import com.navin.melalwallet.webservice.WebserviceCaller;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.edt_username) AppCompatEditText edt_username;
    @BindView(R.id.edt_password) AppCompatEditText edt_password;
    @BindView(R.id.btn_login) AppCompatButton btn_login;
    @BindView(R.id.progress) ProgressBar progress;

    LoginPresentor loginPresentor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresentor = new LoginPresentor(this,new LoginIntractor());


    }

    @OnClick(R.id.btn_login)
    public void btn_login_click() {

        String username = edt_username.getText().toString().trim();
        String password = edt_password.getText().toString().trim();



        loginPresentor.loginUser(username,password);




    }


    @Override
    public void onUsernameError() {
        Toast.makeText(getApplicationContext(), R.string.username_required, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPasswordError() {
        Toast.makeText(getApplicationContext(), R.string.password_required, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailureError(String reason) {
        Toast.makeText(getApplicationContext(), R.string.fail_request, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String reason) {
        Toast.makeText(getApplicationContext(), R.string.wrong_user_pass, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccess(Object response) {

        finish();
        Intent intent = new Intent(getApplicationContext() , MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void showProgressBar() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidesProgressBar() {
        progress.setVisibility(View.GONE);
    }
}
