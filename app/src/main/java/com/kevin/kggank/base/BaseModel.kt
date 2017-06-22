package com.kevin.kggank.base

import com.kevin.kglib.base.LibBaseModel

/**
 * Created by kevin on 16/4/19.
 */
open class BaseModel<P : BasePresenter<*>>(presenter: P) : LibBaseModel<P>(presenter)
