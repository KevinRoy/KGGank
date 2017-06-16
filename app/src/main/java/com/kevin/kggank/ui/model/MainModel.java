package com.kevin.kggank.ui.model;

import com.kevin.kggank.base.BaseModel;
import com.kevin.kggank.constants.Constants;
import com.kevin.kggank.entity.GanhuoListEntity;
import com.kevin.kggank.net.service.GanhuoService;
import com.kevin.kggank.ui.presenter.MainPresenter;
import com.kevin.kglib.rx.Compose;
import com.kevin.kglib.rx.RxUtils;

import io.reactivex.Flowable;

/**
 * Created by kevin on 16/4/15.
 */
public class MainModel extends BaseModel<MainPresenter> {

    private MainPresenter mainPresenter;

    public MainModel(MainPresenter presenter) {
        super(presenter);
        mainPresenter = presenter;
    }

    public Flowable<GanhuoListEntity> getGirls(int pageNo) {
        return RxUtils.create(GanhuoService.class)
                .getAndroidInfo(Constants.PAGE_SIZE, pageNo)
                .compose(Compose.applySchedulers());
    }

}
