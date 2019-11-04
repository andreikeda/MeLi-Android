package com.example.meli.detail.view

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.meli.BuildConfig
import com.example.meli.R
import com.example.meli.core.model.SearchResultModel
import com.example.meli.detail.contract.DetailContract
import com.example.meli.detail.presenter.DetailPresenter
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailContract.View {

    private val TAG = javaClass.simpleName
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

        setSupportActionBar(toolbar)
        val it = intent.getSerializableExtra(EXTRA_DATA) as SearchResultModel
        mPresenter = DetailPresenter(this)
        mPresenter?.initComponents(it)
    }

    override fun onDestroy() {
        mPresenter?.unregister()
        mPresenter = null

        super.onDestroy()
    }

    override fun addAttributesTableRow(items: HashMap<String, String>) {
        val tableRow = TableRow(this).apply {
            layoutParams = TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
            )
        }
        val spacing = resources.getDimensionPixelSize(R.dimen.app_margin_vertical)
        items.forEach { (key, value) ->
            val ll = LinearLayout(this).apply {
                layoutParams = TableRow.LayoutParams(
                    0,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    1f
                )
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER_VERTICAL
                setPadding(spacing / 4, spacing, spacing / 4, spacing)
            }
            val keyTextView = TextView(this).apply {
                layoutParams = LinearLayout.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT
                )
                text = key
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    setTextAppearance(R.style.Text_Detail_Label3)
                } else {
                    setTextAppearance(this@DetailActivity, R.style.Text_Detail_Label3)
                }
                setLines(0)
            }
            val valueTextView = TextView(this).apply {
                layoutParams = LinearLayout.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT
                )
                text = value
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    setTextAppearance(R.style.Text_Detail_Label1)
                } else {
                    setTextAppearance(this@DetailActivity, R.style.Text_Detail_Label1)
                }
                setLines(0)
            }
            if (BuildConfig.enableDebugLogging) {
                Log.i(TAG, "$key = $value")
            }
            ll.addView(keyTextView)
            ll.addView(valueTextView)
            tableRow.addView(ll)
        }
        table_attributes.addView(tableRow)
    }

    override fun hideGroupAttributes() {
        group_attributes.visibility = View.GONE
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

    override fun hideGroupWarranty() {
        group_warranty.visibility = View.GONE
    }

    override fun hideGroupWarrantySeller() {
        group_warranty_seller.visibility = View.GONE
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
