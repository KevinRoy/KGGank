package com.kevin.kggank.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.kevin.kggank.R;
import com.kevin.kggank.base.BaseActivity;
import com.kevin.kggank.entity.GanhuoEntity;
import com.kevin.kggank.entity.GanhuoOneDayEntity;
import com.kevin.kggank.ui.presenter.GanhuoDetailPresenter;
import com.kevin.kggank.ui.view.IGanhuoDetailView;
import com.kevin.kggank.viewholder.databean.GanhuoDetailContentBean;
import com.kevin.kggank.viewholder.databean.GanhuoDetailImgBean;
import com.kevin.kggank.viewholder.databean.GanhuoDetailTitleBean;
import com.steve.creact.library.adapter.CommonRecyclerAdapter;
import com.steve.creact.library.display.DisplayBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by kevin on 16/5/22.
 */

public class GanhuoDetailActivity extends BaseActivity implements IGanhuoDetailView {

    public static final String DETAIL = "detail";

    @BindView(R.id.list)
    RecyclerView list;

    private GanhuoDetailPresenter ganhuoDetailPresenter;
    private CommonRecyclerAdapter adapter;
    private List<DisplayBean> displayBeans = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.activity_ganhuo_detail;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void initView() {
        setTitle(R.string.title_detail);

        if (getIntent() == null)
            return;

        List<String> strings = getIntent().getStringArrayListExtra(DETAIL);
        ganhuoDetailPresenter = new GanhuoDetailPresenter(GanhuoDetailActivity.this, strings);

        list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CommonRecyclerAdapter();
    }

    @Override
    public void getGanhuoOneDay(GanhuoOneDayEntity.GanhuoOneDayDataEntity entity) {
        if (entity == null)
            return;

        List<GanhuoEntity> imgs;

        if ((imgs = entity.getGirlInfo()) != null && imgs.size() > 0) {
            for (int i = 0; i < imgs.size(); i++) {
                displayBeans.add(new GanhuoDetailImgBean(imgs.get(i).getUrl()));
            }
        }

        addInfo(entity.getAndroidInfo());
        addInfo(entity.getIosInfo());
        addInfo(entity.getAppInfo());
        addInfo(entity.getWebInfo());
        addInfo(entity.getExtendInfo());
        addInfo(entity.getRecommendInfo());
        addInfo(entity.getVideoInfo());

        adapter.loadData(displayBeans);
        list.setAdapter(adapter);
    }

    private void addInfo(List<GanhuoEntity> entities) {
        if (entities != null && entities.size() > 0) {
            displayBeans.add(new GanhuoDetailTitleBean(entities.get(0).getType()));
            for (int i = 0; i < entities.size(); i++) {
                displayBeans.add(new GanhuoDetailContentBean(entities.get(i)));
            }
        }
    }
}
