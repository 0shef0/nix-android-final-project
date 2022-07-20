package com.nix.summer.myapp

class Controller(private val model: Model) {

    private lateinit var view: MainActivity

    fun buyChoice(command: Int) {
        when(command) {
            1 -> {
                view.showInfo(model.buy(Drink.ESPRESSO))
            }
            2 -> {
                view.showInfo(model.buy(Drink.LATTE))
            }
            3 -> {
                view.showInfo(model.buy(Drink.CAPPUCCINO))
            }
        }
    }

    fun attachView(_view: MainActivity) {
        view = _view
    }

    fun takeCommand(request: Request, resources: Resources = Resources(0,0,0,0)) {
        when (request.command) {
            "take" -> {
                view.showInfo(model.take())
            }
            "fill" -> {
                view.showInfo(model.fill(resources))
            }
        }
    }
}