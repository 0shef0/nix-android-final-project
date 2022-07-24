package com.nix.summer.myapp.data.mappers

import com.nix.summer.myapp.core.entity.Payment
import com.nix.summer.myapp.data.database.DatabasePayment

class DatabasePaymentToPaymentMapper {

    fun toDomain(databasePayment: DatabasePayment): Payment = with(databasePayment) {
        Payment(
            currency = currency,
            amount = amount
        )
    }
}
