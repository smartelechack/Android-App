package com.example.smartelec.smartelec;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import static com.example.smartelec.smartelec.R.id.view_unit;

/**
 * Created by tejas on 1/21/2017.
 */

public class Buy_Credit extends AppCompatActivity {
    private TextView units;
    RequestQueue queue;
    private SeekBar seekBar;
    private Button buy;
    Handler handler;
    Runnable runnable;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_credit);
        try {
            units = (TextView) findViewById(view_unit);
            seekBar = (SeekBar) findViewById(R.id.seekBar);
            buy = (Button) findViewById(R.id.button);
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        queue=VolleySingleton.getInstance(this).getRequestQueue();


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                units.setText(progress + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {



            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {



            }
        }
        );

        handler=new Handler();
        runnable=new Runnable(){
            public void run()
            {
                Log.d("status","this worked");
                buy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        requestForCurrentPrice();
                    }
                });
                handler.postDelayed(runnable,10000)
                ;            }



        };
        handler.postDelayed(runnable,1000);
    }






    private void requestForCurrentPrice() {
        try {
            units = (TextView) findViewById(view_unit);

            try {
                 String num = units.getText().toString();

                final StringRequest currentPrice = new StringRequest(Request.Method.GET, String.format("http://smartelec.herokuapp.com/user_transactionsupdate?name=Paridhi&units=%s",num),
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                // Log.d("Error.Response","hahah");
                                Log.d("error", error.toString());
                            }
                        }
                );
                queue.add(currentPrice);
            } catch (Exception e) {
                //nothing happens if the textview isnt there
                Log.d("currentprice Exception",e.toString());
                e.printStackTrace();
            }
            }catch (NumberFormatException ex){
            Log.d("numb Exception",ex.toString());
        }


    }}

