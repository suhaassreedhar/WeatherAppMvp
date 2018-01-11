package com.suhaas.weatherappmvp.dependencies;

import com.suhaas.weatherappmvp.api.WeatherApi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class WeatherApiServiceModule {

    private static final String BASE_URL = "";

    @AppScope
    @Provides
    WeatherApi provideApiService(OkHttpClient client, GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory rxJavaCallAdapterFactory){
        Retrofit retrofit = new Retrofit.Builder().client(client)
                .baseUrl(BASE_URL).addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory).build();

        return retrofit.create(WeatherApi.class);
    }

}
