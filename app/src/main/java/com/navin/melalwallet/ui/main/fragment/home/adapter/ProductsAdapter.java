package com.navin.melalwallet.ui.main.fragment.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import com.navin.melalwallet.R;
import com.navin.melalwallet.di.Contact;
import com.navin.melalwallet.models.Product;
import com.navin.melalwallet.ui.productDetail.ProductActivity;
import com.navin.melalwallet.utils.CustomTextView;
import com.navin.melalwallet.webservice.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.PRViewHolder> {

    List<Product> productList;
    Context context;
    public ProductsAdapter(Context context , List<Product> products) {
        productList = products;
        this.context= context;
    }


    @NonNull
    @Override
    public PRViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.products_row,null);

        return new PRViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PRViewHolder holder, int position) {


        Product product = productList.get(position);


        Picasso.get().load(ApiClient.IMAGE_URL + product.getIcon()).into(holder.img_product);


        holder.txt_title.setText(product.getTitle());

        holder.rate_product.setRating(Float.parseFloat(product.getRate()));

        holder.linear_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(context , ProductActivity.class);

                intent.putExtra("data", product);

                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class PRViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.img_product) AppCompatImageView img_product;
        @BindView(R.id.txt_title) CustomTextView txt_title;
        @BindView(R.id.rate_product) AppCompatRatingBar rate_product;
        @BindView(R.id.linear_product) LinearLayout linear_product;


        public PRViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this , itemView);
        }
    }

}
