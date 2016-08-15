package com.kevin.kglib.json.gson;

import com.google.gson.Gson;
import com.kevin.kglib.utils.TimberUtils;

/**
 * gson utils
 * Created by kevin on 16/8/12.
 */

public class GsonUtils {

    public static Gson gson = new Gson();

    public static <T> T fromJson(String json, Class<T> clasz) {
        T result = null;
        try {
            result = gson.fromJson(json, clasz);
        } catch (Exception e) {
            TimberUtils.d("不能解析" + clasz.getName());
        }
        return result;
    }

    public static String toJson(Object object) {
        String result = "";
        try {
            result = gson.toJson(object);
        } catch (Exception e) {
            TimberUtils.d("对象无法转换json");
        }
        return result;
    }
}
