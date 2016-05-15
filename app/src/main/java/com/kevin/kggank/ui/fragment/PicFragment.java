package com.kevin.kggank.ui.fragment;

import com.kevin.kggank.R;
import com.kevin.kggank.base.BaseFragment;

/**
 * Created by kevin on 16/5/13.
 */
public class PicFragment extends BaseFragment {

    public static PicFragment getInstance(){
        return new PicFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_pic;
    }

    @Override
    protected void initView() {

    }
}
