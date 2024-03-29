
package com.example.c0751731_mad3125_midterm.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrbitParams implements Serializable {

    @SerializedName("reference_system")
    @Expose
    private String referenceSystem;
    @SerializedName("regime")
    @Expose
    private String regime;
    @SerializedName("longitude")
    @Expose
    private Object longitude;
    @SerializedName("semi_major_axis_km")
    @Expose
    private Object semiMajorAxisKm;
    @SerializedName("eccentricity")
    @Expose
    private Object eccentricity;
    @SerializedName("periapsis_km")
    @Expose
    private Integer periapsisKm;
    @SerializedName("apoapsis_km")
    @Expose
    private Integer apoapsisKm;
    @SerializedName("inclination_deg")
    @Expose
    private Integer inclinationDeg;
    @SerializedName("period_min")
    @Expose
    private Object periodMin;
    @SerializedName("lifespan_years")
    @Expose
    private Object lifespanYears;
    @SerializedName("epoch")
    @Expose
    private Object epoch;
    @SerializedName("mean_motion")
    @Expose
    private Object meanMotion;
    @SerializedName("raan")
    @Expose
    private Object raan;
    @SerializedName("arg_of_pericenter")
    @Expose
    private Object argOfPericenter;
    @SerializedName("mean_anomaly")
    @Expose
    private Object meanAnomaly;

    public String getReferenceSystem() {
        return referenceSystem;
    }

    public void setReferenceSystem(String referenceSystem) {
        this.referenceSystem = referenceSystem;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    public Object getSemiMajorAxisKm() {
        return semiMajorAxisKm;
    }

    public void setSemiMajorAxisKm(Object semiMajorAxisKm) {
        this.semiMajorAxisKm = semiMajorAxisKm;
    }

    public Object getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Object eccentricity) {
        this.eccentricity = eccentricity;
    }

    public Integer getPeriapsisKm() {
        return periapsisKm;
    }

    public void setPeriapsisKm(Integer periapsisKm) {
        this.periapsisKm = periapsisKm;
    }

    public Integer getApoapsisKm() {
        return apoapsisKm;
    }

    public void setApoapsisKm(Integer apoapsisKm) {
        this.apoapsisKm = apoapsisKm;
    }

    public Integer getInclinationDeg() {
        return inclinationDeg;
    }

    public void setInclinationDeg(Integer inclinationDeg) {
        this.inclinationDeg = inclinationDeg;
    }

    public Object getPeriodMin() {
        return periodMin;
    }

    public void setPeriodMin(Object periodMin) {
        this.periodMin = periodMin;
    }

    public Object getLifespanYears() {
        return lifespanYears;
    }

    public void setLifespanYears(Object lifespanYears) {
        this.lifespanYears = lifespanYears;
    }

    public Object getEpoch() {
        return epoch;
    }

    public void setEpoch(Object epoch) {
        this.epoch = epoch;
    }

    public Object getMeanMotion() {
        return meanMotion;
    }

    public void setMeanMotion(Object meanMotion) {
        this.meanMotion = meanMotion;
    }

    public Object getRaan() {
        return raan;
    }

    public void setRaan(Object raan) {
        this.raan = raan;
    }

    public Object getArgOfPericenter() {
        return argOfPericenter;
    }

    public void setArgOfPericenter(Object argOfPericenter) {
        this.argOfPericenter = argOfPericenter;
    }

    public Object getMeanAnomaly() {
        return meanAnomaly;
    }

    public void setMeanAnomaly(Object meanAnomaly) {
        this.meanAnomaly = meanAnomaly;
    }

}
