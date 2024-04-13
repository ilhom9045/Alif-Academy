package com.alif.newsapplication.core

import android.app.Application
import com.alif.newsapplication.model.dataSource.db.history.DataBaseDataSource

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DataBaseDataSource.initDataBase(this)
    }

}