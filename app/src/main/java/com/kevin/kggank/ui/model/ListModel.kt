package com.kevin.kggank.ui.model

import com.kevin.kggank.constants.Constants
import com.kevin.kggank.entity.GanhuoListEntity
import com.kevin.kggank.service.GanhuoService
import com.kevin.kggank.ui.presenter.ListPresenter
import com.kevin.kglib.base.LibBaseModel
import com.kevin.kglib.rx.Compose
import com.kevin.kglib.rx.RxUtils
import io.reactivex.Flowable


/**
 * Created by kevin on 16/5/18.
 */
class ListModel(presenter: ListPresenter) : LibBaseModel<ListPresenter>(presenter) {

    fun getGirlInfo(pageNo: Int): Flowable<GanhuoListEntity> {
        return RxUtils.create(GanhuoService::class.java)
                .getGirlInfo(Constants.PAGE_SIZE, pageNo)
                .compose(Compose.applySchedulers<GanhuoListEntity>())
    }
}
