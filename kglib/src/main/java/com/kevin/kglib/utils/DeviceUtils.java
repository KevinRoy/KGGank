package com.kevin.kglib.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;

/**
 * 和硬件相关的 util
 * Created by kevin on 16/8/10.
 */

public class DeviceUtils {
    /**
     * 获取设备的制造商
     *
     * @return 设备制造商
     */
    public static String getDeviceManufacture() {
        return android.os.Build.MANUFACTURER;
    }

    /**
     * 获取设备名称
     *
     * @return 设备名称
     */
    public static String getDeviceName() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取设备号
     *
     * @return
     */
    public static String getDeviceIMEI() {
        TelephonyManager telephonyManager = (TelephonyManager) ContextUtils.appContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager == null || TextUtils.isEmpty(telephonyManager.getDeviceId())) {
            return Settings.Secure.getString(ContextUtils.appContext.getContentResolver(), Settings.Secure.ANDROID_ID);
        } else {
            return telephonyManager.getDeviceId();
        }
    }

    /**
     * 获取应用的版本名
     */
    public static String getAppVersion() {
        PackageManager packageManager = ContextUtils.appContext.getPackageManager();
        PackageInfo packageInfo;
        try {
            packageInfo = packageManager.getPackageInfo(ContextUtils.appContext.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取应用的包名
     *
     * @return
     */
    public static String getPackageName() {
        return ContextUtils.appContext.getPackageName();
    }

    /**
     * 获取应用的版本号
     */
    public static int getVersionCode() {
        int versionCode;
        try {
            versionCode = ContextUtils.appContext.getPackageManager()
                    .getPackageInfo(ContextUtils.appContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            versionCode = -1;
        }
        return versionCode;
    }

    /**
     * 获取屏幕的宽度
     */
    public static int getScreenWidth() {
        DisplayMetrics displayMetrics = ContextUtils.appContext.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    /**
     * 获取屏幕的高度
     */
    public static int getScreenHeight() {
        DisplayMetrics displayMetrics = ContextUtils.appContext.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }
}
