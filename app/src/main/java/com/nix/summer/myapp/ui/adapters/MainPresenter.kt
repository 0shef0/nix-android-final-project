package com.nix.summer.myapp.ui.adapters

import com.nix.summer.myapp.core.entity.Drink
import com.nix.summer.myapp.core.entity.Request
import com.nix.summer.myapp.core.entity.Resources
import com.nix.summer.myapp.core.interactors.BuyInteractor
import com.nix.summer.myapp.core.interactors.FillResourcesInteractor
import com.nix.summer.myapp.core.interactors.TakeMoneyInteractor

class MainPresenter(private val buyInteractor: BuyInteractor,
                    private val takeMoneyInteractor: TakeMoneyInteractor,
                    private val fillResourcesInteractor: FillResourcesInteractor
                    ): Contract.Presenter {

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
                view?.showInfo(buyInteractor(Drink.ESPRESSO))
            }
            2 -> {
                view?.showInfo(buyInteractor(Drink.LATTE))
            }
            3 -> {
                view?.showInfo(buyInteractor(Drink.CAPPUCCINO))
            }
        }
    }


    fun takeCommand(request: Request, resources: Resources = Resources(0,0,0,0)) {
        when (request.command) {
            "take" -> {
                view?.showInfo(takeMoneyInteractor())
            }
            "fill" -> {
                view?.showInfo(fillResourcesInteractor(resources))
            }
        }
    }
}