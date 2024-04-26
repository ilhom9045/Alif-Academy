package com.alif.newsapplication.model

import com.alif.newsapplication.model.dataSource.db.history.dao.NewsFavoriteArticlesDao
import com.alif.newsapplication.model.dataSource.db.history.entity.NewsFavoriteArticleEntity

interface NewsFavoriteRepository {

    suspend fun asyncRemove(favorite: NewsArticlesModel)

    suspend fun asyncLoadFavorites(): List<NewsArticlesModel>

    suspend fun asyncAddFavorite(favorite: NewsArticlesModel)

    suspend fun asyncIsFavorite(favorite: NewsArticlesModel): Boolean


    class Base(private val dataBase: NewsFavoriteArticlesDao) : NewsFavoriteRepository {


        override suspend fun asyncRemove(favorite: NewsArticlesModel) {
            dataBase.deleteFavoriteArticleByTitleAndDescription(
                favorite.title,
                favorite.description
            )
        }

        override suspend fun asyncLoadFavorites(): List<NewsArticlesModel> {
            return dataBase.allFavoriteArticles().map {
                NewsArticlesModel(
                    title = it.title,
                    description = it.description,
                    urlToImage = it.urlToImage,
                )
            }
        }

        override suspend fun asyncAddFavorite(favorite: NewsArticlesModel) {
            if (!asyncIsFavorite(favorite)) {
                dataBase.insertArticle(map(favorite))
            }
        }

        override suspend fun asyncIsFavorite(favorite: NewsArticlesModel): Boolean {
            return dataBase.favoritesByTitleAndDescription(favorite.title, favorite.description)
                .isNotEmpty()
        }

        private fun map(favorite: NewsArticlesModel): NewsFavoriteArticleEntity {
            return NewsFavoriteArticleEntity(
                title = favorite.title,
                description = favorite.description,
                urlToImage = favorite.urlToImage
            )
        }


    }

}