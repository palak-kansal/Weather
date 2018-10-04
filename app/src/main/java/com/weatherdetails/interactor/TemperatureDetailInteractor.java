package com.weatherdetails.interactor;

import com.weatherdetails.apis.ApiException;
import com.weatherdetails.apis.ApisCallHelper;
import com.weatherdetails.apis.IResponseListener;
import com.weatherdetails.interactor.ITemperatureDetailInteractor;
import com.weatherdetails.model.WeatherInfo;

/**
 * Created by Palak Kansal on 04/10/2018.
 */

public class TemperatureDetailInteractor implements ITemperatureDetailInteractor {

    private ITemperatureDetailInteractor.onTemperatureLoadListener iListener;

    @Override
    public void loadTemperatureDetail(String city, onTemperatureLoadListener listener) {
        iListener = listener;
        ApisCallHelper.getTemperatureResponse(iResponseListener, city);
    }

    private IResponseListener<WeatherInfo> iResponseListener = new IResponseListener<WeatherInfo>() {
        @Override
        public void onResponse(ApiException exception, WeatherInfo response) {
            if(response != null){
                iListener.onSuccess(response);
            }
            else {
                iListener.onFailure(exception.getCode(), exception.getMessage());
            }
        }
    };
}
