package com.kevin.kggank.ui.activity

import android.support.v4.app.FragmentTabHost
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TabHost

import com.kevin.kggank.R
import com.kevin.kggank.base.BaseActivity
import com.kevin.kggank.entity.GanhuoListEntity
import com.kevin.kggank.ui.fragment.ListFragment
import com.kevin.kggank.ui.fragment.PicFragment
import com.kevin.kggank.ui.fragment.TypeFragment
import com.kevin.kggank.ui.presenter.MainPresenter
import com.kevin.kggank.ui.view.IMainView

import butterknife.BindView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), IMainView {

//    @BindView(R.id.realtabcontent)
//    internal var realtabcontent: FrameLayout? = null
//    @BindView(android.R.id.tabcontent)
//    internal var tabcontent: FrameLayout? = null
//    @BindView(android.R.id.tabhost)
//    lateinit var tabhost: FragmentTabHost

    private var mMainPresenter: MainPresenter? = null
    private var mLayoutInflater: LayoutInflater? = null

    private val fragmentClass = arrayOf<Class<*>>(ListFragment::class.java, TypeFragment::class.java, PicFragment::class.java)
    private val fragmentImage = intArrayOf(R.mipmap.icon_tab_list, R.mipmap.icon_tab_type, R.mipmap.icon_tab_pic)

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        setTitle(R.string.title_main)

        mMainPresenter = MainPresenter(this)
        tabhost!!.setup(this, supportFragmentManager, R.id.realtabcontent)

        mLayoutInflater = layoutInflater

        for (i in fragmentClass.indices) {
            val view = mLayoutInflater!!.inflate(R.layout.layout_tab, null)

            val imageView = view.findViewById(R.id.tab_img) as ImageView
            imageView.setImageDrawable(resources.getDrawable(fragmentImage[i]))

            val tabSpec = tabhost!!.newTabSpec(i.toString()).setIndicator(view)

            tabhost!!.addTab(tabSpec, fragmentClass[i], null)
        }

        tabhost!!.currentTab = 0
        tabhost!!.setOnTabChangedListener { tabId ->
            if (tabId.endsWith("0")) {
            } else if (tabId.endsWith("1")) {
            } else {
            }
        }
    }

    override fun getGirls(ganhuoListEntity: GanhuoListEntity) {

    }
}
