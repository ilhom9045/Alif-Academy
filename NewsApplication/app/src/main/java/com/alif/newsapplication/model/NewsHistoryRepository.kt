package com.alif.newsapplication.model

import com.alif.core.model.Repository
import com.alif.newsapplication.model.dataSource.db.history.DataBaseDataSource
import com.alif.newsapplication.model.dataSource.db.history.dao.NewsHistoryArticlesDao

interface NewsHistoryRepository : Repository {

    suspend fun loadNewsHistory(): List<NewsArticlesModel>

    suspend fun insertNewsArticle(newsArticle: NewsArticlesModel)


    class Base(private val mapper: NewsArticlesModelMapper,
        private val newsHistoryArticlesDao: NewsHistoryArticlesDao
    ) : Repository.AbstractRepository(),
        NewsHistoryRepository {

        override suspend fun loadNewsHistory(): List<NewsArticlesModel> {
            return newsHistoryArticlesDao.getAllArticles().map {
                NewsArticlesModel(
                    title = it.title,
                    description = it.description,
                    urlToImage = it.urlToImage,
                )
            }
        }

        override suspend fun insertNewsArticle(newsArticle: NewsArticlesModel) {
            newsHistoryArticlesDao.insertArticle(mapper.map(newsArticle))
        }
    }

}