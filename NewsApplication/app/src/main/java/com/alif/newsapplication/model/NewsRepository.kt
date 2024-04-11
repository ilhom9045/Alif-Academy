package com.alif.newsapplication.model

import com.alif.core.model.Repository
import com.alif.newsapplication.model.dataSource.NewsDataSource
import com.alif.newsapplication.model.dataSource.network.NetworkClient


interface NewsRepository : Repository {

    suspend fun asyncLoadNews(): List<NewsArticlesModel>

    class Base : Repository.AbstractRepository(), NewsRepository {

        protected val dataSource = NetworkClient.retrofit.create(NewsDataSource::class.java)

        override suspend fun asyncLoadNews(): List<NewsArticlesModel> {
            return dataSource.getNewsEverything().articles
        }
    }
}