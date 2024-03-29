package com.example.meli.search.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.meli.R
import com.example.meli.core.model.SearchResultModel
import kotlinx.android.synthetic.main.item_search_result.view.*

class SearchItemAdapter(
    private val mSearchItems: List<SearchResultModel>,
    private val mContext: Context,
    private val mOnClickListener: View.OnClickListener
) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(
            LayoutInflater.from(mContext).inflate(R.layout.item_search_result, parent, false),
            mOnClickListener
        )

    override fun getItemCount(): Int = mSearchItems.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ViewHolder)?.bindView(mSearchItems[position])
    }

    class ViewHolder(
        itemView: View,
        onClickListener: View.OnClickListener
    ) : RecyclerView.ViewHolder(itemView) {
        val price = itemView.tv_price
        val title = itemView.tv_title
        val thumbnail = itemView.iv_thumbnail

        init {
            itemView.tag = this
            itemView.apply {
                tag = this@ViewHolder
                setOnClickListener(onClickListener)
            }
        }

        fun bindView(searchItem: SearchResultModel) {
            title.text = searchItem.title
            price.text = searchItem.priceFormatted
            Glide
                .with(itemView)
                .load(searchItem.thumbnail)
                .fitCenter()
                .placeholder(R.drawable.ic_image_dark)
                .into(thumbnail)
        }
    }
}
