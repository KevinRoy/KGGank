package com.kevin.kggank.ui.model;

import android.util.Log;

import com.kevin.kggank.base.BaseModel;
import com.kevin.kggank.constants.Constants;
import com.kevin.kggank.entity.BaseResultEntity;
import com.kevin.kggank.entity.CategoryResultEntity;
import com.kevin.kggank.entity.GanhuoEntity;
import com.kevin.kggank.entity.GanhuoListEntity;
import com.kevin.kggank.net.GankApi;
import com.kevin.kggank.net.service.GanhuoService;
import com.kevin.kggank.tool.ComposeBuild;
import com.kevin.kggank.ui.presenter.MainPresenter;
import com.kevin.kggank.util.RxUtils;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kevin on 16/4/15.
 */
public class MainModel extends BaseModel<MainPresenter> {

    private MainPresenter mainPresenter;

    public MainModel(MainPresenter presenter) {
        super(presenter);
        mainPresenter = presenter;
    }

    public Observable<GanhuoListEntity> getGirls(int pageNo) {
        return RxUtils.create(GanhuoService.class)
                .getAndroidInfo(Constants.PAGE_SIZE, pageNo)
                .compose(ComposeBuild.applySchedulers());
    }

}
