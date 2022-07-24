package com.nix.summer.myapp.core.interactors

import com.nix.summer.myapp.core.entity.Payment
import com.nix.summer.myapp.core.entity.Resources
import com.nix.summer.myapp.core.entity.Response
import com.nix.summer.myapp.data.repositories.PaymentRepository

class ExchangeCurrencyInteractor(private val repository: PaymentRepository) {

    suspend operator fun invoke(payment: Payment): Response {
        val exchangedPayment = if (payment.currency != payment.defaultCurrency) {
            repository.makeNetworkExchange(payment)
        } else {
            payment
        }

        return with(exchangedPayment) {
            repository.savePayment(exchangedPayment)
            Response(
                responseMessage = "You payed $amount $currency", Resources(0,0,0,0)
            )
        }
    }
}
