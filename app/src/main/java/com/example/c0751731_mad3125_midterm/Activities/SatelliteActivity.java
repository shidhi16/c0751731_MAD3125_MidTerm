package com.example.c0751731_mad3125_midterm.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.c0751731_mad3125_midterm.R;
import com.example.c0751731_mad3125_midterm.pojo.LaunchSite;
import com.example.c0751731_mad3125_midterm.pojo.Links;
import com.example.c0751731_mad3125_midterm.pojo.Rocket;
import com.example.c0751731_mad3125_midterm.pojo.Satelite;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SatelliteActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BrandsAdapter firstAdapter;
    Context context;


    String strSatellite;
    ArrayList<Satelite> sateliteArrayList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satellite);
        setTitle("RocketList");
        context = SatelliteActivity.this;
        recyclerView = findViewById(R.id.recyclerView);
        firstAdapter = new BrandsAdapter(context, sateliteArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(firstAdapter);

        try {
            strSatellite = readSatellites("jsondata");
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        setArrayListOfSatellites();
    }

    private void setArrayListOfSatellites() {

        try {
            JSONArray satelliteArray = new JSONArray(strSatellite);
            for (int i =0 ; i<satelliteArray.length() ; i++){
                Satelite satelite = new Satelite();
                JSONObject satObject = satelliteArray.getJSONObject(i);
                satelite.setFlightNumber(satObject.getInt("flight_number"));
                satelite.setMissionName(satObject.getString("mission_name"));
                satelite.setLaunchYear(satObject.getString("launch_year"));
                satelite.setLaunchDateUnix(satObject.getInt("launch_date_unix"));

                JSONObject rocketObject = satObject.getJSONObject("rocket");
                Rocket rocket = new Rocket();
                rocket.setRocketName(rocketObject.getString("rocket_name"));
                rocket.setRocketId(rocketObject.getString("rocket_id"));
                rocket.setRocketType(rocketObject.getString("rocket_type"));
                satelite.setRocket(rocket);
                
                JSONObject launchObject = satObject.getJSONObject("launch_site");
                LaunchSite launchSite = new LaunchSite();
                launchSite.setSiteId(launchObject.getString("site_id"));
                launchSite.setSiteName(launchObject.getString("site_name"));
                launchSite.setSiteNameLong(launchObject.getString("site_name_long"));
                satelite.setLaunchSite(launchSite);

                JSONObject linksObject = satObject.getJSONObject("links");
                Links links = new Links();
                if (linksObject.has("mission_patch")){
                    links.setMissionPatch(linksObject.getString("mission_patch"));
                }
                if (linksObject.has("mission_patch_small")){
                    links.setMissionPatchSmall(linksObject.getString("mission_patch_small"));
                }
                if (linksObject.has("wikipedia")){
                    links.setWikipedia(linksObject.getString("wikipedia"));
                }
                if (linksObject.has("video_link")){
                    links.setVideoLink(linksObject.getString("video_link"));
                }
                if (linksObject.has("article_link")){
                    links.setArticleLink(linksObject.getString("article_link"));
                }
                satelite.setLinks(links);
                if (satObject.has("details") && satObject.isNull("details")){
                    satelite.setDetails(satObject.getString("details"));
                }
                sateliteArrayList.add(satelite);

                if (satObject.has("launch_success") && !satObject.isNull("launch_success")){
                    satelite.setLaunchSuccess(satObject.getBoolean("launch_success"));
                }else {
                    satelite.setLaunchSuccess(false);
                }

            }
            firstAdapter.notifyDataSetChanged();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String readSatellites(String fileName) throws IOException
    {
        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(getAssets().open(fileName), "UTF-8"));

        String context = "";
        String line;
        while ((line = reader.readLine()) != null)
        {
            context = context + line;
        }

        return context;

    }

    public class BrandsAdapter extends RecyclerView.Adapter<BrandsAdapter.Holder> {

        private ArrayList<Satelite> sateliteArrayList;
        private Context context;
        private static final String TAG = "BrandsAdapter";

        BrandsAdapter(Context context, ArrayList<Satelite> sateliteArrayList) {
            this.context = context;
            this.sateliteArrayList = sateliteArrayList;
        }

        class Holder extends RecyclerView.ViewHolder {

            final View mView;
            public TextView missionname, rocketname;
            ImageView img_view;
            CardView cardItem;


            Holder(View itemView) {
                super(itemView);
                mView = itemView;
                missionname = itemView.findViewById(R.id.missionname);
                rocketname = itemView.findViewById(R.id.rocketname);
                img_view = itemView.findViewById(R.id.img_view);
                cardItem = itemView.findViewById(R.id.cardItem);


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
            final Satelite satelite = sateliteArrayList.get(position);
            holder.missionname.setText(satelite.getMissionName());
            holder.rocketname.setText(satelite.getLaunchYear());

            Log.e(TAG, "onBindViewHolder: "+satelite.getLinks().getMissionPatchSmall() );
            if (satelite.getLinks().getMissionPatchSmall()!=null){
                Glide.with(context).load(satelite.getLinks().getMissionPatchSmall()).into(holder.img_view);
            }

            holder.cardItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,InfoScreenActivity.class);
                    intent.putExtra("data",satelite);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return sateliteArrayList.size();
        }
    }
}
