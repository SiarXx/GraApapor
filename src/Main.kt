import controllers.MenuController
import models.MenuModel
import views.MenuView
import java.util.*

fun main(){
    val sc = Scanner(System.`in`)
    val menuModel = MenuModel()
    val menuView = MenuView(menuModel)
    val menuController: MenuController
    menuController = MenuController(menuModel,menuView,sc)

    menuController.start()
    sc.close()

}