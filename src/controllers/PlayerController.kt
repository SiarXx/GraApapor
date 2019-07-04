package controllers

import models.PlayerModel

class PlayerController(private val playerModel: PlayerModel){

    fun increaseGoldByAmount(amount: Int){
        playerModel.gold+=amount
    }
    fun decreaseGoldByAmount(amount: Int){
        playerModel.gold-=amount
    }
    fun increaseDay(){
        playerModel.currDay+=1
    }
}