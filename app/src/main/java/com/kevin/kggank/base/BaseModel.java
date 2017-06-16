package com.kevin.kggank.base;

import com.kevin.kglib.base.LibBaseModel;

/**
 * Created by kevin on 16/4/19.
 */
public class BaseModel<P extends BasePresenter> extends LibBaseModel<P>{

    public BaseModel(P presenter) {
        super(presenter);
    }
}
