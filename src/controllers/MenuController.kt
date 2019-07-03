package controllers

import models.MenuModel
import models.PlayerModel
import views.MenuView

class MenuController(val menu: MenuModel, val menuV: MenuView){

    fun setHighscore(player: PlayerModel){
        menu.highscore=player.gold
    }
    fun start(){
        menuV.showStartMenu()
    }

}