package com.suhaas.weatherappmvp.screens.coremvp;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.suhaas.weatherappmvp.R;
import com.suhaas.weatherappmvp.model.WeatherResponse;
import com.suhaas.weatherappmvp.screens.MainActivity;
import com.suhaas.weatherappmvp.screens.MainWeatherAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainView {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    View view;

    MainWeatherAdapter adapter;

    public MainView(MainActivity mainContext) {
        FrameLayout parent = new FrameLayout(mainContext);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(mainContext).inflate(R.layout.activity_main, parent, true);
        ButterKnife.bind(this, view);

        adapter = new MainWeatherAdapter();

        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mainContext);
        recyclerView.setLayoutManager(layoutManager);
    }

    public View view(){
        return view;
    }

    public void swapAdapter(ArrayList<WeatherResponse.WeatherList> weatherLists) {
        adapter.swapAdapter(weatherLists);
    }
}
