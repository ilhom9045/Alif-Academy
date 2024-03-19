package com.alif.themeandstyle

import android.app.Application
import android.util.Log

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(MainActivity::class.simpleName, "App onCreate")
    }
}