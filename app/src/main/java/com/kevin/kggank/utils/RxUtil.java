package com.kevin.kggank.utils;

import com.kevin.kggank.net.GankApi;

import rx.Subscription;

/**
 * Created by kevin on 16/5/3.
 */
public class RxUtil {

    public static <T> T create(Class<T> clasz) {
        return GankApi.getInstance().create(clasz);
    }

    public static void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
