package com.kevin.kglib.utils;

import android.text.TextUtils;
import android.util.Log;

import com.kevin.kglib.BuildConfig;

/**
 * log 相关
 * Created by kevin on 17/5/16.
 */

public class LogUtils {

    private static final String LOGTAG = "logtag";
    private static final boolean isLog = BuildConfig.DEBUG ? true : false;

    public static void d(String tag, String d) {
        if (isLog)
            Log.d(TextUtils.isEmpty(tag) ? LOGTAG : tag, d);
    }

    public static void d(String d) {
        d("", d);
    }

    public static void e(String tag, String e) {
        if (isLog)
            Log.d(TextUtils.isEmpty(tag) ? LOGTAG : tag, e);
    }

    public static void e(String e) {
        e("", e);
    }

    public static void i(String tag, String i) {
        if (isLog)
            Log.d(TextUtils.isEmpty(tag) ? LOGTAG : tag, i);
    }

    public static void i(String i) {
        i("", i);
    }
}
