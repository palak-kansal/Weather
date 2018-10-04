package com.weatherdetails.interactor;

import com.weatherdetails.model.WeatherInfo;

/**
 * Created by Palak Kansal on 04/10/2018.
 */

public interface ITemperatureDetailInteractor {
    interface onTemperatureLoadListener{
        void onSuccess(WeatherInfo weatherInfo);
        void onFailure(int code, String message);
    }
    void loadTemperatureDetail(String city,
                             ITemperatureDetailInteractor.onTemperatureLoadListener listener);
}
