package com.kevin.kggank.ui.presenter

import com.kevin.kggank.entity.GanhuoListEntity
import com.kevin.kggank.ui.model.ListModel
import com.kevin.kggank.ui.view.IlistView
import com.kevin.kglib.base.LibBasePresenter
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by kevin on 16/5/18.
 */
class ListPresenter
constructor(mView: IlistView) : LibBasePresenter<IlistView>(mView) {

    private val model = ListModel(this)

    init {
        getGirlInfo(1)
    }

    fun getGirlInfo(pageNo: Int) {
        addSubscribe(model.getGirlInfo(pageNo)
                .subscribeWith(object : DisposableSubscriber<GanhuoListEntity>() {
                    override fun onNext(ganhuoListEntity: GanhuoListEntity?) {
                        if (ganhuoListEntity == null ||
                                ganhuoListEntity.results == null
                                || ganhuoListEntity.results.size == 0)
                            return

                        getView().getGanhuoListGril(ganhuoListEntity.results)
                    }

                    override fun onError(t: Throwable) {

                    }

                    override fun onComplete() {

                    }
                }))
    }
}
