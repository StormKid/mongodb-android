package com.stormkid.mongodb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stormkid.mongo.Config
import com.stormkid.mongo.curd.ActionDocument
import kotlinx.android.synthetic.main.activity_get_result.*

class GetResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_result)
        val collection = Config.instance.Builder().build()
        val action = ActionDocument(collection!!)
        test.text =  action.findAll().toMutableList().toString()
    }
}
