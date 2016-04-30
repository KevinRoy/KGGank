package com.kevin.kggank.ui.presenter;

import android.content.Context;
import android.widget.Toast;

import com.kevin.kggank.base.BasePresenter;
import com.kevin.kggank.entity.GanhuoEntity;
import com.kevin.kggank.ui.model.MainModel;
import com.kevin.kggank.ui.view.IMainView;
import com.kevin.kggank.util.NetWorkUtils;

import java.util.List;

/**
 * Created by kevin on 16/4/15.
 */
public class MainPresenter extends BasePresenter<IMainView> {

    private Context context;
    private MainModel mainModel;

    public MainPresenter(IMainView mView) {
        super(mView);
        context = mView.getContext();
        mainModel = new MainModel(this);
    }

    public void getGanhuoes(){
        if (NetWorkUtils.isConnectedByState(context)) {
            mainModel.getGanhuoes();
        }else {
            Toast.makeText(context, "没有网络连接!", Toast.LENGTH_LONG).show();
        }
    }
}
