package controllers

import models.BaseModel
import models.EnemyModel

class EnemyController(val enemy: EnemyModel) {

    fun setStats(level: Int) {
        if (level != 0) {
            for (x in 1..level) {
                enemy.dmg += (Math.random() * 3).toInt()
                enemy.health += 1
            }
        }
    }
    fun fight(base: BaseModel, player: PlayerController){
        do {
            enemy.health-=(base.fenceLvl*Math.random()*3).toInt()
            attack(base,player)
            if (enemy.health == 0)
                enemy.lvl++
        }while (enemy.health != 0)
        setStats(enemy.lvl)
    }
    fun attack(base: BaseModel, player: PlayerController){}
}