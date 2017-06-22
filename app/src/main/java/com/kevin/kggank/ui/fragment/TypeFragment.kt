package com.kevin.kggank.ui.fragment


import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.kevin.kggank.R
import com.kevin.kggank.base.BaseFragment
import com.kevin.kggank.constants.Category
import com.kevin.kggank.entity.GanhuoTypeEntity
//import com.kevin.kggank.viewholder.databean.GanhuoTypeBean
import com.steve.creact.library.adapter.CommonRecyclerAdapter
import com.steve.creact.library.display.DisplayBean

import java.util.ArrayList

import butterknife.BindView

/**
 * A simple [Fragment] subclass.
 */
class TypeFragment : BaseFragment() {

    @BindView(R.id.list)
    internal var list: RecyclerView? = null

    private var adapter: CommonRecyclerAdapter? = null

    override fun getLayout(): Int {
        return R.layout.fragment_type
    }

    override fun initView() {
        adapter = CommonRecyclerAdapter()
        list!!.layoutManager = LinearLayoutManager(activity)
        list!!.adapter = adapter

        val displayBeans = ArrayList<DisplayBean<*>>()

//        displayBeans.add(GanhuoTypeBean(GanhuoTypeEntity(Category.ANDROID)))
//        displayBeans.add(GanhuoTypeBean(GanhuoTypeEntity(Category.IOS)))
//        displayBeans.add(GanhuoTypeBean(GanhuoTypeEntity(Category.APP)))
//        displayBeans.add(GanhuoTypeBean(GanhuoTypeEntity(Category.WEB)))
//        displayBeans.add(GanhuoTypeBean(GanhuoTypeEntity(Category.EXTEND)))
//        displayBeans.add(GanhuoTypeBean(GanhuoTypeEntity(Category.RECOMMEND)))
//        displayBeans.add(GanhuoTypeBean(GanhuoTypeEntity(Category.VIDEO)))

        adapter!!.loadData(displayBeans)
    }

    companion object {
        val instance: TypeFragment
            get() = TypeFragment()
    }
}
