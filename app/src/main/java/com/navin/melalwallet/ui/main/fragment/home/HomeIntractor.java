package com.navin.melalwallet.ui.main.fragment.home;

import com.navin.melalwallet.models.IMessageListener;
import com.navin.melalwallet.webservice.WebserviceCaller;

public class HomeIntractor {

    WebserviceCaller webserviceCaller;


    public HomeIntractor() {

        webserviceCaller = new WebserviceCaller();
    }


    interface IHomeListener<T> {

        public void onSuccess(T dataList);

        public void onError(String errorMessage);


        public void onSuccessBest(T dataList);

        public void onErrorBest(String errorMessage);


        public void onSuccessNew(T dataList);

        public void onErrorNew(String errorMessage);


    }



    public void callAnnouncements(IHomeListener listener) {


        webserviceCaller.getAnnouncements(new IMessageListener() {
            @Override
            public void onResponse(Object response) {

                listener.onSuccess(response);

            }

            @Override
            public void onFailure(String errorResponse) {
                listener.onError(errorResponse);
            }
        });

    }



    public void callBest(IHomeListener listener) {


        webserviceCaller.getBestProducts(new IMessageListener() {
            @Override
            public void onResponse(Object response) {

                listener.onSuccessBest(response);

            }

            @Override
            public void onFailure(String errorResponse) {
                listener.onErrorBest(errorResponse);
            }
        });

    }



    public void callNew(IHomeListener listener) {


        webserviceCaller.getNewProducts(new IMessageListener() {
            @Override
            public void onResponse(Object response) {

                listener.onSuccessNew(response);

            }

            @Override
            public void onFailure(String errorResponse) {
                listener.onErrorNew(errorResponse);
            }
        });

    }












}
