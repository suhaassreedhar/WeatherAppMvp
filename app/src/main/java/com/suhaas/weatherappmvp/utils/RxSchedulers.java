package com.suhaas.weatherappmvp.utils;

import rx.Scheduler;

public interface RxSchedulers {

    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();
}
