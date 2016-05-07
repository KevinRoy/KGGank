package com.kevin.kggank.ui.activity;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.kevin.kggank.R;
import com.kevin.kggank.base.BaseActivity;
import com.kevin.kggank.entity.GanhuoListEntity;
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
    }

    @Override
    public void getGirls(GanhuoListEntity ganhuoListEntity) {

    }
}
