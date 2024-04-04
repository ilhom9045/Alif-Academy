package com.alif.newsapplication.model

import com.alif.newsapplication.model.dataSource.NewsDataSource
import com.alif.newsapplication.model.dataSource.network.NetworkClient

interface NewsRepository {

    suspend fun getNews(): List<NewsArticlesModel>

    class Base() : NewsRepository {

        protected val dataSource = NetworkClient.retrofit.create(NewsDataSource::class.java)

        override suspend fun getNews(): List<NewsArticlesModel> {
            return dataSource.getNewsEverything(apiKey = "48faf68bd8d243ee964a0421cc0caad5").articles
        }

    }

}