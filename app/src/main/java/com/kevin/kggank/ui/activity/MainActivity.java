package com.kevin.kggank.ui.activity;

import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;

import com.kevin.kggank.R;
import com.kevin.kggank.base.BaseActivity;
import com.kevin.kggank.entity.GanhuoListEntity;
import com.kevin.kggank.ui.fragment.ListFragment;
import com.kevin.kggank.ui.fragment.PicFragment;
import com.kevin.kggank.ui.fragment.TypeFragment;
import com.kevin.kggank.ui.presenter.MainPresenter;
import com.kevin.kggank.ui.view.IMainView;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements IMainView {

    @BindView(R.id.realtabcontent)
    FrameLayout realtabcontent;
    @BindView(android.R.id.tabcontent)
    FrameLayout tabcontent;
    @BindView(android.R.id.tabhost)
    FragmentTabHost tabhost;
    private MainPresenter mMainPresenter;
    private LayoutInflater mLayoutInflater;

    private Class[] fragmentClass = {ListFragment.class, TypeFragment.class, PicFragment.class};
    private int[] fragmentImage = {R.mipmap.icon_tab_list, R.mipmap.icon_tab_type, R.mipmap.icon_tab_pic};

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setTitle(R.string.title_main);

        mMainPresenter = new MainPresenter(this);
        tabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mLayoutInflater = getLayoutInflater();

        for (int i = 0; i < fragmentClass.length; i++) {
            View view = mLayoutInflater.inflate(R.layout.layout_tab, null);

            ImageView imageView = (ImageView) view.findViewById(R.id.tab_img);
            imageView.setImageDrawable(getResources().getDrawable(fragmentImage[i]));

            TabHost.TabSpec tabSpec = tabhost.newTabSpec(String.valueOf(i)).setIndicator(view);

            tabhost.addTab(tabSpec, fragmentClass[i], null);
        }

        tabhost.setCurrentTab(0);
        tabhost.setOnTabChangedListener(tabId -> {
            if (tabId.endsWith("0")) {
            } else if (tabId.endsWith("1")) {
            } else {
            }
        });
    }

    @Override
    public void getGirls(GanhuoListEntity ganhuoListEntity) {

    }
}
