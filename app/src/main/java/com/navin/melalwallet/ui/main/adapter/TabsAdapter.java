package com.navin.melalwallet.ui.main.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.navin.melalwallet.ui.main.fragment.CategoryFragment;
import com.navin.melalwallet.ui.main.fragment.home.HomeFragment;
import com.navin.melalwallet.ui.main.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

public class TabsAdapter extends FragmentStatePagerAdapter {

//

    List<Fragment> fragmentList;
    List<String> stringList;

    public TabsAdapter(@NonNull FragmentManager fm, List<Fragment> fragments) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        fragmentList = fragments;

    }


    public TabsAdapter(@NonNull FragmentManager fm, List<Fragment> fragments, List<String> titlesList) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        fragmentList = fragments;
        stringList = titlesList;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
}
