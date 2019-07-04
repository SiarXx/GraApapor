package views

import models.BaseModel
import models.EnemyModel
import models.PlayerModel

class GameView(
    private val playerModel: PlayerModel,
    private val enemyModel: EnemyModel,
    private val baseModel: BaseModel
) {
    fun showStartInfo() {
        println("Day ${playerModel.currDay}")
        println("--------------------")
        print("Gold: ${playerModel.gold} | ")
        println("Tents: ${baseModel.tentsNum} | People: ${baseModel.villagersNum}/${2 * baseModel.tentsNum} | Fence Lv: ${baseModel.fenceLvl} | Barier Lv: ${baseModel.magicBarierLvl}")
    }

    fun showBaseMenu() {
        println("1 Refill human resources [x*20$]")
        println("2 Upgrade")
        println("3 Sell one human to slavery [10$]")
        println("4 Next Attack")
    }

    fun showUpgradeOptions() {
        println("1 Upgrade fancy fence ${baseModel.fenceCost}$")
        println("2 Upgrade magical magic barier ${baseModel.barierCost}$")
        println("3 Buy new Tent 200$")
        println("4 Return")
    }

    fun notEnoughResourcesMsg() {
        println("Not Enough Resources")
    }

    fun upgradeCompleteMsg() {
        println("Upgrade Complete")
    }

    fun refillCompleteMsg() {
        println("Refill Complete")
    }

    fun showEnemyStartInfo() {
        println("Attack of Enemy")
        println("HP: ${enemyModel.health} | DMG: ${enemyModel.dmg}")
    }

    fun attackLog(baseModel: BaseModel) {
        println("Enemy HP: ${enemyModel.health} | Villagers: ${baseModel.villagersNum}/${baseModel.tentsNum * 2}")
    }

}