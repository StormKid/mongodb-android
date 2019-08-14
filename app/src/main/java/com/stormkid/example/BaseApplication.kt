package com.stormkid.example

import android.app.Application
import com.stormkid.mongktx.core.Config

/**

@author ke_li
@date 2019/8/14
 */
class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Config.instance.init(this)
    }
}