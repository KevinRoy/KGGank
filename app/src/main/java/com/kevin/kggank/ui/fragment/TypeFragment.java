package com.kevin.kggank.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.kggank.R;
import com.kevin.kggank.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class TypeFragment extends BaseFragment {

    public static TypeFragment getInstance() {
        return new TypeFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_type;
    }

    @Override
    protected void initView() {

    }

}
