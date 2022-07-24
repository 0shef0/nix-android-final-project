package com.nix.summer.myapp.ui.adapters

import com.nix.summer.myapp.core.entity.*
import com.nix.summer.myapp.core.interactors.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainPresenter(private val buyInteractor: BuyInteractor,
                    private val takeMoneyInteractor: TakeMoneyInteractor,
                    private val fillResourcesInteractor: FillResourcesInteractor,
                    private val exchangeCurrencyInteractor: ExchangeCurrencyInteractor,
                    private val loadPaymentInteractor: LoadPaymentInteractor
                    ): Contract.Presenter, CoroutineScope {

    private var view: Contract.View? = null

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Default

    override fun attach(view: Contract.View) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }

    private fun checkResponse(response: Response, drink: Drink, money: String){
        if (response.responseMessage != "I have enough resources, making you a coffee!") {
            view?.showInfo(response)
        } else {
            view?.showInfo(response)
            exchangePayment(Payment(0, drink.currency, drink.cost, money))
        }
    }

    fun buyChoice(command: Int, money: String) {
        when(command) {
            1 -> {
                val response = buyInteractor(Drink.ESPRESSO)
                checkResponse(response, Drink.ESPRESSO, money)
            }
            2 -> {
                val response = buyInteractor(Drink.LATTE)
                checkResponse(response, Drink.LATTE, money)
            }
            3 -> {
                val response = buyInteractor(Drink.CAPPUCCINO)
                checkResponse(response, Drink.CAPPUCCINO, money)
            }
        }
    }

    fun exchangePayment(payment: Payment) {
        launch {
            val response = exchangeCurrencyInteractor(payment)
            withContext(Dispatchers.Main) {
                view?.showPayment(response)
            }
        }
    }

    fun loadPayment() {
        launch {
            val response = loadPaymentInteractor()
            withContext(Dispatchers.Main) {
                view?.showPayment(response)
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