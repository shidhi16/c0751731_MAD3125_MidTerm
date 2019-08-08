package com.example.c0751731_mad3125_midterm.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.c0751731_mad3125_midterm.BaseActivity;
import com.example.c0751731_mad3125_midterm.R;

public class SplashScreenActivity extends BaseActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(), LoginScreenActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch
                (InterruptedException e){
                    e.printStackTrace();
                }

            }
        };
        myThread.start();

    }

}
