package com.kevin.kggank.ui.view;

import com.kevin.kggank.base.IBaseView;
import com.kevin.kggank.entity.GanhuoOneDayEntity;

/**
 * Created by kevin on 16/5/23.
 */

public interface IGanhuoDetailView extends IBaseView {

    public void getGanhuoOneDay(GanhuoOneDayEntity.GanhuoOneDayDataEntity ganhuoOneDayDataEntity);
}
