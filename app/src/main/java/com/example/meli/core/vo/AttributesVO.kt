package com.example.meli.core.vo

import com.google.gson.annotations.SerializedName

data class AttributesVO(
    val id: String,
    val name: String,
    val source: Int,
    @SerializedName("value_id") val valueId: String,
    @SerializedName("value_name") val valueName: String,
    @SerializedName("value_struct") val valueStruct: String?,
    @SerializedName("attribute_group_id") val attrGroupId: String,
    @SerializedName("attribute_group_name") val attrGroupName: String
)