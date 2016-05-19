package com.kevin.kggank.ui.presenter;

import com.kevin.kggank.base.BasePresenter;
import com.kevin.kggank.ui.model.ListModel;
import com.kevin.kggank.ui.view.IlistView;

/**
 * Created by kevin on 16/5/18.
 */
public class ListPresenter extends BasePresenter<IlistView> {

    private ListModel model;

    public ListPresenter(IlistView mView) {
        super(mView);
        model = new ListModel(this);
    }

    public void getGanhuoOneDay() {

    }
}
