package com.suhaas.weatherappmvp.screens.di;

import com.suhaas.weatherappmvp.api.WeatherApi;
import com.suhaas.weatherappmvp.screens.MainActivity;
import com.suhaas.weatherappmvp.screens.coremvp.MainModel;
import com.suhaas.weatherappmvp.screens.coremvp.MainPresenter;
import com.suhaas.weatherappmvp.screens.coremvp.MainView;
import com.suhaas.weatherappmvp.utils.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

@Module
public class MainModule {

    MainActivity mainContext;

    public MainModule(MainActivity mainContext) {
        this.mainContext = mainContext;
    }

    @MainScope
    @Provides
    MainModel provideModel(WeatherApi weatherApi){
        return new MainModel(mainContext, weatherApi);
    }

    @MainScope
    @Provides
    MainView provideView(){
        return new MainView(mainContext);
    }

    @MainScope
    @Provides
    MainPresenter providePresenter(RxSchedulers rxSchedulers, MainView mainView, MainModel mainModel){
        CompositeSubscription subscriptions = new CompositeSubscription();
        return new MainPresenter(mainModel, mainView, rxSchedulers, subscriptions);
    }

    @MainScope
    @Provides
    MainActivity provideContext(){
        return mainContext;
    }

}
