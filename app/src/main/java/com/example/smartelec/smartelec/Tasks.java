package com.example.smartelec.smartelec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by tejas on 1/21/2017.
 */

public class Tasks extends android.support.v4.app.Fragment{
    public Tasks(){
        super();
    }

    private ListView listView;
    Button new_Task;
    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pager_tasks, container, false);
        listView = (ListView)rootView.findViewById(R.id.listview);
        new_Task=(Button)rootView.findViewById(R.id.new_task);



        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new_Task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),NewTask.class));

            }
        });


        final String[] Table =  new String[]{"A","B","C","D"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,android.R.id.text1, Table);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_2,android.R.id.text1, Table);
        listView.setAdapter(adapter);
        listView.setAdapter(adapter1);
    }
}
