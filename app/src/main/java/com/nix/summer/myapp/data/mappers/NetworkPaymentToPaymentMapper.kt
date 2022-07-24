package com.nix.summer.myapp.data.mappers

import com.nix.summer.myapp.core.entity.Payment
import com.nix.summer.myapp.data.network.NetworkPayment


class NetworkPaymentToPaymentMapper {

    fun toDomain(networkPayment: NetworkPayment): Payment = with(networkPayment) {
            Payment(
                currency = targetCurrency,
                amount = conversionResult.toFloat()
            )
        }
}
