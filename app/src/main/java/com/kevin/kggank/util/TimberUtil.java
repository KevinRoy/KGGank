package com.kevin.kggank.util;

import timber.log.Timber;

/**
 * Created by kevin on 16/5/15.
 */
public class TimberUtil {

    public static final String TAG = "KGGank";

    public static void d(String msg, Object... objects) {
        Timber.tag(TAG);
        Timber.d(msg, objects);
    }

    public static void i(String msg, Object... objects) {
        Timber.tag(TAG);
        Timber.i(msg, objects);
    }
}
