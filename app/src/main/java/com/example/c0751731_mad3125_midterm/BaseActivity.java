package com.example.c0751731_mad3125_midterm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public  abstract class BaseActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected  void onStartTransitions(){

    };

    private void onFinishTransitions() {
    }

}
