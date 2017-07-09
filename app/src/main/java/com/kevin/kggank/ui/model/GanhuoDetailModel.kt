package com.kevin.kggank.ui.model

import com.kevin.kggank.entity.GanhuoOneDayEntity
import com.kevin.kggank.service.GanhuoService
import com.kevin.kggank.ui.presenter.GanhuoDetailPresenter
import com.kevin.kglib.base.LibBaseModel
import com.kevin.kglib.rx.Compose
import com.kevin.kglib.rx.RxUtils
import io.reactivex.Flowable

/**
 * Created by kevin on 16/5/23.
 */

class GanhuoDetailModel(presenter: GanhuoDetailPresenter) : LibBaseModel<GanhuoDetailPresenter>(presenter) {

    fun getGanhuoOneDays(year: String, month: String, day: String): Flowable<GanhuoOneDayEntity> {
        return RxUtils.create(GanhuoService::class.java)
                .getGanhuoOneDays(year, month, day)
                .compose(Compose.applySchedulers<GanhuoOneDayEntity>())
    }
}
