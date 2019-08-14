package com.stormkid.mongktx.curd

import com.stormkid.mongktx.core.Config
import org.bson.BsonDocument
import org.bson.Document

/**
查询对象
@author ke_li
@date 2019/5/30
 */
class QueryDocument{

    private val collection =  Config.instance.Builder().build()!!

    fun where(key: String, value: String): MutableList<out Document> {
        val json = "{$key:'$value'}"
        val result = collection.find(BsonDocument.parse(json))
        return result.toMutableList()
    }

    fun sort(key: String, value: String): MutableList<out Document> {
        val json = "{$key:$value}"
        return collection.find().sort(BsonDocument.parse(json)).toMutableList()
    }


    fun limit(size: Int) {

        collection.find().limit(size)
        val total = collection.countDocuments()
    }

}