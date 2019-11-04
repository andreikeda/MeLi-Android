package com.example.meli.core.vo

import com.google.gson.annotations.SerializedName

data class AddressVO(
    @SerializedName("state_id") val stateId: String?,
    @SerializedName("state_name") val stateName: String?,
    @SerializedName("city_id") val cityId: String?,
    @SerializedName("city_name") val cityName: String?
)
