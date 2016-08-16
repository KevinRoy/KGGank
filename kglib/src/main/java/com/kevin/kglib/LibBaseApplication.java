package com.kevin.kglib;

import android.app.Application;

import com.kevin.kglib.net.tool.ConverterFactoryHelper;
import com.kevin.kglib.net.tool.HttpLoggingHelper;
import com.kevin.kglib.utils.ContextUtils;
import com.kevin.kglib.utils.TimberUtils;

import butterknife.ButterKnife;
import retrofit2.Converter;

/**
 * Created by kevin on 16/6/18.
 */

public abstract class LibBaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LibBaseConfig.baseUrl = getDefaultBaseUrl();
        LibBaseConfig.factory = getConverterFactory();

        if (BuildConfig.DEBUG) {
            TimberUtils.plantDebugTree();
        }

        ButterKnife.setDebug(true);
        ContextUtils.init(this);
    }

    /**
     * 设置主URL
     * @return
     */
    protected abstract String getDefaultBaseUrl();

    /**
     * 设置CoverterFactory 目前主要是Gson和Moshi
     * @return
     */
    protected abstract Converter.Factory getConverterFactory();
}
