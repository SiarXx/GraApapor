package controllers

import models.BaseModel
import models.EnemyModel
import views.GameView

class EnemyController(val enemyModel: EnemyModel, val gameView: GameView) {

    private fun setStats(level: Int) {
        if (level != 0) {
            for (x in 1..level) {
                enemyModel.dmg += (Math.random() * 3).toInt()
                enemyModel.health += 2
            }
        }
    }

    fun fight(baseModel: BaseModel, baseC: BaseController) {
        gameView.showEnemyStartInfo()

        do {
            enemyModel.health -= (baseModel.fenceLvl * Math.random() * 3).toInt()
            baseC.takeDmg(enemyModel.dmg)
            gameView.attackLog(baseModel)
        } while (enemyModel.health > 0 && baseModel.villagersNum > 0)
        enemyModel.lvl += 1
        enemyModel.health = 10
        setStats(enemyModel.lvl)
    }
}