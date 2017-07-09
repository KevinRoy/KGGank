package com.kevin.kggank.ui.view

import com.kevin.kggank.entity.GanhuoEntity
import com.kevin.kglib.base.LibIBaseView

/**
 * Created by kevin on 16/5/18.
 */
interface IlistView : LibIBaseView {

    fun getGanhuoListGril(entities: List<GanhuoEntity>)
}
