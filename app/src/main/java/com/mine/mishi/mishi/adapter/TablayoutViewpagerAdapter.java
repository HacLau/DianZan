package com.mine.mishi.mishi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mine.mishi.mishi.base.Contants;

import java.util.List;

/**
 * Created by liush on 2019/2/21.
 */

public class TablayoutViewpagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<String> titles;

    public TablayoutViewpagerAdapter(FragmentManager fm, List<String> titles, List<Fragment> fragments) {
        super(fm);
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int arg0) {
        return fragments.get(arg0);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position% Contants.tablayoutTitleList.size());
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
