package com.kevin.kggank.net;

import android.content.Context;

import com.kevin.kggank.constants.Host;
import com.kevin.kggank.net.service.GanhuoService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kevin on 16/4/15.
 */
public class GankApi {

    private static final int TIMEOUT = 15;
    private static volatile GankApi mGankApi;
    private static Retrofit retrofit;
    private OkHttpClient okHttpClient;

    public static GankApi getInstance() {
        if (mGankApi == null) {
            synchronized (GankApi.class) {
                if (mGankApi == null) {
                    mGankApi = new GankApi();
                }
            }
        }
        return mGankApi;
    }

    private GankApi() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Host.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient);

        retrofit = builder.build();
    }

    public <T> T create(Class<T> clasz) {
        return retrofit.create(clasz);
    }
}
