package com.stormkid.mongokt

import android.app.Application
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.stitch.android.core.Stitch
import com.mongodb.stitch.android.services.mongodb.local.LocalMongoDbService
import org.bson.Document

/**
初始化并获取单个connection
@author ke_li
@date 2019/5/28
 */
open class Config private constructor() {
    /**
     * 移动客户端对象
     */
    private var mobileClient: MongoClient? = null
    /**
     * 数据库名称
     */
    private var dbName = Constants.defautDbName

    /**
     * 数据库连接名称
     */
    private var collection = Constants.defultDbCollection

    /**
     * 数据库连接对象
     */
    private var mongo: MongoCollection<Document>? = null

    companion object {
        val instance by lazy { Config() }
    }

    fun init(application: Application) {
        val appId = application.packageName
        val client = Stitch.initializeDefaultAppClient(appId)
        mobileClient = client.getServiceClient(LocalMongoDbService.clientFactory)
    }

    private fun getClient() = let {
        if (null == mobileClient) throw NullPointerException("client must not be null")
        else
            mobileClient
    }


    inner class Builder {

        fun setDbName(dbName: String): Builder {
            this@Config.dbName = dbName
            return this
        }

        fun setCollection(collection: String): Builder {
            this@Config.collection = collection
            return this
        }

        fun build(): MongoCollection<Document>? = let {
            mongo = getClient()!!.getDatabase(dbName).getCollection(collection)
            mongo!!
        }
    }

    fun close() {
        dbName = ""
        collection = ""
        if (null!=mongo)
        mongo!!.drop()
    }
}