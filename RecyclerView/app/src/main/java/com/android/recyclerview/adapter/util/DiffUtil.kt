package com.android.recyclerview.adapter.util

import androidx.recyclerview.widget.DiffUtil
import com.android.recyclerview.model.Person

class CustomDiffUtil():DiffUtil.ItemCallback<Person>(){
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
       return oldItem == newItem
    }


}