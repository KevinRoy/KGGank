package com.kevin.kggank.viewholder;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kevin.kggank.R;
import com.steve.creact.annotation.DataBean;
import com.steve.creact.library.viewholder.BaseRecyclerViewHolder;

/**
 * Created by kevin on 16/5/26.
 */
@DataBean(beanName = "GanhuoDetailImgBean", data = String.class)
public class GanhuoDetailImgViewHolder extends BaseRecyclerViewHolder<String> {

    public static final int LAYOUT_ID = R.layout.item_detail_img;

    public GanhuoDetailImgViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(String data) {
        if (data == null)
            return;

        ImageView imageView = getView(R.id.img);

        Glide.with(getContext())
                .load(data)
                .into(imageView);
    }
}
