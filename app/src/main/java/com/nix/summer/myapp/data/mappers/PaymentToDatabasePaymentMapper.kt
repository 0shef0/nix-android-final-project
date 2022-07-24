package com.nix.summer.myapp.data.mappers

import com.nix.summer.myapp.core.entity.Payment
import com.nix.summer.myapp.data.database.DatabasePayment

class PaymentToDatabasePaymentMapper {

    fun toData(payment: Payment): DatabasePayment = with(payment) {
        DatabasePayment(
            currency = currency,
            amount = amount
        )
    }
}
