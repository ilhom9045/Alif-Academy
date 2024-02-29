package com.android.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.recyclerview.R
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

class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    private val ageTextView = itemView.findViewById<TextView>(R.id.ageTextView)
    private val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)


    fun bind(item: Person) {
        nameTextView.text = item.name
        ageTextView.text = item.age.toString()
    }

}
