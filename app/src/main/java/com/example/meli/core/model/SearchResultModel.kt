package com.example.meli.core.model

import java.io.Serializable

class SearchResultModel : Serializable {
    var id: String = ""
    var title: String = ""
    var price: Double = 0.0
    var currency: String = ""
    var thumbnail: String = ""
    var soldUnits: Int = 0
    var status: String = ""
    var sellerCity: String = ""
    var sellerState: String = ""
    var sellerStatus: String = ""
    var attributes: HashMap<String, String> = hashMapOf()
    var tags: Array<String> = arrayOf()
    var acceptsMercadoPago: Boolean = false

    val sellerLocaleFormatted: String
        get() = "$sellerCity, $sellerState"
    val statusAndSoldUnitsFormatted: String
        get() = "$status - $soldUnits"
    val priceFormatted: String
        get() = "$currency$ $price"
}
