package com.navin.melalwallet.ui.productDetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.navin.melalwallet.R;
import com.navin.melalwallet.database.AppDatabase;
import com.navin.melalwallet.models.Basket;
import com.navin.melalwallet.models.Product;
import com.navin.melalwallet.ui.base.BaseActivity;
import com.navin.melalwallet.ui.basket.BasketListActivity;
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
import butterknife.OnClick;

public class ProductActivity extends BaseActivity {


    @BindView(R.id.txt_page_title)
    CustomTextView txt_page_title;
    @BindView(R.id.txt_developer)
    CustomTextView txt_developer;
    @BindView(R.id.rate_product)
    AppCompatRatingBar rate_product;
    @BindView(R.id.img_product)
    AppCompatImageView img_product;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.pager) ViewPager pager;
    @BindView(R.id.toolbar) Toolbar toolbar;


    Product product;

    Bundle bundle;
    AppDatabase appDatabase;

    @Override
    public int setContentView() {
        return R.layout.activity_product;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        appDatabase = AppDatabase.getInstance(this);
        bundle = getIntent().getExtras();
        product = bundle.getParcelable("data");

        Picasso.get().load(ApiClient.IMAGE_URL +
                product.getIcon()).into(img_product);

        setSupportActionBar(toolbar);
        txt_page_title.setText(product.getTitle());

        rate_product.setRating(Float.parseFloat(product.getRate()));


        List<Fragment> fragmentLis = new ArrayList<>();

        fragmentLis.add(new ProductDescriptionFragment());
        fragmentLis.add(new ProductCommentsFragment());
        fragmentLis.add(new ProductRelatedFragment());


        List<String> titlesList = new ArrayList<>();

        titlesList.add(getString(R.string.descriptions));
        titlesList.add(getString(R.string.comments));
        titlesList.add(getString(R.string.related));


        pager.setAdapter(new TabsAdapter(getSupportFragmentManager(), fragmentLis, titlesList));


        tabs.setupWithViewPager(pager);

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.my_tab, null);
        tabOne.setText(getResources().getString(R.string.descriptions));
        // tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pencil, 0, 0);
        tabs.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.my_tab, null);
        tabTwo.setText(getResources().getString(R.string.comments));
        //  tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ref_group, 0, 0);
        tabs.getTabAt(1).setCustomView(tabTwo);


        TextView tabThrer = (TextView) LayoutInflater.from(this).inflate(R.layout.my_tab, null);
        tabThrer.setText(getResources().getString(R.string.related));
        // tabThrer.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ref_user, 0, 0);
        tabs.getTabAt(2).setCustomView(tabThrer);


    }

    public Product getProduct() {
        return product;
    }


    @OnClick(R.id.btn_add_basket)
    public void btn_add_basket_click() {

        Basket basket = new Basket(Integer.parseInt(product.getId()),product.getTitle(),product.getIcon());
        appDatabase.userDAO().insertToBasket(basket);
        Log.e("","");


    }


    @OnClick(R.id.btn_basket_list)
    public void btn_basket_list_click() {


        Intent intent = new Intent(getApplicationContext() , BasketListActivity.class);
        startActivity(intent);


    }




}
