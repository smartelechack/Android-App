package com.example.smartelec.smartelec;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

public class Launcher extends AppCompatActivity {
    private Handler handler;
    private Runnable runable;
    private Boolean status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        status=false;
        handler = new Handler();

        runable = new Runnable(){
            public void run(){
                if(status==false){
                    startActivity(new Intent(getApplicationContext(), login.class));
                }
            }
        };
        handler.postDelayed(runable,3000);



    }
}
