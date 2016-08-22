package com.kevin.kggank.ui.model;

import com.kevin.kggank.base.BaseModel;
import com.kevin.kggank.constants.Constants;
import com.kevin.kggank.entity.GanhuoListEntity;
import com.kevin.kggank.net.service.GanhuoService;
import com.kevin.kggank.tool.ComposeBuild;
import com.kevin.kggank.ui.presenter.ListPresenter;
import com.kevin.kglib.net.tool.NetHelper;

import rx.Observable;


/**
 * Created by kevin on 16/5/18.
 */
public class ListModel extends BaseModel<ListPresenter> {

    public ListModel(ListPresenter presenter) {
        super(presenter);
    }

    public Observable<GanhuoListEntity> getGirlInfo(int pageNo){
        return NetHelper.create(GanhuoService.class)
                .getGirlInfo(Constants.PAGE_SIZE, pageNo)
                .compose(ComposeBuild.applySchedulers());
    }
}
