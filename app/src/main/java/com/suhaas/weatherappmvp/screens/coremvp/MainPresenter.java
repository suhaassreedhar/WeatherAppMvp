package com.suhaas.weatherappmvp.screens.coremvp;


import com.suhaas.weatherappmvp.model.WeatherResponse;
import com.suhaas.weatherappmvp.utils.RxSchedulers;

import java.util.ArrayList;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class MainPresenter {

    MainModel mainModel;
    MainView mainView;
    RxSchedulers rxSchedulers;
    CompositeSubscription subscriptions;
    ArrayList<WeatherResponse.WeatherList> weatherLists = new ArrayList<>();

    public MainPresenter(MainModel mainModel, MainView mainView, RxSchedulers rxSchedulers, CompositeSubscription subscriptions) {
        this.mainModel = mainModel;
        this.mainView = mainView;
        this.rxSchedulers = rxSchedulers;
        this.subscriptions = subscriptions;
    }

    public void onCreate() {

    }

    public void onDestroy() {
        subscriptions.clear();
    }

    private Subscription getWeatherList() {
        return null;
    }


}
