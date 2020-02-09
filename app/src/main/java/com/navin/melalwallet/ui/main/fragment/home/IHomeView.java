package com.navin.melalwallet.ui.main.fragment.home;

public interface IHomeView<T> {


    public void showAnnouncements(T dataList);

    public void onErrorAnnouncements();

    public void onConnectionError();


    public void showBest(T dataList);

    public void onErrorBest();

    public void showProgressBarBest();

    public void hideProgressBarBest();


    public void showNew(T dataList);

    public void onErrorNew();

    public void showProgressBarNew();

    public void hideProgressBarNew();


}
