package com.kevin.kglib.utils;

import android.content.Context;

/**
 * context 相关的util
 * Created by kevin on 16/8/7.
 */

public class ContextUtils {

    public static Context appContext;

    public static void init(Context context) {
        appContext = context.getApplicationContext();
    }
}
