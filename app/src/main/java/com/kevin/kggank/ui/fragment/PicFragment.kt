package com.kevin.kggank.ui.fragment

import com.kevin.kggank.R
import com.kevin.kggank.base.BaseFragment

/**
 * Created by kevin on 16/5/13.
 */
class PicFragment : BaseFragment() {

    override fun getLayout(): Int {
        return R.layout.fragment_pic
    }

    override fun initView() {

    }

    companion object {

        val instance: PicFragment
            get() = PicFragment()
    }
}
