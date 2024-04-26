package com.alif.newsapplication.model.dataSource.db.history

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.alif.core.view.extention.loadImage
import com.alif.newsapplication.model.dataSource.db.dictionary.DictionaryDataBase
import kotlin.properties.Delegates.notNull

object DataBaseDataSource {

    var dataBase: NewHistoryDataBase by notNull()

    var dictionaryDataBase: DictionaryDataBase by notNull()

    fun initDataBase(context: Context) {

        dictionaryDataBase =
            Room.databaseBuilder(context, DictionaryDataBase::class.java, "dictionary")
                .createFromAsset("dictionary.db")
                .build()

    }



}