package com.kevin.kggank.net;

import android.content.Context;

import com.kevin.kggank.constants.Host;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kevin on 16/4/15.
 */
public class GankApi {

    private static final int TIMEOUT = 15;
    private static volatile GankApi mGankApi;
    private Retrofit mRetrofit;

    public static GankApi getInstance(Context context) {
        if (mGankApi == null) {
            synchronized (GankApi.class) {
                if (mGankApi == null) {
                    mGankApi = new GankApi(context);
                }
            }
        }
        return mGankApi;
    }

    private GankApi(Context context) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Host.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient);
    }
}
