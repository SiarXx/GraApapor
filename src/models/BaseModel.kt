package models

data class BaseModel(var tentsNum: Int = 4, var villagersNum: Int = tentsNum*2, var magicBarierLvl: Int = 1, var fenceLvl: Int = 1){}