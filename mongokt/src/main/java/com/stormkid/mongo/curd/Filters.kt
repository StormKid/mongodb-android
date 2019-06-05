package com.stormkid.mongo.curd

import com.mongodb.client.model.Filters

/**

@author ke_li
@date 2019/5/30
 */
object Filters {

    fun getSimpleFilter(id:Any) = Filters.eq(id)


}