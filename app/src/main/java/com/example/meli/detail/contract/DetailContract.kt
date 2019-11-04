package com.example.meli.detail.contract

import com.example.meli.core.model.SearchResultModel

interface DetailContract {
    interface Presenter {
        /**
         * Method to manipulate data and initialize UI
         *
         * @param data - object that contains info to initialize UI
         */
        fun initComponents(data: SearchResultModel)

        /**
         * Method to dispose variables
         */
        fun unregister()
    }

    interface View {
        /**
         * Method to add row to attributes section
         *
         * @param items - map with info to insert into row
         */
        fun addAttributesTableRow(items: HashMap<String, String>)

        /**
         * Method to hide attributes section
         */
        fun hideGroupAttributes()

        /**
         * Method to hide seller info section
         */
        fun hideGroupSellerInfo()

        /**
         * Method to hide seller locale labels
         */
        fun hideGroupSellerLocale()

        /**
         * Method to hide seller status labels
         */
        fun hideGroupSellerStatus()

        /**
         * Method to hide warranty section
         */
        fun hideGroupWarranty()

        /**
         * Method to hide warranty seller labels
         */
        fun hideGroupWarrantySeller()

        /**
         * Method to set product price label
         *
         * @param price -
         */
        fun setProductPrice(price: String)
        fun setProductStatusAndSold(statusAndSold: String)
        fun setProductTitle(title: String)
        fun setSellerLocale(locale: String)
        fun setSellerStatus(sellerStatus: String)
        fun setThumbnail(thumbnail: String)
    }
}
