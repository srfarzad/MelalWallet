package com.navin.melalwallet.ui.main.fragment.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.PagerAdapter;

import com.navin.melalwallet.R;
import com.navin.melalwallet.models.Product;
import com.navin.melalwallet.webservice.ApiClient;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 9/27/2017.
 */

public class AnnouncementsAdapter extends PagerAdapter {


    Context m_context;

    List<Product> appsArrayList = new ArrayList<>();
    LayoutInflater inflater;

    public AnnouncementsAdapter(Context context, List<Product> data) {

        m_context = context;

        appsArrayList = data;

        inflater = LayoutInflater.from(m_context);

    }

    @Override
    public int getCount() {
        return appsArrayList.size();
    }


    @Override
    public Object instantiateItem(ViewGroup view, final int position) {
        View imageLayout = inflater.inflate(R.layout.news_row, view, false);

        Product images = appsArrayList.get(position);
        assert imageLayout != null;
         AppCompatImageView imageView = imageLayout.findViewById(R.id.img_news);



        Picasso.get()
                .load(ApiClient.IMAGE_URL +images.getAnnouncementUrl())
                .error(R.mipmap.ic_launcher)
                .into(imageView);

        view.addView(imageLayout, 0);


        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
