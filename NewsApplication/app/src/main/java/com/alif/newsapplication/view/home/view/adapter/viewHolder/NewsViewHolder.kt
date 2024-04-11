package com.alif.newsapplication.view.home.view.adapter.viewHolder

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alif.core.view.adapter.GenericViewHolder
import com.alif.core.view.extention.inflate
import com.alif.core.view.extention.loadImage
import com.alif.newsapplication.R
import com.alif.newsapplication.model.NewsArticlesModel

class NewsViewHolder(
    viewGroup: ViewGroup,
    val listener: OnNewsItemClickedListener
) : GenericViewHolder<NewsArticlesModel>(viewGroup.inflate(R.layout.new_item)) {

    private val imageView = findViewById<ImageView>(R.id.imageView)
    private val titleView = findViewById<TextView>(R.id.titleTextView)
    private val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)

    override fun bind(item: NewsArticlesModel) {
        imageView.loadImage(item.urlToImage)
        titleView.text = item.title
        descriptionTextView.text = item.description
        itemView.setOnClickListener {
            listener.onNewsItemClicked(item, adapterPosition)
        }
    }

    interface OnNewsItemClickedListener {

        fun onNewsItemClicked(item: NewsArticlesModel, position: Int)

    }

}