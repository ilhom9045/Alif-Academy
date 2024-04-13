package com.alif.newsapplication.model.dataSource.db.history.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alif.newsapplication.model.dataSource.db.history.entity.NewsFavoriteArticleEntity


@Dao
interface NewsFavoriteArticlesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertArticle(article: NewsFavoriteArticleEntity)

    @Query("Select * from favorite")
    fun allFavoriteArticles(): List<NewsFavoriteArticleEntity>

    @Query("Delete from favorite where title = :title or description = :description")
    fun deleteFavoriteArticleByTitleAndDescription(title: String, description: String)

    @Query("Select * from favorite where title = :title and description = :description")
    fun favoritesByTitleAndDescription(title: String, description: String):List<NewsFavoriteArticleEntity>

}