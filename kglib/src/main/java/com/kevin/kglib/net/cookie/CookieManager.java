package com.kevin.kglib.net.cookie;

import com.kevin.kglib.util.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;

/**
 * Created by kevin on 16/8/9.
 */

public enum CookieManager {

    INSTANCE;

    public static final String COOKIE = "cookie_";
    public static final String COOKIE_SIZE = "cookie_size";

    public static void saveCookie(List<Cookie> cookies) {
        if (cookies == null || cookies.size() == 0)
            return;

        for (int i = 0; i < cookies.size(); i++) {
            SharedPreferencesUtil.save(COOKIE + i, cookies.get(i).toString());
        }

        SharedPreferencesUtil.save(COOKIE_SIZE, cookies.size());
    }

    public static List<String> getCookie() {
        List<String> cookies = new ArrayList<>();

        int size = SharedPreferencesUtil.get(COOKIE_SIZE, 0);

        for (int i = 0; i < size; i++) {
            String cookieString = SharedPreferencesUtil.get(COOKIE + i, "");
            cookies.add(cookieString);
        }
        return cookies;
    }
}
