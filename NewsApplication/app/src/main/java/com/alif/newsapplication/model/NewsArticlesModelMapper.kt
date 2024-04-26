package com.alif.newsapplication.model

import com.alif.core.common.Mapper
import com.alif.newsapplication.model.dataSource.db.history.entity.NewsHistoryArticleEntity


interface NewsArticlesModelMapper : Mapper<NewsArticlesModel, NewsHistoryArticleEntity> {
    class Base : NewsArticlesModelMapper {
        override fun map(data: NewsArticlesModel): NewsHistoryArticleEntity {
            return NewsHistoryArticleEntity(
                title = data.title,
                description = data.description,
                urlToImage = data.urlToImage
            )
        }
    }
}

