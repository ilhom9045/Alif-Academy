package com.android.recyclerview.adapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.android.recyclerview.R
import com.android.recyclerview.adapter.util.CustomDiffUtil
import com.android.recyclerview.adapter.viewholder.BaseViewHolder
import com.android.recyclerview.adapter.viewholder.HeaderViewHolder
import com.android.recyclerview.adapter.viewholder.ViewHolder
import com.android.recyclerview.model.Person

class MultiViewHolderRecyclerViewAdapter :
    ListAdapter<Person, BaseViewHolder<Person>>(CustomDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Person> {
        return if (viewType == BODY_VIEW_TYPE) {
            ViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view_item, parent, false)
            )
        } else {
            HeaderViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_header_view_item, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Person>, position: Int) =
        holder.bind(getItem(position))

    override fun getItemViewType(position: Int) = if (position % 10 == 0) HEADER_VIEW_TYPE else BODY_VIEW_TYPE
    private companion object {
        const val BODY_VIEW_TYPE = 0
        const val HEADER_VIEW_TYPE = 1
    }
}

