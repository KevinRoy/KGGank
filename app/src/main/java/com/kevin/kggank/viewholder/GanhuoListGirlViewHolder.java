package com.kevin.kggank.viewholder;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kevin.kggank.R;
import com.kevin.kggank.entity.GanhuoEntity;
import com.kevin.kggank.event.GanhuoDetailEvent;
import com.kevin.kggank.tool.RxBus;
import com.kevin.kggank.utils.DateUtil;
import com.steve.creact.annotation.DataBean;
import com.steve.creact.library.viewholder.BaseRecyclerViewHolder;

import java.util.List;

/**
 * Created by kevin on 16/5/21.
 */
@DataBean(beanName = "GanhuoListGirlDayBean", data = GanhuoEntity.class)
public class GanhuoListGirlViewHolder extends BaseRecyclerViewHolder<GanhuoEntity> {

    public static final int LAYOUT_ID = R.layout.item_card_list;

    public GanhuoListGirlViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(GanhuoEntity data) {
        if (data == null)
            return;

        ImageView imageView = getView(R.id.img);

        Glide.with(getContext())
                .load(data.getUrl())
                .into(imageView);

        String date = DateUtil.cutDate(data.getCreatedAt());
        setText(R.id.date, date);

        List<String> strings = DateUtil.getListDate(date);

        setOnItemClickListener(v -> {
            if (strings != null && strings.size() > 0) {
                RxBus.INSTACE.send(new GanhuoDetailEvent(strings));
            }
        });
    }
}