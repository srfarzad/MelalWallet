package com.navin.melalwallet.ui.productDetail.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navin.melalwallet.R;
import com.navin.melalwallet.models.Product;
import com.navin.melalwallet.ui.base.BaseFragment;
import com.navin.melalwallet.ui.productDetail.ProductActivity;
import com.navin.melalwallet.utils.CustomTextView;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDescriptionFragment extends BaseFragment {

    Product product;

    @BindView(R.id.txt_short_description) CustomTextView txt_short_description;
    @BindView(R.id.txt_full_description) CustomTextView txt_full_description;

    public ProductDescriptionFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_product_description;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ProductActivity activity = (ProductActivity)getActivity();


       product= activity.getProduct();
        txt_short_description.setText(product.getShortDescription());
        txt_full_description.setText(product.getFullDescription());

        Log.e("","");




    }
}
