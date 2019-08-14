package com.stormkid.mongktx.utils

import android.util.Log

/**
自定义logger
@author ke_li
@date 2019/6/14
 */
object Log {
    private const val APP_LOGGER = "APP_LOGGER"
    private var isEnable = true

    fun init(isEnable: Boolean){
        com.stormkid.mongktx.utils.Log.isEnable = isEnable
    }

    fun w(msg: Any) {
        if (isEnable)
            Log.w(APP_LOGGER, msg.toString())
    }

    fun d(msg: Any) {
        if (isEnable)
            Log.w(APP_LOGGER, msg.toString())
    }

    fun e(msg: Any) {
        if (isEnable)
            Log.w(APP_LOGGER, msg.toString())
    }

    fun i(msg: Any) {
        if (isEnable)
            Log.w(APP_LOGGER, msg.toString())
    }
}