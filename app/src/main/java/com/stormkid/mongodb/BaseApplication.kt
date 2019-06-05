package com.stormkid.mongodb

import android.app.Application
import com.stormkid.mongo.Config

/**

@author ke_li
@date 2019/5/28
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Config.instance.init(this)
    }
}