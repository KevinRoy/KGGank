package com.kevin.kglib.net.tool;

import com.kevin.kglib.net.NetworkManager;

/**
 * Created by kevin on 16/8/9.
 */

public class NetHelper {

    public static <T> T create(Class<T> clasz) {
        return NetworkManager.getInstance().create(clasz);
    }
}
