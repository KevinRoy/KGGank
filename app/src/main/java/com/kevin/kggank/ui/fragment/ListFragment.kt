package com.kevin.kggank.ui.fragment


import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.kevin.kggank.R
import com.kevin.kggank.base.BaseFragment
import com.kevin.kggank.entity.GanhuoEntity
import com.kevin.kggank.ui.presenter.ListPresenter
import com.kevin.kggank.ui.view.IlistView
//import com.kevin.kggank.viewholder.databean.GanhuoListGirlDayBean
import com.steve.creact.library.adapter.CommonRecyclerAdapter
import com.steve.creact.library.display.DisplayBean

import java.util.ArrayList

import butterknife.BindView

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : BaseFragment(), IlistView {
    @BindView(R.id.list)
    internal var list: RecyclerView? = null
    @BindView(R.id.swipe)
    internal var swipe: SwipeRefreshLayout? = null

    private var adapter: CommonRecyclerAdapter? = null
    private var listPresenter: ListPresenter? = null

    override fun getLayout(): Int {
        return R.layout.fragment_list
    }

    override fun initView() {
        adapter = CommonRecyclerAdapter()
        listPresenter = ListPresenter(this)

        list!!.layoutManager = LinearLayoutManager(activity)
    }

    override fun getGanhuoListGril(entities: List<GanhuoEntity>) {

        val displayBeans = ArrayList<DisplayBean<*>>()

        if (entities == null || entities.size == 0)
            return

        for (i in entities.indices) {
//            displayBeans.add(GanhuoListGirlDayBean(entities[i]))
        }

        adapter!!.loadData(displayBeans)
        list!!.adapter = adapter
    }

    companion object {

        val instance: ListFragment
            get() = ListFragment()
    }
}
