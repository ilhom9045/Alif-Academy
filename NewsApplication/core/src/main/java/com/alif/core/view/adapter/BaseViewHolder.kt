package com.alif.core.view.adapter

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(protected val v: View) : RecyclerView.ViewHolder(v) {

    abstract fun bind(item: T)

    protected fun <V : View> findViewById(@IdRes id: Int): V = itemView.findViewById(id)

}