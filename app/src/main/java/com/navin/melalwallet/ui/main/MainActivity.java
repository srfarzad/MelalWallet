package com.navin.melalwallet.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.navin.melalwallet.R;
import com.navin.melalwallet.models.MessageEvent;
import com.navin.melalwallet.ui.main.adapter.TabsAdapter;
import com.navin.melalwallet.ui.main.fragment.CategoryFragment;
import com.navin.melalwallet.ui.main.fragment.SettingFragment;
import com.navin.melalwallet.ui.main.fragment.home.HomeFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.bottom_navigation) BottomNavigationView bottom_navigation;

    @BindView(R.id.pager) ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //getSupportFragmentManager().beginTransaction().replace(R.id.frame,new HomeFragment()).commit();





        List<Fragment> fragmentList = new ArrayList<>();

        fragmentList.add(new HomeFragment());
        fragmentList.add(new CategoryFragment());
        fragmentList.add(new SettingFragment());

        pager.setAdapter(new TabsAdapter(getSupportFragmentManager(),fragmentList));

        bottom_navigation.setOnNavigationItemSelectedListener(this);
    }

/*
    @OnClick(R.id.btn_click)
    public void btn_click_click() {


        MessageEvent event = new MessageEvent() ;
        event.setTitle("Shahriyar");
        event.setId(20);
        EventBus.getDefault().post(event);





    }*/


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {

            case R.id.item_home :


                //getSupportFragmentManager().beginTransaction().replace(R.id.frame,new HomeFragment()).commit();

                pager.setCurrentItem(0);


                break;

            case R.id.item_category :

              //  getSupportFragmentManager().beginTransaction().replace(R.id.frame,new CategoryFragment()).commit();

                pager.setCurrentItem(1);

                break;


            case R.id.item_setting :

               // getSupportFragmentManager().beginTransaction().replace(R.id.frame,new SettingFragment()).commit();

                pager.setCurrentItem(2);

                break;




        }

        return false;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

























}
