package com.suhaas.weatherappmvp.screens;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suhaas.weatherappmvp.R;
import com.suhaas.weatherappmvp.model.WeatherResponse;

import java.util.ArrayList;

public class MainWeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder>{

    ArrayList<WeatherResponse.WeatherList> weatherLists = new ArrayList<>();

    public void swapAdapter(ArrayList<WeatherResponse.WeatherList> weatherLists){
        this.weatherLists.clear();
        this.weatherLists.addAll(weatherLists);
        notifyDataSetChanged();
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        WeatherResponse.WeatherList weatherList = weatherLists.get(position);
        holder.bind(weatherList);
    }

    @Override
    public int getItemCount() {
        if (weatherLists != null && weatherLists.size() > 0){
            return weatherLists.size();
        }else {
            return 0;
        }
    }
}
