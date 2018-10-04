package com.weatherdetails.presenter;

/**
 * Created by Palak Kansal on 04/10/2018.
 */

public interface ITemperatureDetailPresenter {
    void loadTemperatureDetails(String city);
    void onDestroy();
}
