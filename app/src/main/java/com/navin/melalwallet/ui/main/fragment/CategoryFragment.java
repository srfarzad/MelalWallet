package com.navin.melalwallet.ui.main.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navin.melalwallet.R;
import com.navin.melalwallet.models.Category;
import com.navin.melalwallet.models.IMessageListener;
import com.navin.melalwallet.ui.main.adapter.CategoryAdapter;
import com.navin.melalwallet.webservice.WebserviceCaller;
import com.navin.mellallibrary.CheckNetworkConnection;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    WebserviceCaller webserviceCaller;

    @BindView(R.id.recycler_category) RecyclerView recycler_category;


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_category, container, false);


        ButterKnife.bind(this,view);

        webserviceCaller = new WebserviceCaller();


        if(CheckNetworkConnection.isConnectionAvailable(getActivity()))
        {

        }


        webserviceCaller.getCategories(new IMessageListener() {
            @Override
            public void onResponse(Object response) {
                Log.e("","");

                List<Category> categoryList =( List<Category> )response;

                CategoryAdapter adapter = new CategoryAdapter(getActivity(),(List<Category>) categoryList);
                recycler_category.setAdapter(adapter);

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
                recycler_category.setLayoutManager(gridLayoutManager);

            }

            @Override
            public void onFailure(String errorResponse) {
                Log.e("","");
            }
        });



        return view;
    }

}
