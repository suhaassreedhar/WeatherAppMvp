package com.suhaas.weatherappmvp.screens.coremvp;


import android.util.Log;

import com.suhaas.weatherappmvp.model.WeatherResponse;
import com.suhaas.weatherappmvp.utils.RxSchedulers;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class MainPresenter {

    MainModel mainModel;
    MainView mainView;
    RxSchedulers rxSchedulers;
    CompositeSubscription subscriptions;
    List<WeatherResponse.WeatherList> weatherResponseList;

    public MainPresenter(MainModel mainModel, MainView mainView, RxSchedulers rxSchedulers, CompositeSubscription subscriptions) {
        this.mainModel = mainModel;
        this.mainView = mainView;
        this.rxSchedulers = rxSchedulers;
        this.subscriptions = subscriptions;
    }

    public void onCreate() {

        Log.d("enter to presenter", "okay");
        subscriptions.add(getWeatherList());
    }

    public void onDestroy() {
        subscriptions.clear();
    }

    private Subscription getWeatherList() {
        return mainModel.isNetworkAvailable().doOnNext(networkAvailable ->{
            if (!networkAvailable){
                Log.d("No network", "No Connection");
            }
        })
                .filter(isNetworkAvailable -> true)
                .flatMap(isAvailable -> mainModel.provideWeatherList())
                .subscribeOn(rxSchedulers.internet())
                .observeOn(rxSchedulers.androidThread())
                .subscribe(weatherList -> {
                    Log.d("Okay", "Loaded");
                    mainView.swapAdapter((ArrayList<WeatherResponse.WeatherList>) weatherList.getList());
                    weatherResponseList = weatherList.getList();
                });
    }


}
