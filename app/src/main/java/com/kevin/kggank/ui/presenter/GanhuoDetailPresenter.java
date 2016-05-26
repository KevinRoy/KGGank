package com.kevin.kggank.ui.presenter;

import com.kevin.kggank.base.BasePresenter;
import com.kevin.kggank.base.IBaseView;
import com.kevin.kggank.entity.GanhuoOneDayEntity;
import com.kevin.kggank.ui.model.GanhuoDetailModel;
import com.kevin.kggank.ui.view.IGanhuoDetailView;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by kevin on 16/5/23.
 */

public class GanhuoDetailPresenter extends BasePresenter<IGanhuoDetailView> {

    private GanhuoDetailModel model;
    private List<String> dates = new ArrayList<String>();

    public GanhuoDetailPresenter(IGanhuoDetailView mView, List<String> dates) {
        super(mView);
        model = new GanhuoDetailModel(this);
        this.dates = dates;

        if (dates.size() == 3) {
            getGanhuoOneDays(dates.get(0), dates.get(1), dates.get(2));
        }
    }

    public void getGanhuoOneDays(String year, String month, String day) {
        addSubscribe(model.getGanhuoOneDays(year, month, day)
                .subscribe(new Subscriber<GanhuoOneDayEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GanhuoOneDayEntity ganhuoOneDayEntity) {
                        if (ganhuoOneDayEntity == null ||
                                ganhuoOneDayEntity.getResults() == null)
                            return;

                        getView().getGanhuoOneDay(ganhuoOneDayEntity.getResults());
                    }
                }));
    }
}
