package com.nix.summer.myapp.adapters

import com.nix.summer.myapp.core.entity.Drink
import com.nix.summer.myapp.core.model.Model
import com.nix.summer.myapp.core.entity.Request
import com.nix.summer.myapp.core.entity.Resources

class MainPresenter(private var model: Model): Contract.Presenter {

    private var view: Contract.View? = null

    override fun attach(view: Contract.View) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }

    fun buyChoice(command: Int) {
        when(command) {
            1 -> {
                view?.showInfo(model.buy(Drink.ESPRESSO))
            }
            2 -> {
                view?.showInfo(model.buy(Drink.LATTE))
            }
            3 -> {
                view?.showInfo(model.buy(Drink.CAPPUCCINO))
            }
        }
    }


    fun takeCommand(request: Request, resources: Resources = Resources(0,0,0,0)) {
        when (request.command) {
            "take" -> {
                view?.showInfo(model.take())
            }
            "fill" -> {
                view?.showInfo(model.fill(resources))
            }
        }
    }
}