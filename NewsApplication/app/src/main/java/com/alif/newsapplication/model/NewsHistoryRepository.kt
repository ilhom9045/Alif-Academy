package com.alif.newsapplication.model

import com.alif.core.common.Mapper
import com.alif.core.model.Repository
import com.alif.newsapplication.model.dataSource.db.history.DataBaseDataSource
import com.alif.newsapplication.model.dataSource.db.history.entity.NewsHistoryArticleEntity

interface NewsHistoryRepository : Repository {

    suspend fun loadNewsHistory(): List<NewsArticlesModel>

    suspend fun insertNewsArticle(newsArticle: NewsArticlesModel)


    class Base : Repository.AbstractRepository(), NewsHistoryRepository {

        private val mapper = NewsArticlesModelMapper()

        override suspend fun loadNewsHistory(): List<NewsArticlesModel> {
            return DataBaseDataSource.dataBase.historyDao().getAllArticles().map {
                NewsArticlesModel(
                    title = it.title,
                    description = it.description,
                    urlToImage = it.urlToImage,
                )
            }
        }

        override suspend fun insertNewsArticle(newsArticle: NewsArticlesModel) {
            DataBaseDataSource.dataBase.historyDao().insertArticle(mapper.map(newsArticle))
        }
    }

}