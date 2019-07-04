package views

import models.MenuModel

class MenuView(private val menuM: MenuModel){
    fun showStartMenu(){
        println("TurboMegaSuperUltraGra 3\n")
        println("1 New Game")
        println("2 Highscore")
        println("3 Quit")
    }
    fun showHighscore(){
        println("Highscore: ${menuM.highscore} gold\n")
    }
}