package com.example.testtask.entries;

import com.google.gson.annotations.SerializedName;

/**
 * Created by resident on 08.07.17.
 */
public class TariffPlane {
    private int id;
    private int condition;
    private int change;
    @SerializedName("time_interval")
    private int time_interval;
    private String description;

    public void setId(int id) {
        this.id = id;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public void setTime_interval(int time_interval) {
        this.time_interval = time_interval;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
