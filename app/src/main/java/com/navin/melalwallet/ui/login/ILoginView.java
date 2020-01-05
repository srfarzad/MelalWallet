package com.navin.melalwallet.ui.login;

public interface ILoginView<T> {

    public void onUsernameError();

    public void onPasswordError();


    public void onFailureError(String reason);


    public void onError(String reason);


    public void onSuccess(T response);

    public void showProgressBar();

    public void hidesProgressBar();


}
