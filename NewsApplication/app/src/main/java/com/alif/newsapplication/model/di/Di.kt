package com.alif.newsapplication.model.di

import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.alif.newsapplication.model.NewsArticlesModelMapper
import com.alif.newsapplication.model.NewsFavoriteRepository
import com.alif.newsapplication.model.NewsHistoryRepository
import com.alif.newsapplication.model.NewsRepository
import com.alif.newsapplication.model.dataSource.NewsDataSource
import com.alif.newsapplication.model.dataSource.db.history.NewHistoryDataBase
import com.alif.newsapplication.model.dataSource.db.history.dao.NewsFavoriteArticlesDao
import com.alif.newsapplication.model.dataSource.db.history.dao.NewsHistoryArticlesDao
import com.alif.newsapplication.model.dataSource.network.NetworkClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val dataSourceModule = module {
    single<NewsDataSource> { NetworkClient.retrofit.create(NewsDataSource::class.java) }
    single<NewHistoryDataBase> {
        val miration_from_1_to_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    """
                CREATE TABLE "favorite" (
                    "title"	TEXT NOT NULL,
                    "description"	TEXT NOT NULL,
                    "urlToImage"	TEXT NOT NULL,
                    "id"	INTEGER NOT NULL,
                    PRIMARY KEY("id" AUTOINCREMENT)
                )
            """.trimIndent()
                )
            }
        }
        Room.databaseBuilder(androidApplication(), NewHistoryDataBase::class.java, "new_history")
            .addMigrations(miration_from_1_to_2)
            .build()
    }

    single<NewsHistoryArticlesDao> {
        get<NewHistoryDataBase>().historyDao()
    }

    single<NewsFavoriteArticlesDao> {
        get<NewHistoryDataBase>().favoriteDao()
    }
}

val repositoryModule = module {
    factory<NewsArticlesModelMapper> { NewsArticlesModelMapper.Base() }
    factory<NewsRepository> { NewsRepository.Base(get()) }
    factory<NewsHistoryRepository> { NewsHistoryRepository.Base(get(), get()) }
    factory<NewsFavoriteRepository> { NewsFavoriteRepository.Base(get()) }
}