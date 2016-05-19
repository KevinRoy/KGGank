package com.kevin.kggank.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.jakewharton.rxbinding.support.v7.widget.RxRecyclerView;
import com.kevin.kggank.R;
import com.kevin.kggank.base.BaseFragment;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends BaseFragment {

    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;

    public static ListFragment getInstance() {
        return new ListFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initView() {

    }
}
