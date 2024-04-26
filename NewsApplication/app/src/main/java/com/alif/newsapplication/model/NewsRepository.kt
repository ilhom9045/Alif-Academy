package com.alif.newsapplication.model

import com.alif.core.model.Repository
import com.alif.newsapplication.model.dataSource.NewsDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


interface NewsRepository : Repository {

    suspend fun asyncLoadNews(): List<NewsArticlesModel>

    class Base(private val dataSource: NewsDataSource) : Repository.AbstractRepository(),
        NewsRepository {

        override suspend fun asyncLoadNews(): List<NewsArticlesModel> {
            return withContext(Dispatchers.IO) {
                dataSource.getNewsEverything().articles
            }
        }
    }
}