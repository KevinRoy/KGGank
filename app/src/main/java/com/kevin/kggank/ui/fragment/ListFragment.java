package com.kevin.kggank.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jakewharton.rxbinding.support.v7.widget.RxRecyclerView;
import com.kevin.kggank.R;
import com.kevin.kggank.base.BaseFragment;
import com.kevin.kggank.entity.GanhuoEntity;
import com.kevin.kggank.entity.GanhuoOneDayEntity;
import com.kevin.kggank.ui.presenter.ListPresenter;
import com.kevin.kggank.ui.view.IlistView;
import com.kevin.kggank.utils.TimberUtil;
import com.kevin.kggank.viewholder.databean.GanhuoListGirlDayBean;
import com.steve.creact.library.adapter.CommonRecyclerAdapter;
import com.steve.creact.library.display.DisplayBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends BaseFragment implements IlistView {

    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;

    private CommonRecyclerAdapter adapter;
    private ListPresenter listPresenter;

    public static ListFragment getInstance() {
        return new ListFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initView() {
        adapter = new CommonRecyclerAdapter();
        listPresenter = new ListPresenter(this);

        list.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void getGanhuoListGril(List<GanhuoEntity> entities) {

        List<DisplayBean> displayBeans = new ArrayList<>();

        if (entities == null || entities.size() == 0)
            return;

        for (int i = 0; i < entities.size(); i++) {
            displayBeans.add(new GanhuoListGirlDayBean(entities.get(i)));
        }

        adapter.loadData(displayBeans);
        list.setAdapter(adapter);
    }
}
