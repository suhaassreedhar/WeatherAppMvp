package com.suhaas.weatherappmvp.screens;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.suhaas.weatherappmvp.R;
import com.suhaas.weatherappmvp.model.WeatherResponse;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WeatherViewHolder extends RecyclerView.ViewHolder{

    View view;

    @BindView(R.id.item_speed)
    TextView weatherSpeed;


    public WeatherViewHolder(View itemView) {
        super(itemView);
        this.view = itemView;
        ButterKnife.bind(this, view);
    }

    public void bind(WeatherResponse.WeatherList weatherList) {
        weatherSpeed.setText(String.valueOf(weatherList.getSpeed()));
    }
}
