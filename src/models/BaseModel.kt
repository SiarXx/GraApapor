package models

data class BaseModel(var tentsNum: Int = 4,
                     var villagersNum: Int = tentsNum*2,
                     var magicBarierLvl: Int = 1,
                     var fenceLvl: Int = 1,
                     var fenceCost: Int = 100,
                     var barierCost: Int = 100,
                     var tenCost: Int = 200)