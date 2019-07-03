import controllers.MenuController
import models.MenuModel
import views.MenuView

fun main(){
    var mV: MenuView = MenuView()
    var mM: MenuModel = MenuModel()
    var mC: MenuController = MenuController(mM,mV)

    mC.start()


}