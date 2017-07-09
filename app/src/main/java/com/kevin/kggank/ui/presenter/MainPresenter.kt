package com.kevin.kggank.ui.presenter

import android.widget.Toast
import com.kevin.kggank.entity.GanhuoListEntity
import com.kevin.kggank.ui.model.MainModel
import com.kevin.kggank.ui.view.IMainView
import com.kevin.kglib.base.LibBasePresenter
import com.kevin.kglib.utils.NetWorkUtils
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by kevin on 16/4/15.
 */
class MainPresenter
constructor(mView: IMainView) : LibBasePresenter<IMainView>(mView) {

    private val mainModel: MainModel

    init {
        mainModel = MainModel(this)
        getGirls(1)
    }

    fun getGirls(pageNo: Int) {
        if (NetWorkUtils.isConnected()) {
            addSubscribe(mainModel.getGirls(pageNo).subscribeWith(object : DisposableSubscriber<GanhuoListEntity>() {
                override fun onNext(ganhuoListEntity: GanhuoListEntity?) {
                    if (ganhuoListEntity != null &&
                            ganhuoListEntity.results != null &&
                            ganhuoListEntity.results.size > 0) {
                        getView().getGirls(ganhuoListEntity)
                    }
                }

                override fun onError(t: Throwable) {

                }

                override fun onComplete() {

                }
            }))
        } else {
            Toast.makeText(context, "没有网络连接!", Toast.LENGTH_LONG).show()
        }
    }
}
