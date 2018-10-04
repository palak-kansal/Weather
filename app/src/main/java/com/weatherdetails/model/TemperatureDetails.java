package com.weatherdetails.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Palak Kansal on 04/10/2018.
 */

public class TemperatureDetails {
    @SerializedName("temp_min")
    private int minTemp;
    @SerializedName("temp_max")
    private int maxTemp;

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }
}
