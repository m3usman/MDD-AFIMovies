package com.example.muneeb.afi_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Muneeb on 25/11/2017.
 */

public class SplashActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        TimerTask task = new TimerTask() {

            @Override
            public void run() {

            }
        };

        Timer splash = new Timer();
        splash.schedule(task,10000);


        //start home activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


        //close splash activity
        finish();

    }//end onCreate
}//end SplashActivity