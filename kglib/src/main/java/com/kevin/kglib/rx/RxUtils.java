package com.kevin.kglib.rx;

import com.kevin.kglib.net.NetworkManager;

/**
 * Created by kevin on 16/8/16.
 */

public class RxUtils {

    public static <T> T create(Class<T> clasz) {
        return NetworkManager.getInstance().create(clasz);
    }
}
