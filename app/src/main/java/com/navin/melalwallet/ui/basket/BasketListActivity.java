package com.navin.melalwallet.ui.basket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.navin.melalwallet.R;
import com.navin.melalwallet.confiig.PrefManager;
import com.navin.melalwallet.database.AppDatabase;
import com.navin.melalwallet.ui.base.BaseActivity;
import com.navin.melalwallet.ui.login.LoginActivity;
import com.navin.melalwallet.utils.view.PersianButton;
import com.navin.mellallibrary.DrawableUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class BasketListActivity extends BaseActivity {

    AppDatabase appDatabase;
    @BindView(R.id.recycler_basket_list)
    RecyclerView recycler_basket_list;
    @BindView(R.id.btn_payment)
    PersianButton btn_payment;

    PrefManager prefManager;

    @Override
    public int setContentView() {
        return R.layout.activity_basket_list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appDatabase = AppDatabase.getInstance(this);
        prefManager = new PrefManager(this);

        recycler_basket_list.setAdapter(new BasketAdapter(this, appDatabase.userDAO().getAllBasket()));


        recycler_basket_list.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));


        //  btn_payment.setBackgroundDrawable(DrawableUtils.customView(););


        DrawableUtils.customView(this, btn_payment, R.color.green, R.color.white);


    }


    @OnClick(R.id.btn_payment)
    public void btn_payment_click() {


        if (prefManager.isLogin()) {
            Log.e("","");

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://android-learn.ir/pay"));

            startActivity(intent);


        } else {

            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);

        }


    }


}
