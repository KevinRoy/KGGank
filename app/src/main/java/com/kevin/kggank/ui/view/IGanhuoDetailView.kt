package com.kevin.kggank.ui.view

import com.kevin.kggank.entity.GanhuoOneDayEntity
import com.kevin.kglib.base.LibIBaseView

/**
 * Created by kevin on 16/5/23.
 */

interface IGanhuoDetailView : LibIBaseView {

    fun getGanhuoOneDay(ganhuoOneDayDataEntity: GanhuoOneDayEntity.GanhuoOneDayDataEntity)
}
