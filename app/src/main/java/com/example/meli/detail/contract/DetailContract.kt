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
         * Method to set product price output
         *
         * @param price - output string
         */
        fun setProductPrice(price: String)

        /**
         * Method to set status and sold output
         *
         * @param statusAndSold - output string
         */
        fun setProductStatusAndSold(statusAndSold: String)

        /**
         * Method to set product title output
         *
         * @param title - output string
         */
        fun setProductTitle(title: String)

        /**
         * Method to set seller locale output
         *
         * @param locale - output string
         */
        fun setSellerLocale(locale: String)

        /**
         * Method to set seller status output
         *
         * @param sellerStatus - output string
         */
        fun setSellerStatus(sellerStatus: String)

        /**
         * Method to set thumbnail
         *
         * @param thumbnail - output string
         */
        fun setThumbnail(thumbnail: String)
    }
}
