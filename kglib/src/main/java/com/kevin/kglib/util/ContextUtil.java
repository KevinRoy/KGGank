package com.kevin.kglib.util;

import android.content.Context;

/**
 * context 相关的util
 * Created by kevin on 16/8/7.
 */

public class ContextUtil {

    public static Context appContext;

    public static void init(Context context) {
        appContext = context.getApplicationContext();
    }
}
