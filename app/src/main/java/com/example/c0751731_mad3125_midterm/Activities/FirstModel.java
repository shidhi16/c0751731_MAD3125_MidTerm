package com.example.c0751731_mad3125_midterm.Activities;

public class FirstModel {

    public FirstModel() {
    }


    private String mission_name;

    public String getMission_name() {
        return mission_name;
    }

    public void setMission_name(String mission_name) {
        this.mission_name = mission_name;
    }

    public String getLaunch_year() {
        return launch_year;
    }

    public void setLaunch_year(String launch_year) {
        this.launch_year = launch_year;
    }

    public String getLaunch_date_local() {
        return launch_date_local;
    }

    public void setLaunch_date_local(String launch_date_local) {
        this.launch_date_local = launch_date_local;
    }

    public String getRocket_name() {
        return sat_name;
    }

    public void setRocket_name(String rocket_name) {
        this.sat_name = rocket_name;
    }

    public String getRocket_type() {
        return sat_type;
    }

    public void setRocket_type(String rocket_type) {
        this.sat_type = rocket_type;
    }

    public String getMission_patch_small() {
        return mission_patch_small;
    }

    public void setMission_patch_small(String mission_patch_small) {
        this.mission_patch_small = mission_patch_small;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public FirstModel(String mission_name, String launch_year, String launch_date_local, String rocket_name, String rocket_type, String mission_patch_small, String details) {
        this.mission_name = mission_name;
        this.launch_year = launch_year;
        this.launch_date_local = launch_date_local;
        this.sat_name = rocket_name;
        this.sat_type = rocket_type;
        this.mission_patch_small = mission_patch_small;
        this.details = details;
    }

    private String launch_year;
    private String launch_date_local;
    private String sat_name;
    private String sat_type;
    private String mission_patch_small;
    private String details;


}

