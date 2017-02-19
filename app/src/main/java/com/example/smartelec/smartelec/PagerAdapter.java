package com.example.smartelec.smartelec;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by tejas on 1/20/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(android.support.v4.app.FragmentManager fm){
        super(fm);
    }


    @Override
    public Fragment getItem(int i) {
        Log.d("the position requested", String.format("%d",i));
        switch (i)
        {
            case 0:return new Base();
            case 1:return new Tasks();


        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);
        switch(position){
            case 0:
                return "Home";
            case 1:
                return "Tasks";
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

}
