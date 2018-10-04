package com.weatherdetails.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Palak Kansal on 04/10/2018.
 */

public class Icon {
    @SerializedName("icon")
    private String iconName;

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
}
