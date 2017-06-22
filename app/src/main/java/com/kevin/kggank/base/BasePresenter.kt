package com.kevin.kggank.base

import com.kevin.kglib.base.LibBasePresenter

/**
 * Created by kevin on 16/4/14.
 */
open class BasePresenter<T : IBaseView>(view: T) : LibBasePresenter<T>(view)