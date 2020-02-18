package com.navin.melalwallet.ui.main.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.navin.melalwallet.R;
import com.navin.melalwallet.confiig.PrefManager;
import com.navin.melalwallet.models.Languages;
import com.navin.melalwallet.ui.base.BaseFragment;
import com.navin.melalwallet.utils.ApplicationManager;
import com.navin.mellallibrary.AppManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends BaseFragment {

    @BindView(R.id.spi_languages)
    Spinner spi_languages;

    PrefManager prefManager;


    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_setting;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prefManager = new PrefManager(getActivity());



        if(prefManager.getLanguage()== Languages.FARSI.getValue()){
            spi_languages.setSelection(Languages.FARSI.getValue());
        }else if(prefManager.getLanguage()==Languages.ENGLISH.getValue()){
            spi_languages.setSelection(Languages.ENGLISH.getValue());
        }

        spi_languages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                Log.e("", "");


                switch (i) {

                    case 0:
                        prefManager.setLanguage(Languages.ENGLISH.getValue());

                        break;

                    case 1:

                        prefManager.setLanguage(Languages.FARSI.getValue());

                        break;


                }







            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


    @OnClick(R.id.img_done)
    public void img_done_click() {
        AppManager.triggerRebirth(getActivity());
    }



}
