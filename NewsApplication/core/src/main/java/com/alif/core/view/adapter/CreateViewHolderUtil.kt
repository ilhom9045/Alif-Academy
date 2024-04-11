package com.alif.core.view.adapter

import android.view.ViewGroup

interface CreateViewHolderUtil<T> {

    fun createViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T>

    fun getViewHolderType(model: T, position: Int): Int = 0

}