package com.kevin.kggank.ui.presenter;

import android.widget.Toast;

import com.kevin.kggank.base.BasePresenter;
import com.kevin.kggank.entity.GanhuoListEntity;
import com.kevin.kggank.ui.model.MainModel;
import com.kevin.kggank.ui.view.IMainView;
import com.kevin.kggank.utils.NetWorkUtil;

import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by kevin on 16/4/15.
 */
public class MainPresenter extends BasePresenter<IMainView> {

    private MainModel mainModel;

    public MainPresenter(IMainView mView) {
        super(mView);
        mainModel = new MainModel(this);
        getGirls(1);
    }


    public void getGirls(int pageNo) {
        if (NetWorkUtil.isConnectedByState(getContext())) {
            addSubscribe(mainModel.getGirls(pageNo).subscribeWith(new DisposableSubscriber<GanhuoListEntity>() {
                @Override
                public void onNext(GanhuoListEntity ganhuoListEntity) {
                    if (ganhuoListEntity != null &&
                            ganhuoListEntity.getResults() != null &&
                            ganhuoListEntity.getResults().size() > 0) {
                        getView().getGirls(ganhuoListEntity);
                    }
                }

                @Override
                public void onError(Throwable t) {

                }

                @Override
                public void onComplete() {

                }
            }));
        } else {
            Toast.makeText(getContext(), "没有网络连接!", Toast.LENGTH_LONG).show();
        }
    }
}
