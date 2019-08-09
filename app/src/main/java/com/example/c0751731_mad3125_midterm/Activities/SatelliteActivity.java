package com.example.c0751731_mad3125_midterm.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.c0751731_mad3125_midterm.R;

import java.util.ArrayList;
import java.util.List;

public class SatelliteActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BrandsAdapter firstAdapter;
    Context context;
    ProgressDialog myDialog;
    String url = "https://api.spacexdata.com/v3/launches";
    private List<FirstModel> firstModels = new ArrayList<FirstModel>();
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("RocketList");
        context = SatelliteActivity.this;
        recyclerView = findViewById(R.id.recycler_view);
        firstAdapter = new BrandsAdapter(context, firstModels);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        recyclerView.setAdapter(firstAdapter);

//        showdata();

    }

    public class BrandsAdapter extends RecyclerView.Adapter<BrandsAdapter.Holder> {

        private List<FirstModel> dataList;
        private Context context;

        BrandsAdapter(Context context, List<FirstModel> dataList) {
            this.context = context;
            this.dataList = dataList;
        }

        class Holder extends RecyclerView.ViewHolder {

            final View mView;
            public TextView missionname, rocketname;
            ImageView img_view;
            CardView lin1;


            Holder(View itemView) {
                super(itemView);
                mView = itemView;
                missionname = itemView.findViewById(R.id.missionname);
                rocketname = itemView.findViewById(R.id.rocketname);
                img_view = itemView.findViewById(R.id.img_view);


            }
        }

        @Override
        public BrandsAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.satadapter, parent, false);
            return new BrandsAdapter.Holder(view);
        }

        @Override
        public void onBindViewHolder(BrandsAdapter.Holder holder, final int position) {
//            int status = dataList.get(position).getStatus();
//            if (status == 1) {
            holder.rocketname.setText(dataList.get(position).getRocket_name());
            holder.missionname.setText(dataList.get(position).getMission_name());
            String img_id = dataList.get(position).getMission_patch_small();
            holder.lin1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editor.putString("image", dataList.get(position).getMission_patch_small());
                    editor.putString("r_name", dataList.get(position).getRocket_name());
                    editor.putString("m_name", dataList.get(position).getMission_name());
                    editor.putString("details", dataList.get(position).getDetails());
                    editor.putString("local_d", dataList.get(position).getLaunch_year());
                    editor.apply();
                    startActivity(new Intent(SatelliteActivity.this, InfoScreenActivity.class));
                }
            });

//            Glide.with(context).load(img_id).into(holder.img_view);
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }
    }
}
