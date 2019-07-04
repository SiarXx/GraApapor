package controllers

import models.BaseModel
import models.EnemyModel
import models.PlayerModel
import views.GameView
import java.util.*

class GameController(private val menuController: MenuController, sc: Scanner) {
    private val playerModel = PlayerModel()
    private val enemyModel = EnemyModel()
    private val baseMode = BaseModel()
    private val gameView = GameView(playerModel, enemyModel, baseMode)
    private val playerController = PlayerController(playerModel)
    private val enemyController = EnemyController(enemyModel, gameView)
    private val baseController = BaseController(baseMode, gameView, sc, playerModel, enemyController, playerController)


    fun gameStart() {
        gameRun()
        menuController.setHighscore(playerModel)
    }

    private fun gameRun() {
        do {
            baseController.startView()
            baseController.baseMenu()
            playerController.increaseDay()
            playerController.increaseGoldByAmount(50)
        } while (baseMode.villagersNum > 0)
    }
}