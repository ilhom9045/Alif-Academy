package com.alif.newsapplication.model.db.history

import android.content.Context
import androidx.room.Room
import kotlin.properties.Delegates.notNull

object DataBaseDataSource {

    var dataBase:NewHistoryDataBase by notNull()

    fun initDataBase(context: Context){
        dataBase = Room.databaseBuilder(context,NewHistoryDataBase::class.java,"new_history")
            .createFromAsset("new_history.db")
            .build()
    }

}