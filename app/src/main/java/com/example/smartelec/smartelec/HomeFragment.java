package com.example.smartelec.smartelec;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tejas on 1/20/2017.
 */

public class HomeFragment extends android.support.v4.app.Fragment implements TabLayout.OnTabSelectedListener{
    public HomeFragment(){
        super();
    }
    TabLayout tabLayout;
    private PagerAdapter pg;
    private ViewPager viewPager;
    View rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         rootview = inflater.inflate(R.layout.fragment_home, container, false);

        return rootview;



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager = (ViewPager)rootview.findViewById(R.id.view_pager);
         pg = new PagerAdapter(getFragmentManager());
        viewPager.setAdapter(pg);

        tabLayout = (TabLayout) rootview.findViewById(R.id.tab_layout);
        tabLayout.setOnTabSelectedListener(this);
        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
