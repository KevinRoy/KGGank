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
    private Retrofit retrofit;
    private GanhuoService ganhuoService;

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
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        okhttp3.Request.Builder builder = chain.request().newBuilder();
//
//                        builder.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
//                        builder.addHeader("Connection", "Close");
//                        builder.addHeader("Charset", "UTF-8");
//
//                        return chain.proceed(builder.build());
//                    }
//                })
                .build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Host.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient);

        retrofit = builder.build();

        ganhuoService = retrofit.create(GanhuoService.class);
    }

    public GanhuoService getGanhuoService() {
        return ganhuoService;
    }
}
