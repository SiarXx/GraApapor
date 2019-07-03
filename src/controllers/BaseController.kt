package controllers

import models.BaseModel
import models.PlayerModel

class BaseController(val base: BaseModel) {

    fun upgradeDef(i: Int) {

    }

    fun upgradeTents() {

    }

    fun takeDmg(amount: Int){
        base.villagersNum-=amount
    }

    fun maxVillagers(): Int = base.tentsNum * 2

    fun refreshVillagers(player: PlayerModel) {
        if (player.gold > maxVillagers() * 10)
            base.villagersNum = maxVillagers()
    }
}