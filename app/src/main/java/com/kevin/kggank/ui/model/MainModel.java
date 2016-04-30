package com.kevin.kggank.ui.model;

import android.util.Log;

import com.kevin.kggank.base.BaseModel;
import com.kevin.kggank.entity.BaseResultEntity;
import com.kevin.kggank.entity.CategoryResultEntity;
import com.kevin.kggank.entity.GanhuoEntity;
import com.kevin.kggank.net.GankApi;
import com.kevin.kggank.ui.presenter.MainPresenter;

import java.util.List;

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

    public void getGanhuoes() {
        GankApi.getInstance(mainPresenter.getView().getContext())
                .getGanhuoService().getAndroidInfo("10", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResultEntity<List<GanhuoEntity>>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("hh", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("hh", "onError");
                    }

                    @Override
                    public void onNext(BaseResultEntity<List<GanhuoEntity>> listCategoryResultEntity) {
                        Log.d("hh", listCategoryResultEntity.getResults().size() + "");
                    }
                });
    }

}
