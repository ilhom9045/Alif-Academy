package com.android.recyclerview.adapter.viewholder

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    fun <T : View> findViewById(@IdRes id: Int): T = itemView.findViewById(id)

    val context = itemView.context

    abstract fun bind(item: T)

}