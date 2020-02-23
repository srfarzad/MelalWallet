package com.navin.melalwallet.ui.basket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.navin.melalwallet.R;
import com.navin.melalwallet.models.Basket;
import com.navin.melalwallet.webservice.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BasketAdapter extends RecyclerView.Adapter<BasketViewHolder> {

    Context context;
    List<Basket> basketList;

    public BasketAdapter(Context context, List<Basket> baskets) {
        this.context = context;
        this.basketList = baskets;

    }

    @NonNull
    @Override
    public BasketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.basket_row, null);
        return new BasketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BasketViewHolder holder, int position) {


        Basket basket = basketList.get(position);

        Picasso.get().load(ApiClient.IMAGE_URL + basket.getIcon()).into(holder.img_product);

        holder.txt_title.setText(basket.getTitle());


    }

    @Override
    public int getItemCount() {
        return basketList.size();
    }
}
