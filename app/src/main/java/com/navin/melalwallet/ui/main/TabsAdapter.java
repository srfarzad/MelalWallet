package com.navin.melalwallet.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.navin.melalwallet.fragment.CategoryFragment;
import com.navin.melalwallet.fragment.HomeFragment;
import com.navin.melalwallet.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

public class TabsAdapter extends FragmentStatePagerAdapter {

//

    List<Fragment> fragmentList;

    public TabsAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragmentList = new ArrayList<>();

        fragmentList.add(new HomeFragment());
        fragmentList.add(new CategoryFragment());
        fragmentList.add(new SettingFragment());

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
}
