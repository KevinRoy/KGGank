package com.kevin.kggank.ui.presenter;

import com.kevin.kggank.base.BasePresenter;
import com.kevin.kggank.entity.GanhuoListEntity;
import com.kevin.kggank.ui.model.ListModel;
import com.kevin.kggank.ui.view.IlistView;

import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by kevin on 16/5/18.
 */
public class ListPresenter extends BasePresenter<IlistView> {

    private ListModel model = new ListModel(this);

    public ListPresenter(IlistView mView) {
        super(mView);

        getGirlInfo(1);
    }

    public void getGirlInfo(int pageNo) {
        addSubscribe(model.getGirlInfo(pageNo)
                .subscribeWith(new DisposableSubscriber<GanhuoListEntity>() {
                    @Override
                    public void onNext(GanhuoListEntity ganhuoListEntity) {
                        if (ganhuoListEntity == null ||
                                ganhuoListEntity.getResults() == null
                                || ganhuoListEntity.getResults().size() == 0)
                            return;

                        getView().getGanhuoListGril(ganhuoListEntity.getResults());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
