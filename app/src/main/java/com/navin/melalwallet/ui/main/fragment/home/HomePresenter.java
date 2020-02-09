package com.navin.melalwallet.ui.main.fragment.home;

public class HomePresenter implements HomeIntractor.IHomeListener {


    IHomeView iHomeView;
    HomeIntractor intractor;

    public HomePresenter (IHomeView iHomeView, HomeIntractor intractor) {
        this.iHomeView=iHomeView;
        this.intractor=intractor;

    }

    public void displayNews(){
        intractor.callAnnouncements(this);
    }
    public void bestProducts() {


        iHomeView.showProgressBarBest();
        intractor.callBest(this);

    }

    public void newProducts() {


        iHomeView.showProgressBarNew();
        intractor.callNew(this);

    }

    @Override
    public void onSuccess(Object dataList) {

        iHomeView.showAnnouncements(dataList);

    }

    @Override
    public void onError(String errorMessage) {
            iHomeView.onErrorAnnouncements();
    }

    @Override
    public void onSuccessBest(Object dataList) {

        iHomeView.hideProgressBarBest();
        iHomeView.showBest(dataList);

    }

    @Override
    public void onErrorBest(String errorMessage) {
        iHomeView.hideProgressBarBest();
        iHomeView.onErrorBest();

    }

    @Override
    public void onSuccessNew(Object dataList) {
        iHomeView.hideProgressBarNew();
        iHomeView.showNew(dataList);
    }

    @Override
    public void onErrorNew(String errorMessage) {
        iHomeView.hideProgressBarNew();
        iHomeView.onErrorNew();
    }
}
