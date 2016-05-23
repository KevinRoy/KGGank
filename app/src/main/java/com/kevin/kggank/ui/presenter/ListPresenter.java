package com.kevin.kggank.ui.presenter;

import com.kevin.kggank.base.BasePresenter;
import com.kevin.kggank.entity.GanhuoListEntity;
import com.kevin.kggank.entity.GanhuoOneDayEntity;
import com.kevin.kggank.ui.model.ListModel;
import com.kevin.kggank.ui.view.IlistView;
import com.kevin.kggank.utils.TimberUtil;

import rx.Subscriber;

/**
 * Created by kevin on 16/5/18.
 */
public class ListPresenter extends BasePresenter<IlistView> {

    private ListModel model = new ListModel(this);

    public ListPresenter(IlistView mView) {
        super(mView);

        getGirlInfo(1);
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

                    }
                }));
    }

    public void getGirlInfo(int pageNo) {
        addSubscribe(model.getGirlInfo(pageNo)
                .subscribe(new Subscriber<GanhuoListEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        TimberUtil.d(e.toString());
                    }

                    @Override
                    public void onNext(GanhuoListEntity ganhuoListEntity) {
                        if (ganhuoListEntity == null ||
                                ganhuoListEntity.getResults() == null
                                || ganhuoListEntity.getResults().size() == 0)
                            return;

                        getView().getGanhuoListGril(ganhuoListEntity.getResults());
                    }
                }));
    }
}
