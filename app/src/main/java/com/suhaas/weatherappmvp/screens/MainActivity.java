package com.suhaas.weatherappmvp.screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.suhaas.weatherappmvp.ApplicationController;
import com.suhaas.weatherappmvp.R;
import com.suhaas.weatherappmvp.screens.coremvp.MainPresenter;
import com.suhaas.weatherappmvp.screens.coremvp.MainView;
import com.suhaas.weatherappmvp.screens.di.DaggerMainComponenet;
import com.suhaas.weatherappmvp.screens.di.MainModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainView mainView;
    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainComponenet.builder().appComponent(ApplicationController.getAppComponent()).mainModule(new MainModule(this)).build().inject(this);
        setContentView(mainView.view());
        mainPresenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
    }
}
