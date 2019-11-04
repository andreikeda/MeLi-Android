package com.example.meli.core.vo

import com.google.gson.annotations.SerializedName

data class GetSearchResultVO(
    val id: String,
    val title: String,
    val price: Double,
    @SerializedName("currency_id") val currencyId: String,
    @SerializedName("available_quantity") val availableQuantity: Int,
    @SerializedName("sold_quantity") val soldQuantity: Int,
    @SerializedName("buying_mode") val buyingMode: String,
    val condition: String,
    val thumbnail: String,
    @SerializedName("accepts_mercadopago") val acceptsMercadoPago: Boolean,
    val tags: List<String>,
    val attributes: List<AttributesVO>,
    val seller: SellerVO,
    val installments: InstallmentsVO,
    val address: AddressVO?,
    val shipping: ShippingVO
)
