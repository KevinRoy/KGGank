package com.kevin.kglib;

import android.app.Application;

import com.kevin.kglib.utils.ContextUtils;
import com.kevin.kglib.utils.TimberUtils;

import butterknife.ButterKnife;

/**
 * Created by kevin on 16/6/18.
 */

public abstract class LibBaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LibBaseConfig.baseUrl = getDefaultBaseUrl();

        if (BuildConfig.DEBUG) {
            TimberUtils.plantDebugTree();
        }

        ButterKnife.setDebug(true);
        ContextUtils.init(this);
    }

    protected abstract String getDefaultBaseUrl();
}
