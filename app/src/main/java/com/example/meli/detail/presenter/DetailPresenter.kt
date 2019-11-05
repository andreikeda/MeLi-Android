package com.example.meli.detail.presenter

import com.example.meli.core.model.SearchResultModel
import com.example.meli.core.splitInto
import com.example.meli.detail.contract.DetailContract

/**
 * Presenter class to manipulate data and update UI.
 *
 * @param mView - View contract to request ui changes
 */
class DetailPresenter(var mView: DetailContract.View?) : DetailContract.Presenter {
    override fun initComponents(data: SearchResultModel) {
        val isSellerInfoEmpty = data.sellerCity.isBlank()
                && data.sellerStatus.isBlank()
                && data.sellerState.isBlank()
        mView?.run {
            setProductPrice(data.priceFormatted)
            setProductStatusAndSold(data.statusAndSoldUnitsFormatted)
            setProductTitle(data.title)
            if (isSellerInfoEmpty) {
                hideGroupSellerInfo()
            } else {
                if (data.sellerCity.isBlank() &&
                        data.sellerState.isBlank()) {
                    hideGroupSellerLocale()
                } else {
                    setSellerLocale(data.sellerLocaleFormatted)
                }
                if (data.sellerStatus.isBlank()) {
                    hideGroupSellerStatus()
                } else {
                    setSellerStatus(data.sellerStatus)
                }
            }
            setThumbnail(data.thumbnail)
            if (data.attributes.isEmpty()) {
                hideGroupAttributes()
            } else {
                for (i in 0 until data.attributes.size step 2) {
                    addAttributesTableRow(data.attributes.splitInto(2, i))
                }
            }
            if (data.tags.isEmpty() &&
                    !data.acceptsMercadoPago) {
                hideGroupWarranty()
            } else if (data.acceptsMercadoPago &&
                !data.tags.contains("extended_warranty_eligible")) {
                hideGroupWarrantySeller()
            }
        }
    }

    override fun unregister() {
        mView = null
    }
}
