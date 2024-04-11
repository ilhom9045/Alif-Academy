package com.alif.newsapplication.view.home.view.adapter

import android.view.ViewGroup
import com.alif.core.view.adapter.CreateViewHolderUtil
import com.alif.core.view.adapter.GenericAdapter
import com.alif.core.view.adapter.GenericViewHolder
import com.alif.newsapplication.model.NewsArticlesModel
import com.alif.newsapplication.view.home.view.adapter.viewHolder.NewsViewHolder

fun NewsAdapter(listener: NewsViewHolder.OnNewsItemClickedListener) =
    GenericAdapter.Base(object : CreateViewHolderUtil<NewsArticlesModel> {
        override fun createViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): GenericViewHolder<NewsArticlesModel> {
            return NewsViewHolder(parent, listener)
        }
    })