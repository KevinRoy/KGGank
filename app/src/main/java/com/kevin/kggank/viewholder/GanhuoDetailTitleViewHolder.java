package com.kevin.kggank.viewholder;

import android.text.TextUtils;
import android.view.View;

import com.kevin.kggank.R;
import com.steve.creact.annotation.DataBean;
import com.steve.creact.library.viewholder.BaseRecyclerViewHolder;

/**
 * Created by kevin on 16/5/23.
 */
@DataBean(beanName = "GanhuoDetailTitleBean", data = String.class)
public class GanhuoDetailTitleViewHolder extends BaseRecyclerViewHolder<String> {

    public static final int LAYOUT_ID = R.layout.item_detail_title;

    public GanhuoDetailTitleViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(String data) {
        if (TextUtils.isEmpty(data))
            return;

        setText(R.id.title, data);
    }
}
