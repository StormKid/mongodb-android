package com.stormkid.mongo

import org.bson.Document

/**
工具类
@author ke_li
@date 2019/5/28
 */
object Utils {

    fun BeanToBson(any: Any, dateFormat: String) = let {
        val json = JsonUtil.instance.setDateFormat(dateFormat).toJson(any)
        Document.parse(json)
    }

    fun <T>BsonToBean(document: Document, expertChange: Model.ExpertChange<out T>) = let{
        val json = document.toJson()
        JsonUtil.instance.setDateFormat(expertChange.dateFormat).parse(json,expertChange.clazz)
    }
}