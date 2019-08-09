package com.example.c0751731_mad3125_midterm.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0751731_mad3125_midterm.R;

public class InfoScreenActivity extends AppCompatActivity {
    SharedPreferences preferences;
    String  image,s_name,m_name,details,local_d;
    ImageView img_view; TextView missionname,satname,date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);
        setTitle("Details");
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        image = preferences.getString("image", "");
        s_name = preferences.getString("s_name", "");
        m_name = preferences.getString("m_name", "");
        details = preferences.getString("details", "");
        local_d = preferences.getString("local_d", "");


        missionname =  findViewById(R.id.missionname);
        satname =  findViewById(R.id.rocketname);
        //description =  findViewById(R.id.description);
        date =  findViewById(R.id.date);
        img_view =  findViewById(R.id.img_detail);

        missionname.setText(m_name);
        satname.setText(s_name);
        //description.setText(details);
        date.setText(local_d);
        missionname.setText(m_name);
//        Glide.with(this).load(image).into(img_view);


    }
}

