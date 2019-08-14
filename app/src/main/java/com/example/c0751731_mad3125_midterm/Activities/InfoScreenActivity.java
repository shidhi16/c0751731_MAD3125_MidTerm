package com.example.c0751731_mad3125_midterm.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.c0751731_mad3125_midterm.R;
import com.example.c0751731_mad3125_midterm.pojo.Satelite;

public class InfoScreenActivity extends AppCompatActivity {
    SharedPreferences preferences;
    ImageView imgSat;
    TextView tvMissionName;
    TextView tvFlightNo;
    //TextView tvLaunchDate;
    TextView tvLaunchYear;
    TextView tvMissionID;
    TextView tvDesc;
    Button btnWiki;


    Satelite modal ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);
        setTitle("Details");

        if (getIntent().getExtras()!=null){
            modal = (Satelite) getIntent().getSerializableExtra("data");
        }

        tvMissionName =  findViewById(R.id.tvMissionName);
        imgSat = findViewById(R.id.imgSat);
        tvMissionName.setText(modal.getMissionName());

        tvFlightNo = findViewById(R.id.tvFlightNo);
        tvFlightNo.setText(modal.getFlightNumber());
        //tvLaunchDate.setText(modal.getLaunchDateUnix());

        tvLaunchYear = findViewById(R.id.tvLaunchYear);
        tvLaunchYear.setText(modal.getLaunchYear());
        tvMissionID = findViewById(R.id.tvMissionID);
        tvMissionID.setText(modal.getMissionId());

        tvDesc = findViewById(R.id.tvDesc);
        tvDesc.setText(modal.getDetails());

        btnWiki = findViewById(R.id.btn_wiki);



        Glide.with(this).load(modal.getLinks().getMissionPatchSmall()).into(imgSat);



    }
}

