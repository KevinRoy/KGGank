package com.kevin.kglib.net.tool;

import com.kevin.kglib.utils.LogUtils;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * http log helper
 * Created by kevin on 16/8/10.
 */

public class HttpLoggingHelper {

    public static final String TAG = "okhttp";

    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message -> {
        LogUtils.d(TAG, message);
    });

    public static HttpLoggingInterceptor setBody() {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }

    public static HttpLoggingInterceptor setBasic() {
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return logging;
    }

    public static HttpLoggingInterceptor setHeaders() {
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return logging;
    }
}
