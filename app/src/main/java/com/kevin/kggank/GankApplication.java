package com.kevin.kggank;

import com.kevin.kggank.constants.Host;
import com.kevin.kglib.LibBaseApplication;
import com.kevin.kglib.net.tool.ConverterFactoryHelper;

import retrofit2.Converter;

/**
 * Created by kevin on 16/5/15.
 */
public class GankApplication extends LibBaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected String getDefaultBaseUrl() {
        return Host.BASE_URL;
    }

    @Override
    protected Converter.Factory getConverterFactory() {
        return ConverterFactoryHelper.createGsonFactory();
    }
}
