package com.navin.melalwallet.ui.main.fragment.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.navin.melalwallet.R;
import com.navin.melalwallet.models.MessageEvent;
import com.navin.melalwallet.models.Product;
import com.navin.melalwallet.ui.main.fragment.home.adapter.AnnouncementsAdapter;
import com.navin.melalwallet.ui.main.fragment.home.adapter.ProductsAdapter;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements IHomeView {

    private AdView mAdView;

    HomePresenter presenter;

    int currentPage = 0;
    int sizeCount = 0;
    Runnable runnable;

    @BindView(R.id.pager) ViewPager pager;
    @BindView(R.id.dots_indicator) SpringDotsIndicator dots_indicator;
    @BindView(R.id.progress_best_product) ProgressBar progress_best_product;
    @BindView(R.id.recycler_best_product) RecyclerView recycler_best_product;
    @BindView(R.id.recycler_new_product) RecyclerView recycler_new_product;
    @BindView(R.id.progress_new_product) ProgressBar progress_new_product;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this , view);

       mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        presenter = new HomePresenter(this, new HomeIntractor());


        presenter.displayNews();


        presenter.bestProducts();

        presenter.newProducts();

        return view;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {


        Log.e("","");
        /* Do something */


    };



    @Override
    public void onStart() {
        super.onStart();

        EventBus.getDefault().register(this);


    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void showAnnouncements(Object dataList) {
    Log.e("","");


    AnnouncementsAdapter adapter = new AnnouncementsAdapter(getActivity() , (List<Product>) dataList);
        sizeCount = ((List<Product>) dataList).size();
    pager.setAdapter(adapter);


    dots_indicator.setViewPager(pager);


        Handler handler = new Handler();


         runnable = new Runnable() {
            @Override
            public void run() {

                if(currentPage==sizeCount){
                    currentPage = 0;
                }
                pager.setCurrentItem(currentPage++,true);


            }
        };


        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);

            }
        },3000,3000);




    }

    @Override
    public void onErrorAnnouncements() {

    }

    @Override
    public void onConnectionError() {

    }

    @Override
    public void showBest(Object dataList) {


        ProductsAdapter adapter = new ProductsAdapter(getActivity() , (List<Product>) dataList);

        recycler_best_product.setAdapter(adapter);


        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);

        recycler_best_product.setLayoutManager(manager);


    }

    @Override
    public void onErrorBest() {

        Toast.makeText(getActivity(),"Erro", Toast.LENGTH_LONG).show();

    }

    @Override
    public void showProgressBarBest() {

        progress_best_product.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgressBarBest() {
        progress_best_product.setVisibility(View.GONE);
    }

    @Override
    public void showNew(Object dataList) {


        ProductsAdapter adapter = new ProductsAdapter(getActivity() , (List<Product>) dataList);

        recycler_new_product.setAdapter(adapter);


        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);

        recycler_new_product.setLayoutManager(manager);

    }

    @Override
    public void onErrorNew() {

    }

    @Override
    public void showProgressBarNew() {
        progress_new_product.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBarNew() {
        progress_new_product.setVisibility(View.GONE);
    }
}
