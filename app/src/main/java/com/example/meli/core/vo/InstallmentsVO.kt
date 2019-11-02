package com.example.meli.core.vo

import com.google.gson.annotations.SerializedName

/**
 * "quantity": 12,
"amount": 2033.34,
"rate": 63.77,
"currency_id": "ARS"
 */
data class InstallmentsVO(
    val quantity:  Int,
    val amount: Double,
    val rate: Double,
    @SerializedName("currency_id") val currencyId: String
)