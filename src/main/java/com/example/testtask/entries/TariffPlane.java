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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public int getTime_interval() {
        return time_interval;
    }

    public void setTime_interval(int time_interval) {
        this.time_interval = time_interval;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
