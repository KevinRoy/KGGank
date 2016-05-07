package com.kevin.kggank.ui.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.kevin.kggank.base.BasePresenter;
import com.kevin.kggank.entity.GanhuoEntity;
import com.kevin.kggank.entity.GanhuoListEntity;
import com.kevin.kggank.ui.activity.MainActivity;
import com.kevin.kggank.ui.model.MainModel;
import com.kevin.kggank.ui.view.IMainView;
import com.kevin.kggank.util.NetWorkUtils;

import java.util.List;

import rx.Observer;

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
        if (NetWorkUtils.isConnectedByState(getContext())) {
            addSubscribe(mainModel.getGirls(pageNo).subscribe(new Observer<GanhuoListEntity>() {
                @Override
                public void onCompleted() {
                    Log.i("dd", "");
                }

                @Override
                public void onError(Throwable e) {
                    Log.i("dd", "");
                }

                @Override
                public void onNext(GanhuoListEntity ganhuoListEntity) {
                    if (ganhuoListEntity != null &&
                            ganhuoListEntity.getResults() != null &&
                            ganhuoListEntity.getResults().size() > 0) {
                        getView().getGirls(ganhuoListEntity);
                    }
                }
            }));
        } else {
            Toast.makeText(getContext(), "没有网络连接!", Toast.LENGTH_LONG).show();
        }
    }
}
