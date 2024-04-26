package com.alif.newsapplication.core

import android.app.Application
import com.alif.newsapplication.model.di.dataSourceModule
import com.alif.newsapplication.model.di.repositoryModule
import com.alif.newsapplication.view.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(dataSourceModule, repositoryModule, presentationModule))
        }
    }

}