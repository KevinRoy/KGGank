package com.kevin.kggank.ui.view

import com.kevin.kggank.base.IBaseView
import com.kevin.kggank.entity.GanhuoEntity
import com.kevin.kggank.entity.GanhuoOneDayEntity

/**
 * Created by kevin on 16/5/18.
 */
interface IlistView : IBaseView {

    fun getGanhuoListGril(entities: List<GanhuoEntity>)
}
