package com.kevin.kggank.ui.model;

import com.kevin.kggank.base.BaseModel;
import com.kevin.kggank.entity.GanhuoOneDayEntity;
import com.kevin.kggank.net.service.GanhuoService;
import com.kevin.kggank.ui.presenter.GanhuoDetailPresenter;
import com.kevin.kglib.rx.Compose;
import com.kevin.kglib.rx.RxUtils;

import io.reactivex.Flowable;

/**
 * Created by kevin on 16/5/23.
 */

public class GanhuoDetailModel extends BaseModel<GanhuoDetailPresenter> {

    public GanhuoDetailModel(GanhuoDetailPresenter presenter) {
        super(presenter);
    }

    public Flowable<GanhuoOneDayEntity> getGanhuoOneDays(String year, String month, String day) {
        return RxUtils.create(GanhuoService.class)
                .getGanhuoOneDays(year, month, day)
                .compose(Compose.applySchedulers());

    }
}
