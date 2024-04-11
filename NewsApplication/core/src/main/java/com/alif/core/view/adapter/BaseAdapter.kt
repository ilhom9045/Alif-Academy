package com.alif.core.view.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<T, VH : BaseViewHolder<T>>(
    areItemsTheSame: (oldItem: T, newItem: T) -> Boolean = { _, _ ->
        false
    },
    areContentsTheSame: (oldItem: T, newItem: T) -> Boolean = { _, _ ->
        false
    }
) : ListAdapter<T, VH>(BaseDiffUtil(areItemsTheSame, areContentsTheSame))


class BaseDiffUtil<T>(
    private val areItemsTheSame: (oldItem: T, newItem: T) -> Boolean,
    private val areContentsTheSame: (oldItem: T, newItem: T) -> Boolean
) : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T & Any, newItem: T & Any): Boolean =
        areItemsTheSame.invoke(oldItem, newItem)

    override fun areContentsTheSame(oldItem: T & Any, newItem: T & Any): Boolean =
        areContentsTheSame.invoke(oldItem, newItem)

}