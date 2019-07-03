package controllers

import models.PlayerModel

class PlayerController(val player: PlayerModel){

    fun setGold(amount: Int){
        player.gold+=amount
    }
    fun setDay(){
        player.currDay++
    }
}