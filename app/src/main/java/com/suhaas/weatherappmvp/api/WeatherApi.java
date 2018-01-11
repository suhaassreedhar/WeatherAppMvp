package com.suhaas.weatherappmvp.api;


import com.suhaas.weatherappmvp.model.WeatherResponse;

import retrofit2.http.GET;
import rx.Observable;

public interface WeatherApi {

    @GET("staticweather")
    Observable<WeatherResponse.CityBean> getCity();

    @GET("staticweather")
    Observable<WeatherResponse.WeatherList> getWeather();
}
