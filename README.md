# mongodb-android
an mongodb mobile for android

# use

### BaseApplication

```kotlin
   override fun onCreate() {
            super.onCreate()
            Config.instance.init(application)
        }
```

### CURD

#### init
```kotlin
   data class Entity(val name:String):Model.BaseEntity()
   private val collection =  Config.instance.Builder().build()
   private val action = ActionDocument(collection!!).deal(Model.InportBean(Entity("demo")))
```

#### action
```kotlin
   fun doAction(){
      action.findAll() 
      action.insert(false)
      action.replace(Model.InportBean(Entity("other")))
      action.delete()
   }
```
