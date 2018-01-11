package com.suhaas.weatherappmvp.screens.coremvp;


import com.suhaas.weatherappmvp.api.WeatherApi;
import com.suhaas.weatherappmvp.model.WeatherResponse;
import com.suhaas.weatherappmvp.screens.MainActivity;
import com.suhaas.weatherappmvp.utils.NetworkUtils;

import rx.Observable;

public class MainModel {

    MainActivity context;
    WeatherApi weatherApi;

    public MainModel(MainActivity context, WeatherApi weatherApi) {
        this.context = context;
        this.weatherApi = weatherApi;
    }

    Observable<WeatherResponse.WeatherList> provideWeatherList(){
        return weatherApi.getWeather();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(context);
    }

}
