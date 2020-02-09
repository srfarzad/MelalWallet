package com.navin.melalwallet.ui.productDetail.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navin.melalwallet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductCommentsFragment extends Fragment {


    public ProductCommentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_comments, container, false);
    }

}
