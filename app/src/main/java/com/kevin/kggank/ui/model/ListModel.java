package com.kevin.kggank.ui.model;

import com.kevin.kggank.base.BaseModel;
import com.kevin.kggank.constants.Constants;
import com.kevin.kggank.entity.GanhuoListEntity;
import com.kevin.kggank.net.service.GanhuoService;
import com.kevin.kggank.ui.presenter.ListPresenter;
import com.kevin.kglib.rx.Compose;
import com.kevin.kglib.rx.RxUtils;

import io.reactivex.Flowable;


/**
 * Created by kevin on 16/5/18.
 */
public class ListModel extends BaseModel<ListPresenter> {

    public ListModel(ListPresenter presenter) {
        super(presenter);
    }

    public Flowable<GanhuoListEntity> getGirlInfo(int pageNo){
        return RxUtils.create(GanhuoService.class)
                .getGirlInfo(Constants.PAGE_SIZE, pageNo)
                .compose(Compose.applySchedulers());
    }
}
