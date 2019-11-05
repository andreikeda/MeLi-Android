package com.example.meli.detail

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import androidx.test.rule.ActivityTestRule
import com.example.meli.detail.view.DetailActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4::class)
class DetailTest {

    @get:Rule
    private var activityTestRule: ActivityTestRule<DetailActivity> =
        ActivityTestRule(DetailActivity::class.java)

    private var mRobot: DetailRobot? = null

    @Before
    fun setUp() {
        mRobot = DetailRobot(activityTestRule)
    }

    @After
    fun dismiss() {
        mRobot?.stop()
        mRobot = null
    }

    @Test
    fun testDetailScreen_FullInfo() {
        val model = DetailHelper.searchResultModelFullInfo
        mRobot?.detail {
            start(model)
            /**
             * Common checks for labels
             */
            checkLabelAttributesText()
            checkLabelSellerLocaleText()
            checkLabelSellerStatusText()
            checkLabelSellerText()
            checkLabelWarrantyMercadoPagoSubText()
            checkLabelWarrantyMercadoPagoText()
            checkLabelWarrantySellerSubText()
            checkLabelWarrantySellerText()
            checkLabelWarrantyText()
            /**
             * Checks for output sequences
             */
            checkOutputPriceText(model.priceFormatted)
            checkOutputStatusAndSoldText(model.statusAndSoldUnitsFormatted)
            checkOutputTitleText(model.title)
            checkOutputLocaleText(model.sellerLocaleFormatted)
            checkOutputSellerStatusText(model.sellerStatus)
            /**
             * Checks for groups visibility
             */
            checkGroupSellerInfoIsDisplayed()
            checkGroupWarrantyIsDisplayed()
            checkGroupAttributesIsDisplayed()
        }
    }

    @Test
    fun testDetailScreen_NoAttributes() {
        val model = DetailHelper.searchResultModelNoAttributes
        mRobot?.detail {
            start(model)
            /**
             * Common checks for labels
             */
            checkLabelAttributesText()
            checkLabelSellerLocaleText()
            checkLabelSellerStatusText()
            checkLabelSellerText()
            checkLabelWarrantyMercadoPagoSubText()
            checkLabelWarrantyMercadoPagoText()
            checkLabelWarrantySellerSubText()
            checkLabelWarrantySellerText()
            checkLabelWarrantyText()
            /**
             * Checks for output sequences
             */
            checkOutputPriceText(model.priceFormatted)
            checkOutputStatusAndSoldText(model.statusAndSoldUnitsFormatted)
            checkOutputTitleText(model.title)
            checkOutputLocaleText(model.sellerLocaleFormatted)
            checkOutputSellerStatusText(model.sellerStatus)
            /**
             * Checks for groups visibility
             */
            checkGroupSellerInfoIsDisplayed()
            checkGroupWarrantyIsDisplayed()
            checkGroupAttributesIsNotDisplayed()
        }
    }

    @Test
    fun testDetailScreen_NoSellerInfo() {
        val model = DetailHelper.searchResultModelNoSellerInfo
        mRobot?.detail {
            start(model)
            /**
             * Common checks for labels
             */
            checkLabelAttributesText()
            checkLabelSellerLocaleText()
            checkLabelSellerStatusText()
            checkLabelSellerText()
            checkLabelWarrantyMercadoPagoSubText()
            checkLabelWarrantyMercadoPagoText()
            checkLabelWarrantySellerSubText()
            checkLabelWarrantySellerText()
            checkLabelWarrantyText()
            /**
             * Checks for output sequences
             */
            checkOutputPriceText(model.priceFormatted)
            checkOutputStatusAndSoldText(model.statusAndSoldUnitsFormatted)
            checkOutputTitleText(model.title)
            /**
             * Checks for groups visibility
             */
            checkGroupSellerInfoIsNotDisplayed()
            checkGroupWarrantyIsDisplayed()
            checkGroupAttributesIsDisplayed()
        }
    }

    @Test
    fun testDetailScreen_NoSellerLocale() {
        val model = DetailHelper.searchResultModelNoSellerLocale
        mRobot?.detail {
            start(model)
            /**
             * Common checks for labels
             */
            checkLabelAttributesText()
            checkLabelSellerLocaleText()
            checkLabelSellerStatusText()
            checkLabelSellerText()
            checkLabelWarrantyMercadoPagoSubText()
            checkLabelWarrantyMercadoPagoText()
            checkLabelWarrantySellerSubText()
            checkLabelWarrantySellerText()
            checkLabelWarrantyText()
            /**
             * Checks for output sequences
             */
            checkOutputPriceText(model.priceFormatted)
            checkOutputStatusAndSoldText(model.statusAndSoldUnitsFormatted)
            checkOutputTitleText(model.title)
            checkOutputSellerStatusText(model.sellerStatus)
            /**
             * Checks for groups visibility
             */
            checkGroupSellerLocaleIsNotDisplayed()
            checkGroupSellerStatusIsDisplayed()
            checkGroupWarrantyIsDisplayed()
            checkGroupAttributesIsDisplayed()
        }
    }

    @Test
    fun testDetailScreen_NoSellerStatus() {
        val model = DetailHelper.searchResultModelNoSellerStatus
        mRobot?.detail {
            start(model)
            /**
             * Common checks for labels
             */
            checkLabelAttributesText()
            checkLabelSellerLocaleText()
            checkLabelSellerStatusText()
            checkLabelSellerText()
            checkLabelWarrantyMercadoPagoSubText()
            checkLabelWarrantyMercadoPagoText()
            checkLabelWarrantySellerSubText()
            checkLabelWarrantySellerText()
            checkLabelWarrantyText()
            /**
             * Checks for output sequences
             */
            checkOutputPriceText(model.priceFormatted)
            checkOutputStatusAndSoldText(model.statusAndSoldUnitsFormatted)
            checkOutputTitleText(model.title)
            checkOutputLocaleText(model.sellerLocaleFormatted)
            /**
             * Checks for groups visibility
             */
            checkGroupSellerStatusIsNotDisplayed()
            checkGroupSellerLocaleIsDisplayed()
            checkGroupWarrantyIsDisplayed()
            checkGroupAttributesIsDisplayed()
        }
    }

    @Test
    fun testDetailScreen_NoTagsAndNoAcceptsMercadoPago() {
        val model = DetailHelper.searchResultModelNoTagsAndNoAcceptsMercadoPago
        mRobot?.detail {
            start(model)
            /**
             * Common checks for labels
             */
            checkLabelAttributesText()
            checkLabelSellerLocaleText()
            checkLabelSellerStatusText()
            checkLabelSellerText()
            checkLabelWarrantyMercadoPagoSubText()
            checkLabelWarrantyMercadoPagoText()
            checkLabelWarrantySellerSubText()
            checkLabelWarrantySellerText()
            checkLabelWarrantyText()
            /**
             * Checks for output sequences
             */
            checkOutputPriceText(model.priceFormatted)
            checkOutputStatusAndSoldText(model.statusAndSoldUnitsFormatted)
            checkOutputTitleText(model.title)
            checkOutputLocaleText(model.sellerLocaleFormatted)
            checkOutputSellerStatusText(model.sellerStatus)
            /**
             * Checks for groups visibility
             */
            checkGroupSellerInfoIsDisplayed()
            checkGroupWarrantyIsNotDisplayed()
            checkGroupAttributesIsDisplayed()
        }
    }

    @Test
    fun testDetailScreen_TagsNotContainsWarrantyAndAcceptsMercadoPago() {
        val model = DetailHelper.searchResultModelTagsNotContainsWarrantyAndAcceptsMercadoPago
        mRobot?.detail {
            start(model)
            /**
             * Common checks for labels
             */
            checkLabelAttributesText()
            checkLabelSellerLocaleText()
            checkLabelSellerStatusText()
            checkLabelSellerText()
            checkLabelWarrantyMercadoPagoSubText()
            checkLabelWarrantyMercadoPagoText()
            checkLabelWarrantySellerSubText()
            checkLabelWarrantySellerText()
            checkLabelWarrantyText()
            /**
             * Checks for output sequences
             */
            checkOutputPriceText(model.priceFormatted)
            checkOutputStatusAndSoldText(model.statusAndSoldUnitsFormatted)
            checkOutputTitleText(model.title)
            checkOutputLocaleText(model.sellerLocaleFormatted)
            checkOutputSellerStatusText(model.sellerStatus)
            /**
             * Checks for groups visibility
             */
            checkGroupSellerInfoIsDisplayed()
            checkGroupWarrantyIsDisplayed()
            checkGroupAttributesIsDisplayed()
        }
    }
}