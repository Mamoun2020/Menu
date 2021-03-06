package com.example.menu.menurestaurante;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
// FragmentStatePagerAdapter special to a lot of tabs
public class PagerAdapter extends FragmentStatePagerAdapter {
    // to save set of tabs in list , we need to adapter
    ArrayList<MainTab> tabs = new ArrayList<>();
    // array list element tab
    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    public  void addTap(MainTab mainTab){
        tabs.add(mainTab);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return tabs.get(position).getFragment_tabLayout();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        //return myTabs.get(position).getTabName();
        return  tabs.get(position).itemTab.getName_item();
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

}
