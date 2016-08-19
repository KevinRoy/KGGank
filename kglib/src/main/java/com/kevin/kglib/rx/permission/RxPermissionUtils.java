package com.kevin.kglib.rx.permission;

import android.view.View;

import com.jakewharton.rxbinding.view.RxView;
import com.kevin.kglib.utils.ContextUtils;
import com.tbruyelle.rxpermissions.RxPermissions;

import rx.Observable;

/**
 * Created by kevin on 16/8/18.
 */

public class RxPermissionUtils {

    public static Observable request(String... permissions) {
        return RxPermissions.getInstance(ContextUtils.appContext)
                .request(permissions);
    }

    public static Observable requestEach(String... permissions){
        return RxPermissions.getInstance(ContextUtils.appContext)
                .requestEach(permissions);
    }

    public static Observable click(View view, String... permissions){
        return RxView.clicks(view)
                .compose(RxPermissions.getInstance(ContextUtils.appContext).ensure(permissions));
    }
}
