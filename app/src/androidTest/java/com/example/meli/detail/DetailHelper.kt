package com.example.meli.detail

import com.example.meli.core.model.SearchResultModel

object DetailHelper {

    private val COMMON_ID = "abc123"
    private val COMMON_TITLE = "Motorola G6"
    private val COMMON_PRICE = 200.0
    private val COMMON_CURRENCY_ID = "US"
    private val COMMON_THUMBNAIL =
        "https://cdn.pixabay.com/photo/2016/06/14/14/09/skeleton-1456627_960_720.png"
    private val COMMON_SOLD_QUANTITY = 30
    private val COMMON_STATUS = "new"
    private val COMMON_MERCADO_PAGO = true
    private val COMMON_SELLER_CITY = "New York"
    private val COMMON_SELLER_STATE = "New York"
    private val COMMON_SELLER_STATUS = "Platinum"
    private val COMMON_TAGS = arrayListOf("extended_warranty_eligible", "brand_verified")
    private val CUSTOM_TAGS = arrayListOf("brand_verified")
    private val COMMON_ATTRIBUTES = hashMapOf<String, String>().apply {
        put("Marca", "Motorola")
        put("Modelo de CPU", "4x1.8 GHz Kryo 250 Gold/4x1.8 GHz Kryo 250 Silver")
    }

    val searchResultModelFullInfo: SearchResultModel
        get() = SearchResultModel().apply {
            id = COMMON_ID
            title = COMMON_TITLE
            price = COMMON_PRICE
            currency = COMMON_CURRENCY_ID
            thumbnail = COMMON_THUMBNAIL
            soldUnits = COMMON_SOLD_QUANTITY
            status = COMMON_STATUS
            acceptsMercadoPago = COMMON_MERCADO_PAGO
            sellerCity = COMMON_SELLER_CITY
            sellerState = COMMON_SELLER_STATE
            sellerStatus = COMMON_SELLER_STATUS
            tags.plus(COMMON_TAGS)
            attributes.putAll(COMMON_ATTRIBUTES)
        }

    val searchResultModelNoSellerInfo: SearchResultModel
        get() = SearchResultModel().apply {
            id = COMMON_ID
            title = COMMON_TITLE
            price = COMMON_PRICE
            currency = COMMON_CURRENCY_ID
            thumbnail = COMMON_THUMBNAIL
            soldUnits = COMMON_SOLD_QUANTITY
            status = COMMON_STATUS
            acceptsMercadoPago = COMMON_MERCADO_PAGO
            tags.plus(COMMON_TAGS)
            attributes.putAll(COMMON_ATTRIBUTES)
        }

    val searchResultModelNoSellerLocale: SearchResultModel
        get() = SearchResultModel().apply {
            id = COMMON_ID
            title = COMMON_TITLE
            price = COMMON_PRICE
            currency = COMMON_CURRENCY_ID
            thumbnail = COMMON_THUMBNAIL
            soldUnits = COMMON_SOLD_QUANTITY
            status = COMMON_STATUS
            acceptsMercadoPago = COMMON_MERCADO_PAGO
            sellerStatus = COMMON_SELLER_STATUS
            tags.plus(COMMON_TAGS)
            attributes.putAll(COMMON_ATTRIBUTES)
        }

    val searchResultModelNoSellerStatus: SearchResultModel
        get() = SearchResultModel().apply {
            id = COMMON_ID
            title = COMMON_TITLE
            price = COMMON_PRICE
            currency = COMMON_CURRENCY_ID
            thumbnail = COMMON_THUMBNAIL
            soldUnits = COMMON_SOLD_QUANTITY
            status = COMMON_STATUS
            acceptsMercadoPago = COMMON_MERCADO_PAGO
            sellerCity = COMMON_SELLER_CITY
            sellerState = COMMON_SELLER_STATE
            tags.plus(COMMON_TAGS)
            attributes.putAll(COMMON_ATTRIBUTES)
        }

    val searchResultModelNoAttributes: SearchResultModel
        get() = SearchResultModel().apply {
            id = COMMON_ID
            title = COMMON_TITLE
            price = COMMON_PRICE
            currency = COMMON_CURRENCY_ID
            thumbnail = COMMON_THUMBNAIL
            soldUnits = COMMON_SOLD_QUANTITY
            status = COMMON_STATUS
            acceptsMercadoPago = COMMON_MERCADO_PAGO
            sellerCity = COMMON_SELLER_CITY
            sellerState = COMMON_SELLER_STATE
            sellerStatus = COMMON_SELLER_STATUS
            tags.plus(COMMON_TAGS)
        }

    val searchResultModelNoTagsAndNoAcceptsMercadoPago: SearchResultModel
        get() = SearchResultModel().apply {
            id = COMMON_ID
            title = COMMON_TITLE
            price = COMMON_PRICE
            currency = COMMON_CURRENCY_ID
            thumbnail = COMMON_THUMBNAIL
            soldUnits = COMMON_SOLD_QUANTITY
            status = COMMON_STATUS
            sellerCity = COMMON_SELLER_CITY
            sellerState = COMMON_SELLER_STATE
            sellerStatus = COMMON_SELLER_STATUS
            attributes.putAll(COMMON_ATTRIBUTES)
        }

    val searchResultModelTagsNotContainsWarrantyAndAcceptsMercadoPago: SearchResultModel
        get() = SearchResultModel().apply {
            id = COMMON_ID
            title = COMMON_TITLE
            price = COMMON_PRICE
            currency = COMMON_CURRENCY_ID
            thumbnail = COMMON_THUMBNAIL
            soldUnits = COMMON_SOLD_QUANTITY
            status = COMMON_STATUS
            acceptsMercadoPago = COMMON_MERCADO_PAGO
            sellerCity = COMMON_SELLER_CITY
            sellerState = COMMON_SELLER_STATE
            sellerStatus = COMMON_SELLER_STATUS
            tags.plus(CUSTOM_TAGS)
            attributes.putAll(COMMON_ATTRIBUTES)
        }
}
