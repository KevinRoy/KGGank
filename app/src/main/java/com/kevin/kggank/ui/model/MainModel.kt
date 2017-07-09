package com.kevin.kggank.ui.model

import com.kevin.kggank.constants.Constants
import com.kevin.kggank.entity.GanhuoListEntity
import com.kevin.kggank.service.GanhuoService
import com.kevin.kggank.ui.presenter.MainPresenter
import com.kevin.kglib.base.LibBaseModel
import com.kevin.kglib.rx.Compose
import com.kevin.kglib.rx.RxUtils
import io.reactivex.Flowable

/**
 * Created by kevin on 16/4/15.
 */
class MainModel(private val mainPresenter: MainPresenter) : LibBaseModel<MainPresenter>(mainPresenter) {

    fun getGirls(pageNo: Int): Flowable<GanhuoListEntity> {
        return RxUtils.create(GanhuoService::class.java)
                .getAndroidInfo(Constants.PAGE_SIZE, pageNo)
                .compose(Compose.applySchedulers<GanhuoListEntity>())
    }

}
