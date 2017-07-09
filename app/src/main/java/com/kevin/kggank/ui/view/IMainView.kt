package com.kevin.kggank.ui.view

import com.kevin.kggank.entity.GanhuoListEntity
import com.kevin.kglib.base.LibIBaseView

/**
 * Created by kevin on 16/4/15.
 */
interface IMainView : LibIBaseView {

    fun getGirls(ganhuoListEntity: GanhuoListEntity)
}
