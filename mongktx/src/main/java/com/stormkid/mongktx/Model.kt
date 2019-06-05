package com.stormkid.mongokt

import java.io.Serializable

/**

@author ke_li
@date 2019/5/30
 */
class Model {

    data class ExpertChange<T>(
        var dateFormat: String = "yyyy-MM-dd HH:mm:ss",
        val clazz: Class<out T>
    ):Serializable

    data class InportBean(
        val bean:Any,
        var dateFormat: String = "yyyy-MM-dd HH:mm:ss"
    ):Serializable


    open class BaseEntity(
        var _id:String = "${System.currentTimeMillis()}"
    ):Serializable
}