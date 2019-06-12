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


    /**
     * 使用自己的data class 继承此class 来重命名id
     */
    open class BaseEntity(
        var _id:String = "${System.currentTimeMillis()}"
    ):Serializable
}