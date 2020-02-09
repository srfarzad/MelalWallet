package com.navin.melalwallet.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.navin.melalwallet.R;
import com.navin.melalwallet.models.Category;
import com.navin.melalwallet.utils.CustomTextView;
import com.navin.melalwallet.webservice.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.PourEmadiVH> {

    List<Category> categoryList;
    Context context;

    public CategoryAdapter(Context context , List<Category> categories) {
        categoryList = categories;
        this.context = context;
    }


    @NonNull
    @Override
    public PourEmadiVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.category_row,null);

        return new PourEmadiVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PourEmadiVH holder, int position) {


        Category category = categoryList.get(position);


        Picasso.get().
                load(ApiClient.IMAGE_URL +category.getIcon())
                .into(holder.img_category);

        holder.txt_title.setText(category.getTitle());




    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class PourEmadiVH extends RecyclerView.ViewHolder {

        @BindView(R.id.img_category) AppCompatImageView img_category;
        @BindView(R.id.txt_title) CustomTextView txt_title;


        public PourEmadiVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


}
