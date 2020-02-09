package com.navin.melalwallet.ui.productDetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.navin.melalwallet.R;
import com.navin.melalwallet.models.Product;
import com.navin.melalwallet.ui.base.BaseActivity;
import com.navin.melalwallet.ui.main.adapter.TabsAdapter;
import com.navin.melalwallet.ui.productDetail.fragments.ProductCommentsFragment;
import com.navin.melalwallet.ui.productDetail.fragments.ProductDescriptionFragment;
import com.navin.melalwallet.ui.productDetail.fragments.ProductRelatedFragment;
import com.navin.melalwallet.utils.CustomTextView;
import com.navin.melalwallet.webservice.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProductActivity extends BaseActivity {


    @BindView(R.id.txt_page_title) CustomTextView txt_page_title;
    @BindView(R.id.txt_developer) CustomTextView txt_developer;
    @BindView(R.id.rate_product) AppCompatRatingBar rate_product;
    @BindView(R.id.img_product) AppCompatImageView img_product;
    @BindView(R.id.tabs) TabLayout tabs;
    @BindView(R.id.pager) ViewPager pager;




    Product product;

    Bundle bundle;

    @Override
    public int setContentView() {
        return R.layout.activity_product;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        bundle = getIntent().getExtras();
        product = bundle.getParcelable("data");

        Picasso.get().load(ApiClient.IMAGE_URL +
                product.getIcon()).into(img_product);


        txt_page_title.setText(product.getTitle());

        rate_product.setRating(Float.parseFloat(product.getRate()));


        List<Fragment> fragmentLis = new ArrayList<>();

        fragmentLis.add(new ProductDescriptionFragment());
        fragmentLis.add(new ProductCommentsFragment());
        fragmentLis.add(new ProductRelatedFragment());

        pager.setAdapter(new TabsAdapter(getSupportFragmentManager(),fragmentLis));


    }


}
