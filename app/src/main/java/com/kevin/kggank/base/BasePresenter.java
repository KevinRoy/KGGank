package com.kevin.kggank.base;

import com.kevin.kglib.base.LibBasePresenter;

/**
 * Created by kevin on 16/4/14.
 */
public class BasePresenter<T extends IBaseView> extends LibBasePresenter<T> {

    public BasePresenter(T view) {
        super(view);
    }
}