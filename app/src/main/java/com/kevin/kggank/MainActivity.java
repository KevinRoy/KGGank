package com.kevin.kggank;

import android.os.Bundle;

import com.kevin.kggank.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setTitle(R.string.title_main);
    }
}
