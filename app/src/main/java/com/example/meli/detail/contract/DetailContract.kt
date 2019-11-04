package com.example.meli.detail.contract

import com.example.meli.core.model.SearchResultModel

interface DetailContract {
    interface Presenter {
        fun initComponents(data: SearchResultModel)
        fun unregister()
    }

    interface View {
        fun addAttributesTableRow(items: HashMap<String, String>)
        fun hideGroupAttributes()
        fun hideGroupSellerInfo()
        fun hideGroupSellerLocale()
        fun hideGroupSellerStatus()
        fun hideGroupWarranty()
        fun hideGroupWarrantySeller()
        fun setProductPrice(price: String)
        fun setProductStatusAndSold(statusAndSold: String)
        fun setProductTitle(title: String)
        fun setSellerLocale(locale: String)
        fun setSellerStatus(sellerStatus: String)
        fun setThumbnail(thumbnail: String)
    }
}