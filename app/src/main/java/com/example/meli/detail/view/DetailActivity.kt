package com.example.meli.detail.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.meli.R
import com.example.meli.core.model.SearchResultModel
import com.example.meli.detail.contract.DetailContract
import com.example.meli.detail.presenter.DetailPresenter
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailContract.View {

    private var mPresenter: DetailContract.Presenter? = null

    companion object {
        private const val EXTRA_DATA = "data"

        fun createIntent(context: Context, data: SearchResultModel) =
            Intent(context, DetailActivity::class.java).apply {
                putExtra(EXTRA_DATA, data)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val it = intent.getSerializableExtra(EXTRA_DATA) as SearchResultModel
        mPresenter = DetailPresenter(this)
        mPresenter?.initComponents(it)
    }

    override fun onDestroy() {
        mPresenter?.unregister()
        mPresenter = null

        super.onDestroy()
    }

    override fun hideGroupSellerInfo() {
        group_seller_info.visibility = View.GONE
    }

    override fun hideGroupSellerLocale() {
        group_seller_locale.visibility = View.GONE
    }

    override fun hideGroupSellerStatus() {
        group_seller_status.visibility = View.GONE
    }

    override fun setProductPrice(price: String) {
        tv_price.text = price
    }

    override fun setProductStatusAndSold(statusAndSold: String) {
        tv_status_and_sold.text = getString(R.string.formatted_status_and_sold_units, statusAndSold)
    }

    override fun setProductTitle(title: String) {
        tv_title.text = title
    }

    override fun setSellerLocale(locale: String) {
        tv_locale.text = locale
    }

    override fun setSellerStatus(sellerStatus: String) {
        tv_seller_status.text = sellerStatus
    }

    override fun setThumbnail(thumbnail: String) {
        Glide
            .with(this)
            .load(thumbnail)
            .fitCenter()
            .placeholder(R.drawable.ic_image_dark)
            .into(iv_thumbnail)
    }
}