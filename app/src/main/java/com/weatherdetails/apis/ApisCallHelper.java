package com.weatherdetails.apis;

import com.weatherdetails.model.WeatherInfo;
import retrofit2.Call;

/**
 * This class contains all the retrofit apis call.
 */
public class ApisCallHelper {

    public static void getTemperatureResponse(IResponseListener<WeatherInfo> iResponseListener, String city){
        ApiServices.WeatherService weatherService = ApiManager.getInstance().createService(ApiServices.WeatherService.class);
        Call<WeatherInfo> call = weatherService.getWeatherInfo(city, "metric","c8eaaee8f8da3a3c520e00ef2bfcb7d8");
        call.enqueue(ApiManager.getInstance().addCallback(iResponseListener));
    }
}
