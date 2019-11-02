package com.example.meli.core.vo

import com.google.gson.annotations.SerializedName

data class ShippingVO(
    val mode: String,
    val tags: List<String>,
    @SerializedName("free_shipping") val freeShipping: Boolean,
    @SerializedName("logistic_type") val logisticType: String,
    @SerializedName("store_pick_up") val storePickUp: Boolean
)