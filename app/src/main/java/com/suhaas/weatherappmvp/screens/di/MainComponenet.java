package com.suhaas.weatherappmvp.screens.di;

import com.suhaas.weatherappmvp.dependencies.AppComponent;
import com.suhaas.weatherappmvp.screens.MainActivity;

import dagger.Component;

@MainScope
@Component(dependencies = {AppComponent.class}, modules = {MainModule.class})
public interface MainComponenet {
    void inject(MainActivity mainActivity);
}
