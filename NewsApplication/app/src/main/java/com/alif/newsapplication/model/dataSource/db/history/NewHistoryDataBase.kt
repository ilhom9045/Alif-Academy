package com.alif.newsapplication.model.dataSource.db.history

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alif.newsapplication.model.dataSource.db.history.dao.NewsFavoriteArticlesDao
import com.alif.newsapplication.model.dataSource.db.history.dao.NewsHistoryArticlesDao
import com.alif.newsapplication.model.dataSource.db.history.entity.NewsFavoriteArticleEntity
import com.alif.newsapplication.model.dataSource.db.history.entity.NewsHistoryArticleEntity


@Database(
    entities = [NewsHistoryArticleEntity::class, NewsFavoriteArticleEntity::class],
    version = 2,
)
abstract class NewHistoryDataBase : RoomDatabase() {

    abstract fun historyDao(): NewsHistoryArticlesDao

    abstract fun favoriteDao(): NewsFavoriteArticlesDao

}