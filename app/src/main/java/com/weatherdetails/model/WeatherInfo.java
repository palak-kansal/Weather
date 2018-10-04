package com.weatherdetails.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Palak Kansal on 04/10/2018.
 */

public class WeatherInfo {
    @SerializedName("main")
    private TemperatureDetails temperatureDetails;
    @SerializedName("weather")
    private List<Icon> icon = new ArrayList<>();
    public TemperatureDetails getTemperatureDetails() {
        return temperatureDetails;
    }

    public void setTemperatureDetails(TemperatureDetails temperatureDetails) {
        this.temperatureDetails = temperatureDetails;
    }

    public List<Icon> getIcon() {
        return icon;
    }

    public void setIcon(List<Icon> icon) {
        this.icon = icon;
    }
}
