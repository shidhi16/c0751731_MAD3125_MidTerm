
package com.example.c0751731_mad3125_midterm.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SecondStage implements Serializable {

    @SerializedName("block")
    @Expose
    private Integer block;
    @SerializedName("payloads")
    @Expose
    private List<Payload> payloads = null;

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public List<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<Payload> payloads) {
        this.payloads = payloads;
    }

}
