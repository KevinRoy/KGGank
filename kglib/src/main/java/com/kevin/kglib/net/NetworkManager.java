package com.kevin.kglib.net;

import android.text.TextUtils;

import com.kevin.kglib.LibBaseConfig;
import com.kevin.kglib.net.cookie.PersistentCookieJar;
import com.kevin.kglib.net.cookie.cache.SetCookieCache;
import com.kevin.kglib.net.cookie.persistence.SharedPrefsCookiePersistor;
import com.kevin.kglib.net.tool.HttpLoggingHelper;
import com.kevin.kglib.utils.ContextUtils;
import com.kevin.kglib.utils.FileUtils;
import com.kevin.kglib.utils.NetWorkUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by kevin on 16/6/17.
 */

public class NetworkManager {

    private static final int TIMEOUT = 15;
    private static volatile NetworkManager networkManager;
    private static Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private String baseUrl;
    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = chain -> {
        Request request = chain.request();

        if (!NetWorkUtils.isConnected()) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }

        Response response = chain.proceed(request);

        return response
                .newBuilder()
                .header("Cache-Control", "public, max-age=60, max-stale=2419200")
                .removeHeader("Pragma").build();
    };

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
                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(ContextUtils.appContext));

        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .cookieJar(cookieJar)
                .cache(getCache())
                .addInterceptor(HttpLoggingHelper.setBody())
                .addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient);

        retrofit = builder.build();
    }

    private Cache getCache() {
        int cacheSize;
        String cachePath = FileUtils.getCacheDir();
        if (FileUtils.isSDCardMounted()) {
            cacheSize = 100 * 1024 * 1024;
        } else {
            cacheSize = 20 * 1024 * 1024;
        }
        return new Cache(new File(cachePath), cacheSize);
    }

    public <T> T create(Class<T> clasz) {
        return retrofit.create(clasz);
    }
}
