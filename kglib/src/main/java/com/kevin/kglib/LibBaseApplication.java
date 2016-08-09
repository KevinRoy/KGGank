package com.kevin.kglib;

import android.app.Application;

import com.kevin.kglib.util.ContextUtil;
import com.kevin.kglib.util.TimberUtil;

import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by kevin on 16/6/18.
 */

public abstract class LibBaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LibBaseConfig.baseUrl = getDefaultBaseUrl();

        if (BuildConfig.DEBUG) {
            TimberUtil.plantDebugTree();
        }

        ButterKnife.setDebug(true);
        ContextUtil.init(this);
    }

    protected abstract String getDefaultBaseUrl();
}
