package com.kevin.kggank.ui.presenter

import com.kevin.kggank.entity.GanhuoOneDayEntity
import com.kevin.kggank.ui.model.GanhuoDetailModel
import com.kevin.kggank.ui.view.IGanhuoDetailView
import com.kevin.kglib.base.LibBasePresenter
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by kevin on 16/5/23.
 */

class GanhuoDetailPresenter
constructor(mView: IGanhuoDetailView, dates: List<String>) : LibBasePresenter<IGanhuoDetailView>(mView) {

    private var model: GanhuoDetailModel = GanhuoDetailModel(this)
    private var dates: List<String> = ArrayList()

    init {
        this.dates = dates

        if (dates.size == 3) {
            getGanhuoOneDays(dates[0], dates[1], dates[2])
        }
    }

    fun getGanhuoOneDays(year: String, month: String, day: String) {
        addSubscribe(model.getGanhuoOneDays(year, month, day)
                .subscribeWith(object : DisposableSubscriber<GanhuoOneDayEntity>() {
                    override fun onNext(ganhuoOneDayEntity: GanhuoOneDayEntity?) {
                        if (ganhuoOneDayEntity == null || ganhuoOneDayEntity.results == null)
                            return

                        getView().getGanhuoOneDay(ganhuoOneDayEntity.results)
                    }

                    override fun onError(t: Throwable) {

                    }

                    override fun onComplete() {

                    }
                }))
    }
}
