package com.kevin.kglib.net.tool;

import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by kevin on 16/8/15.
 */

public class ConverterFactoryHelper {

    public static Converter.Factory createMoshiFactory() {
        return MoshiConverterFactory.create();
    }

    public static Converter.Factory createGsonFactory() {
        return GsonConverterFactory.create();
    }

}
