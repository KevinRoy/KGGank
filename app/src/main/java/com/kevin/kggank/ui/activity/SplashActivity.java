package com.kevin.kggank.ui.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.widget.ImageView;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.view.ViewAttachEvent;
import com.kevin.kggank.R;
import com.kevin.kggank.base.BaseActivity;

import butterknife.BindView;
import rx.Observable;
import rx.functions.Func1;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.loading_img)
    ImageView loadingImg;

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

        new Handler().postDelayed(() -> {

        }, 2000);

        ((AnimationDrawable) loadingImg.getDrawable()).start();
    }
}
