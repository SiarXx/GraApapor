package controllers

import models.MenuModel
import models.PlayerModel
import views.MenuView
import java.util.*

class MenuController(val menuModel: MenuModel, val menuView: MenuView, var sc: Scanner) {

    fun setHighscore(player: PlayerModel) {
        menuModel.highscore = player.gold
    }

    fun start() {
        mainMenuControl()

    }

    fun mainMenuControl() {
        var option: String

        menuView.showStartMenu()
        loop@ do {
            option = sc.nextLine()
            when (option) {
                "1" -> {
                    val gameController = GameController(this, sc)
                    gameController.gameStart()
                }
                "2" -> menuView.showHighscore()
                "3" -> break@loop
                else -> println("chose 1, 2 or 3")
            }
            menuView.showStartMenu()
        } while (true)

    }

}