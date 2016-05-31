package com.kevin.kggank.ui.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.widget.ImageView;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.view.ViewAttachEvent;
import com.jakewharton.rxbinding.widget.RxTextView;
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

//        RxView.attaches(loadingImg)
//                .debounce()



        ((AnimationDrawable) loadingImg.getDrawable()).start();

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 2000);
    }
}
