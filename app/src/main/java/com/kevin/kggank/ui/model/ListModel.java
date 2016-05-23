package com.kevin.kggank.ui.model;

import com.kevin.kggank.base.BaseModel;
import com.kevin.kggank.constants.Constants;
import com.kevin.kggank.entity.GanhuoListEntity;
import com.kevin.kggank.entity.GanhuoOneDayEntity;
import com.kevin.kggank.net.service.GanhuoService;
import com.kevin.kggank.tool.ComposeBuild;
import com.kevin.kggank.ui.presenter.ListPresenter;
import com.kevin.kggank.utils.RxUtil;

import rx.Observable;


/**
 * Created by kevin on 16/5/18.
 */
public class ListModel extends BaseModel<ListPresenter> {

    public ListModel(ListPresenter presenter) {
        super(presenter);
    }

    public Observable<GanhuoOneDayEntity> getGanhuoOneDays(String year, String month, String day) {
        return RxUtil.create(GanhuoService.class)
                .getGanhuoOneDays(year, month, day)
                .compose(ComposeBuild.applySchedulers());

    }

    public Observable<GanhuoListEntity> getGirlInfo(int pageNo){
        return RxUtil.create(GanhuoService.class)
                .getGirlInfo(Constants.PAGE_SIZE, pageNo)
                .compose(ComposeBuild.applySchedulers());
    }
}
