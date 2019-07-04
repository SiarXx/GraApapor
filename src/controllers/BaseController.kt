package controllers

import models.BaseModel
import models.PlayerModel
import views.GameView
import java.util.*

class BaseController(
    private val baseModel: BaseModel,
    private val gameView: GameView,
    var sc: Scanner,
    var playerModel: PlayerModel,
    var enemyController: EnemyController,
    var playerController: PlayerController
) {

    private fun upgradeBarier() {
        if (playerModel.gold >= baseModel.barierCost) {
            baseModel.magicBarierLvl += 1
            playerController.decreaseGoldByAmount(baseModel.barierCost)
            baseModel.barierCost += 10
        } else
            gameView.notEnoughResourcesMsg()
    }

    private fun upgradeFence() {
        if (playerModel.gold >= baseModel.fenceCost) {
            baseModel.fenceLvl += 1
            playerController.decreaseGoldByAmount(baseModel.fenceCost)
            baseModel.fenceCost += 10
        } else
            gameView.notEnoughResourcesMsg()
    }

    private fun upgradeTents() {
        if (playerModel.gold >= baseModel.tenCost) {
            baseModel.tentsNum += 1
            playerController.decreaseGoldByAmount(baseModel.tenCost)
            baseModel.tenCost += 20
            baseModel.villagersNum += 2
        } else
            gameView.notEnoughResourcesMsg()
    }

    private fun sellHumans() {
        if (baseModel.villagersNum > 2) {
            baseModel.villagersNum -= 1
            playerController.increaseGoldByAmount(10)
        } else
            gameView.notEnoughResourcesMsg()
    }

    fun takeDmg(amount: Int) {
        if (amount - baseModel.magicBarierLvl * 2 > 0)
            baseModel.villagersNum -= amount - baseModel.magicBarierLvl * 2
    }

    private fun maxHumans(): Int = baseModel.tentsNum * 2
    private fun missingHumans(): Int = maxHumans() - baseModel.villagersNum
    private fun refillHumans() {
        if (playerModel.gold >= missingHumans() * 20) {
            baseModel.villagersNum = maxHumans()
            playerController.decreaseGoldByAmount(missingHumans() * 20)
        } else
            gameView.notEnoughResourcesMsg()
    }

    fun startView() {
        gameView.showStartInfo()
    }

    fun baseMenu() {
        var option: String
        gameView.showBaseMenu()
        loop@ do {
            option = sc.nextLine()
            when (option) {
                "1" -> {
                    refillHumans()
                    gameView.refillCompleteMsg()
                }
                "2" -> upgradeMenu()
                "3" -> sellHumans()
                "4" -> {
                    enemyController.fight(baseModel, this)
                    break@loop
                }
                else -> println("chose 1, 2, 3 or 4")
            }
        } while (true)

    }

    private fun upgradeMenu() {
        var option: String
        gameView.showStartInfo()
        gameView.showUpgradeOptions()
        loop@ do {
            option = sc.nextLine()
            when (option) {
                "1" -> {
                    upgradeFence()
                    gameView.upgradeCompleteMsg()
                }
                "2" -> {
                    upgradeBarier()
                    gameView.upgradeCompleteMsg()
                }
                "3" -> {
                    upgradeTents()
                    gameView.upgradeCompleteMsg()
                }
                "4" -> break@loop
                else -> println("chose 1, 2, 3 or 4")
            }
            gameView.showStartInfo()
            gameView.showUpgradeOptions()
        } while (true)
        gameView.showStartInfo()
        gameView.showBaseMenu()
    }
}
