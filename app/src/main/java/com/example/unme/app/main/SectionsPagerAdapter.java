package com.example.unme.app.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.unme.R;
import com.example.unme.app.Products.BeverFragment;
import com.example.unme.app.Products.DealsFragment;
import com.example.unme.app.Products.ForOne;
import com.example.unme.app.Products.ForShareFragment;
import com.example.unme.app.Products.SidesFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = "APP_Fragment";
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3,R.string.tab_text_4,R.string.tab_text_5};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new DealsFragment();
                break;
            case 1:
                fragment = new ForOne();
                break;
            case 2:
                fragment = new ForShareFragment();
                break;
            case 3:
                fragment = new SidesFragment();
                break;
            case 4:
                fragment = new BeverFragment();
                break;
        }
            return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 5;
    }
}