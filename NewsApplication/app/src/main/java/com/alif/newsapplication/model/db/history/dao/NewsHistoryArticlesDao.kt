package com.alif.newsapplication.model.db.history.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.alif.newsapplication.model.db.history.entity.NewsHistoryArticleEntity


@Dao
interface NewsHistoryArticlesDao {

    @Insert
    fun insertArticle(article: NewsHistoryArticleEntity)

    @Query("Select * from history")
    fun getAllArticles(): List<NewsHistoryArticleEntity>

}