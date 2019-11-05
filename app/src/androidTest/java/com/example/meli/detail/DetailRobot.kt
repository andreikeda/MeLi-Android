package com.example.meli.detail

import android.content.Context
import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.meli.BaseTestRobot
import com.example.meli.R
import com.example.meli.core.model.SearchResultModel
import com.example.meli.detail.view.DetailActivity

class DetailRobot(
    private var activityTestRule: ActivityTestRule<DetailActivity>?
) : BaseTestRobot() {

    private val LABEL_ATTRIBUTES = R.id.tv_label_attributes
    private val LABEL_LOCALE = R.id.tv_label_locale
    private val LABEL_SELLER = R.id.tv_label_seller
    private val LABEL_SELLER_STATUS = R.id.tv_label_seller_status
    private val LABEL_WARRANTY = R.id.tv_label_warranty
    private val LABEL_WARRANTY_MERCADO_PAGO = R.id.tv_label_warranty_mercado_pago
    private val LABEL_WARRANTY_MERCADO_PAGO_SUB = R.id.tv_label_warranty_mercado_pago_sub
    private val LABEL_WARRANTY_SELLER = R.id.tv_label_warranty_seller
    private val LABEL_WARRANTY_SELLER_SUB = R.id.tv_label_warranty_seller_sub
    private val OUTPUT_STATUS_AND_SOLD = R.id.tv_status_and_sold
    private val OUTPUT_TITLE = R.id.tv_title
    private val OUTPUT_PRICE = R.id.tv_price
    private val OUTPUT_LOCALE = R.id.tv_locale
    private val OUTPUT_SELLER_STATUS = R.id.tv_seller_status
    private val TEXT_ATTRIBUTES_ID = R.string.label_attributes
    private val TEXT_SELLER_INFO_ID = R.string.label_seller_info
    private val TEXT_SELLER_LOCALE_ID = R.string.label_locale
    private val TEXT_SELLER_STATUS_ID = R.string.label_seller_status
    private val TEXT_WARRANTY_ID = R.string.label_warranty
    private val TEXT_WARRANTY_MERCADO_PAGO_ID = R.string.label_warranty_mercado_pago
    private val TEXT_WARRANTY_MERCADO_PAGO_SUB_ID = R.string.label_warranty_mercado_pago_sub
    private val TEXT_WARRANTY_SELLER_ID = R.string.label_warranty_seller
    private val TEXT_WARRANTY_SELLER_SUB_ID = R.string.label_warranty_seller_sub

    private val context: Context
        get() = InstrumentationRegistry.getInstrumentation().targetContext

    fun start(data: SearchResultModel) {
        activityTestRule?.launchActivity(DetailActivity.createIntent(context, data))
    }

    fun stop() {
        activityTestRule?.finishActivity()
        activityTestRule = null
    }

    fun detail(func: DetailRobot.() -> Unit) = DetailRobot(activityTestRule)
        .apply { func() }

    fun checkGroupAttributesIsDisplayed() = checkIsDisplayed(LABEL_ATTRIBUTES)

    fun checkGroupAttributesIsNotDisplayed() = checkIsNotDisplayed(LABEL_ATTRIBUTES)

    fun checkGroupSellerInfoIsDisplayed() {
        checkIsDisplayed(LABEL_SELLER)
        checkIsDisplayed(LABEL_SELLER_STATUS)
        checkIsDisplayed(LABEL_LOCALE)
        checkIsDisplayed(OUTPUT_SELLER_STATUS)
        checkIsDisplayed(OUTPUT_LOCALE)
    }

    fun checkGroupSellerInfoIsNotDisplayed() {
        checkIsNotDisplayed(LABEL_SELLER)
        checkIsNotDisplayed(LABEL_SELLER_STATUS)
        checkIsNotDisplayed(LABEL_LOCALE)
        checkIsNotDisplayed(OUTPUT_SELLER_STATUS)
        checkIsNotDisplayed(OUTPUT_LOCALE)
    }

    fun checkGroupSellerLocaleIsDisplayed() {
        checkIsDisplayed(LABEL_SELLER)
        checkIsDisplayed(LABEL_LOCALE)
        checkIsDisplayed(OUTPUT_LOCALE)
    }

    fun checkGroupSellerLocaleIsNotDisplayed() {
        checkIsNotDisplayed(LABEL_LOCALE)
        checkIsNotDisplayed(OUTPUT_LOCALE)
    }

    fun checkGroupSellerStatusIsDisplayed() {
        checkIsDisplayed(LABEL_SELLER)
        checkIsDisplayed(LABEL_SELLER_STATUS)
        checkIsDisplayed(OUTPUT_SELLER_STATUS)
    }

    fun checkGroupSellerStatusIsNotDisplayed() {
        checkIsNotDisplayed(LABEL_SELLER_STATUS)
        checkIsNotDisplayed(OUTPUT_SELLER_STATUS)
    }

    fun checkGroupWarrantySellerIsDisplayed() {
        checkIsDisplayed(LABEL_WARRANTY)
        checkIsDisplayed(LABEL_WARRANTY_SELLER)
        checkIsDisplayed(LABEL_WARRANTY_SELLER_SUB)
    }

    fun checkGroupWarrantySellerIsNotDisplayed() {
        checkIsNotDisplayed(LABEL_WARRANTY_SELLER)
        checkIsNotDisplayed(LABEL_WARRANTY_SELLER_SUB)
    }

    fun checkGroupWarrantyIsDisplayed() {
        checkIsDisplayed(LABEL_WARRANTY)
        checkIsDisplayed(LABEL_WARRANTY_SELLER)
        checkIsDisplayed(LABEL_WARRANTY_SELLER_SUB)
        checkIsDisplayed(LABEL_WARRANTY_MERCADO_PAGO)
        checkIsDisplayed(LABEL_WARRANTY_MERCADO_PAGO_SUB)
    }

    fun checkGroupWarrantyIsNotDisplayed() {
        checkIsNotDisplayed(LABEL_WARRANTY)
        checkIsNotDisplayed(LABEL_WARRANTY_SELLER)
        checkIsNotDisplayed(LABEL_WARRANTY_SELLER_SUB)
        checkIsNotDisplayed(LABEL_WARRANTY_MERCADO_PAGO)
        checkIsNotDisplayed(LABEL_WARRANTY_MERCADO_PAGO_SUB)
    }

    fun checkLabelAttributesText() =
        matchText(LABEL_ATTRIBUTES, context.getString(TEXT_ATTRIBUTES_ID))

    fun checkLabelSellerText() =
        matchText(LABEL_SELLER, context.getString(TEXT_SELLER_INFO_ID))

    fun checkLabelSellerLocaleText() =
        matchText(LABEL_LOCALE, context.getString(TEXT_SELLER_LOCALE_ID))

    fun checkLabelSellerStatusText() =
        matchText(LABEL_SELLER_STATUS, context.getString(TEXT_SELLER_STATUS_ID))

    fun checkLabelWarrantyText() =
        matchText(LABEL_WARRANTY, context.getString(TEXT_WARRANTY_ID))

    fun checkLabelWarrantyMercadoPagoText() =
        matchText(LABEL_WARRANTY_MERCADO_PAGO, context.getString(TEXT_WARRANTY_MERCADO_PAGO_ID))

    fun checkLabelWarrantyMercadoPagoSubText() =
        matchText(LABEL_WARRANTY_MERCADO_PAGO_SUB, context.getString(TEXT_WARRANTY_MERCADO_PAGO_SUB_ID))

    fun checkLabelWarrantySellerText() =
        matchText(LABEL_WARRANTY_SELLER, context.getString(TEXT_WARRANTY_SELLER_ID))

    fun checkLabelWarrantySellerSubText() =
        matchText(LABEL_WARRANTY_SELLER_SUB, context.getString(TEXT_WARRANTY_SELLER_SUB_ID))

    fun checkOutputStatusAndSoldText(text: String) =
        matchText(
            OUTPUT_STATUS_AND_SOLD,
            context.getString(R.string.formatted_status_and_sold_units, text)
        )

    fun checkOutputTitleText(text: String) = matchText(OUTPUT_TITLE, text)

    fun checkOutputPriceText(text: String) = matchText(OUTPUT_PRICE, text)

    fun checkOutputLocaleText(text: String) = matchText(OUTPUT_LOCALE, text)

    fun checkOutputSellerStatusText(text: String) = matchText(OUTPUT_SELLER_STATUS, text)
}