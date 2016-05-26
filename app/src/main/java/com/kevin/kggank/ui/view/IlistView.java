package com.kevin.kggank.ui.view;

import com.kevin.kggank.base.IBaseView;
import com.kevin.kggank.entity.GanhuoEntity;
import com.kevin.kggank.entity.GanhuoOneDayEntity;

import java.util.List;

/**
 * Created by kevin on 16/5/18.
 */
public interface IlistView extends IBaseView {

    public void getGanhuoListGril(List<GanhuoEntity> entities);
}
