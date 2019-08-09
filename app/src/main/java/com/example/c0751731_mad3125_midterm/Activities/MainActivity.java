package com.example.c0751731_mad3125_midterm.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0751731_mad3125_midterm.R;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    Context context;
    String url = "https://api.spacexdata.com/v3/launches";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please..wait while saving");
        progressDialog.setCancelable(false);
    }

}


