package com.weatherdetails.view;

import com.weatherdetails.model.WeatherInfo;

/**
 * Created by Palak Kansal on 04/10/2018.
 */

public interface ITemperatureDetailView {
    void getTemperatureDetails(WeatherInfo weatherInfo);
    void onError(int code);
    void showLoading();
    void hideLoading();
}
