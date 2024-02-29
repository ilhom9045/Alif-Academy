package com.android.recyclerview

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.recyclerview.adapter.adapter.MultiViewHolderRecyclerViewAdapter
import com.android.recyclerview.model.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class MainActivity : AppCompatActivity() {

    val items = mutableListOf<Person>().apply {
        repeat(100) {
            add(
                Person(
                    id = "$it",
                    name = "Name is $it",
                    age = it
                )
            )
        }
    }

    val newData = mutableListOf<Person>().apply {
        for (it in 0..100 step 2){
            add(
                Person(
                    id = "$it",
                    name = "$it",
                    age = it
                )
            )
        }
    }

    val recyclerViewAdapter = MultiViewHolderRecyclerViewAdapter()

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewAdapter.submitList(items)
        findViewById<Button>(R.id.button).setOnClickListener {
            recyclerViewAdapter.submitList(newData)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this)
    }
}

