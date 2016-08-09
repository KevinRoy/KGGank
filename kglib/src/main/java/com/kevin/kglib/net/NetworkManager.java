package com.kevin.kglib.net;

import android.text.TextUtils;

import com.kevin.kglib.LibBaseConfig;
import com.kevin.kglib.net.cookie.PersistentCookieJar;
import com.kevin.kglib.net.cookie.cache.SetCookieCache;
import com.kevin.kglib.net.cookie.persistence.SharedPrefsCookiePersistor;
import com.kevin.kglib.util.ContextUtil;
import com.kevin.kglib.util.TimberUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by kevin on 16/6/17.
 */

public class NetworkManager {
    public static final String TAG = "okhttp";

    private static final int TIMEOUT = 15;
    private static volatile NetworkManager networkManager;
    private static Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private String baseUrl;

    public static NetworkManager getInstance() {
        if (networkManager == null) {
            synchronized (NetworkManager.class) {
                if (networkManager == null) {
                    networkManager = new NetworkManager();
                }
            }
        }
        return networkManager;
    }

    private NetworkManager() {
        baseUrl = LibBaseConfig.baseUrl;

        if (TextUtils.isEmpty(baseUrl))
            throw new NullPointerException("baseUrl is null");




        CookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(ContextUtil.appContext));

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                TimberUtil.d(TAG, message);
            }
        });

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .cookieJar(cookieJar)
                .addInterceptor(logging)
                .build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient);

        retrofit = builder.build();
    }

    public <T> T create(Class<T> clasz) {
        return retrofit.create(clasz);
    }
}