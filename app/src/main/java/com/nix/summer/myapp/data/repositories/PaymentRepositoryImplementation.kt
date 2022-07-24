package com.nix.summer.myapp.data.repositories

import com.nix.summer.myapp.core.entity.Payment
import com.nix.summer.myapp.data.mappers.NetworkPaymentToPaymentMapper
import com.nix.summer.myapp.data.network.ExchangeServiceAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PaymentRepositoryImplementation(
    private val exchangeServiceApi: ExchangeServiceAPI,
    private val networkPaymentToPaymentMapper: NetworkPaymentToPaymentMapper,
): PaymentRepository {

    override suspend fun makeNetworkExchange(payment: Payment): Payment {
        val networkPayment = withContext(Dispatchers.IO) {
            exchangeServiceApi.exchangeCurrency(
                "${payment.defaultCurrency}/${payment.currency}/${payment.amount}"
            )
        }
        return networkPaymentToPaymentMapper.toDomain(networkPayment)
    }

}
