package com.kevin.kggank;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by kevin on 16/5/15.
 */
public class GankApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
