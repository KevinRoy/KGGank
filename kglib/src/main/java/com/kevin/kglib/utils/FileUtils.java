package com.kevin.kglib.utils;

import android.os.Environment;

import java.io.File;

/**
 * file util
 * Created by kevin on 16/8/10.
 */

public class FileUtils {

    public static final String FILECACHE = "appCache";

    // 判断SD卡是否被挂载
    public static boolean isSDCardMounted() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    // 获取SD卡的根目录
    public static String getSDCardBaseDir() {
        if (isSDCardMounted()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return null;
    }

    // 获取缓存目录
    public static String getCacheDir() {
        String cachePath;
        if (isSDCardMounted()) {
            File outCacheFile = ContextUtils.appContext.getExternalCacheDir();
            if (outCacheFile != null) {
                cachePath = outCacheFile.getAbsolutePath();
            } else {
                String packageName = DeviceUtils.getPackageName();
                cachePath = FileUtils.getSDCardBaseDir()
                        + File.separator + FILECACHE
                        + File.separator + packageName;
            }
        } else {
            cachePath = ContextUtils.appContext.getCacheDir().getAbsolutePath();
        }
        File file = new File(cachePath);
        if (!file.exists()) file.mkdirs();
        return cachePath;
    }
}
