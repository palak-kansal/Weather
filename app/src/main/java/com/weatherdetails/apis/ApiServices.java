package com.weatherdetails.apis;

import com.weatherdetails.model.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Creates Services for retrofit
 */
public interface ApiServices {

    interface WeatherService{
        @GET("data/2.5/weather")
        Call<WeatherInfo> getWeatherInfo(@Query("q") String city,
                                         @Query("units") String units,
                                         @Query("appid") String appId);
    }
}
