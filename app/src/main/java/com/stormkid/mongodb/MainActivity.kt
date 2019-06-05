package com.stormkid.mongodb

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stormkid.mongo.Config
import com.stormkid.mongo.Model
import com.stormkid.mongo.curd.ActionDocument
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val collection = Config.instance.Builder().build()
        val action = ActionDocument(collection!!).deal(Model.InportBean(Item("煞笔", true)))
        to.setOnClickListener {
            if (action.replace(Model.InportBean(Item("逗比", false))))
            startActivity(Intent(this, GetResultActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Config.instance.close()
    }

    data class Item(
        val name: String,
        val isZha: Boolean
    ) : Model.BaseEntity()
}
