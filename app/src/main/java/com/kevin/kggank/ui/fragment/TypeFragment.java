package com.kevin.kggank.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jakewharton.rxbinding.support.v7.widget.RxRecyclerView;
import com.jakewharton.rxbinding.support.v7.widget.RxRecyclerViewAdapter;
import com.kevin.kggank.R;
import com.kevin.kggank.base.BaseFragment;
import com.kevin.kggank.constants.Category;
import com.kevin.kggank.entity.GanhuoTypeEntity;
import com.kevin.kggank.tool.ComposeBuild;
import com.kevin.kggank.utils.TimberUtil;
import com.kevin.kggank.viewholder.databean.GanhuoTypeBean;
import com.steve.creact.library.adapter.CommonRecyclerAdapter;
import com.steve.creact.library.display.DisplayBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class TypeFragment extends BaseFragment {

    @BindView(R.id.list)
    RecyclerView list;

    private CommonRecyclerAdapter adapter;

    public static TypeFragment getInstance() {
        return new TypeFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_type;
    }

    @Override
    protected void initView() {
        adapter = new CommonRecyclerAdapter();
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(adapter);

        List<DisplayBean> displayBeans = new ArrayList<>();

        displayBeans.add(new GanhuoTypeBean(new GanhuoTypeEntity(Category.ANDROID)));
        displayBeans.add(new GanhuoTypeBean(new GanhuoTypeEntity(Category.IOS)));
        displayBeans.add(new GanhuoTypeBean(new GanhuoTypeEntity(Category.APP)));
        displayBeans.add(new GanhuoTypeBean(new GanhuoTypeEntity(Category.WEB)));
        displayBeans.add(new GanhuoTypeBean(new GanhuoTypeEntity(Category.EXTEND)));
        displayBeans.add(new GanhuoTypeBean(new GanhuoTypeEntity(Category.RECOMMEND)));
        displayBeans.add(new GanhuoTypeBean(new GanhuoTypeEntity(Category.VIDEO)));

        // TODO: 16/5/28 Rx的用法
//        RxRecyclerViewAdapter.dataChanges(adapter)
//                .subscribeOn(Schedulers.io())
//                .onErrorResumeNext(new Func1<Throwable, Observable<? extends CommonRecyclerAdapter>>() {
//                    @Override
//                    public Observable<? extends CommonRecyclerAdapter> call(Throwable throwable) {
//                        return Observable.empty();
//                    }
//                })
//                .compose(ComposeBuild.applySchedulers())
//                .subscribe(commonRecyclerAdapter -> {
//                    commonRecyclerAdapter.loadData(displayBeans);
//                });
        adapter.loadData(displayBeans);
    }
}
