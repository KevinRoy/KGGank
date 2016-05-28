package com.kevin.kggank.viewholder;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.FrameLayout;

import com.kevin.kggank.R;
import com.kevin.kggank.constants.Category;
import com.kevin.kggank.entity.GanhuoTypeEntity;
import com.steve.creact.annotation.DataBean;
import com.steve.creact.library.viewholder.BaseRecyclerViewHolder;

/**
 * Created by kevin on 16/5/26.
 */
@DataBean(beanName = "GanhuoTypeBean", data = GanhuoTypeEntity.class)
public class GanhuoTypeViewHolder extends BaseRecyclerViewHolder<GanhuoTypeEntity> {

    public static final int LAYOUT_ID = R.layout.item_type;

    public GanhuoTypeViewHolder(View itemView) {
        super(itemView);
    }

    @ColorInt
    int bgColor;

    @IdRes
    int imgRes;

    @Override
    public void setData(GanhuoTypeEntity data) {
        if (data == null)
            return;

        FrameLayout frameLayout = getView(R.id.layout);

        String type = data.getType();
        int imgRes = 0;

        if (type.equals(Category.ANDROID)) {
            imgRes = R.mipmap.icon_android;
            bgColor = getColorRes(R.color.color_B3a9ff79);
        } else if (type.equals(Category.IOS)) {
            imgRes = R.mipmap.icon_apple;
            bgColor = getColorRes(R.color.color_B3e6e6e6);
        } else if (type.equals(Category.APP)) {
            imgRes = R.mipmap.icon_app;
            bgColor = getColorRes(R.color.color_B3ffa970);
        } else if (type.equals(Category.WEB)) {
            imgRes = R.mipmap.icon_web;
            bgColor = getColorRes(R.color.color_B375c6f0);
        } else if (type.equals(Category.EXTEND)) {
            imgRes = R.mipmap.icon_extend;
            bgColor = getColorRes(R.color.color_B3ff9ccd);
        } else if (type.equals(Category.RECOMMEND)) {
            imgRes = R.mipmap.icon_recommend;
            bgColor = getColorRes(R.color.color_B38b9cff);
        } else if (type.equals(Category.VIDEO)) {
            imgRes = R.mipmap.icon_video;
            bgColor = getColorRes(R.color.color_B3ff8778);
        }

        setImageSrc(R.id.center_img, imgRes);

        frameLayout.setBackgroundColor(bgColor);
    }

    private int getColorRes(int resId) {
        return getContext().getResources().getColor(resId);
    }
}
