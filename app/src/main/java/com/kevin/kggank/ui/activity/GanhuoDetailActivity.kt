package com.kevin.kggank.ui.activity

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView

import com.kevin.kggank.R
import com.kevin.kggank.base.BaseActivity
import com.kevin.kggank.entity.GanhuoEntity
import com.kevin.kggank.entity.GanhuoOneDayEntity
import com.kevin.kggank.ui.presenter.GanhuoDetailPresenter
import com.kevin.kggank.ui.view.IGanhuoDetailView
//import com.kevin.kggank.viewholder.databean.GanhuoDetailContentBean
//import com.kevin.kggank.viewholder.databean.GanhuoDetailImgBean
//import com.kevin.kggank.viewholder.databean.GanhuoDetailTitleBean
import com.steve.creact.library.adapter.CommonRecyclerAdapter
import com.steve.creact.library.display.DisplayBean

import java.util.ArrayList

import butterknife.BindView
import kotlinx.android.synthetic.main.activity_ganhuo_detail.*

/**
 * Created by kevin on 16/5/22.
 */

class GanhuoDetailActivity : BaseActivity(), IGanhuoDetailView {

    private var ganhuoDetailPresenter: GanhuoDetailPresenter? = null
    private var adapter: CommonRecyclerAdapter? = null
    private val displayBeans = ArrayList<DisplayBean<*>>()

    override fun getLayout(): Int {
        return R.layout.activity_ganhuo_detail
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun initView() {
        setTitle(R.string.title_detail)

        if (intent == null)
            return

        val strings = intent.getStringArrayListExtra(DETAIL)
        ganhuoDetailPresenter = GanhuoDetailPresenter(this@GanhuoDetailActivity, strings)

        list!!.layoutManager = LinearLayoutManager(this)
        adapter = CommonRecyclerAdapter()
    }

    override fun getGanhuoOneDay(entity: GanhuoOneDayEntity.GanhuoOneDayDataEntity) {
        if (entity == null)
            return

        val imgs: List<GanhuoEntity> = entity.girlInfo

        if (imgs != null && imgs.size > 0){
            for (i in imgs.indices){
//                displayBeans.add(GanhuoDetailImgBean(imgs[i].url))
            }
        }

        addInfo(entity.androidInfo)
        addInfo(entity.iosInfo)
        addInfo(entity.appInfo)
        addInfo(entity.webInfo)
        addInfo(entity.extendInfo)
        addInfo(entity.recommendInfo)
        addInfo(entity.videoInfo)

        adapter!!.loadData(displayBeans)
        list!!.adapter = adapter;
    }

    private fun addInfo(entities: List<GanhuoEntity>?) {
        if (entities != null && entities.size > 0) {
//            displayBeans.add(GanhuoDetailTitleBean(entities[0].type))
            for (i in entities.indices) {
//                displayBeans.add(GanhuoDetailContentBean(entities[i]))
            }
        }
    }

    companion object {
        val DETAIL = "detail"
    }
}
