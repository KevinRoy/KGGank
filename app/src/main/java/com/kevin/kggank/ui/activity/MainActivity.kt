package com.kevin.kggank.ui.activity

import android.view.LayoutInflater
import android.widget.ImageView
import com.kevin.kggank.R
import com.kevin.kggank.entity.GanhuoListEntity
import com.kevin.kggank.ui.fragment.ListFragment
import com.kevin.kggank.ui.fragment.PicFragment
import com.kevin.kggank.ui.fragment.TypeFragment
import com.kevin.kggank.ui.presenter.MainPresenter
import com.kevin.kggank.ui.view.IMainView
import com.kevin.kglib.base.LibBaseActivity
import com.kevin.kglib.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : LibBaseActivity(), IMainView {
    override fun initView() {
        setTitle(R.string.title_main)

        mMainPresenter = MainPresenter(this)

//        actionButton = findViewById(R.id.actionButton) as FloatingActionButton

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

        actionButton!!.setOnClickListener {
            ToastUtils.show("点击")
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

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

//    override fun getLayout(): Int {
//        return R.layout.activity_main
//    }
//
//    override fun initView() {
//        setTitle(R.string.title_main)
//
//        mMainPresenter = MainPresenter(this)
//
//        actionButton = findViewById(R.id.actionButton) as FloatingActionButton
//
//        tabhost!!.setup(this, supportFragmentManager, R.id.realtabcontent)
//
//        mLayoutInflater = layoutInflater
//
//        for (i in fragmentClass.indices) {
//            val view = mLayoutInflater!!.inflate(R.layout.layout_tab, null)
//
//            val imageView = view.findViewById(R.id.tab_img) as ImageView
//            imageView.setImageDrawable(resources.getDrawable(fragmentImage[i]))
//
//            val tabSpec = tabhost!!.newTabSpec(i.toString()).setIndicator(view)
//
//            tabhost!!.addTab(tabSpec, fragmentClass[i], null)
//        }
//
//        tabhost!!.currentTab = 0
//        tabhost!!.setOnTabChangedListener { tabId ->
//            if (tabId.endsWith("0")) {
//            } else if (tabId.endsWith("1")) {
//            } else {
//            }
//        }
//
//        actionButton!!.setOnClickListener {
//            ToastUtils.show("点击")
//        }
//    }

    override fun getGirls(ganhuoListEntity: GanhuoListEntity) {

    }
}
