package com.example.c0751731_mad3125_midterm.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import com.example.c0751731_mad3125_midterm.R;

public class HomeScreenActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        recyclerView = findViewById(R.id.recyclerView);

    }
}