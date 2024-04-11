package com.alif.newsapplication.model.db.history

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alif.newsapplication.model.db.history.dao.NewsHistoryArticlesDao
import com.alif.newsapplication.model.db.history.entity.NewsHistoryArticleEntity


@Database(
    entities = [NewsHistoryArticleEntity::class],
    version = 1
)
abstract class NewHistoryDataBase : RoomDatabase() {
    abstract fun historyDao(): NewsHistoryArticlesDao

}