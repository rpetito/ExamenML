package com.example.rodrigo.examenml.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L0663298 on 22/01/2018.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fragmentList = new ArrayList<>();
    }

    public void addFragment(Fragment fragment) {
        this.fragmentList.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Override
    public int getCount() {
        return fragmentList.size();
    }


}
