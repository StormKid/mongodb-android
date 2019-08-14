package com.stormkid.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stormkid.mongktx.Model
import com.stormkid.mongktx.curd.ActionDocument
import com.stormkid.mongktx.curd.QueryDocument
import com.stormkid.mongktx.utils.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val action = ActionDocument().deal(Model.InportBean(Entity("demo")))

//        action.findAll()
        action.insert(false)
        do_search.setOnClickListener {
            val where = QueryDocument().where("name", "demo")
            Log.w(where)
        }
//        action.replace(Model.InportBean(Entity("other")))
//        action.delete()
    }



    data class Entity(val name: String) : Model.BaseEntity()


}
