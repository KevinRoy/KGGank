package com.kevin.kggank.ui.activity

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Handler
import android.widget.ImageView

import com.kevin.kggank.R
import com.kevin.kggank.base.BaseActivity

import butterknife.BindView
import kotlinx.android.synthetic.main.activity_splash.*

class GuideActivity : BaseActivity() {

    override fun getLayout(): Int {
        return R.layout.activity_splash
    }

    override fun initView() {
        (loading_img!!.drawable as AnimationDrawable).start()

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
