package com.stormkid.mongktx.utils

import com.google.gson.GsonBuilder

/**
json 工具类
@author ke_li
@date 2019/5/30
 */
class JsonUtil private constructor() {

    private var dateFormat = "yyyy-MM-dd HH:mm:ss"
    private val builder = GsonBuilder()

    companion object {
        val instance by lazy { JsonUtil() }
    }

    fun setDateFormat(formart: String): JsonUtil {
        dateFormat = formart
        return this
    }

    fun <T> parse(json: String, clazz: Class<out T>): T = let {
        val gson = builder.setDateFormat(dateFormat).serializeNulls().create()
        gson.fromJson<T>(json, clazz)
    }


    fun toJson(any: Any) = let {
        val gson = builder.setDateFormat(dateFormat).serializeNulls().create()
        gson.toJson(any)
    }
}