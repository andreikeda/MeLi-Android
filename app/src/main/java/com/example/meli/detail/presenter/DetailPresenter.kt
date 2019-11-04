package com.example.meli.detail.presenter

import com.example.meli.core.model.SearchResultModel
import com.example.meli.detail.contract.DetailContract

class DetailPresenter(var mView: DetailContract.View?) : DetailContract.Presenter {
    override fun initComponents(data: SearchResultModel) {
        val isSellerInfoEmpty = data.sellerLocaleFormatted.isBlank() && data.sellerStatus.isBlank()
        mView?.run {
            setProductPrice(data.priceFormatted)
            setProductStatusAndSold(data.statusAndSoldUnitsFormatted)
            setProductTitle(data.title)
            if (isSellerInfoEmpty) {
                hideGroupSellerInfo()
            } else {
                if (data.sellerLocaleFormatted.isBlank()) {
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
        }
    }

    override fun unregister() {
        mView = null
    }
}