package com.example.myapplication

import android.app.Application

class App:Application() {

    var dbClass:String?=null
    override fun onCreate() {
        super.onCreate()
        dbClass = "dbClass"
    }

}