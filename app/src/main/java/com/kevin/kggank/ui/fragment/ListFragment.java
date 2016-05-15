package com.kevin.kggank.ui.fragment;


import android.support.v4.app.Fragment;

import com.kevin.kggank.R;
import com.kevin.kggank.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends BaseFragment {

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
