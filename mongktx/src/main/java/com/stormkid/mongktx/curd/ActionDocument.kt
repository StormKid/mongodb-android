package com.stormkid.mongokt.curd

import com.mongodb.client.FindIterable
import com.mongodb.client.MongoCollection
import com.stormkid.mongktx.Model
import com.stormkid.mongktx.Utils
import org.bson.Document

/**

@author ke_li
@date 2019/5/30
 */
class ActionDocument(private val collection: MongoCollection<Document>) {

    private var doc: Document? = null

    /**
     * 初始化model
     */
    fun deal(bean: Model.InportBean): ActionDocument {
        doc = Utils.BeanToBson(bean.bean, bean.dateFormat)
        return this
    }

    /**
     * 增。isRepeat 是否重复增加
     */
    fun insert(isRepeat: Boolean): Boolean {
        if (doc == null) return false
        if (isRepeat)
            collection.insertOne(doc!!)
        else {
            if (collection.findOneAndReplace(doc!!, doc!!) == null)
                collection.insertOne(doc!!)
        }
        return true
    }


    /**
     * 替换或更新
     */
    fun replace(bean: Model.InportBean): Boolean {
        var result: Document? = null
        val newValue = Utils.BeanToBson(bean.bean, bean.dateFormat)
        if (null != doc)
            result = collection.findOneAndReplace(doc!!, newValue!!)
        return result != null
    }


    /**
     * 删除
     */
    fun delete(): Boolean {
        var result: Document? = null
        if (null != doc)
            result = collection.findOneAndDelete(doc!!)
        return result != null
    }

    fun findAll(): FindIterable<Document> {
        return collection.find()
    }

}