package com.nix.summer.myapp.core.entity

data class Payment(
    val id: Long? = null,
    val defaultCurrency: String? = "USD",
    val amount: Float,
    val currency: String
)
