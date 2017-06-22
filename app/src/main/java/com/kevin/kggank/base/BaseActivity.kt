package com.kevin.kggank.base

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem

import com.kevin.kggank.R
import com.kevin.kglib.base.LibBaseActivity

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder

/**
 * Created by kevin on 16/4/14.
 */
abstract class BaseActivity : LibBaseActivity() {

    @BindView(R.id.toolbar)
    internal var toolbar: Toolbar? = null

    private val isBack = false
    private var unbinder: Unbinder? = null

    abstract override fun getLayout(): Int

    abstract override fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        unbinder = ButterKnife.bind(this)
        initToolbar()
        initView()
    }

    private fun initToolbar() {
        title = ""
        setSupportActionBar(toolbar)

        if (isBack()) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    protected fun isBack(): Boolean {
        return false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()

            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun getContext(): Context {
        return this
    }
}
