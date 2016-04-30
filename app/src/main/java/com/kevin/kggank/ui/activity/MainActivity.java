package com.kevin.kggank.ui.activity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.kevin.kggank.R;
import com.kevin.kggank.base.BaseActivity;
import com.kevin.kggank.ui.presenter.MainPresenter;
import com.kevin.kggank.ui.view.IMainView;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements IMainView {
    @Nullable
    @BindView(R.id.hehe)
    TextView textView;
    private MainPresenter mMainPresenter;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setTitle(R.string.title_main);

        mMainPresenter = new MainPresenter(this);
        mMainPresenter.getGanhuoes();

    }

    @Override
    public Context getContext() {
        return this;
    }

//    @Override
//    public List<GanhuoEntity> getGanhuoes() {
//        return mMainPresenter.getGanhuoes();
//    }
}
