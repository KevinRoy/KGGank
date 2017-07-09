package com.kevin.kggank.ui.fragment

import com.kevin.kggank.R
import com.kevin.kglib.base.LibBaseFragment

/**
 * Created by kevin on 16/5/13.
 */
class PicFragment : LibBaseFragment() {

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
