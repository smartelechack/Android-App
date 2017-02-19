package com.example.smartelec.smartelec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

/**
 * Created by tejas on 1/21/2017.
 */

public class Devices extends android.support.v4.app.Fragment {
    public Devices(){
        super();
    }
    GridView gridView;
    View rootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pager_devices, container, false);
        gridView = (GridView) rootView.findViewById(R.id.gridview);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gridView.setAdapter(new ImageAdapter(getContext()));

    }
}