package com.alif.core.view.adapter

import android.view.ViewGroup

abstract class GenericAdapter<T>(
    val viewModelFactory: CreateViewHolderUtil<T>,
    areItemsTheSame: (oldItem: T, newItem: T) -> Boolean = { _, _ -> false },
    areContentsTheSame: (oldItem: T, newItem: T) -> Boolean = { _, _ -> false }
) : BaseAdapter<T, GenericViewHolder<T>>(areItemsTheSame, areContentsTheSame) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> {
        return viewModelFactory.createViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: GenericViewHolder<T>, position: Int) =
        holder.bind(item = getItem(position))

    override fun getItemViewType(position: Int): Int {
        return viewModelFactory.getViewHolderType(getItem(position), position)
    }

    class Base<T>(
        createViewHolderUtil: CreateViewHolderUtil<T>,
        areItemsTheSame: (oldItem: T, newItem: T) -> Boolean = { _, _ -> false },
        areContentsTheSame: (oldItem: T, newItem: T) -> Boolean = { _, _ -> false }
    ) : GenericAdapter<T>(createViewHolderUtil, areItemsTheSame, areContentsTheSame)

}
