package com.kevin.kggank.base;

/**
 * Created by kevin on 16/4/19.
 */
public class BaseModel<P extends BasePresenter> {

    private P mPresenter;

    public BaseModel(P presenter) {
        this.mPresenter = presenter;
    }

    public P getPresenter() {
        return mPresenter;
    }
}
