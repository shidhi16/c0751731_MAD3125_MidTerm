
package com.example.c0751731_mad3125_midterm.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Telemetry implements Serializable {

    @SerializedName("flight_club")
    @Expose
    private Object flightClub;

    public Object getFlightClub() {
        return flightClub;
    }

    public void setFlightClub(Object flightClub) {
        this.flightClub = flightClub;
    }

}
