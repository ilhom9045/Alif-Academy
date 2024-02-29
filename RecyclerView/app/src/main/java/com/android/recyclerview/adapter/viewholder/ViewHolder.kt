package com.android.recyclerview.adapter.viewholder

import android.view.View
import android.widget.TextView
import com.android.recyclerview.R
import com.android.recyclerview.model.Person

class ViewHolder(v: View) : BaseViewHolder<Person>(v) {

    private val ageTextView = findViewById<TextView>(R.id.ageTextView)
    private val nameTextView = findViewById<TextView>(R.id.nameTextView)

    override fun bind(item: Person) {
        nameTextView.text = item.name
        ageTextView.text = item.age.toString()
    }

}