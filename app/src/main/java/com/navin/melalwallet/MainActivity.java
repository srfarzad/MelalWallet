package com.navin.melalwallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.navin.melalwallet.EventBus.Events;
import com.navin.melalwallet.EventBus.GlobalBus;
import com.navin.melalwallet.fragment.CategoryFragment;
import com.navin.melalwallet.fragment.HomeFragment;
import com.navin.melalwallet.fragment.SettingFragment;
import com.navin.melalwallet.ui.main.TabsAdapter;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.bottom_navigation) BottomNavigationView bottom_navigation;

    @BindView(R.id.pager) ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //getSupportFragmentManager().beginTransaction().replace(R.id.frame,new HomeFragment()).commit();



        pager.setAdapter(new TabsAdapter(getSupportFragmentManager()));




        bottom_navigation.setOnNavigationItemSelectedListener(this);
    }


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
    protected void onStart() {
        super.onStart();
        GlobalBus.getBus().register(this);
    }
    @Subscribe
    public void getMessage(Events.FragmenActivityMessage event){
        Toast.makeText(this,event.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GlobalBus.getBus().unregister(this);
    }
}
