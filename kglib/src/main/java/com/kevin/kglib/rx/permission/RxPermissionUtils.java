package com.kevin.kglib.rx.permission;

import android.app.Activity;
import android.view.View;

import com.jakewharton.rxbinding2.view.RxView;
import com.kevin.kglib.utils.ContextUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.Observable;

/**
 * 请求权限相关
 * Created by kevin on 16/8/18.
 */

public class RxPermissionUtils {

    private static RxPermissions rxPermissions = new RxPermissions((Activity) ContextUtils.appContext);

    public static Observable request(String... permissions) {
        return rxPermissions
                .request(permissions);
    }

    public static Observable requestEach(String... permissions) {
        return rxPermissions.requestEach(permissions);
    }

    public static Observable click(View view, String... permissions) {
        return RxView.clicks(view)
                .compose(rxPermissions.ensure(permissions));
    }
}
