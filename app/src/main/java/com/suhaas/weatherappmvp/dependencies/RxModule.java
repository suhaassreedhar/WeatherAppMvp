package com.suhaas.weatherappmvp.dependencies;

import com.suhaas.weatherappmvp.utils.RxSchedulers;
import com.suhaas.weatherappmvp.utils.RxSchedulersImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class RxModule {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new RxSchedulersImpl();
    }
}
