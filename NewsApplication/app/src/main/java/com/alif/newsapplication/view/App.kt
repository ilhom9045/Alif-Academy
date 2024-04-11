package com.alif.newsapplication.view

import android.app.Application
import com.alif.newsapplication.model.db.history.DataBaseDataSource

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DataBaseDataSource.initDataBase(this)
    }

}