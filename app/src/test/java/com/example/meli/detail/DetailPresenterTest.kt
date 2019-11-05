package com.example.meli.detail

import com.example.meli.core.splitInto
import com.example.meli.detail.contract.DetailContract
import com.example.meli.detail.presenter.DetailPresenter
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test

class DetailPresenterTest {

    private var mView: DetailContract.View? = mockk(relaxed = true)
    private var mPresenter: DetailContract.Presenter? = null

    @Before
    fun setUp() {
        mPresenter = DetailPresenter(mView)
    }

    @Test
    fun testDetailPresenter_FullInfo() {
        val data = DetailPresenterHelper.searchResultModelFullInfo
        mPresenter?.initComponents(data)
        verify {
            mView?.run {
                setProductPrice(data.priceFormatted)
                setProductStatusAndSold(data.statusAndSoldUnitsFormatted)
                setProductTitle(data.title)
                setSellerLocale(data.sellerLocaleFormatted)
                setSellerStatus(data.sellerStatus)
                setThumbnail(data.thumbnail)
                for (i in 0 until data.attributes.size step 2) {
                    addAttributesTableRow(data.attributes.splitInto(2, i))
                }
            }
        }
    }

    @Test
    fun testDetailPresenter_NoAttributes() {
        val data = DetailPresenterHelper.searchResultModelNoAttributes
        mPresenter?.initComponents(data)
        verify {
            mView?.run {
                setProductPrice(data.priceFormatted)
                setProductStatusAndSold(data.statusAndSoldUnitsFormatted)
                setProductTitle(data.title)
                setSellerLocale(data.sellerLocaleFormatted)
                setSellerStatus(data.sellerStatus)
                setThumbnail(data.thumbnail)
                hideGroupAttributes()
            }
        }
    }

    @Test
    fun testDetailPresenter_NoSellerInfo() {
        val data = DetailPresenterHelper.searchResultModelNoSellerInfo
        mPresenter?.initComponents(data)
        verify {
            mView?.run {
                setProductPrice(data.priceFormatted)
                setProductStatusAndSold(data.statusAndSoldUnitsFormatted)
                setProductTitle(data.title)
                hideGroupSellerInfo()
                setThumbnail(data.thumbnail)
                for (i in 0 until data.attributes.size step 2) {
                    addAttributesTableRow(data.attributes.splitInto(2, i))
                }
            }
        }
    }

    @Test
    fun testDetailPresenter_NoSellerLocale() {
        val data = DetailPresenterHelper.searchResultModelNoSellerLocale
        mPresenter?.initComponents(data)
        verify {
            mView?.run {
                setProductPrice(data.priceFormatted)
                setProductStatusAndSold(data.statusAndSoldUnitsFormatted)
                setProductTitle(data.title)
                setSellerStatus(data.sellerStatus)
                hideGroupSellerLocale()
                setThumbnail(data.thumbnail)
                for (i in 0 until data.attributes.size step 2) {
                    addAttributesTableRow(data.attributes.splitInto(2, i))
                }
            }
        }
    }

    @Test
    fun testDetailPresenter_NoSellerStatus() {
        val data = DetailPresenterHelper.searchResultModelNoSellerStatus
        mPresenter?.initComponents(data)
        verify {
            mView?.run {
                setProductPrice(data.priceFormatted)
                setProductStatusAndSold(data.statusAndSoldUnitsFormatted)
                setProductTitle(data.title)
                setSellerLocale(data.sellerLocaleFormatted)
                hideGroupSellerStatus()
                setThumbnail(data.thumbnail)
                for (i in 0 until data.attributes.size step 2) {
                    addAttributesTableRow(data.attributes.splitInto(2, i))
                }
            }
        }
    }

    @Test
    fun testDetailPresenter_NoTagsAndNoAcceptsMercadoPago() {
        val data = DetailPresenterHelper.searchResultModelNoTagsAndNoAcceptsMercadoPago
        mPresenter?.initComponents(data)
        verify {
            mView?.run {
                setProductPrice(data.priceFormatted)
                setProductStatusAndSold(data.statusAndSoldUnitsFormatted)
                setProductTitle(data.title)
                setSellerLocale(data.sellerLocaleFormatted)
                setSellerStatus(data.sellerStatus)
                setThumbnail(data.thumbnail)
                for (i in 0 until data.attributes.size step 2) {
                    addAttributesTableRow(data.attributes.splitInto(2, i))
                }
                hideGroupWarranty()
            }
        }
    }

    @Test
    fun testDetailPresenter_TagsNotContainsWarrantyAndAcceptsMercadoPago() {
        val data = DetailPresenterHelper.searchResultModelTagsNotContainsWarrantyAndAcceptsMercadoPago
        mPresenter?.initComponents(data)
        verify {
            mView?.run {
                setProductPrice(data.priceFormatted)
                setProductStatusAndSold(data.statusAndSoldUnitsFormatted)
                setProductTitle(data.title)
                setSellerLocale(data.sellerLocaleFormatted)
                setSellerStatus(data.sellerStatus)
                setThumbnail(data.thumbnail)
                for (i in 0 until data.attributes.size step 2) {
                    addAttributesTableRow(data.attributes.splitInto(2, i))
                }
                hideGroupWarrantySeller()
            }
        }
    }

    @After
    fun destroy() {
        mPresenter?.unregister()
        mPresenter = null
    }
}
