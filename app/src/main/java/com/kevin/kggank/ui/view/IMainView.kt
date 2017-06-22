package com.kevin.kggank.ui.view

import com.kevin.kggank.base.IBaseView
import com.kevin.kggank.entity.GanhuoEntity
import com.kevin.kggank.entity.GanhuoListEntity

/**
 * Created by kevin on 16/4/15.
 */
interface IMainView : IBaseView {

    fun getGirls(ganhuoListEntity: GanhuoListEntity)
}
