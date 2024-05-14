package com.alif.contentprovider

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alif.contentprovider.viewHolder.NewsArticlesModel
import com.alif.contentprovider.viewHolder.NewsViewHolder

class MainActivity : AppCompatActivity(), NewsViewHolder.OnNewsItemClickedListener {

    val newAdapter = NewsAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newAdapter
        }

        findViewById<Button>(R.id.button).setOnClickListener {

            contentResolver.query(
                Uri.parse("content://com.alif.newsapplication"),
                null,
                null,
                null,
                null,
                null
            )?.let {
                val mutableList = mutableListOf<NewsArticlesModel>()
                try {
                    while (it.moveToNext()) {
                        val imageUrl = it.getString(it.getColumnIndex("urlToImage"))
                        val title = it.getString(it.getColumnIndex("title"))
                        val description = it.getString(it.getColumnIndex("description"))
                        mutableList.add(
                            NewsArticlesModel(
                                title = title,
                                urlToImage = imageUrl,
                                description = description
                            )
                        )
                    }
                } finally {
                    it.close()
                }
                newAdapter.submitList(mutableList)
            }
        }
    }

    override fun onNewsItemClicked(item: NewsArticlesModel, position: Int) {}

    override fun onLongItemClicked(view: View, item: NewsArticlesModel, position: Int): Boolean {
        return true
    }
}