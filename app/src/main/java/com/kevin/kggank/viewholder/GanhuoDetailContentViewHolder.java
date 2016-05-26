package com.kevin.kggank.viewholder;

import android.view.View;

import com.kevin.kggank.R;
import com.kevin.kggank.entity.GanhuoEntity;
import com.steve.creact.annotation.DataBean;
import com.steve.creact.library.viewholder.BaseRecyclerViewHolder;

/**
 * Created by kevin on 16/5/23.
 */
@DataBean(beanName = "GanhuoDetailContentBean", data = GanhuoEntity.class)
public class GanhuoDetailContentViewHolder extends BaseRecyclerViewHolder<GanhuoEntity> {

    public static final int LAYOUT_ID = R.layout.item_detail_content;

    public GanhuoDetailContentViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(GanhuoEntity data) {
        if (data == null)
            return;

        setText(R.id.content, data.getDesc());
    }
}
