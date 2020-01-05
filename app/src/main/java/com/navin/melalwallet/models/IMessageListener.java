package com.navin.melalwallet.models;

public interface IMessageListener<T> {

    public void onResponse(T response);
    public void onFailure(String errorResponse);


}
