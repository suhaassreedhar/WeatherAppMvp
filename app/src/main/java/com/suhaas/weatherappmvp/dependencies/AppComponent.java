package com.suhaas.weatherappmvp.dependencies;

import com.suhaas.weatherappmvp.api.WeatherApi;
import com.suhaas.weatherappmvp.utils.RxSchedulers;

import dagger.Component;

@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, WeatherApiServiceModule.class})
public interface AppComponent {

    RxSchedulers rxSchedulers();
    WeatherApi apiService();
}
