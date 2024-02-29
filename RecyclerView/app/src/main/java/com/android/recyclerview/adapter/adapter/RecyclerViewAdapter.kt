package com.android.recyclerview.adapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.android.recyclerview.R
import com.android.recyclerview.adapter.viewholder.ViewHolder
import com.android.recyclerview.adapter.util.CustomDiffUtil
import com.android.recyclerview.model.Person

class RecyclerViewAdapter :
    ListAdapter<Person, ViewHolder>(CustomDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}


