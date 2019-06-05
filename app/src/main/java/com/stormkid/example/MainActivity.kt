package com.stormkid.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stormkid.mongokt.Config
import com.stormkid.mongokt.Model
import com.stormkid.mongokt.curd.ActionDocument

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val collection =  Config.instance.Builder().build()
       val action = ActionDocument(collection!!).deal(Model.InportBean(Entity("demo")))


        action.findAll()
        action.insert(false)
        action.replace(Model.InportBean(Entity("other")))
        action.delete()
    }


     data class Entity(val name:String):Model.BaseEntity()


}
