package com.example.meli.core.vo

import com.google.gson.annotations.SerializedName

data class SellerVO(
    val id: Long,
    @SerializedName("power_seller_status") val powerSellerStatus: String,
    @SerializedName("car_dealer") val carDealer: Boolean,
    @SerializedName("real_estate_agency") val realEstateAgency: Boolean,
    val tags: List<String>
)