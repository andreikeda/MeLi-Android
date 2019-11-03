package com.example.meli.core.model

import java.io.Serializable

class SearchResultModel : Serializable {
    var id: String = ""
    var title: String = ""
    var price: Double = 0.0
    var currency: String = ""
    var thumbnail: String = ""
    val priceFormatted: String
        get() = "$currency$ $price"
}
