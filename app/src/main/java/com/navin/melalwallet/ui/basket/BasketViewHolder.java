package com.navin.melalwallet.ui.basket;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.navin.melalwallet.R;
import com.navin.melalwallet.utils.CustomTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BasketViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.img_product) AppCompatImageView img_product;
    @BindView(R.id.txt_title) CustomTextView txt_title;



    public BasketViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
