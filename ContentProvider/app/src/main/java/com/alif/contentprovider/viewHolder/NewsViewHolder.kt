package com.alif.contentprovider.viewHolder

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alif.contentprovider.R
import com.alif.core.view.adapter.GenericViewHolder
import com.alif.core.view.extention.inflate
import com.bumptech.glide.Glide

data class NewsArticlesModel(
    val author: String = "",
    val content: String = "",
    val description: String,
    val publishedAt: String = "",
    val source: Source? = null,
    val title: String,
    val url: String = "",
    val urlToImage: String
) {
    data class Source(
        val name: String
    )
}

class NewsViewHolder(
    viewGroup: ViewGroup,
    val listener: OnNewsItemClickedListener
) : GenericViewHolder<NewsArticlesModel>(viewGroup.inflate(R.layout.new_item)) {

    private val imageView = findViewById<ImageView>(R.id.imageView)
    private val titleView = findViewById<TextView>(R.id.titleTextView)
    private val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)

    override fun bind(item: NewsArticlesModel) {
        Glide.with(imageView).load(item.urlToImage).into(imageView)
        titleView.text = item.title
        descriptionTextView.text = item.description
        itemView.setOnClickListener {
            listener.onNewsItemClicked(item, adapterPosition)
        }
        itemView.setOnLongClickListener {
            listener.onLongItemClicked(it, item, adapterPosition)
        }
    }

    interface OnNewsItemClickedListener {

        fun onNewsItemClicked(item: NewsArticlesModel, position: Int)

        fun onLongItemClicked(view: View, item: NewsArticlesModel, position: Int): Boolean

    }

}