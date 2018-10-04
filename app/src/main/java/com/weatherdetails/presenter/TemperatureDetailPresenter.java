package com.weatherdetails.presenter;

import com.weatherdetails.interactor.ITemperatureDetailInteractor;
import com.weatherdetails.view.ITemperatureDetailView;
import com.weatherdetails.interactor.TemperatureDetailInteractor;
import com.weatherdetails.model.WeatherInfo;

/**
 * Created by Palak Kansal on 04/10/2018.
 */

public class TemperatureDetailPresenter implements ITemperatureDetailPresenter, ITemperatureDetailInteractor.onTemperatureLoadListener {
    private ITemperatureDetailView mTemperatureDetailView;
    private ITemperatureDetailInteractor mTemperatureDetailInteractor;

    public TemperatureDetailPresenter(ITemperatureDetailView temperatureDetailView) {
        this.mTemperatureDetailView = temperatureDetailView;
        this.mTemperatureDetailInteractor = new TemperatureDetailInteractor();
    }

    @Override
    public void loadTemperatureDetails(String city) {
        if (mTemperatureDetailView != null) {
            mTemperatureDetailView.showLoading();
        }
        mTemperatureDetailInteractor.loadTemperatureDetail(city,this);
    }

    @Override
    public void onDestroy() {
    mTemperatureDetailView = null;
    }

    @Override
    public void onSuccess(WeatherInfo weatherInfo) {
        mTemperatureDetailView.hideLoading();
        mTemperatureDetailView.getTemperatureDetails(weatherInfo);
    }

    @Override
    public void onFailure(int code, String message) {
        if (mTemperatureDetailView != null) {
            mTemperatureDetailView.hideLoading();
            mTemperatureDetailView.onError(code);
        }
    }

}
