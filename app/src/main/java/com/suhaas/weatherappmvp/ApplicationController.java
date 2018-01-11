package com.suhaas.weatherappmvp;


import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.suhaas.weatherappmvp.dependencies.AppComponent;
import com.suhaas.weatherappmvp.dependencies.AppContextModule;
import com.suhaas.weatherappmvp.dependencies.DaggerAppComponent;

import timber.log.Timber;

public class ApplicationController extends Application{

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initialiseLogger();
        initialiseAppComponent();

        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
    }

    private void initialiseLogger() {
        if (BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {

                }
            });
        }
    }

    private void initialiseAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
    }

    public static AppComponent getAppComponent(){
        return appComponent;
    }
}
