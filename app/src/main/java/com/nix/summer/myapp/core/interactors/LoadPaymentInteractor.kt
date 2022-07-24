package com.nix.summer.myapp.core.interactors

import com.nix.summer.myapp.core.entity.Resources
import com.nix.summer.myapp.core.entity.Response
import com.nix.summer.myapp.data.repositories.FakeRepository
import com.nix.summer.myapp.data.repositories.PaymentRepository

class LoadPaymentInteractor(private val repository: PaymentRepository) {

    operator fun invoke(): Response {
        val payment = repository.loadPayment()
        return Response(responseMessage = "Action saved in DB: ${payment?.amount ?: "None"} " +
                (payment?.currency ?: "Unknown"), Resources(0,0,0,0))
    }
}
