package com.alif.contentprovider

import android.view.ViewGroup
import com.alif.contentprovider.viewHolder.NewsArticlesModel
import com.alif.contentprovider.viewHolder.NewsViewHolder
import com.alif.core.view.adapter.CreateViewHolderUtil
import com.alif.core.view.adapter.GenericAdapter
import com.alif.core.view.adapter.GenericViewHolder

fun NewsAdapter(listener: NewsViewHolder.OnNewsItemClickedListener) =
    GenericAdapter.Base(object : CreateViewHolderUtil<NewsArticlesModel> {
        override fun createViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): GenericViewHolder<NewsArticlesModel> {
            return NewsViewHolder(parent, listener)
        }
    })