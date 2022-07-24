package com.nix.summer.myapp.data.repositories

import com.nix.summer.myapp.core.entity.Payment

interface PaymentRepository {

    suspend fun makeNetworkExchange(payment: Payment): Payment

    fun savePayment(payment: Payment)

    fun loadPayment(): Payment?

}
