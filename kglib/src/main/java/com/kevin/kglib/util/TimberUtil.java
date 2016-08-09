package com.kevin.kglib.util;

import timber.log.Timber;

/**
 * timber相关的util
 * Created by kevin on 16/8/9.
 */

public class TimberUtil {

    private static final String KGTAG = "kgtag";

    public static void plantDebugTree() {
        Timber.plant(new Timber.DebugTree());
    }

    public static void d(String d, Object... object) {
        tag();
        Timber.d(d, object);
    }

    public static void e(String e, Object... object) {
        tag();
        Timber.e(e, object);
    }

    public static void i(String i, Object... object) {
        tag();
        Timber.i(i, object);
    }

    private static void tag() {
        Timber.tag(KGTAG);
    }
}
